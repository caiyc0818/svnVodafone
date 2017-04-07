package com.huawei.vodafone.ui.activity;

import java.util.Date;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.db.DBSignInAdapter;
import com.huawei.vodafone.listener.Listener.Click;
import com.huawei.vodafone.ui.myview.RoundProgressBar;
import com.huawei.vodafone.ui.myview.dialog.ExchangeDialog;
import com.huawei.vodafone.util.DateUtil;
import com.huawei.vodafone.util.PreferenceUtils;
import com.huawei.vodafone.util.StringUtils;
import com.huawei.vodafone.util.TAGUtil;

/**
 * @author weich 签到主页面
 */
public class SignMainActivity extends BaseActivity {
	private RelativeLayout sign_in_cirle;
	private RoundProgressBar flow_progreessbar;
	private TextView integral_rules;
	private TextView credits_exchange;
	private TextView integral_history;
	private TextView continuous_days;
	private int day = 4;
	private int days;
	private Handler handler;
	private Runnable run;
	private int proday;
	private TextView pointsNum;
	private DBSignInAdapter db;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_in_main);
		initSecondTitle(getString(R.string.sign_in));
		initView();
	}

	private void initView() {
		sign_in_cirle = (RelativeLayout) findViewById(R.id.sign_in_cirle);
		flow_progreessbar = (RoundProgressBar) findViewById(R.id.flow_progreessbar);
		integral_rules = (TextView) findViewById(R.id.integral_rules);
		credits_exchange = (TextView) findViewById(R.id.credits_exchange);
		integral_history = (TextView) findViewById(R.id.integral_history);
		continuous_days = (TextView) findViewById(R.id.continuous_days);
		pointsNum = (TextView) findViewById(R.id.points_num);

		integral_rules.setOnClickListener(this);
		credits_exchange.setOnClickListener(this);
		integral_history.setOnClickListener(this);
		sign_in_cirle.setOnClickListener(this);
		initbar();
	}

	private void initbar() {
		int Points = PreferenceUtils.getInt(getBaseContext(), "SignInPoints");
		pointsNum.setText(StringUtils.formatDecimalFloat(Points, 0));

		days = PreferenceUtils.getInt(getBaseContext(), "SignInDays", 0);
		long time = PreferenceUtils.getLong(getBaseContext(), "SignInTime", 0);
		long cuttime = DateUtil.ConverToDate(
				DateUtil.ConverToString(new Date(), "yyyyMMdd"), "yyyyMMdd")
				.getTime();
		sign_in_cirle.setEnabled(false);
		if (cuttime < time) {
			AnimaBar();
		} else if (time < cuttime && cuttime - time < 24 * 60 * 60 * 1000) {
			autocheck();
		} else {
			PreferenceUtils.setInt(getBaseContext(), "SignInDays", 0);
			days = 0;
			autocheck();
		}
	}

	/**
	 * 进度条动画
	 */
	private void AnimaBar() {
		flow_progreessbar.setProgressth(0, 0);
		flow_progreessbar.setProgress(0);
		proday = 0;
		handler = new Handler();
		run = new Runnable() {

			@Override
			public void run() {
				if (proday / 10 < days && proday / 10 < 10) {
					flow_progreessbar.setProgress(++proday);
					continuous_days.setText(proday / 10 + "");
					handler.postDelayed(run, 5);
				}
			}
		};
		handler.postDelayed(run, 300);
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.sign_in_cirle:

			break;
		case R.id.integral_rules:
			startActivity(new Intent(SignMainActivity.this,
					SignRulesActivity.class));
			activityAnimationOpen();
			break;
		case R.id.credits_exchange:
			startActivityForResult(new Intent(SignMainActivity.this,
					SignCreditsActivity.class), TAGUtil.tag12);
			activityAnimationOpen();
			break;
		case R.id.integral_history:
			startActivity(new Intent(SignMainActivity.this,
					SignHistoryActivity.class));
			activityAnimationOpen();
			break;
		default:
			break;
		}
	}

	private void autocheck() {
		days = days >= 10 ? 0 : days;
		int Points = PreferenceUtils.getInt(getBaseContext(), "SignInPoints") + 5;
		PreferenceUtils.setInt(getBaseContext(), "SignInDays", ++days);
		PreferenceUtils.setLong(getBaseContext(), "SignInTime",
				System.currentTimeMillis());
		PreferenceUtils.setInt(getBaseContext(), "SignInPoints", Points);
		if (db == null)
			db = new DBSignInAdapter(this);
		db.openDb();
		db.insert("sign in", DateUtil.ConverToString(new Date(), "yyyy-MM-dd"),
				days, 5, 1);
		db.closeDb();
		AnimaBar();
		sign_in_cirle.setEnabled(false);
		if (days >= 10) {
			Points = Points + 100;
			PreferenceUtils.setInt(getBaseContext(), "SignInPoints", Points);
			db.openDb();
			db.insert("sign in",
					DateUtil.ConverToString(new Date(), "yyyy-MM-dd"), days,
					100, 1);
			db.closeDb();

			ExchangeDialog dialog = new ExchangeDialog(SignMainActivity.this,
					R.layout.sign_in_congratulate_dialog,
					getString(R.string.congratulations));
			dialog.show();
			dialog.setClick(new Click() {
				@Override
				public void onClicked(Object num, int num1, String num2,
						boolean num3) {
					if (num3) {
						startActivity(new Intent(SignMainActivity.this,
								SignCreditsActivity.class));
						activityAnimationOpen();
					}

				}
			});
		}
		pointsNum.setText(StringUtils.formatDecimalFloat(Points, 0));
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == TAGUtil.tag12) {
			pointsNum
					.setText(StringUtils.formatDecimalFloat(PreferenceUtils
							.getInt(getBaseContext(), "SignInPoints"), 0));
		}
	}
}
