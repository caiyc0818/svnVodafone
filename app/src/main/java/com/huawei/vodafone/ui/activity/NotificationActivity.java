package com.huawei.vodafone.ui.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.huawei.swipemenulistview.SwipeMenu;
import com.huawei.swipemenulistview.SwipeMenuCreator;
import com.huawei.swipemenulistview.SwipeMenuItem;
import com.huawei.swipemenulistview.SwipeMenuListView;
import com.huawei.swipemenulistview.SwipeMenuListView.OnMenuItemClickListener;
import com.huawei.vodafone.R;
import com.huawei.vodafone.db.DBAdapter;
import com.huawei.vodafone.db.JokeMsg;
import com.huawei.vodafone.ui.adapter.NotificationAdapter;

public class NotificationActivity extends BaseActivity implements
		OnClickListener, OnItemClickListener {

	private LinearLayout ll_usage;
	private LinearLayout ll_bulling;
	private LinearLayout ll_offers;
	private ImageView ll_image_usage;
	private ImageView ll_image_bulling;
	private ImageView ll_image_offers;
	private ImageView back;
	private SwipeMenuListView swipeMenuListView;
	private NotificationAdapter adapter;
	private ArrayList<JokeMsg> data;
	private ScrollView scrollView;
	private int flag = 0;
	DBAdapter db;
	private List<JokeMsg> data1 = new ArrayList<JokeMsg>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification);
		initSecondTitle("Notifications");
		db = new DBAdapter(this);
		db.openDb();
		if (db.queryAllRecord() != null) {
			data1 = db.queryAllRecord();
		}
		db.closeDb();
		Log.d("dataa1", data1.size() + "");

		initView();
	}

	private void initView() {
		// String json="{\"data\":[{\"type\":"usage","",""}]}";
		ll_usage = (LinearLayout) findViewById(R.id.ll_usage);
		ll_bulling = (LinearLayout) findViewById(R.id.ll_bulling);
		ll_offers = (LinearLayout) findViewById(R.id.ll_offers);
		ll_image_usage = (ImageView) findViewById(R.id.ll_image_usage);
		ll_image_bulling = (ImageView) findViewById(R.id.ll_image_bulling);
		ll_image_offers = (ImageView) findViewById(R.id.ll_image_offers);
		back = (ImageView) findViewById(R.id.back);
		ll_usage.setOnClickListener(this);
		ll_bulling.setOnClickListener(this);
		ll_offers.setOnClickListener(this);
		back.setOnClickListener(this);
		scrollView = (ScrollView) findViewById(R.id.ss);
		scrollView.smoothScrollTo(0, 20);
		swipeMenuListView = (SwipeMenuListView) findViewById(R.id.swipeMenuListView);
		swipeMenuListView.setOnItemClickListener(this);
		swipeMenuListView.setDivider(null);
		data = new ArrayList<JokeMsg>();
		adapter = new NotificationAdapter(this, data1, -1);
		swipeMenuListView.setAdapter(adapter);
		// step 1. create a MenuCreator
		SwipeMenuCreator creator = new SwipeMenuCreator() {

			@Override
			public void create(SwipeMenu menu) {
				SwipeMenuItem item1 = new SwipeMenuItem(getApplicationContext());
				item1.setBackground(new ColorDrawable(getResources().getColor(
						R.color.bg_delete)));
				item1.setWidth(dp2px(90));
				item1.setIcon(R.drawable.bg_delete);
				menu.addMenuItem(item1);
				SwipeMenuItem item2 = new SwipeMenuItem(getApplicationContext());
				item2.setBackground(new ColorDrawable(getResources().getColor(
						R.color.bg_mark)));
				item2.setWidth(dp2px(90));
				item2.setIcon(R.drawable.bg_mark);
				menu.addMenuItem(item2);
				// SwipeMenuItem item3 = new
				// SwipeMenuItem(getApplicationContext());
				// item3.setBackground(new
				// ColorDrawable(getResources().getColor(R.color.bg_archive)));
				// item3.setWidth(dp2px(90));
				// item3.setIcon(R.drawable.bg_archive);
				// menu.addMenuItem(item3);
			}
		};

		swipeMenuListView
				.setOnMenuItemClickListener(new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(int position,
							SwipeMenu menu, int index) {
						switch (index) {
						case 0:
							adapter.delete(position);
							// ToastUtil.showToast(getApplicationContext(),
							// "你点击的是position：" + position);
							break;
						case 1:
							setRead(position);
							break;
						}
						return false;
					}
				});
		// set creator
		swipeMenuListView.setMenuCreator(creator);
	}

	private void setRead(int position) {
		// adapter = new
		// NotificationAdapter(NotificationActivity.this,
		// data,
		// position);
		// swipeMenuListView.setAdapter(adapter);
		DBAdapter db = new DBAdapter(NotificationActivity.this);
		db.openDb();

		if (flag == 1) {
			// for(int i=0;i<data1.size();i++){
			// if(data1.get(i).getType().equals("usage")){
			// if (db.queryAllRecord() != null) {
			// data1 = db.queryAllRecord();
			// }
			// data.add(new JokeMsg(data1.get(i).getIdd(),
			// data1.get(i).getType(),
			// data1.get(i).getCode(),
			// data1.get(i).getContent()));
			// }
			// }

			db.update(data.get(position).getIdd());
			Log.d("data", data.get(position).getIdd());
			Log.d("data", position + "");

			data.clear();
			for (int i = 0; i < data1.size(); i++) {
				if (data1.get(i).getType().equals("usage")) {
					if (db.queryAllRecord() != null) {
						data1 = db.queryAllRecord();
					}
					data.add(new JokeMsg(data1.get(i).getIdd(), data1.get(i)
							.getType(), data1.get(i).getCode(), data1.get(i)
							.getContent()));
				}
			}
			db.closeDb();
			adapter = new NotificationAdapter(NotificationActivity.this, data,
					-1);
		} else if (flag == 2) {
			// for(int i=0;i<data1.size();i++){
			// if(data1.get(i).getType().equals("billing")){
			// db.update(data1.get(position).getIdd());
			// if (db.queryAllRecord() != null) {
			// data1 = db.queryAllRecord();
			// }
			// data.add(new JokeMsg(data1.get(i).getIdd(),
			// data1.get(i).getType(),
			// data1.get(i).getCode(),
			// data1.get(i).getContent()));
			// }
			// }

			db.update(data.get(position).getIdd());
			Log.d("data", data1.get(position).getIdd());

			data.clear();
			for (int i = 0; i < data1.size(); i++) {
				if (data1.get(i).getType().equals("billing")) {
					// db.update(data1.get(position).getIdd());
					if (db.queryAllRecord() != null) {
						data1 = db.queryAllRecord();
					}
					data.add(new JokeMsg(data1.get(i).getIdd(), data1.get(i)
							.getType(), data1.get(i).getCode(), data1.get(i)
							.getContent()));
				}
			}
			db.closeDb();
			adapter = new NotificationAdapter(NotificationActivity.this, data,
					-1);
		} else if (flag == 3) {
			// for (int i = 0; i < data1.size(); i++) {
			// if (data1.get(i).getType().equals("offers"))
			// {
			// db.update(data1.get(position).getIdd());
			// if (db.queryAllRecord() != null) {
			// data1 = db.queryAllRecord();
			// }
			// data.add(new JokeMsg(data1.get(i).getIdd(),
			// data1.get(i).getType(),
			// data1.get(i).getCode(),
			// data1.get(i).getContent()));
			// }
			// }
			db.update(data.get(position).getIdd());
			Log.d("data", data.get(position).getIdd());
			data.clear();
			for (int i = 0; i < data1.size(); i++) {
				if (data1.get(i).getType().equals("offers")) {
					// db.update(data1.get(position).getIdd());
					if (db.queryAllRecord() != null) {
						data1 = db.queryAllRecord();
					}
					data.add(new JokeMsg(data1.get(i).getIdd(), data1.get(i)
							.getType(), data1.get(i).getCode(), data1.get(i)
							.getContent()));
				}
			}
			db.closeDb();
			adapter = new NotificationAdapter(NotificationActivity.this, data,
					-1);
		} else {
			db.update(data1.get(position).getIdd());
			data1.clear();
			if (db.queryAllRecord() != null) {
				data1 = db.queryAllRecord();
			}
			adapter = new NotificationAdapter(NotificationActivity.this, data1,
					-1);
		}

		swipeMenuListView.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.ll_usage:
			flag = 1;
			data.clear();
			data1.clear();
			db = new DBAdapter(this);
			db.openDb();
			if (db.queryAllRecord() != null) {
				data1 = db.queryAllRecord();
			}
			db.closeDb();

			for (int i = 0; i < data1.size(); i++) {
				if (data1.get(i).getType().equals("usage")) {
					data.add(new JokeMsg(data1.get(i).getIdd(), data1.get(i)
							.getType(), data1.get(i).getCode(), data1.get(i)
							.getContent()));
				}
			}
			adapter = new NotificationAdapter(this, data, 1);
			swipeMenuListView.setAdapter(adapter);
			ll_image_usage.setBackgroundResource(R.drawable.bg_nc_s);
			ll_image_bulling.setBackgroundResource(R.drawable.bg_text_uns);
			ll_image_offers.setBackgroundResource(R.drawable.bg_info_uns);
			break;
		case R.id.ll_bulling:
			flag = 2;
			data.clear();
			data1.clear();
			db = new DBAdapter(this);
			db.openDb();
			if (db.queryAllRecord() != null) {
				data1 = db.queryAllRecord();
			}
			db.closeDb();
			for (int i = 0; i < data1.size(); i++) {
				if (data1.get(i).getType().equals("billing")) {
					data.add(new JokeMsg(data1.get(i).getIdd(), data1.get(i)
							.getType(), data1.get(i).getCode(), data1.get(i)
							.getContent()));
				}
			}
			adapter = new NotificationAdapter(this, data, -1);
			swipeMenuListView.setAdapter(adapter);
			ll_image_usage.setBackgroundResource(R.drawable.bg_nc_uns);
			ll_image_bulling.setBackgroundResource(R.drawable.bg_text_s);
			ll_image_offers.setBackgroundResource(R.drawable.bg_info_uns);
			break;
		case R.id.ll_offers:
			flag = 3;
			data.clear();
			data1.clear();
			db = new DBAdapter(this);
			db.openDb();
			if (db.queryAllRecord() != null) {
				data1 = db.queryAllRecord();
			}
			db.closeDb();
			for (int i = 0; i < data1.size(); i++) {
				if (data1.get(i).getType().equals("offers")) {
					data.add(new JokeMsg(data1.get(i).getIdd(), data1.get(i)
							.getType(), data1.get(i).getCode(), data1.get(i)
							.getContent()));
				}
			}
			adapter = new NotificationAdapter(this, data, -1);
			swipeMenuListView.setAdapter(adapter);
			ll_image_usage.setBackgroundResource(R.drawable.bg_nc_uns);
			ll_image_bulling.setBackgroundResource(R.drawable.bg_text_uns);
			ll_image_offers.setBackgroundResource(R.drawable.bg_info_s);
			break;
		case R.id.back:
			onBackPressed();
			break;

		default:
			break;
		}

	}

	private int dp2px(int dp) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
				getResources().getDisplayMetrics());
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		setRead(position);
		startActivity(new Intent(NotificationActivity.this,
				NotificationDetailsActivity.class));
	}
}
