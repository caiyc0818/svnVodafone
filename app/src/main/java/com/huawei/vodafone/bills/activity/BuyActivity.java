package com.huawei.vodafone.bills.activity;

import com.huawei.vodafone.R;
import com.huawei.vodafone.ui.activity.BaseActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author kanl
 *
 * @create 2016年7月29日 下午5:06:58
 */
public class BuyActivity extends BaseActivity {
	private ImageView close_iv;
	private TextView tv_yes,tv_no;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.buy_activity);
		initView();
	}

	private void initView() {
		tv_yes = (TextView) findViewById(R.id.tv_yes);
		tv_no = (TextView) findViewById(R.id.tv_no);
		close_iv = (ImageView) findViewById(R.id.close_iv);
		tv_yes.setOnClickListener(this);
		tv_no.setOnClickListener(this);
		close_iv.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.close_iv:
			finish();
			activityAnimationDown();
			break;
		case R.id.tv_yes:
			Intent intent = new Intent();
			intent.putExtra("isbuy", 1);
			setResult(RESULT_OK, intent);
			finish();
			activityAnimationDown();
			break;
		case R.id.tv_no:
			finish();
			activityAnimationDown();
			break;

		default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
		activityAnimationDown();
	}

}
