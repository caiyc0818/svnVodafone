package com.huawei.vodafone.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.huawei.vodafone.R;

/**
 * @author weich 签到rules
 */
public class SignRulesActivity extends BaseActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_in_rules);
		initSecondTitle(getString(R.string.integral_rules));
		initView();
	}

	private void initView() {
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		default:
			break;
		}
	}

}
