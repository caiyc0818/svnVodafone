package com.huawei.vodafone.bills.activity;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.huawei.vodafone.MyApplication;
import com.huawei.vodafone.R;
import com.huawei.vodafone.net.RequestListener;
import com.huawei.vodafone.ui.activity.BaseActivity;
import com.huawei.vodafone.ui.myview.MyListview;
import com.huawei.vodafone.ui.myview.StatscsView;

/**
 * @author kanl
 *
 * @create 2016年7月21日 上午11:06:32
 */
public class BillsActivity extends FragmentActivity implements OnClickListener,
		RequestListener {
	private MyListview mListView;
	private BillAdapter adapter;
	private LinearLayout lin_current_spend, lin_layout;
	private ImageView img_back;
	private TextView tv_average;
	private float[] elecDate = { 60.0f, 35.0f, 40.5f, 60.0f, 50.0f, 60.0f };
	private float[] elecDate1 = { 20.0f, 0f, 0f, 11.0f, 0f, 30.0f };
	int width = MyApplication.screenWidth;
	int height = MyApplication.screenHeight;
	private StatscsView statscsView;
	private DrawerLayout DrawerLayout;
	private ArrayList<String> xValues1, xValues2;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_bills);
		initView();
		resizeViews();
		getData();
		// showBarChart1(bar_chart1, mBarData1);
		xValues1 = new ArrayList<String>();
		xValues1.add("Sep");
		xValues1.add("Aug");
		xValues1.add("Jul");
		xValues1.add("Jun");
		xValues1.add("May");
		xValues1.add("Apr");

		xValues2 = new ArrayList<String>();
		xValues2.add("5 Sep 2016");
		xValues2.add("5 Aug 2016");
		xValues2.add("5 Jul 2016");
		xValues2.add("5 Jun 2016");
		xValues2.add("5 May 2016");
		xValues2.add("5 Apr 2016");
		xValues2.add("5 Mar 2016");
		xValues2.add("5 Feb 2016");

	}

	private void initView() {
		DrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout);
		img_back = (ImageView) findViewById(R.id.back);
		statscsView = (StatscsView) findViewById(R.id.statscsView1);
		lin_current_spend = (LinearLayout) findViewById(R.id.lin_current_spend);
		lin_layout = (LinearLayout) findViewById(R.id.lin_layout);
		mListView = (MyListview) findViewById(R.id.listview);
		mListView.setFocusable(false);
		tv_average = (TextView) findViewById(R.id.tv_average);
		tv_average.setText("Your average spend in the last" + "\n"
				+ "six months:");

		TextView titleTv = (TextView) findViewById(R.id.title);
		ImageView rightBtn = (ImageView) findViewById(R.id.close);
		rightBtn.setVisibility(View.INVISIBLE);
		titleTv.setText(getString(R.string.current_bills));

		adapter = new BillAdapter(this);
		mListView.setAdapter(adapter);
		lin_current_spend.setOnClickListener(this);
		img_back.setOnClickListener(this);
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(BillsActivity.this,
						AllCurrentSpendActivity.class);
				intent.putExtra("title", xValues2.get(position));
				intent.putExtra("next", xValues2.get(position + 1));

				intent.putExtra("tag", "0");
				startActivity(intent);
				((BaseActivity) BaseActivity.A).activityAnimationOpen();
			}
		});
	}

	private void resizeViews() {

		int lin_height = (int) (240 / 1134.0 * height);

		int img_back_width = (int) (70 / 640.0 * width);
		int img_back_height = (int) (70 / 1136.0 * height);

		int lin_padding = (int) (30 / 750.0 * width);

		lin_current_spend.getLayoutParams().height = lin_height;

		lin_layout.setPadding(lin_padding, 0, lin_padding, 0);
		// Drawable drawable = getResources().getDrawable(
		// R.drawable.white_search_icon);
		// drawable.setBounds(0, 0, (int) (27 / 640.0 * width),
		// (int) (27 / 1136.0 * height));
	}

	private void getData() {
		int[] lastData0 = new int[] { 54, 54, 54, 65, 65, 65 };
		int[] thisData0 = new int[] { 54, 54, 54, 54, 54, 54 };

		statscsView.updateThisData(lastData0);
		statscsView.updateLastData(thisData0);
	}

	@Override
	public void requestSuccess(Object tag, String json) {
		// TODO Auto-generated method stub

	}

	@Override
	public void requestError(Object tag, VolleyError e) {
		// TODO Auto-generated method stub

	}

	class BillAdapter extends BaseAdapter {
		Context mContext;

		public BillAdapter(Context mContext) {
			this.mContext = mContext;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 6;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder holder = null;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = LayoutInflater.from(mContext).inflate(
						R.layout.bills_detail_item, parent, false);
				holder.tv_one = (TextView) convertView
						.findViewById(R.id.tv_one);
				holder.tv_two = (TextView) convertView
						.findViewById(R.id.tv_two);
				holder.tv_three = (TextView) convertView
						.findViewById(R.id.tv_three);
				holder.tv_four = (TextView) convertView
						.findViewById(R.id.tv_four);
				holder.view_line = (View) convertView
						.findViewById(R.id.view_line);
				holder.lin_item = (LinearLayout) convertView
						.findViewById(R.id.lin_item);
				int width = MyApplication.screenWidth;
				int height = MyApplication.screenHeight;
				int lin_height = (int) (240 / 1134.0 * height);
				int lin_paddind_top = (int) (16 / 1136.0 * height);
				int lin_paddind_left_first = (int) (20 / 640.0 * width);
				holder.lin_item.getLayoutParams().height = lin_height;
				if (position != 0 & position > 2) {
					holder.view_line
							.setBackgroundResource(R.drawable.blue_line);
				}
				// holder.holder.view_line.getLayoutParams().height=lin_height;
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			String title = xValues1.get(position);
			if (position == 0) {
				holder.tv_four.setText("Not paid");
				holder.tv_four.setTextColor(Color.parseColor("#9c2aa0"));

			} else {
				holder.tv_four.setText(Html.fromHtml("7 " + "<b>" + title
						+ "</b>" + " by Direct Debit"));
				holder.tv_four.setTextColor(getResources().getColor(
						R.color.black));
			}
			holder.tv_one.setText(xValues2.get(position));

			if (position <= 2) {
				holder.tv_two.setText("€22.98");
				holder.tv_three.setText("€5.00");
				holder.tv_three.setTextColor(Color.parseColor("#9c2aa0"));
			} else {
				holder.tv_two.setText("€17.98");
				holder.tv_three.setText("€0.00");
				holder.tv_three.setTextColor(getResources().getColor(
						R.color.black));
			}
			return convertView;
		}

		class ViewHolder {
			TextView tv_one, tv_two, tv_three, tv_four;
			LinearLayout lin_item;
			View view_line;
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.lin_current_spend:
			Intent intent = new Intent(BillsActivity.this,
					AllCurrentSpendActivity.class);
			intent.putExtra("title", "All current spend");
			intent.putExtra("tag", "1");
			startActivity(intent);
			((BaseActivity) BaseActivity.A).activityAnimationOpen();
			break;

		case R.id.back:
			finish();
			((BaseActivity) BaseActivity.A).activityAnimationClose();
			break;
		case R.id.menu_btn1:
			// DrawerLayout.openDrawer(Gravity.RIGHT);
			break;

		default:
			break;
		}
	}

}
