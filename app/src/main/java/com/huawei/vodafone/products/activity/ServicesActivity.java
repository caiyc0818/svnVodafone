package com.huawei.vodafone.products.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.huawei.vodafone.R;
import com.huawei.vodafone.ui.activity.BaseActivity;

public class ServicesActivity extends BaseActivity {
	private LinearLayout ll_mail;
	private LinearLayout ll_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_services);
		initSecondTitle("Services");
		ll_mail = (LinearLayout) findViewById(R.id.ll_mail);
		ll_text = (LinearLayout) findViewById(R.id.lin_text);
		ll_mail.setOnClickListener(this);
		ll_text.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.ll_mail:
			startActivity(new Intent(ServicesActivity.this,
					ServiceDetailsActivity.class));
			activityAnimationOpen();
			break;
		case R.id.lin_text:

			break;
		default:
			break;
		}
	}
}
