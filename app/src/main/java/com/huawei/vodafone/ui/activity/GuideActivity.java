package com.huawei.vodafone.ui.activity;

import com.huawei.vodafone.R;
import com.huawei.vodafone.util.PreferenceUtils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Privacy and T&C
 * @author luow
 *
 */
public class GuideActivity extends BaseActivity {
	private TextView mTextContext;
	private Button cancle_btn;
	private Button ok_btn;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		isFirst();
		setContentView(R.layout.activity_guide);
		context = this;
		initView();
		initData();
		
	}

	private void initData() {
		String a1 = getResources().getString(R.string.tutorial_context_three);
		String a2 = getResources().getString(R.string.tutorial_context_four);
		String a3 = getResources().getString(R.string.tutorial_context_five);
		String a4 = getResources().getString(R.string.tutorial_context_six);
		SpannableString spanttt = new SpannableString(a1 + a2 + a3 + a4);

		spanttt.setSpan(new TextViewURLSpan1(), a1.length(), a1.length() + a2.length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		spanttt.setSpan(new TextViewURLSpan2(), a1.length() + a2.length() + a3.length(),
				a1.length() + a2.length() + a3.length() + a4.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		mTextContext.setText(spanttt);
		mTextContext.setMovementMethod(LinkMovementMethod.getInstance());
	}

	private void initView() {
		mTextContext = (TextView) findViewById(R.id.tv_context);
		cancle_btn = (Button) findViewById(R.id.cancle_btn);
		ok_btn = (Button) findViewById(R.id.ok_btn);
		cancle_btn.setOnClickListener(this);
		ok_btn.setOnClickListener(this);
	}

	private void isFirst() {
		boolean isFirst = (boolean) PreferenceUtils.getBoolean(this, "isFirst");
		if (isFirst) {
			Intent it = new Intent(GuideActivity.this, LoginActivity.class);
			startActivity(it);
			finish();
		}
		
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.cancle_btn:
			finish();
			break;
		case R.id.ok_btn:
			startActivity(new Intent(context, LoginActivity.class));
			finish();
			break;

		default:
			break;
		}
	}

	/**
	 * Privacy policy点击监听 新增说明 样式
	 **/
	private class TextViewURLSpan1 extends ClickableSpan {

		public TextViewURLSpan1() {

		}

		@Override
		public void updateDrawState(TextPaint ds) {
			ds.setUnderlineText(true); // 去掉下划线
		}

		@Override
		public void onClick(View widget) {
			Intent it = new Intent(context, ArgeementActivity.class);
			it.putExtra("from", "privacy");
			startActivity(it);
		}
	}

	/**
	 * T&C's点击监听 新增说明 样式
	 **/
	private class TextViewURLSpan2 extends ClickableSpan {

		public TextViewURLSpan2() {

		}

		@Override
		public void updateDrawState(TextPaint ds) {
			ds.setUnderlineText(true); // 去掉下划线
		}

		@Override
		public void onClick(View widget) {
			Intent it = new Intent(context, ArgeementActivity.class);
			it.putExtra("from", "tc");
			startActivity(it);
		}
	}

}
