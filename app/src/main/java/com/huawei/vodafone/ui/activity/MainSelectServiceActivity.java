package com.huawei.vodafone.ui.activity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.huawei.vodafone.R;
import com.huawei.vodafone.ui.adapter.SelectServceListAdapter;
import com.huawei.vodafone.ui.myview.CharacterParser;
import com.huawei.vodafone.util.TAGUtil;

/**
 * @author weich 首页账号切换
 */
public class MainSelectServiceActivity extends BaseActivity implements
		OnItemClickListener {

	private RelativeLayout toprl, searchrl;
	private ImageView searchIV;
	private ImageView close;
	private EditText searchEdit;
	private ImageView delete;
	private ListView searchList;
	private SelectServceListAdapter adapter;
	private int select = 0;
	private CharacterParser characterParser;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_select_servce);
		initView();
	}

	private void initView() {
		toprl = (RelativeLayout) findViewById(R.id.top_rl);
		searchrl = (RelativeLayout) findViewById(R.id.search_rl);
		searchIV = (ImageView) findViewById(R.id.support_search_iv);
		close = (ImageView) findViewById(R.id.close_iv);
		searchEdit = (EditText) findViewById(R.id.search_et);
		delete = (ImageView) findViewById(R.id.delete_iv);
		searchList = (ListView) findViewById(R.id.search_list);

		characterParser = CharacterParser.getInstance();
		searchList.setOnItemClickListener(this);
		searchIV.setOnClickListener(this);
		close.setOnClickListener(this);
		delete.setOnClickListener(this);
		select = getIntent().getIntExtra("select", select);
		fake();
		searchEdit.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				filterData(s.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void fake() {

		adapter = new SelectServceListAdapter(getBaseContext());
		searchList.setAdapter(adapter);
	}

	private void filterData(String filterStr) {
		// ArrayList<OfferInstValue> filterDateList = new
		// ArrayList<OfferInstValue>();
		//
		// if (TextUtils.isEmpty(filterStr)) {
		// filterDateList = list;
		// } else {
		// filterDateList.clear();
		// if (isNumeric(filterStr)) {
		// for (OfferInstValue companyMailListBean : list) {
		// String mobile = companyMailListBean.getMaxNumber();
		// if (mobile.startsWith(filterStr.toString())) {
		// filterDateList.add(companyMailListBean);
		// }
		// }
		//
		// } else {
		// for (OfferInstValue companyMailListBean : list) {
		// String name = companyMailListBean.getOfferName()
		// .toLowerCase();
		// if (name.startsWith(filterStr.toLowerCase())) {
		// filterDateList.add(companyMailListBean);
		// }
		// }
		// }
		// }
		//
		// adapter.setList(filterDateList);
	}

	public boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.support_search_iv:
			if (searchrl.isShown()) {
				searchrl.setVisibility(View.GONE);
				toprl.setBackgroundColor(getResources().getColor(
						R.color.gray_search));
			} else {
				searchrl.setVisibility(View.VISIBLE);
				toprl.setBackgroundResource(R.drawable.search_bg);
			}
			break;
		case R.id.close_iv:
			finish();
			activityAnimationDown();
			break;
		case R.id.delete_iv:
			searchEdit.setText("");
			break;
		default:
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Intent intent = new Intent();
		intent.putExtra("select", adapter.getselect(arg2));
		setResult(TAGUtil.tag1, intent);
		finish();
		activityAnimationDown();
	}

}
