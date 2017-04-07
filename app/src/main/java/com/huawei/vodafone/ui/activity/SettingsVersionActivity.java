package com.huawei.vodafone.ui.activity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.huawei.vodafone.R;

public class SettingsVersionActivity extends BaseActivity implements
		OnClickListener {

	private TextView version_code;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_version);
		initSecondTitle(getString(R.string.settings_version));
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub

		version_code = (TextView) findViewById(R.id.version_code);
		version_code.setText(String
				.valueOf(getVersionName(SettingsVersionActivity.this))
				+ " "
				+ getResources().getString(
						R.string.settings_version_for_android));

	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {

		default:
			break;
		}
	}

	public static String getVersionName(Context context) {
		return getPackageInfo(context).versionName;
	}

	// 版本号
	public static int getVersionCode(Context context) {
		return getPackageInfo(context).versionCode;
	}

	private static PackageInfo getPackageInfo(Context context) {
		PackageInfo pi = null;

		try {
			PackageManager pm = context.getPackageManager();
			pi = pm.getPackageInfo(context.getPackageName(),
					PackageManager.GET_CONFIGURATIONS);

			return pi;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pi;
	}
}
