package com.huawei.vodafone.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.huawei.vodafone.R;

public class SettingsTermsActivity extends BaseActivity implements
		OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_terms);
		initSecondTitle(getString(R.string.settings_terms));
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
