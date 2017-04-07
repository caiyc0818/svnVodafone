package com.huawei.vodafone.bills.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.huawei.vodafone.MyApplication;
import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.UserInfo;
import com.huawei.vodafone.net.RequestListener;
import com.huawei.vodafone.ui.myview.MyListview;
import com.huawei.vodafone.ui.myview.NewViewPager;

/**
 * @author kanl
 *
 * @create 2016年7月23日 上午10:39:10
 */
public class ItemisedBillActivity extends FragmentActivity implements
		RequestListener, OnClickListener {
	private ImageView ivBottomLine, back_img;
	private TextView tv_chargeable, tv_non, tv_all, title, tv_name, tv_phone,
			tv_money, load_more;
	private View view_line;
	private int currIndex = 0;
	private int bottomLineWidth;
	private Resources resources;
	private LinearLayout lin_one;
	private LinearLayout rel_title, lin_foot;
	int width = MyApplication.screenWidth;
	int height = MyApplication.screenHeight;
	private NewViewPager mViewPaper;
	private ViewPagerAdapter adapter1;
	private List<ImageView> images;
	private int currentItem;
	private int oldItem;
	private ImageView img_left, img_right, img_back;
	// private int[] imageIds = new int[] { UserInfo.getIcon(),
	// UserInfo.getIcon() };
	private RadioButton rd_date, rd_calls, rd_txts;
	private ScrollView scroll_view;
	private MyListview myListView;
	// private TextView tv_loadmore;
	private ChargeableAdapter adapter;
	private int num = 10;
	private static final String TAG = "1";

	private static final int LOAD_DATA_FINISH = 10;

	private static final int REFRESH_DATA_FINISH = 11;

	private ProgressBar moreProgressBar;

	private int count = 10;
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case LOAD_DATA_FINISH:
				if (adapter != null) {
					num += 10;
					adapter.notifyDataSetChanged();
				}
				moreProgressBar.setVisibility(View.GONE);
				load_more.setText("Load more");// 加载更多完成
				break;
			default:
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_itemised_bill);
		resources = getResources();
		initView();
		InitWidth();
		InitViewPager();
	}

	private void initView() {
		TextView titleTv = (TextView) findViewById(R.id.title);
		ImageView rightBtn = (ImageView) findViewById(R.id.close);
		rightBtn.setVisibility(View.INVISIBLE);
		titleTv.setText("Itemised spend");

		rd_date = (RadioButton) findViewById(R.id.rd_date);
		rd_calls = (RadioButton) findViewById(R.id.rd_calls);
		rd_txts = (RadioButton) findViewById(R.id.rd_txts);
		mViewPaper = (NewViewPager) findViewById(R.id.vp);
		img_left = (ImageView) findViewById(R.id.img_left);
		img_right = (ImageView) findViewById(R.id.img_right);
		img_back = (ImageView) findViewById(R.id.back);
		tv_name = (TextView) findViewById(R.id.tv_name);
		tv_phone = (TextView) findViewById(R.id.tv_phone);
		tv_money = (TextView) findViewById(R.id.tv_money);
		load_more = (TextView) findViewById(R.id.load_more);
		myListView = (MyListview) findViewById(R.id.listview);
		lin_foot = (LinearLayout) findViewById(R.id.lin_foot);
		moreProgressBar = (ProgressBar) findViewById(R.id.pull_to_refresh_progress);
		tv_name.setText(UserInfo.getUserName() + "'s phone");
		tv_phone.setText(UserInfo.getUserMobile());
		tv_money.setText("€22.98");
		adapter = new ChargeableAdapter(getBaseContext(), num);
		myListView.setAdapter(adapter);
		myListView.setFocusable(false);
		img_left.setOnClickListener(this);
		img_right.setOnClickListener(this);
		rd_date.setOnClickListener(this);
		rd_calls.setOnClickListener(this);
		rd_txts.setOnClickListener(this);
		img_back.setOnClickListener(this);
		lin_foot.setOnClickListener(this);
		images = new ArrayList<ImageView>();
		// for (int i = 0; i < imageIds.length; i++) {
		// ImageView imageView = new ImageView(this);
		// imageView.setBackgroundResource(imageIds[i]);
		// images.add(imageView);
		// }

		ImageView imageView = new ImageView(this);
		imageView.setImageBitmap(UserInfo.getIcon(getBaseContext()));
		images.add(imageView);

		adapter1 = new ViewPagerAdapter();
		mViewPaper.setAdapter(adapter1);
		mViewPaper
				.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

					@Override
					public void onPageSelected(int position) {
						if (getIntent().getStringExtra("name_code").equals("1")) {
							switch (position) {
							case 0:
								img_left.setImageResource(R.drawable.img_left);
								img_right
										.setImageResource(R.drawable.img_right);
								tv_name.setText("Jen's phone");
								tv_phone.setText("07783 947975");
								tv_money.setText("€53.00");

								break;
							case 1:
								img_right
										.setImageResource(R.drawable.img_right_gray);
								img_left.setImageResource(R.drawable.img_left_light);
								tv_name.setText("David's phone");
								tv_phone.setText("07785 460399");
								tv_money.setText("€64.50");
								break;

							default:
								img_left.setImageResource(R.drawable.img_left_light);
								img_right
										.setImageResource(R.drawable.img_right);
								tv_name.setText("Jen's phone");
								tv_phone.setText("07553 476543");
								tv_money.setText("€53.00");
								break;
							}
						} else {
							switch (position) {
							case 0:
								img_left.setImageResource(R.drawable.img_left);
								img_right
										.setImageResource(R.drawable.img_right);
								tv_name.setText("David's phone");
								tv_phone.setText("07785 460399");
								tv_money.setText("€64.50");
								break;
							case 1:
								img_right
										.setImageResource(R.drawable.img_right_gray);
								img_left.setImageResource(R.drawable.img_left_light);
								tv_name.setText("Jen's phone");
								tv_phone.setText("07783 947975");
								tv_money.setText("€53.00");
								break;

							default:
								img_left.setImageResource(R.drawable.img_left_light);
								img_right
										.setImageResource(R.drawable.img_right);
								tv_name.setText("Jen's phone");
								tv_phone.setText("07553 476543");
								tv_money.setText("€53.00");
								break;
							}
						}
						currentItem = position;
						oldItem = position;
					}

					@Override
					public void onPageScrolled(int arg0, float arg1, int arg2) {

					}

					@Override
					public void onPageScrollStateChanged(int arg0) {

					}
				});

	}

	private class ViewPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return images.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup view, int position, Object object) {
			view.removeView(images.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup view, int position) {
			// TODO Auto-generated method stub
			view.addView(images.get(position));
			return images.get(position);
		}

	}

	@Override
	public void requestSuccess(Object tag, String json) {

	}

	@Override
	public void requestError(Object tag, VolleyError e) {

	}

	private void InitViewPager() {
		tv_all = (TextView) findViewById(R.id.tv_all);
		tv_chargeable = (TextView) findViewById(R.id.tv_chargeable);
		tv_non = (TextView) findViewById(R.id.tv_non);

	}

	private void InitWidth() {
		ivBottomLine = (ImageView) findViewById(R.id.iv_nav_indicator);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.img_left:
			mViewPaper.setCurrentItem(currentItem - 1);
			break;
		case R.id.img_right:
			mViewPaper.setCurrentItem(currentItem + 1);
			break;
		case R.id.rd_date:
			rd_date.setChecked(false);
			rd_calls.setChecked(true);
			break;
		case R.id.rd_calls:
			break;
		case R.id.rd_txts:
			rd_txts.setChecked(false);
			rd_calls.setChecked(true);
			break;
		case R.id.back:
			finish();
			overridePendingTransition(R.anim.activity_back,
					R.anim.activity_finish);
			break;

		case R.id.lin_foot:
			moreProgressBar.setVisibility(View.VISIBLE);
			load_more.setText("loading...");
			new Thread() {
				@Override
				public void run() {

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					handler.sendEmptyMessage(LOAD_DATA_FINISH);

				}
			}.start();
			break;

		default:
			break;
		}

	}

	class ChargeableAdapter extends BaseAdapter {
		private Context mContext;

		public ChargeableAdapter(Context mContext, int num) {
			this.mContext = mContext;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return num;
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
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = LayoutInflater.from(mContext).inflate(
						R.layout.itemised_detail_item, parent, false);
				int width = MyApplication.screenWidth;
				int height = MyApplication.screenHeight;
				int lin_height = (int) (76 / 1136.0 * height);
				int lin_paddind_top = (int) (16 / 1136.0 * height);
				int lin_paddind_left_first = (int) (20 / 640.0 * width);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			return convertView;
		}

		private class ViewHolder {

		}
	}

}
