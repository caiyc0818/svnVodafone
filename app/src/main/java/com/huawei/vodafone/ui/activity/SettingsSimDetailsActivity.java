package com.huawei.vodafone.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.UserInfo;

public class SettingsSimDetailsActivity extends BaseActivity implements
		OnClickListener {

	private ImageView go_left;
	private ImageView go_right;
	private ImageView imageView;
	private ImageView imageView2;
	private TextView text2;
	private TextView text1;
	private TextView phone2;
	private LinearLayout phone;
	private LinearLayout conunt1;
	private LinearLayout conunt2;
	private int num;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_sim_detail);
		initSecondTitle(getString(R.string.settings_SIM_details));
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub

		go_right = (ImageView) findViewById(R.id.go_right);
		imageView = (ImageView) findViewById(R.id.image1);
		imageView2 = (ImageView) findViewById(R.id.image11);
		go_left = (ImageView) findViewById(R.id.go_left);
		text1 = (TextView) findViewById(R.id.text1);
		text2 = (TextView) findViewById(R.id.text2);
		phone2 = (TextView) findViewById(R.id.phone2);
		phone = (LinearLayout) findViewById(R.id.phone);
		conunt1 = (LinearLayout) findViewById(R.id.converged2);
		conunt2 = (LinearLayout) findViewById(R.id.converged);
		go_left.setOnClickListener(this);
		go_right.setOnClickListener(this);
		phone.setOnClickListener(this);
		phone.setVisibility(View.VISIBLE);
		conunt1.setVisibility(View.GONE);
		conunt2.setVisibility(View.GONE);
		imageView.setVisibility(View.VISIBLE);
		String mobile = UserInfo.getUserMobile();
		text1.setText(UserInfo.getUserName() + "'s" + " phone");
		text2.setText(mobile);
		phone2.setText(mobile);
		imageView.setImageBitmap(UserInfo.getIcon(getBaseContext()));
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.go_right:
			num++;
			if (num % 2 == 0) {
				phone.setVisibility(View.VISIBLE);
				conunt1.setVisibility(View.GONE);
				conunt2.setVisibility(View.GONE);
				imageView.setVisibility(View.VISIBLE);
				imageView2.setVisibility(View.GONE);
				text2.setVisibility(View.VISIBLE);
				text1.setText("David's phone");
				text2.setText("07785460399");
				phone2.setText("07785460399");
				imageView.setImageResource(R.drawable.david_ic);
			} else if (num % 2 == 1) {
				imageView.setVisibility(View.VISIBLE);
				imageView2.setVisibility(View.GONE);
				phone.setVisibility(View.VISIBLE);
				text2.setVisibility(View.VISIBLE);
				text1.setText("Jen's phone");
				text2.setText("07783947975");
				phone2.setText("07783947975");
				imageView.setImageResource(R.drawable.jen);
			}
			break;
		case R.id.go_left:
			num--;
			if (num % 2 == 0) {
				text1.setText("David's phone");
				text2.setText("07785460399");
				phone2.setText("07785460399");
				phone.setVisibility(View.VISIBLE);
				imageView.setVisibility(View.VISIBLE);
				imageView2.setVisibility(View.GONE);
				conunt1.setVisibility(View.GONE);
				conunt2.setVisibility(View.GONE);
				text2.setVisibility(View.VISIBLE);
				imageView.setImageResource(R.drawable.david_ic);
			} else if (num % 2 == 1) {
				phone.setVisibility(View.VISIBLE);
				imageView.setVisibility(View.VISIBLE);
				imageView2.setVisibility(View.GONE);
				conunt1.setVisibility(View.GONE);
				conunt2.setVisibility(View.GONE);
				text1.setText("Jen's phone");
				text2.setText("07783947975");
				phone2.setText("07783947975");
				text2.setVisibility(View.VISIBLE);
				imageView.setImageResource(R.drawable.jen);
			}

			break;
		case R.id.phone:
			// Intent intent = new Intent(SettingsSimDetailsActivity.this,
			// SettingsSimDetailsActivity2.class);
			// startActivity(intent);
			// activityAnimationOpen();
			break;

		default:
			break;
		}
	}
}
