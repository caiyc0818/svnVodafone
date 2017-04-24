package com.huawei.vodafone.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import com.android.volley.VolleyError;
import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.DiyItemList;
import com.huawei.vodafone.bean.PlansBean;
import com.huawei.vodafone.bean.PlansItem;
import com.huawei.vodafone.bills.activity.AddOnsActivity;
import com.huawei.vodafone.net.IRequest;
import com.huawei.vodafone.net.RequestJSon;
import com.huawei.vodafone.net.RequestListener;
import com.huawei.vodafone.net.URLs;
import com.huawei.vodafone.products.activity.ServicesActivity;
import com.huawei.vodafone.ui.fragment.FragmentPagerAdapter;
import com.huawei.vodafone.ui.fragment.Offers_Fragment1;
import com.huawei.vodafone.util.DensityUtil;
import com.huawei.vodafone.util.JsonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SettingsOffersAndExtrarsActivity extends BaseFragmentActivity
		implements OnClickListener, RequestListener {

	private ViewPager viewPager;
	private LinearLayout dotsLayout;
	private LinearLayout ll1;
	private RelativeLayout plans;
	private RelativeLayout add;
	private RelativeLayout diy;
	private RelativeLayout services;
	private ArrayList<Fragment> fragments = new ArrayList<Fragment>();
	private ArrayList<View> dots;
	private FragmentPagerAdapter mAdapetr;
	private RelativeLayout setting_service, rel_addons;
	private ArrayList<android.support.v4.app.Fragment> pushResourceList = new ArrayList<android.support.v4.app.Fragment>();
	/**
	 * 当前图片的索引号
	 */
	private int currentItem = 0;
	private int count;
	private DiyItemList DiyItemList;
  private ImageView image_line;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_offers_and_extras_for_you);
		initSecondTitle(getString(R.string.settings_offer));
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub

		viewPager = (ViewPager) findViewById(R.id.carousel_vp);
		dotsLayout = (LinearLayout) findViewById(R.id.carousel_dots);
		plans = (RelativeLayout) findViewById(R.id.plans);
		add = (RelativeLayout) findViewById(R.id.add);
		services = (RelativeLayout) findViewById(R.id.services);
		diy = (RelativeLayout) findViewById(R.id.diy);
		ll1 = (LinearLayout) findViewById(R.id.ll1);
		image_line = (ImageView) findViewById(R.id.image_line);
		plans.setOnClickListener(this);
		add.setOnClickListener(this);
		services.setOnClickListener(this);
		diy.setOnClickListener(this);
		IRequest.get(16, URLs.RANK_COMBINATION_AND_PRICE,
				RequestJSon.rankCombinationAndPrice(),
				SettingsOffersAndExtrarsActivity.this);

	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.plans:
			startActivity(new Intent(SettingsOffersAndExtrarsActivity.this,
					SettingsOffersAndExtrarsPlansActivity.class));
			activityAnimationOpen();
			break;
		case R.id.services:
			startActivity(new Intent(SettingsOffersAndExtrarsActivity.this,
					ServicesActivity.class));
			activityAnimationOpen();
			break;
		case R.id.add:
			startActivity(new Intent(SettingsOffersAndExtrarsActivity.this,
					AddOnsActivity.class));
			activityAnimationOpen();
			break;
		case R.id.diy:
			startActivity(new Intent(SettingsOffersAndExtrarsActivity.this,
					DiyPlansActivity.class));
			activityAnimationOpen();
			break;

		default:
			break;
		}
	}

	private void addCarousel(List<Fragment> pushResourceList) {
		// count = tempList.size();
		dots = new ArrayList<View>();
		if (dotsLayout != null) {
			dotsLayout.removeAllViews();
		}
		count = pushResourceList.size();
		fragments.addAll(pushResourceList);
		// 添加Fragment
		for (int i = 0; i < count; i++) {
			// TODO 添加标题下面的点********当滚动主题有时再放开下面代码******
			ImageView dotsView = new ImageView(this);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			params.setMargins(5, 0, 5, 5);
			dotsView.setLayoutParams(params);
			dotsView.setBackgroundResource(R.drawable.banner1);
			if (0 == i) {
				dotsView.setBackgroundResource(R.drawable.banner_icon);
			}
			dotsView.setTag(i);
			dotsLayout.addView(dotsView);
			dots.add(dotsView);
			dotsLayout.getChildAt(i).setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					viewPager.setCurrentItem((Integer) v.getTag());
				}

			});

		}
		mAdapetr = new FragmentPagerAdapter(
				SettingsOffersAndExtrarsActivity.this
						.getSupportFragmentManager(),
				fragments);
		// 去除过度动画
		// setViewPagerScrollSpeed();
		// 控制加载的页数
		// viewPager.setOffscreenPageLimit(1);
		// viewPager.setCurrentItem(0, true);
		viewPager.setAdapter(mAdapetr);
//		设置有内容显示
		ll1.setVisibility(View.VISIBLE);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		params.setMargins(0, DensityUtil.dip2px(this, -15), 0, 0);
		image_line.setLayoutParams(params);
		viewPager.setOnPageChangeListener(new MyPageChangeListener());
		if (count > 0) {
			handler.postDelayed(new ScrollTask(), 1000);

		}
	}

	// 解决viewpager切换动画时间
	private void setViewPagerScrollSpeed() {
		try {
			Field mScroller = null;
			mScroller = ViewPager.class.getDeclaredField("mScroller");
			mScroller.setAccessible(true);
			FixedSpeedScroller scroller = new FixedSpeedScroller(
					viewPager.getContext());
			mScroller.set(viewPager, scroller);
		} catch (NoSuchFieldException e) {

		} catch (IllegalArgumentException e) {

		} catch (IllegalAccessException e) {

		}
	}

	public class FixedSpeedScroller extends Scroller {
		private int mDuration = 0;

		public FixedSpeedScroller(Context context) {
			super(context);
		}

		public FixedSpeedScroller(Context context, Interpolator interpolator) {
			super(context, interpolator);
		}

		public FixedSpeedScroller(Context context, Interpolator interpolator,
				boolean flywheel) {
			super(context, interpolator, flywheel);
		}

		@Override
		public void startScroll(int startX, int startY, int dx, int dy,
				int duration) {
			super.startScroll(startX, startY, dx, dy, mDuration);
		}

		@Override
		public void startScroll(int startX, int startY, int dx, int dy) {
			super.startScroll(startX, startY, dx, dy, mDuration);
		}
	}

	/**
	 * 当ViewPager中页面的状态发生改变时调用
	 * 
	 * @author zhangbingkang
	 * @version [2013-6-18]
	 * @see [相关类/方法]
	 */
	private class MyPageChangeListener implements OnPageChangeListener {
		private int oldPosition = 0;

		/**
		 * This method will be invoked when a new page becomes selected.
		 * position: Position index of the new selected page.
		 */
		public void onPageSelected(int position) {
			int max = fragments.size();
			if (position == max) { // 最后一页时回到第一页
				viewPager.setCurrentItem(0, false);
				position = 0;
			}
			currentItem = position;
			dots.get(oldPosition).setBackgroundResource(R.drawable.banner1);
			dots.get(position).setBackgroundResource(R.drawable.banner_icon);
			oldPosition = position;

			// if (!isScrolling) {
			// int max = imageViews.size() + 1;
			// int position = (currentPosition + 1) % imageViews.size();
			// viewPager.setCurrentItem(position, true);
			// if (position == max) { // 最后一页时回到第一页
			// viewPager.setCurrentItem(1, false);
			// }
			// }
		}

		public void onPageScrollStateChanged(int arg0) {
		}

		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}
	}

	// 定时器
	Handler handler = new Handler();
	private PlansBean plansBean;
	private List<PlansItem> plansList;

	/**
	 * 换行切换任务
	 * 
	 * @author zhangbingkang
	 * @version [2013-6-18]
	 * @see [相关类/方法]
	 */
	private class ScrollTask implements Runnable {
		public void run() {
			synchronized (viewPager) {
				currentItem = (currentItem + 1) % fragments.size();
				viewPager.setCurrentItem(currentItem);
				// 通过Handler切换图片
				handler.postDelayed(this, 5000);
			}
		}
	}

	@Override
	public void requestSuccess(Object tag, String json) {
		// TODO Auto-generated method stub

		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(json);
			JSONObject obj = jsonObj.getJSONObject("header");
			String code = obj.getString("resultCode");
			if ("0".equals(code)) {
				plansBean = JsonUtils.getBodyObject(json, PlansBean.class);
				plansList = plansBean.getItemList();
				for (int i = 0; i < plansList.size(); i++) {
					if (i <= 2) {
						Bundle data = new Bundle();
						data.putInt("type", i);
						data.putSerializable("DiyList",
								(Serializable) plansList);
						Offers_Fragment1 OfferFragment = new Offers_Fragment1();
						OfferFragment.setArguments(data);
						pushResourceList.add(OfferFragment);
					} else {
						break;
					}
				}
				addCarousel(pushResourceList);
			} else {

			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void requestError(Object tag, VolleyError e) {
		// TODO Auto-generated method stub

	}
}
