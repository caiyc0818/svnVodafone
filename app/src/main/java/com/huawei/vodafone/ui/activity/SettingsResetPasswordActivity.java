package com.huawei.vodafone.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.huawei.vodafone.R;
import com.huawei.vodafone.util.DensityUtil;
import com.huawei.vodafone.util.PreferenceUtils;
import com.huawei.vodafone.util.StringUtils;
import com.huawei.vodafone.util.ToastUtil;

public class SettingsResetPasswordActivity extends BaseActivity implements
		OnClickListener {

	private ImageView bills_bg_img;
	private LinearLayout lin;
	private LinearLayout erron_tips2;
	private EditText phone_number;
	private EditText password;
	private EditText reset_password;
	private EditText confirm_password;
	private Button Check;
	private Button btn_send;
	private CountTimer countTimer;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_reset_password);
		initSecondTitle(getString(R.string.settings_reset_your_password));
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		countTimer = new CountTimer(60000, 1000);
		bills_bg_img = (ImageView) findViewById(R.id.back);
		phone_number = (EditText) findViewById(R.id.phone_number);
		password = (EditText) findViewById(R.id.password);
		phone_number.setSelection(phone_number.length());
		reset_password = (EditText) findViewById(R.id.reset_password);
		confirm_password = (EditText) findViewById(R.id.confirm_password);
		Check = (Button) findViewById(R.id.Check);
		btn_send = (Button) findViewById(R.id.btn_send);
		btn_send.setOnClickListener(this);
		lin = (LinearLayout) findViewById(R.id.lin);
		erron_tips2 = (LinearLayout) findViewById(R.id.erron_tips2);
		bills_bg_img.setOnClickListener(this);
		Check.setOnClickListener(this);
		reset_password.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				erron_tips2.setVisibility(View.GONE);
				Check.setEnabled(true);
				Check.setBackgroundResource(R.drawable.settings_resetpin_back_red);
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});
		phone_number.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				// TODO Auto-generated method stub
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					password.requestFocusFromTouch();
				}
				return false;
			}
		});
		password.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				// TODO Auto-generated method stub
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					reset_password.requestFocusFromTouch();
				}
				return false;
			}
		});
		reset_password.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				// TODO Auto-generated method stub
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					confirm_password.requestFocusFromTouch();
				}
				return false;
			}
		});
		confirm_password
				.setOnEditorActionListener(new OnEditorActionListener() {

					@Override
					public boolean onEditorAction(TextView v, int actionId,
							KeyEvent event) {
						// TODO Auto-generated method stub
						if (actionId == EditorInfo.IME_ACTION_DONE) {
							confirm_password.requestFocusFromTouch();
						}
						return false;
					}
				});
		phone_number.postDelayed(new Runnable() {
			@Override
			public void run() {
				showInputManager(phone_number);
			}
		}, 200);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {

		case R.id.back:
			InputMethodManager imm = (InputMethodManager) getSystemService(SettingsResetPasswordActivity.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(phone_number.getWindowToken(), 0);
			imm.hideSoftInputFromWindow(reset_password.getWindowToken(), 0);
			imm.hideSoftInputFromWindow(confirm_password.getWindowToken(), 0);
			imm.hideSoftInputFromWindow(password.getWindowToken(), 0);

			finish();
			activityAnimationClose();

			break;
		case R.id.btn_send:
			if (StringUtils.isEmpty(phone_number.getText().toString())
					|| phone_number.getText().toString().length() != 11) {
				ToastUtil.showToast(SettingsResetPasswordActivity.this,
						"Please enter the correct number.");
				break;
			}
			if (countTimer != null) {
				countTimer.start();
			}
			btn_send.setEnabled(false);
			break;
		case R.id.Check:
			if (StringUtils.isEmpty(phone_number.getText().toString())
					|| phone_number.getText().toString().length() != 11) {
				ToastUtil.showToast(SettingsResetPasswordActivity.this,
						"Please enter the correct number.");
				break;
			}
			if (TextUtils.isEmpty(password.getText().toString())) {
				ToastUtil.showToast(SettingsResetPasswordActivity.this,
						getResources().getString(R.string.enter_code));
				break;
			}
			if (StringUtils.isEmpty(reset_password.getText().toString())) {
				ToastUtil.showToast(SettingsResetPasswordActivity.this,
						"Please enter the new password");
				break;
			}

			if (reset_password.getText().toString().length() < 5) {
				erron_tips2.setVisibility(View.VISIBLE);
				Check.setBackgroundResource(R.drawable.settings_resetpin_back2);
				Check.setEnabled(false);
				ViewGroup.LayoutParams lp = lin.getLayoutParams();
				lp.height = DensityUtil.dip2px(
						SettingsResetPasswordActivity.this, 375);
				break;
			} else {
				erron_tips2.setVisibility(View.GONE);
				ViewGroup.LayoutParams lp = lin.getLayoutParams();
				lp.height = DensityUtil.dip2px(
						SettingsResetPasswordActivity.this, 320);
			}
			if (!reset_password.getText().toString()
					.equals(confirm_password.getText().toString())) {
				ToastUtil.showToast(SettingsResetPasswordActivity.this,
						"Please confirm that the password is consistent.");
				break;
			}
			finish();
			activityAnimationClose();
			Intent it = new Intent("com.vodafone.reset_password_sucess");
			SettingsResetPasswordActivity.this.sendBroadcast(it);
			PreferenceUtils.setString(SettingsResetPasswordActivity.this,
					"password", confirm_password.getText().toString());

			break;

		default:
			break;
		}
	}

	class CountTimer extends CountDownTimer {

		public CountTimer(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}

		@Override
		public void onTick(long millisUntilFinished) {
			btn_send.setText(millisUntilFinished / 1000 + "s");
		}

		@Override
		public void onFinish() {
			btn_send.setEnabled(true);
			btn_send.setText(getResources().getString(
					R.string.settings_send_code));
		}

	}
}
