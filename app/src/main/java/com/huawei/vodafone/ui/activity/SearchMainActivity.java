package com.huawei.vodafone.ui.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.ui.adapter.FaqsSearchAdapter;
import com.huawei.vodafone.util.StringUtils;

/**
 * @author weich 搜索
 */
public class SearchMainActivity extends BaseActivity {
	private ImageView close_iv;
	private AutoCompleteTextView searchEt;
	private TextView search_data;
	private TextView search_call;
	private TextView search_vodafone;
	private ImageView search_go_iv;
	private int num = 1;
	private String value = "data";

	private boolean needrefresh = false;
	private ImageView delete_iv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_main);
		initView();
	}

	private void initView() {
		close_iv = (ImageView) findViewById(R.id.back);
		searchEt = (AutoCompleteTextView) findViewById(R.id.search_et);
		search_data = (TextView) findViewById(R.id.search_data);
		search_call = (TextView) findViewById(R.id.search_call);
		search_vodafone = (TextView) findViewById(R.id.search_vodafone);
		search_go_iv = (ImageView) findViewById(R.id.search_go_iv);
		delete_iv = (ImageView) findViewById(R.id.delete_iv);

		close_iv.setOnClickListener(this);
		search_go_iv.setOnClickListener(this);
		search_data.setOnClickListener(this);
		search_call.setOnClickListener(this);
		search_vodafone.setOnClickListener(this);
		delete_iv.setOnClickListener(this);
		addSearchData();
		delete_iv.setVisibility(View.GONE);
		searchEt.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				if (StringUtils.isEmpty(s.toString())) {
					delete_iv.setVisibility(View.GONE);
				} else {
					delete_iv.setVisibility(View.VISIBLE);
				}
			}
		});
	}

	private void addSearchData() {
		List<String> strs = new ArrayList<String>();
		strs.add("Vodafone");
		strs.add("Call");
		strs.add("Data");
		strs.add("My order");
		strs.add("Useful numbers");
		strs.add("My bill");
		FaqsSearchAdapter faqsSearchAdapter = new FaqsSearchAdapter(strs,
				SearchMainActivity.this);
		searchEt.setAdapter(faqsSearchAdapter);
		searchEt.setThreshold(1); // 设置输入一个字符 提示，默认为2
		searchEt.setDropDownAnchor(R.id.search_et);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(SearchMainActivity.this,
				SearchDetailActivity.class);
		switch (v.getId()) {
		case R.id.back:
			finish();
			activityAnimationDown();
			return;
		case R.id.search_data:
			intent.putExtra("name", "Data");
			break;
		case R.id.search_call:
			intent.putExtra("name", "Call");
			break;
		case R.id.search_vodafone:
			intent.putExtra("name", "Vodafone");
			break;
		case R.id.search_go_iv:
			intent.putExtra("name", searchEt.getText().toString() + "");
			break;
		case R.id.delete_iv:
			searchEt.setText("");
			return;
		default:
			break;
		}
		startActivity(intent);
		activityAnimationOpen();
	}
}
