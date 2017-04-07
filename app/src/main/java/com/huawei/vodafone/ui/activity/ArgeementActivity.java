package com.huawei.vodafone.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huawei.vodafone.R;

public class ArgeementActivity extends BaseActivity {
	private TextView mTitle;
	private LinearLayout mPrvacy;
	private LinearLayout mTc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_argeement);
		initSecondTitle(getString(R.string.settings_terms));
		mTitle = (TextView) findViewById(R.id.title);
		mPrvacy = (LinearLayout) findViewById(R.id.linear_privaty);
		mTc = (LinearLayout) findViewById(R.id.linear_terms);
		if (getIntent().getStringExtra("from").equals("privacy")) {
			mTitle.setText(R.string.privacy);
			mPrvacy.setVisibility(View.VISIBLE);
			mTc.setVisibility(View.GONE);
		} else {
			mTitle.setText(R.string.terms);
			mPrvacy.setVisibility(View.GONE);
			mTc.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
	}
}
