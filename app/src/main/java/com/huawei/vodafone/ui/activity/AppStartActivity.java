package com.huawei.vodafone.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.huawei.vodafone.R;
import com.igexin.sdk.PushManager;
import com.igexin.sdk.PushService;

/**
 * 引导界面
 * 
 * @author luow
 *
 */
public class AppStartActivity extends BaseActivity {
	static Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_start);
		PushManager.getInstance().initialize(this.getApplicationContext(), PushService.class);
		handler.postDelayed(StartRunnable, 1500);

	}

	private Runnable StartRunnable = new Runnable() {
		@Override
		public void run() {
			goNextActivity();
			finish();
		}
	};

	private void goNextActivity() {
		Intent it = new Intent(AppStartActivity.this, GuideActivity.class);
		startActivity(it);
	}

}
