package com.huawei.vodafone.bills.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.huawei.vodafone.MyApplication;
import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.UserInfo;
import com.huawei.vodafone.net.RequestListener;
import com.huawei.vodafone.ui.activity.BaseActivity;
import com.huawei.vodafone.ui.myview.MyListview;

/**
 * @author kanl
 *
 * @create 2016年7月22日 上午11:35:22
 */
public class AllCurrentSpendActivity extends BaseActivity implements
		RequestListener {
	private MyListview myListView;
	private AllSpendAdapter adapter;
	private TextView tv_title, text_one, text_two, text_three, text_four;
	private LayoutInflater mInflater;
	private int num = 1;
	private int num2 = 1;
	private int code = 1;
	private int code2 = 1;
	LinearLayout lin_spend, lin_lt, lin_out;
	RelativeLayout rel_calls;
	CheckBox check_arrows, check_out;
	RelativeLayout rel_out;
	TextView tv_see, tv_out;
	ImageView img_head;
	View view_line;
	private TextView tv_one;
	private TextView tv_two;
	private TextView tv_four;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_current_spend);
		initSecondTitle("April bill");
		initView();
		tv_title.setText(getIntent().getStringExtra("title"));
	}

	private void initView() {
		tv_out = (TextView) findViewById(R.id.tv_out);
		text_one = (TextView) findViewById(R.id.text_one);
		tv_one = (TextView) findViewById(R.id.tv_one);
		tv_two = (TextView) findViewById(R.id.tv_two);
		tv_four = (TextView) findViewById(R.id.tv_four);
		text_one = (TextView) findViewById(R.id.text_one);
		text_two = (TextView) findViewById(R.id.text_two);
		text_three = (TextView) findViewById(R.id.text_three);
		text_four = (TextView) findViewById(R.id.text_four);
		lin_spend = (LinearLayout) findViewById(R.id.lin_spend);
		lin_lt = (LinearLayout) findViewById(R.id.lin_lt);
		check_arrows = (CheckBox) findViewById(R.id.img_arrows);
		check_out = (CheckBox) findViewById(R.id.check_out);
		lin_out = (LinearLayout) findViewById(R.id.lin_out);
		rel_out = (RelativeLayout) findViewById(R.id.rel_out);
		tv_see = (TextView) findViewById(R.id.tv_see);
		img_head = (ImageView) findViewById(R.id.head_img);
		view_line = (View) findViewById(R.id.view_line);
		rel_calls = (RelativeLayout) findViewById(R.id.rel_calls);
		myListView = (MyListview) findViewById(R.id.listview);
		tv_title = (TextView) findViewById(R.id.title);
		TextView tv_three = (TextView) findViewById(R.id.tv_three);
		tv_three.setText(Html
				.fromHtml("<b><tt><font color='#9c2aa0'>€22.98</font></tt></b>(inc.€9.66 VAT)"));
		tv_four.setText(Html
				.fromHtml("Includes <font color='#9c2aa0'>€5.00</font> out of plan spend"));
		if (getIntent().getStringExtra("tag").equals("1")) {
			text_one.setText("Since 5th Oct 2016");
			text_two.setText("€22.98");
			text_three.setText("Last Updated 19st Oct 2016");
			text_four.setText(R.string.tv_paid_current);
		} else if (getIntent().getStringExtra("tag").equals("0")) {
			text_one.setText(getIntent().getStringExtra("next") + " - "
					+ getIntent().getStringExtra("title"));
		}
		img_head.setImageBitmap(UserInfo.getIcon(getBaseContext()));

		// myListView.addHeaderView(view);
		// myListView.setFocusable(false);
		// tv_title = (TextView) view.findViewById(R.id.tv_title);
		adapter = new AllSpendAdapter(this);
		myListView.setAdapter(adapter);
		lin_lt.setOnClickListener(this);
		rel_out.setOnClickListener(this);
		tv_see.setOnClickListener(this);
		rel_calls.setOnClickListener(this);
		myListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

			}
		});
		tv_one.setText(UserInfo.getUserName() + "'s phone");
		tv_two.setText(UserInfo.getUserMobile());
	}

	class AllSpendAdapter extends BaseAdapter {
		private Context mContext;

		public AllSpendAdapter(Context mContext) {
			this.mContext = mContext;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 1;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = LayoutInflater.from(mContext).inflate(
						R.layout.all_detail_item, parent, false);
				holder.lin_spend = (LinearLayout) convertView
						.findViewById(R.id.lin_spend);
				holder.lin_lt = (LinearLayout) convertView
						.findViewById(R.id.lin_lt);
				holder.check_arrows = (CheckBox) convertView
						.findViewById(R.id.img_arrows);
				holder.check_out = (CheckBox) convertView
						.findViewById(R.id.check_out);
				holder.lin_out = (LinearLayout) convertView
						.findViewById(R.id.lin_out);
				holder.rel_out = (RelativeLayout) convertView
						.findViewById(R.id.rel_out);
				holder.tv_see = (TextView) convertView
						.findViewById(R.id.tv_see);
				holder.img_head = (ImageView) convertView
						.findViewById(R.id.head_img);
				holder.view_line = (View) convertView
						.findViewById(R.id.view_line);
				holder.rel_calls = (RelativeLayout) convertView
						.findViewById(R.id.rel_calls);
				holder.tv_out = (TextView) convertView
						.findViewById(R.id.tv_out);
				holder.tv_one = (TextView) convertView
						.findViewById(R.id.tv_one);
				holder.tv_two = (TextView) convertView
						.findViewById(R.id.tv_two);
				// holder.tv_three = (TextView) convertView
				// .findViewById(R.id.tv_three);
				// holder.tv_four = (TextView) convertView
				// .findViewById(R.id.tv_four);
				int width = MyApplication.screenWidth;
				int height = MyApplication.screenHeight;
				int lin_height = (int) (76 / 1136.0 * height);
				int lin_paddind_top = (int) (16 / 1136.0 * height);
				int lin_paddind_left_first = (int) (20 / 640.0 * width);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			if (position == 0) {
				holder.tv_one.setText(UserInfo.getUserName() + "'s phone");
				holder.tv_two.setText(UserInfo.getUserMobile());
			}
			holder.lin_lt.setOnClickListener(new btnListener1(holder.lin_spend,
					holder.check_arrows, position) {
			});
			holder.rel_out.setOnClickListener(new btnListener2(holder.lin_out,
					holder.check_out));

			holder.tv_see.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(mContext,
							ItemisedBillActivity.class);
					intent.putExtra("name_code", "1");
					startActivity(intent);
					activityAnimationOpen();
				}
			});

			holder.rel_calls.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(mContext,
							ItemisedBillActivity.class);
					intent.putExtra("name_code", "1");
					startActivity(intent);
					activityAnimationOpen();
				}
			});
			if (num == 2) {
				holder.lin_spend.setVisibility(View.VISIBLE);
				holder.check_arrows.setChecked(false);
				holder.check_arrows.setButtonDrawable(R.drawable.arrows_up);
			} else if (num == 1) {
				holder.lin_spend.setVisibility(View.GONE);
				holder.check_arrows.setChecked(true);
				holder.check_arrows.setButtonDrawable(R.drawable.arrows_down);

			}

			if (num2 == 2) {
				holder.lin_out.setVisibility(View.VISIBLE);
				holder.check_out.setChecked(false);
				holder.check_out.setButtonDrawable(R.drawable.out_up_img);
				holder.tv_out.setTypeface(Typeface
						.defaultFromStyle(Typeface.BOLD));
				holder.rel_out.setBackgroundColor(Color.parseColor("#f7f7f7"));
			} else if (num2 == 1) {
				holder.lin_out.setVisibility(View.GONE);
				holder.check_out.setChecked(true);
				holder.check_out.setButtonDrawable(R.drawable.out_down_img);
				holder.tv_out.setTypeface(Typeface
						.defaultFromStyle(Typeface.NORMAL));
				holder.rel_out.setBackgroundColor(Color.parseColor("#ffffff"));
			}

			return convertView;
		}

		class btnListener1 implements OnClickListener {
			private LinearLayout lin_spend;
			CheckBox check_arrows;
			int position;

			public btnListener1(LinearLayout lin_spend, CheckBox check_arrows,
					int position) {
				this.lin_spend = lin_spend;
				this.check_arrows = check_arrows;
				this.position = position;
			}

			@Override
			public void onClick(View v) {

				if (num == 1) {
					num = 2;
				} else if (num == 2) {
					num = 1;

				}
				// if (check_arrows.isChecked()) {
				// lin_spend.setVisibility(View.VISIBLE);
				// check_arrows.setChecked(false);
				// check_arrows.setButtonDrawable(R.drawable.arrows_up);
				// }else{
				// lin_spend.setVisibility(View.GONE);
				// check_arrows.setChecked(true);
				// check_arrows.setButtonDrawable(R.drawable.arrows_down);
				// }
				adapter.notifyDataSetChanged();
			}
		}

		class btnListener2 implements OnClickListener {
			private LinearLayout lin_out;
			CheckBox check_out;

			public btnListener2(LinearLayout lin_out, CheckBox check_out) {
				this.lin_out = lin_out;
				this.check_out = check_out;
			}

			@Override
			public void onClick(View v) {
				// if (check_out.isChecked()) {
				// lin_out.setVisibility(View.VISIBLE);
				// check_out.setChecked(false);
				// check_out.setButtonDrawable(R.drawable.out_up_img);
				// }else{
				// lin_out.setVisibility(View.GONE);
				// check_out.setChecked(true);
				// check_out.setButtonDrawable(R.drawable.out_down_img);
				// }

				if (num2 == 1) {
					num2 = 2;
				} else if (num2 == 2) {
					num2 = 1;
				}
				adapter.notifyDataSetChanged();
			}
		}

		private class ViewHolder {
			LinearLayout lin_spend, lin_lt, lin_out;
			RelativeLayout rel_calls;
			CheckBox check_arrows, check_out;
			RelativeLayout rel_out;
			TextView tv_see, tv_out, tv_one, tv_two;
			ImageView img_head;
			View view_line;
		}

	}

	@Override
	public void requestSuccess(Object tag, String json) {

	}

	@Override
	public void requestError(Object tag, VolleyError e) {

	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		Intent intent;
		switch (v.getId()) {
		case R.id.lin_lt:
			switch (code) {
			case 1:
				lin_spend.setVisibility(View.VISIBLE);
				check_arrows.setChecked(false);
				check_arrows.setButtonDrawable(R.drawable.arrows_up);
				code = 2;
				break;
			case 2:
				lin_spend.setVisibility(View.GONE);
				check_arrows.setChecked(true);
				check_arrows.setButtonDrawable(R.drawable.arrows_down);
				code = 1;
				break;

			default:
				break;
			}
			break;

		case R.id.rel_out:
			switch (code2) {
			case 1:
				lin_out.setVisibility(View.VISIBLE);
				check_out.setChecked(false);
				check_out.setButtonDrawable(R.drawable.out_up_img);
				tv_out.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));// 加粗
				rel_out.setBackgroundColor(Color.parseColor("#f7f7f7"));
				code2 = 2;
				break;
			case 2:
				lin_out.setVisibility(View.GONE);
				check_out.setChecked(true);
				check_out.setButtonDrawable(R.drawable.out_down_img);
				tv_out.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));// 正常
				rel_out.setBackgroundColor(Color.parseColor("#ffffff"));
				code2 = 1;
				break;

			default:
				break;
			}
			break;

		case R.id.tv_see:
			intent = new Intent(getBaseContext(), ItemisedBillActivity.class);
			intent.putExtra("name_code", "0");
			startActivity(intent);
			activityAnimationOpen();
			break;

		case R.id.rel_calls:
			intent = new Intent(getBaseContext(), ItemisedBillActivity.class);
			intent.putExtra("name_code", "0");
			startActivity(intent);
			activityAnimationOpen();
			break;

		default:
			break;
		}
	}

}
