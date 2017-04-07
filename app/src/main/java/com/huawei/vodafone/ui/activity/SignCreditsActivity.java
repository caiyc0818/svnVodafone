package com.huawei.vodafone.ui.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.ui.adapter.SignInCreditsListAdapter;
import com.huawei.vodafone.ui.adapter.SignInPagerAdapter;
import com.huawei.vodafone.util.PreferenceUtils;
import com.huawei.vodafone.util.StringUtils;
import com.huawei.vodafone.util.TAGUtil;

/**
 * @author weich 签到rules
 */
public class SignCreditsActivity extends BaseActivity implements
		OnItemClickListener {
	/**
	 * android-support-v4中的滑动组件
	 */
	private ViewPager viewPager;

	/**
	 * 滑动的图片集合
	 */
	private List<View> imageViews;

	/**
	 * 图片数量
	 */
	private int count;

	/**
	 * 点的父布局
	 */
	private LinearLayout dotsLayout;

	/**
	 * 图片标题正文的那些点
	 */
	private List<View> dots;

	/**
	 * 当前图片的索引号
	 */
	private int currentItem = 0;
	/**
	 * 定时器
	 */
	Handler handler = new Handler();
	private ListView credits_list;
	private TextView points_num;
	private SignInCreditsListAdapter adapter;
	private ScrollView sign_in_credits;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_in_credits);
		initSecondTitle("Loyalty point redemption");
		initView();
	}

	private void initView() {
		dotsLayout = (LinearLayout) findViewById(R.id.card_discount_dots);
		viewPager = (ViewPager) findViewById(R.id.card_discount_vp);
		credits_list = (ListView) findViewById(R.id.credits_list);
		points_num = (TextView) findViewById(R.id.points_num);
		sign_in_credits = (ScrollView) findViewById(R.id.sign_in_credits);

		adapter = new SignInCreditsListAdapter(getBaseContext(), 3);
		credits_list.setAdapter(adapter);
		credits_list.setOnItemClickListener(this);
		sign_in_credits.smoothScrollTo(0, 0);
		addAds();
		handler.postDelayed(new ScrollTask(), 3000);

		points_num.setText(StringUtils.formatDecimalFloat(
				PreferenceUtils.getInt(getBaseContext(), "SignInPoints"), 0)
				+ " Points");
	}

	private void addAds() {
		imageViews = new ArrayList<View>();
		dots = new ArrayList<View>();
		imageViews.clear();
		dots.clear();
		dotsLayout.removeAllViews();
		int[] imgId = { R.drawable.ic_launcher };
		count = 3;

		for (int i = 0; i < count; i++) {
			// 初始化图片资源
			if (i == 0) {
				ImageView imageView = new ImageView(SignCreditsActivity.this);
				LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
				imageView.setLayoutParams(layoutParams);
				imageView.setScaleType(ScaleType.CENTER_INSIDE);
				imageView.setImageResource(R.drawable.iphone_image1);
				imageViews.add(imageView);
			} else if (i == 1) {
				ImageView imageView = new ImageView(SignCreditsActivity.this);
				LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
				imageView.setLayoutParams(layoutParams);
				imageView.setScaleType(ScaleType.CENTER_INSIDE);
				imageView.setImageResource(R.drawable.mate8_shouye);
				imageViews.add(imageView);
			} else if (i == 2) {
				ImageView imageView = new ImageView(SignCreditsActivity.this);
				LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
				imageView.setLayoutParams(layoutParams);
				imageView.setScaleType(ScaleType.CENTER_INSIDE);
				imageView.setImageResource(R.drawable.p9_shouye);
				imageViews.add(imageView);
			}

			// 添加标题下面的点
			ImageView dotsView = new ImageView(SignCreditsActivity.this);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			params.setMargins(5, 0, 5, 5);
			dotsView.setLayoutParams(params);
			dotsView.setBackgroundResource(R.drawable.banner);
			if (0 == i) {
				dotsView.setBackgroundResource(R.drawable.banner_icon);
			}
			dotsLayout.addView(dotsView);
			dots.add(dotsView);
		}
		// 设置填充ViewPager页面的适配器
		viewPager.setAdapter(new SignInPagerAdapter(SignCreditsActivity.this,
				imageViews, viewPager));
		// 设置一个监听器，当ViewPager中的页面改变时调用
		viewPager.addOnPageChangeListener(new MyPageChangeListener());
		viewPager.setCurrentItem(0);

	}

	/**
	 * 换行切换任务
	 * 
	 * @version [2013-6-18]
	 * @see [相关类/方法]
	 */
	private class ScrollTask implements Runnable {
		@Override
		public void run() {
			synchronized (viewPager) {
				if (imageViews != null) {
					if (imageViews.size() != 0) {
						currentItem = currentItem + 1;
						if (currentItem >= imageViews.size()) {
							currentItem = 0;
						}
						viewPager.setCurrentItem(currentItem);
					}
					// 通过Handler切换图片
					handler.postDelayed(this, 3000);
				}
			}
		}
	}

	/**
	 * 当ViewPager中页面的状态发生改变时调用
	 * 
	 */
	private class MyPageChangeListener implements OnPageChangeListener {
		private int oldPosition = 0;

		@Override
		public void onPageSelected(int position) {
			currentItem = position;
			dots.get(oldPosition).setBackgroundResource(R.drawable.banner);
			dots.get(position).setBackgroundResource(R.drawable.banner_icon);
			oldPosition = position;
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}
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
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent(SignCreditsActivity.this,
				SignCreditsDetailActivity.class);
		intent.putExtra("num", position);
		startActivityForResult(intent, TAGUtil.tag12);
		activityAnimationOpen();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == TAGUtil.tag12) {
			points_num
					.setText(StringUtils.formatDecimalFloat(PreferenceUtils
							.getInt(getBaseContext(), "SignInPoints"), 0)
							+ " Points");
			adapter.notifyDataSetChanged();
		}
	}
}
