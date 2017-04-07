package com.huawei.vodafone.bills.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.huawei.vodafone.R;
import com.huawei.vodafone.ui.activity.BaseActivity;

/**
 * @author kanl
 *
 * @create 2016年7月29日 下午2:21:46
 */
public class AddOnsActivity extends BaseActivity {
	private LinearLayout lin_lt;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_add_ons);
		initSecondTitle("Add-ons");
		initView();
	}

	private void initView() {
		lin_lt = (LinearLayout) findViewById(R.id.lin_lt);
		lin_lt.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.lin_lt:
			Intent intent = new Intent(AddOnsActivity.this,
					AddonsdetailActivity.class);
			startActivity(intent);
			activityAnimationOpen();
			break;
		default:
			break;
		}
	}

}
