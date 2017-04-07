package com.huawei.vodafone.ui.activity;

import com.huawei.vodafone.R;
import com.huawei.vodafone.util.AppManager;
import com.huawei.vodafone.util.DensityUtil;
import com.huawei.vodafone.util.PreferenceUtils;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SettingsConfirmPinActivity extends BaseActivity implements OnClickListener {
	private EditText editText1;
	private EditText editText2;
	private EditText editText3;
	private EditText editText4;
	private TextView pin_continue;
	private TextView pin_goBack;
	private LinearLayout erron_tips;
	private LinearLayout lin;
	private String pw;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_set_up_pin_confirle);
		pw = getIntent().getStringExtra("pin_num");
		AppManager.getAppManager().addActivity(this);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		erron_tips = (LinearLayout) findViewById(R.id.erron_tips);
		lin = (LinearLayout) findViewById(R.id.lin);
		pin_continue = (TextView) findViewById(R.id.pin_con);
		pin_continue.setBackgroundResource(R.drawable.settings_resetpin_back_red);
		pin_goBack = (TextView) findViewById(R.id.pin_goBack);
		pin_goBack.setOnClickListener(this);
		pin_continue.setClickable(false);
		pin_continue.setOnClickListener(this);
		editText1 = (EditText) findViewById(R.id.edit1);
		editText2 = (EditText) findViewById(R.id.edit2);
		editText3 = (EditText) findViewById(R.id.edit3);
		editText4 = (EditText) findViewById(R.id.edit4);

		editText1.setTag(1);
		editText2.setTag(2);
		editText3.setTag(3);
		editText4.setTag(4);
		// 添加 内容change listener ：输入焦点后移 + 密码验证
		editText1.addTextChangedListener(new MyTextChangeWatcher(1));
		editText2.addTextChangedListener(new MyTextChangeWatcher(2));
		editText3.addTextChangedListener(new MyTextChangeWatcher(3));
		editText4.addTextChangedListener(new MyTextChangeWatcher(4));

		// del 监听，输入焦点前移
		editText2.setOnKeyListener(keyListener);
		editText3.setOnKeyListener(keyListener);
		editText4.setOnKeyListener(keyListener);
		editText1.setOnKeyListener(keyListener);
		editText1.requestFocus();
		// 打开软键盘
		InputMethodManager imm = (InputMethodManager) SettingsConfirmPinActivity.this
				.getSystemService(SettingsConfirmPinActivity.this.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

	}

	class MyTextChangeWatcher implements TextWatcher {
		// 标示 绑定的EditText
		private int index;

		public MyTextChangeWatcher(int index) {
			super();
			this.index = index;
		}

		@Override
		public void afterTextChanged(Editable s) {
			if (s != null && s.length() == 1) {
				if (index < 4) {// 焦点后移
					getEditTextFromIndex(index).clearFocus();
					getEditTextFromIndex(index + 1).requestFocusFromTouch();
				} else {
					// TODO 判断
					// handler.sendEmptyMessage(1);
				}
				setFlag(false, index);// 对应标志位 置 1
				// 有内容输入，判断密码是否输入OK
				handler.sendEmptyMessage(1);
		} else {
				// 清除 对应 标识位
				setFlag(true, index);
			}

		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
erron_tips.setVisibility(View.GONE);
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			erron_tips.setVisibility(View.GONE);

		}

	}

	private byte flag;

	/**
	 * 对指定位 进行位操作
	 * 
	 * @param isNull
	 *            true：当前值为null ，清零。false：有值，该标志位 给1.
	 * @param index
	 *            标志位index
	 */
	private void setFlag(boolean isNull, int index) {
		// 得到 唯一一个 1的二进制数 00001000
		byte b = (byte) (1 << (index - 1));
		if (isNull) {// 指定 位 清零
			b = (byte) ~b; // 11110111
			flag = (byte) (flag & b);
		} else {// 制定位 赋值 1
			flag = (byte) (flag | b);
		}
	}

	/**
	 * 扫描EditText 是否存在没有输入的
	 * 
	 * @return true 有空， false 都填写值了
	 */
	private boolean scanEditTextHasNull() {
		for (int i = 0; i < 4; i++) {

			if (getEditTextFromIndex(i + 1).getText() == null || getEditTextFromIndex(i + 1).getText().length() != 1) {
				// 有一个为空，立即返回
				return true;
			}
		}
		return false;
	}

	/**
	 * 监听删除键 前移焦点
	 */
	private OnKeyListener keyListener = new OnKeyListener() {

		@Override
		public boolean onKey(View v, int keyCode, KeyEvent event) {

			if (Integer.parseInt(String.valueOf(v.getTag())) - 1 > 0) {
				if ((((EditText) v).getText().toString() == null || ((EditText) v).getText().toString().isEmpty())
						&& keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
					// 该EditText的 内容已为空，并且 del 键按下
					v.clearFocus();// 清除该控件焦点
					v.setBackgroundResource(R.drawable.settings_set_or_confirm_pin_edit);
					erron_tips.setVisibility(View.GONE);
					// 将焦点给到前面一个EditText
					EditText editText = getEditTextFromIndex(Integer.parseInt(String.valueOf(v.getTag())) - 1);
					// editText.requestFocus(); //也可以
					editText.setBackgroundResource(R.drawable.settings_set_or_confirm_pin_edit);
					editText.requestFocusFromTouch();
				}
			}

			return false;
		}
	};

	private EditText getEditTextFromIndex(int index) {
		switch (index) {
		case 1:
			return editText1;
		case 2:
			return editText2;
		case 3:
			return editText3;
		case 4:
			return editText4;

		default:
			break;
		}
		return null;
	}

	/**
	 * 判断密码是否正确
	 */
	private boolean judgePassWord() {
		for (int i = 0; i < 4; i++) {
			if (!String.valueOf(pw.charAt(i)).equals(getEditTextFromIndex(i + 1).getText().toString())) {
				return false;// 有一个密码不符合，就立即跳出
			}
		}
		return true;
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			// 标志位 方法判断
			if (!scanEditTextHasNull()) {// 都 已输入
				if (judgePassWord()) {
					pin_continue.setBackgroundResource(R.drawable.settings_resetpin_back_red);
					pin_continue.setClickable(true);
					// ToastUtil.showToast(Settings_setup_pin.this, "PIN正确");
					erron_tips.setVisibility(View.GONE);
					ViewGroup.LayoutParams lp = lin.getLayoutParams();
					lp.height = DensityUtil.dip2px(SettingsConfirmPinActivity.this, 240);
					PreferenceUtils.setString(SettingsConfirmPinActivity.this, "pin_num", pw);

				} else {
					pin_continue.setBackgroundResource(R.drawable.settings_resetpin_back1);
					pin_continue.setClickable(false);
					editText1.setBackgroundResource(R.drawable.settings_set_or_confirm_edit);
					editText2.setBackgroundResource(R.drawable.settings_set_or_confirm_edit);
					editText3.setBackgroundResource(R.drawable.settings_set_or_confirm_edit);
					editText4.setBackgroundResource(R.drawable.settings_set_or_confirm_edit);
					ViewGroup.LayoutParams lp = lin.getLayoutParams();
					lp.height = DensityUtil.dip2px(SettingsConfirmPinActivity.this, 285);
					erron_tips.setVisibility(View.VISIBLE);
					// ToastUtil.showToast(Settings_setup_pin.this, "PIN错误");
				}
			} else {
				// ToastUtil.showToast(Settings_reset_Pin.this, "有输入框未输入值");

			}

			// 扫描输入框，是否全都已输入
			if (scanEditTextHasNull()) {
				return;
			}
			// 判断 密码有效性
			// if (judgePassWord()) {
			// startActivity(new Intent(MainActivity.this,
			// TMainActivity.class));
			// } else {
			// Toast.makeText(MainActivity.this, "密码输入错误", Toast.LENGTH_SHORT)
			// .show();
			// }

		};
	};

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.pin_con:
			if (judgePassWord()) {
				AppManager.getAppManager().finishAllActivity();
				finish();
				activityAnimationClose();
				Intent it = new Intent("com.vodafone.reset_pin_sucess");
				SettingsConfirmPinActivity.this.sendBroadcast(it);
				PreferenceUtils.setString(SettingsConfirmPinActivity.this, "pin_num",pw);
			}
			break;
		case R.id.pin_goBack:
			finish();
			activityAnimationClose();
			break;
		default:
			break;
		}
	}
}
