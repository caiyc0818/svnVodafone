package com.huawei.vodafone.ui.activity;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.huawei.vodafone.R;
import com.huawei.vodafone.db.DBAdapter;
import com.huawei.vodafone.net.IRequest;
import com.huawei.vodafone.net.RequestListener;
import com.huawei.vodafone.net.URLs;
import com.huawei.vodafone.ui.myview.Myedittext;
import com.huawei.vodafone.ui.myview.dialog.WaitDialog;
import com.huawei.vodafone.util.MethodUtils;
import com.huawei.vodafone.util.PreferenceUtils;
import com.huawei.vodafone.util.StringUtils;
import com.huawei.vodafone.util.ToastUtil;

public class LoginActivity extends BaseActivity implements RequestListener {

	private EditText et_user_name;
	private Myedittext et_pwd;
	private LinearLayout isGone;
	private LinearLayout mPwdErrorDialog;
	private LinearLayout mEnterFiveErrorDialog;
	private LinearLayout UserNameFormatError;
	private Button btn_login;
	private Button btn_forgotton;
	private Button btn_reset_account;
	private Button btn_register;
	private TextView mUserNameFormat;
	private TextView mPwdFormat;
	private Context context;
	private int count = 0;
	static Handler handler = new Handler();
	public static LoginActivity currentActivity;
	DBAdapter db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		PreferenceUtils.setBoolean(this, "isFirst", true);
		context = this;
		currentActivity = this;
		initView();
		initListener();
		db = new DBAdapter(this);
		db.openDb();

		db.delete();

		for (int i = 0; i < 7; i++) {
			if (i == 0) {
				db.insert(i + "", "usage", "0",
						"Set a data cap so thia you never go above your monthly allowance.");
			}
			if (i == 1) {
				db.insert(i + "", "usage", "0",
						"Why not explore out add-ons? 1GB for only €6.99.");
			}
			if (i == 2) {

				db.insert(i + "", "billing", "0",
						"Your plan has unlimited free calls to all UK mobiles and landlines.");
			}
			if (i == 3) {
				db.insert(i + "", "billing", "0", "Your've run out of data");
			}
			if (i == 4) {
				db.insert(i + "", "billing", "0",
						"plan has unlimited free calls to all UK mobiles.");
			}
			if (i == 5) {
				db.insert(i + "", "offers", "0",
						"You plan has free unlimited texts to UK mobiles.");
			}
			if (i == 6) {
				db.insert(i + "", "offers", "0",
						"Upgrade to free unlimited texts to UK mobiles");
			}
		}
		db.closeDb();
	}

	public void initView() {
		et_user_name = (EditText) findViewById(R.id.et_user_name);
		et_pwd = (Myedittext) findViewById(R.id.et_pwd);
		isGone = (LinearLayout) findViewById(R.id.isGone);
		mUserNameFormat = (TextView) findViewById(R.id.user_name_format_error);
		mPwdFormat = (TextView) findViewById(R.id.pwd_format_error);
		mPwdErrorDialog = (LinearLayout) findViewById(R.id.linear_pwd_error);
		mEnterFiveErrorDialog = (LinearLayout) findViewById(R.id.linear_username_error);
		UserNameFormatError = (LinearLayout) findViewById(R.id.linear_username_format_error);
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_forgotton = (Button) findViewById(R.id.btn_forgotton);
		btn_reset_account = (Button) findViewById(R.id.btn_reset_account);
		btn_register = (Button) findViewById(R.id.btn_register);

		et_user_name.setText("4915298006711");
		et_user_name.setSelection(et_user_name.getText().length());
		et_pwd.setText("123456");
		btn_login.setEnabled(true);
		btn_login.setBackgroundResource(R.color.register_btn);
		btn_login.setTextColor(getResources().getColor(R.color.white));
		if (!PreferenceUtils.getString(context, "et_user_name").equals("")) {
			et_user_name.setText(PreferenceUtils.getString(context,
					"et_user_name"));
			et_pwd.setText(PreferenceUtils.getString1(context, "queren"));
			et_user_name.setSelection(et_user_name.getText().length());
			btn_login.setEnabled(true);
			btn_login.setBackgroundResource(R.color.register_btn);
			btn_login.setTextColor(getResources().getColor(R.color.white));
		}
		Log.d("automaticLogon",
				PreferenceUtils.getBoolean(context, "automaticLogon") + "");
		if (getIntent().getIntExtra("code", 0) != 1) {

			if (PreferenceUtils.getBoolean(context, "automaticLogon")) {// true
				// 自动登录
				handler.postDelayed(StartRunnable1, 800);
			}
		}
	}

	private void initListener() {
		btn_login.setOnClickListener(this);
		btn_forgotton.setOnClickListener(this);
		btn_reset_account.setOnClickListener(this);
		btn_register.setOnClickListener(this);
		et_pwd.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				if (TextUtils.isEmpty(et_user_name.getText().toString())
						|| TextUtils.isEmpty(et_pwd.getText().toString())) {
					btn_login.setEnabled(false);
					btn_login.setBackgroundResource(R.color.login_btn);
					btn_login.setTextColor(getResources().getColor(
							R.color.login_btn_text));
				} else {
					btn_login.setEnabled(true);
					UserNameFormatError.setVisibility(View.GONE);
					mPwdErrorDialog.setVisibility(View.GONE);
					mPwdErrorDialog.setVisibility(View.GONE);
					btn_login.setBackgroundResource(R.color.register_btn);
					btn_login.setTextColor(getResources().getColor(
							R.color.white));
				}
			}
		});

		et_user_name.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				if (TextUtils.isEmpty(et_user_name.getText().toString())
						|| TextUtils.isEmpty(et_pwd.getText().toString())) {
					btn_login.setEnabled(false);
					btn_login.setBackgroundResource(R.color.login_btn);
					btn_login.setTextColor(getResources().getColor(
							R.color.login_btn_text));
				} else {
					btn_login.setEnabled(true);
					UserNameFormatError.setVisibility(View.GONE);
					mPwdErrorDialog.setVisibility(View.GONE);
					btn_login.setBackgroundResource(R.color.register_btn);
					btn_login.setTextColor(getResources().getColor(
							R.color.white));
				}
			}
		});
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.btn_forgotton:
			startActivity(new Intent(context, ForgottenActivity.class));
			// startActivity(new Intent(context, NotificationActivity.class));
			break;
		case R.id.btn_register:
			ToastUtil.showToast(context, "Follow up development");

			break;
		case R.id.btn_login:
			if (!MethodUtils.isHasHanZi(et_user_name.getText().toString())) {
				UserNameFormatError.setVisibility(View.VISIBLE);
				mUserNameFormat.setText("User name contains Chinese");
			} else if (!MethodUtils.isFitPassword(et_pwd.getText().toString())) {
				mPwdErrorDialog.setVisibility(View.VISIBLE);
				mPwdFormat.setText("Password format error");
				// } else if
				// (!et_user_name.getText().toString().equals("07785460399")) {
				// UserNameFormatError.setVisibility(View.VISIBLE);
				// mUserNameFormat.setText("User name not exist");
			} else if (!StringUtils
					.isEmpty((et_user_name.getText().toString()))
					&& et_pwd.getText().toString()
							.equals(PreferenceUtils.getString1(this, "queren"))) {
				mPwdErrorDialog.setVisibility(View.GONE);
				dialog = new WaitDialog(this);
				dialog.setLogin();
				dialog.show();
				handler.postDelayed(StartRunnable, 1500);
				PreferenceUtils.setString(context, "et_user_name", et_user_name
						.getText().toString());
				PreferenceUtils.setString(context, "et_pwd", et_pwd.getText()
						.toString());

				Map<String, Object> params = new HashMap<String, Object>();
				params.put("mobile", et_user_name.getText().toString());
				if (!StringUtils.isEmpty(PreferenceUtils.getString(
						getBaseContext(), "CID"))) {
					params.put("deviceToken",
							PreferenceUtils.getString(getBaseContext(), "CID"));
					params.put("fromType", 0);
					IRequest.get(1, URLs.GETUI, params, this);
				}
			} else {
				count++;
				et_pwd.setVisibilty(true);
				et_pwd.setBackgroundResource(R.drawable.et_error_pwd);
				mPwdErrorDialog.setVisibility(View.VISIBLE);
				mPwdFormat.setText(R.string.pwd_error);
				// if (count >= 2 && count <= 4) {
				// ToastUtil.showToast(context, "You have lost the wrong
				// password " + count + " times");
				// }
				if (count == 5) {
					et_pwd.setVisibilty(false);
					isGone.setVisibility(View.GONE);
					mPwdErrorDialog.setVisibility(View.GONE);
					mEnterFiveErrorDialog.setVisibility(View.VISIBLE);
					btn_reset_account.setVisibility(View.VISIBLE);
					et_user_name
							.setBackgroundResource(R.drawable.login_edittext);
					et_pwd.setBackgroundResource(R.drawable.login_edittext);
					et_user_name.setEnabled(false);
					et_pwd.setEnabled(false);
				}
			}
			break;
		case R.id.btn_reset_account:
			// startActivity(new Intent(context, LoginActivity.class));
			// finish();
			break;
		default:
			break;
		}
	}

	private Runnable StartRunnable = new Runnable() {
		@Override
		public void run() {
			Intent intent = new Intent(context, MainActivity.class);
			intent.putExtra("name", et_user_name.getText().toString());
			startActivity(intent);
			finish();
			// dialog.dismiss();
		}
	};

	private Runnable StartRunnable1 = new Runnable() {
		@Override
		public void run() {
			dialog = new WaitDialog(context);
			dialog.show();
			handler.postDelayed(StartRunnable, 1500);
		}
	};
	private WaitDialog dialog;

	@Override
	public void requestSuccess(Object tag, String json) {

	}

	@Override
	public void requestError(Object tag, VolleyError e) {

	}
}
