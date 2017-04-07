package com.huawei.vodafone.products.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.ui.activity.BaseActivity;

public class ServiceDetailsActivity extends BaseActivity {

	private View status_bar_bg;
	private RelativeLayout bar_layout;
	private ImageView menu_btn;
	private LinearLayout lin_top;
	private LinearLayout linear_privaty;
	private TextView tv_buy_mail;
	private TextView tv_mail_success;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_details);
		initSecondTitle("Services");
		initView();
	}

	public void initView() {
		status_bar_bg = findViewById(R.id.status_bar_bg);
		bar_layout = (RelativeLayout) findViewById(R.id.bar_layout);
		menu_btn = (ImageView) findViewById(R.id.menu_btn);
		lin_top = (LinearLayout) findViewById(R.id.lin_top);
		linear_privaty = (LinearLayout) findViewById(R.id.linear_privaty);
		tv_buy_mail = (TextView) findViewById(R.id.tv_buy_mail);
		tv_mail_success = (TextView) findViewById(R.id.tv_mail_success);
		tv_buy_mail.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.tv_buy_mail:
			Intent intent = new Intent(this, BuyMailActivity.class);
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
		switch (resultCode) { // resultCode为回传的标记，我在B中回传的是RESULT_OK
		case RESULT_OK:
			Bundle b = data.getExtras(); // data为B中回传的Intent
			int d = b.getInt("isbuy");// str即为回传的值
			if (d == 1) {
				tv_buy_mail.setVisibility(View.GONE);
				tv_mail_success.setVisibility(View.VISIBLE);
			}
			break;
		default:
			break;
		}
	}
}
