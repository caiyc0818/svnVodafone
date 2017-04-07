package com.huawei.vodafone.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.huawei.vodafone.R;

public class SettingsPersonaliseYourSerChangeNameActivity extends BaseActivity
		implements OnClickListener {
	private EditText name;
	private EditText number;
	private String name1;
	private String number1;
	private TextView phone;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_personalise_change_name);
		initSecondTitle(getString(R.string.settings_personalise_services));
		name1 = getIntent().getStringExtra("name");
		number1 = getIntent().getStringExtra("number");
		initView();
		name.setText(name1);
		phone.setText(number1);
		name.postDelayed(new Runnable() {
			@Override
			public void run() {
				showInputManager(name);
			}
		}, 200);
	}

	private void initView() {
		// TODO Auto-generated method stub

		name = (EditText) findViewById(R.id.name);
		number = (EditText) findViewById(R.id.number);
		phone = (TextView) findViewById(R.id.phone);
		// / 获取编辑框焦点
		name.requestFocus();
		// 打开软键盘
		InputMethodManager imm = (InputMethodManager) SettingsPersonaliseYourSerChangeNameActivity.this
				.getSystemService(SettingsPersonaliseYourSerChangeNameActivity.this.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
		name.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				// TODO Auto-generated method stub
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					number.requestFocusFromTouch();
					number.setSelection(number.getText().length());
				}
				return false;
			}
		});
		number.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				// TODO Auto-generated method stub
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					Intent it = new Intent();
					it.setClass(
							SettingsPersonaliseYourSerChangeNameActivity.this,
							SettingsPersonaliseYourSerActivity.class);
					// it.putExtra("number", number.getText().toString());
					it.putExtra("name", name.getText().toString());
					setResult(1, it);
					finish();
					activityAnimationClose();
				}
				return false;
			}
		});
		((RelativeLayout) name.getParent())
				.setBackgroundResource(R.drawable.settings_personalise_the_app_personalise_your_services_edit_name_07);
	}

	// private OnKeyListener keyListener = new OnKeyListener() {
	//
	// @Override
	// public boolean onKey(View v, int keyCode, KeyEvent event) {
	//
	// if ((((EditText) v).getText().toString() != null || !((EditText)
	// v).getText().toString().isEmpty())
	// && keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() ==
	// KeyEvent.ACTION_DOWN
	// ) {
	// Intent it = new Intent();
	// it.setClass(Settings_personalise_your_ser_change_name.this,
	// Settings_personalise_you_ser.class);
	// it.putExtra("number", number.getText().toString());
	// it.putExtra("name", name.getText().toString());
	// setResult(1, it);
	// finish();
	// activityAnimationClose();
	// }
	//
	// return false;
	// }
	// };
	// private OnKeyListener keyListener2 = new OnKeyListener() {
	//
	// @Override
	// public boolean onKey(View v, int keyCode, KeyEvent event) {
	//
	// if ((((EditText) v).getText().toString() != null || !((EditText)
	// v).getText().toString().isEmpty())
	// && keyCode == KeyEvent.KEYCODE_ENTER&& event.getAction() ==
	// KeyEvent.ACTION_DOWN) {
	// Intent it = new Intent();
	// it.setClass(Settings_personalise_your_ser_change_name.this,
	// Settings_personalise_you_ser.class);
	// it.putExtra("name", name.getText().toString());
	// it.putExtra("name", name.getText().toString());
	// setResult(1, it);
	// finish();
	// activityAnimationClose();
	// }
	//
	// return false;
	// }
	// };

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {

		default:
			break;
		}
	}
}
