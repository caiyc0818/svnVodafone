package com.huawei.vodafone.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.ui.adapter.SearchListAdapter;
import com.huawei.vodafone.ui.myview.dialog.SuccessDialog;
import com.huawei.vodafone.util.TAGUtil;

/**
 * @author weich 搜索
 */
public class SearchDetailActivity extends BaseActivity implements
		OnItemClickListener {
	private TextView search_text;
	private ListView search_list;

	private int type = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_detail);
		initSecondTitle(getString(R.string.search_hint));
		initView();
	}

	private void initView() {
		search_text = (TextView) findViewById(R.id.search_text);
		search_list = (ListView) findViewById(R.id.search_list);

		String name = getIntent().getStringExtra("name");
		if (name.toLowerCase().equals("data")) {
			search_list.setAdapter(new SearchListAdapter(getBaseContext(), 3,
					type));
			search_text.setText(Html.fromHtml("<b>" + name
					+ "</b><br>3 results"));
		} else if (name.toLowerCase().equals("call")) {
			type = 1;
			search_list.setAdapter(new SearchListAdapter(getBaseContext(), 1,
					type));
			search_text.setText(Html.fromHtml("<b>" + name
					+ "<br></b>1 results"));
		} else {
			search_text.setText(Html.fromHtml("<b>" + name
					+ "<br></b>0 results"));
		}
		search_list.setOnItemClickListener(this);
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {

		default:
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Intent intent = new Intent(SearchDetailActivity.this,
				MainAddDataActivity.class);
		if (type == 1) {
			intent.putExtra("add", 2);
			intent.putExtra("type", type);
		} else {
			intent.putExtra("add", arg2 + 1);
			intent.putExtra("type", type);
		}

		startActivityForResult(intent, 100);
		activityAnimationUp();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == TAGUtil.tag3) {
			SuccessDialog dialog = new SuccessDialog(this);
			dialog.settext(data.getStringExtra("message"));
			dialog.show();
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
}
