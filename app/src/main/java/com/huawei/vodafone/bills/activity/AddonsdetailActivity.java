package com.huawei.vodafone.bills.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.ui.activity.BaseActivity;

/**
 * @author kanl
 *
 * @create 2016年7月29日 下午3:19:42
 */
public class AddonsdetailActivity extends BaseActivity {
	private TextView tv_buy, tv_success;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_add_ons_detail);
		initSecondTitle("Add-ons");
		initView();
	}

	private void initView() {
		tv_buy = (TextView) findViewById(R.id.tv_buy);
		tv_success = (TextView) findViewById(R.id.tv_success);
		tv_buy.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.tv_buy:
			Intent intent = new Intent(this, BuyActivity.class);
			startActivityForResult(intent, 100);
			activityAnimationUp();
			break;

		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (resultCode) {
		case RESULT_OK:
			Bundle b = data.getExtras();
			int d = b.getInt("isbuy");
			if (d == 1) {
				tv_buy.setVisibility(View.GONE);
				tv_success.setVisibility(View.VISIBLE);
				tv_success
						.setText(Html
								.fromHtml("You've added "
										+ "<b>Vodafone protect plus</b>"
										+ " to your plan.This could take up to 24 hours to update on your account"));
			}
			break;
		default:
			break;
		}
	}
}
