package com.huawei.vodafone.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.util.MethodUtils;
import com.huawei.vodafone.util.PreferenceUtils;

public class ForgottenActivity extends BaseActivity {

	private ImageView img_back;
	private EditText et_phone;
	private EditText et_send_code;
	private Button btn_send;
	private EditText et_pwd;
	private EditText et_pwd_repeat;
	private Button btn_check;
	private CountTimer countTimer;
	private LinearLayout linear_enter_phone_error;
	private TextView forgot_phone;
	private LinearLayout linear_enter_code_error;
	private TextView forgot_code;
	private LinearLayout linear_pwd_one_error;
	private TextView user_pwd_one_error;
	private LinearLayout linear_pwd_two_error;
	private TextView user_pwd_two_error;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forgotten);
		initSecondTitle(getString(R.string.forgotten_btn));
		initView();
	}

	public void initView() {
		countTimer = new CountTimer(60000, 1000);
		img_back = (ImageView) findViewById(R.id.back);
		et_phone = (EditText) findViewById(R.id.et_phone);
		et_send_code = (EditText) findViewById(R.id.et_send_code);
		btn_send = (Button) findViewById(R.id.btn_send);
		et_pwd = (EditText) findViewById(R.id.et_pwd);
		et_pwd_repeat = (EditText) findViewById(R.id.et_pwd_repeat);
		btn_check = (Button) findViewById(R.id.btn_check);
		linear_enter_phone_error = (LinearLayout) findViewById(R.id.linear_enter_phone_error);
		linear_enter_code_error = (LinearLayout) findViewById(R.id.linear_enter_code_error);
		linear_pwd_one_error = (LinearLayout) findViewById(R.id.linear_pwd_one_error);
		linear_pwd_two_error = (LinearLayout) findViewById(R.id.linear_pwd_two_error);
		user_pwd_one_error = (TextView) findViewById(R.id.user_pwd_one_error);
		forgot_phone = (TextView) findViewById(R.id.forgot_phone);
		forgot_code = (TextView) findViewById(R.id.forgot_code);
		user_pwd_two_error = (TextView) findViewById(R.id.user_pwd_two_error);

		img_back.setOnClickListener(this);
		btn_send.setOnClickListener(this);
		btn_check.setOnClickListener(this);
		et_phone.addTextChangedListener(new TextWatcher() {

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
				linear_enter_phone_error.setVisibility(View.GONE);
				linear_enter_code_error.setVisibility(View.GONE);
				linear_pwd_one_error.setVisibility(View.GONE);
				linear_pwd_two_error.setVisibility(View.GONE);
			}
		});
		et_send_code.addTextChangedListener(new TextWatcher() {

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
				linear_enter_phone_error.setVisibility(View.GONE);
				linear_enter_code_error.setVisibility(View.GONE);
				linear_pwd_one_error.setVisibility(View.GONE);
				linear_pwd_two_error.setVisibility(View.GONE);
			}
		});
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
				linear_enter_phone_error.setVisibility(View.GONE);
				linear_enter_code_error.setVisibility(View.GONE);
				linear_pwd_one_error.setVisibility(View.GONE);
				linear_pwd_two_error.setVisibility(View.GONE);
			}
		});
		et_pwd_repeat.addTextChangedListener(new TextWatcher() {

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
				linear_enter_phone_error.setVisibility(View.GONE);
				linear_enter_code_error.setVisibility(View.GONE);
				linear_pwd_one_error.setVisibility(View.GONE);
				linear_pwd_two_error.setVisibility(View.GONE);
			}
		});

	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.back:
			onBackPressed();
			break;
		case R.id.btn_send:
			if (countTimer != null) {
				countTimer.start();
			}
			btn_send.setEnabled(false);
			break;
		case R.id.btn_check:
			if (TextUtils.isEmpty(et_phone.getText().toString())) {
				// ToastUtil.showToast(ForgottenActivity.this,
				// getResources().getString(R.string.your_number));
				linear_enter_phone_error.setVisibility(View.VISIBLE);
				forgot_phone.setText(getResources().getString(
						R.string.your_number));
				// } else if
				// (!MethodUtils.isMobile(et_phone.getText().toString())) {
			} else if (et_phone.getText().toString().length() != 11
					|| !MethodUtils.isAllNumber(et_phone.getText().toString())) {
				// ToastUtil.showToast(ForgottenActivity.this, "Please enter the
				// correct number.");
				linear_enter_phone_error.setVisibility(View.VISIBLE);
				forgot_phone.setText("Please enter the correct number.");
			} else if (TextUtils.isEmpty(et_send_code.getText().toString())) {
				// ToastUtil.showToast(ForgottenActivity.this,
				// getResources().getString(R.string.enter_code));
				linear_enter_code_error.setVisibility(View.VISIBLE);
				forgot_code.setText(getResources().getString(
						R.string.enter_code));
			} else if (TextUtils.isEmpty(et_pwd.getText().toString())) {
				// ToastUtil.showToast(ForgottenActivity.this,
				// getResources().getString(R.string.new_pwd));
				linear_pwd_one_error.setVisibility(View.VISIBLE);
				user_pwd_one_error.setText(getResources().getString(
						R.string.new_pwd));
			} else if (!MethodUtils.isFitPassword(et_pwd.getText().toString())) {
				// ToastUtil.showToast(ForgottenActivity.this, "Please enter the
				// correct password format ");
				linear_pwd_one_error.setVisibility(View.VISIBLE);
				user_pwd_one_error.setText("Please enter the 6-16 password!");
			} else if (TextUtils.isEmpty(et_pwd_repeat.getText().toString())) {
				// ToastUtil.showToast(ForgottenActivity.this,
				// getResources().getString(R.string.confim_pwd));
				linear_pwd_two_error.setVisibility(View.VISIBLE);
				user_pwd_two_error.setText(getResources().getString(
						R.string.confim_pwd));
			} else if (!et_pwd.getText().toString()
					.equals(et_pwd_repeat.getText().toString())) {
				// ToastUtil.showToast(ForgottenActivity.this, "Two passwords
				// are not consistent");
				linear_pwd_two_error.setVisibility(View.VISIBLE);
				user_pwd_two_error.setText("Two passwords are not consistent!");
			} else {
				PreferenceUtils.setString(this, "queren", et_pwd.getText()
						.toString());
				startActivity(new Intent(ForgottenActivity.this,
						LoginActivity.class));
				LoginActivity.currentActivity.finish();
				finish();
			}
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
			btn_send.setText("send code");
		}

	}
}
