package com.huawei.vodafone.ui.activity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.ui.adapter.SignInHistoryRightListAdapter;
import com.huawei.vodafone.ui.adapter.SignInHistoryleftListAdapter;

/**
 * @author weich 签到历史
 */
public class SignHistoryActivity extends BaseActivity {
	private TextView income_tv;
	private ImageView income_iv;
	private TextView expense_tv;
	private ImageView expense_iv;
	private ListView history_list;
	private SignInHistoryleftListAdapter leftadapter;
	private SignInHistoryRightListAdapter rightadapter;
	private LinearLayout history_layout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_in_history);
		initSecondTitle(getString(R.string.history));
		initView();
	}

	private void initView() {
		history_layout = (LinearLayout) findViewById(R.id.history_layout);
		income_tv = (TextView) findViewById(R.id.income_tv);
		income_iv = (ImageView) findViewById(R.id.income_iv);
		expense_tv = (TextView) findViewById(R.id.expense_tv);
		expense_iv = (ImageView) findViewById(R.id.expense_iv);
		history_list = (ListView) findViewById(R.id.history_list);

		leftadapter = new SignInHistoryleftListAdapter(getBaseContext(), 4);
		rightadapter = new SignInHistoryRightListAdapter(getBaseContext(), 2);
		history_list.setAdapter(leftadapter);
		income_tv.setOnClickListener(this);
		expense_tv.setOnClickListener(this);
		income_tv.setText(Html.fromHtml("<b>Earned</b>"));
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.income_tv:
			setselect(0);
			history_list.setAdapter(leftadapter);
			break;
		case R.id.expense_tv:
			setselect(1);
			history_list.setAdapter(rightadapter);
			break;
		default:
			break;
		}
	}

	private void setselect(int num) {
		switch (num) {
		case 0:
			income_tv.setText(Html.fromHtml("<b>Earned</b>"));
			expense_tv.setText("Spent");
			income_iv.setVisibility(View.VISIBLE);
			expense_iv.setVisibility(View.INVISIBLE);
			history_layout.setBackgroundResource(R.color.white);
			break;
		case 1:
			income_tv.setText("Earned");
			expense_tv.setText(Html.fromHtml("<b>Spent</b>"));
			income_iv.setVisibility(View.INVISIBLE);
			expense_iv.setVisibility(View.VISIBLE);
			history_layout.setBackgroundResource(R.color.white);
			break;
		default:
			break;
		}
	}

}
