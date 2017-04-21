package com.huawei.vodafone.bills.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.huawei.vodafone.MyApplication;
import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.UserInfo;
import com.huawei.vodafone.ui.activity.BaseActivity;
import com.huawei.vodafone.ui.activity.BaseFragmentActivity;
import com.huawei.vodafone.ui.myview.CircleImageView;
import com.huawei.vodafone.ui.myview.MyListview;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * @author kanl
 *
 * @create 2016年7月23日 上午10:39:10
 */
public class NetWorkUsageActivity extends BaseFragmentActivity implements
		OnClickListener {
	private ImageView ivBottomLine, back_img, img_data, img_calls;
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
	private ImageView img_back;
	private CircleImageView img_head;
	private MyListview myListView;
	// private TextView tv_loadmore;

	private static final int LOAD_DATA_FINISH = 10;

	private static final int REFRESH_DATA_FINISH = 11;

	private ProgressBar moreProgressBar;

	private int count = 10;
	private FragmentManager fragmentManager;
	private DataFragment datafragment;

	/**
	 * 用于展示动态的Fragment
	 */
	private CallsFragment callfragment;

	private TextView tv_toitemised;
	private ImageLoader imageLoader;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_networkusage);
		resources = getResources();
		imageLoader = ImageLoader.getInstance();
		initView();
		InitWidth();
		InitViewPager();
		setTabSelection(0);
	}

	private void initView() {
		TextView titleTv = (TextView) findViewById(R.id.title);
		ImageView rightBtn = (ImageView) findViewById(R.id.close);
		rightBtn.setVisibility(View.INVISIBLE);
		titleTv.setText("Usage history");
		tv_toitemised = (TextView) findViewById(R.id.tv_toitemised);
		tv_toitemised.setText("see " + UserInfo.getUserName() + "'s "
				+ "itemised spend");
		img_data = (ImageView) findViewById(R.id.img_data);
		img_calls = (ImageView) findViewById(R.id.img_calls);
		img_head = (CircleImageView) findViewById(R.id.img_head);
		img_back = (ImageView) findViewById(R.id.back);
		tv_name = (TextView) findViewById(R.id.tv_name);
		tv_phone = (TextView) findViewById(R.id.tv_phone);
		fragmentManager = getSupportFragmentManager();
		// img_head.setOnClickListener(this);
		img_back.setOnClickListener(this);
		tv_toitemised.setOnClickListener(this);
		img_head.setImageBitmap(UserInfo.getIcon(getBaseContext()));
		tv_name.setText(UserInfo.getUserName() + "'s phone");
		tv_phone.setText(UserInfo.getUserMobile());
	}

	private void InitViewPager() {
		tv_all = (TextView) findViewById(R.id.tv_all);
		tv_non = (TextView) findViewById(R.id.tv_non);
		tv_all.setOnClickListener(this);
		tv_non.setOnClickListener(this);

	}

	private void InitWidth() {
		ivBottomLine = (ImageView) findViewById(R.id.iv_nav_indicator);
	}

	@Override
	public void onClick(View v) {
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// Fragment contentFragment;
		switch (v.getId()) {
		case R.id.back:
			finish();
			((BaseActivity) BaseActivity.A).activityAnimationClose();
			break;

		case R.id.tv_all:
			setTabSelection(0);
			img_data.setVisibility(View.VISIBLE);
			img_calls.setVisibility(View.INVISIBLE);
			tv_all.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));// 加粗
			tv_non.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
			break;

		case R.id.tv_non:
			setTabSelection(1);
			img_data.setVisibility(View.INVISIBLE);
			img_calls.setVisibility(View.VISIBLE);
			tv_non.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));// 加粗
			tv_all.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
			break;

		case R.id.tv_toitemised:
			Intent intent = new Intent(NetWorkUsageActivity.this,
					ItemisedBillActivity.class);
			intent.putExtra("name_code", "0");
			startActivity(intent);
			overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
		default:
			break;
		}
		transaction.commit();
	}

	/**
	 * 根据传入的index参数来设置选中的tab页。
	 * 
	 * @param index
	 *            每个tab页对应的下标。0表示消息，1表示联系人，2表示动态，3表示设置。
	 */
	private void setTabSelection(int index) {
		// 每次选中之前先清楚掉上次的选中状态
		// clearSelection();
		// 开启一个Fragment事务
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
		hideFragments(transaction);
		switch (index) {
		case 0:
			// 当点击了消息tab时，改变控件的图片和文字颜色
			// messageImage.setImageResource(R.drawable.message_selected);
			// messageText.setTextColor(Color.WHITE);
			if (datafragment == null) {
				// 如果MessageFragment为空，则创建一个并添加到界面上
				datafragment = new DataFragment();
				transaction.add(R.id.content, datafragment);
			} else {
				// 如果MessageFragment不为空，则直接将它显示出来
				transaction.show(datafragment);
			}
			break;
		case 1:
			// 当点击了动态tab时，改变控件的图片和文字颜色
			// newsImage.setImageResource(R.drawable.news_selected);
			// newsText.setTextColor(Color.WHITE);
			if (callfragment == null) {
				// 如果NewsFragment为空，则创建一个并添加到界面上
				callfragment = new CallsFragment();
				transaction.add(R.id.content, callfragment);
			} else {
				// 如果NewsFragment不为空，则直接将它显示出来
				transaction.show(callfragment);
			}
			break;
		}
		transaction.commit();
	}

	private void hideFragments(FragmentTransaction transaction) {
		if (datafragment != null) {
			transaction.hide(datafragment);
		}
		if (callfragment != null) {
			transaction.hide(callfragment);
		}
	}

}
