package com.huawei.vodafone.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;

import com.huawei.vodafone.R;

public class SettingsPersonaliseSelectYourHomeScreenServiceActivity extends
		BaseActivity implements OnClickListener {
	private RadioButton CheckBox1;
	private RadioButton CheckBox2;
	private RadioButton CheckBox3;
	private Button save;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_personalise_select);
		initSecondTitle(getString(R.string.settings_select_service));
		initView();
	}

	private void initView() {

		CheckBox1 = (RadioButton) findViewById(R.id.CheckBox1);
		CheckBox2 = (RadioButton) findViewById(R.id.CheckBox2);
		CheckBox3 = (RadioButton) findViewById(R.id.CheckBox3);
		save = (Button) findViewById(R.id.save);
		save.setOnClickListener(this);
		CheckBox1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					CheckBox2.setChecked(false);
					CheckBox3.setChecked(false);
				}
			}
		});
		CheckBox2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					CheckBox1.setChecked(false);
					CheckBox3.setChecked(false);
				}
			}
		});
		CheckBox3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					CheckBox2.setChecked(false);
					CheckBox1.setChecked(false);
				}
			}
		});

	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.save:
			finish();
			break;
		default:
			break;
		}
	}
}
