package com.huawei.vodafone.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.vodafone.R;

public class SettingsPersonaliseYourSerPicActivity extends BaseActivity
		implements OnClickListener {
	private ImageView user_image;
	private TextView text1;
	private TextView text2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_personalise_you_services);
		initSecondTitle(getString(R.string.settings_personalise_services));
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		user_image = (ImageView) findViewById(R.id.image1);
		text1 = (TextView) findViewById(R.id.text1);
		text2 = (TextView) findViewById(R.id.text2);
		text1.setOnClickListener(this);
		text2.setOnClickListener(this);
		Intent intent = getIntent();
		Bitmap bitmap = intent.getParcelableExtra("bitmap");
		user_image.setImageBitmap(bitmap);

	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.text1:
			Intent resultIntent = new Intent(this,
					SettingsPersonaliseYourSerActivity.class);
			setResult(1004, resultIntent);
			finish();
			activityAnimationClose();
			break;
		case R.id.text2:
			finish();
			activityAnimationClose();
			break;

		default:
			break;
		}
	}
}
