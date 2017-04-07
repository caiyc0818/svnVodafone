package com.huawei.vodafone.ui.adapter;

import java.util.List;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewParent;

/**
 * @author hanweipeng
 * @version V1.0 创建时间：2014-2-18 上午11:08:48
 */
public class SignInPagerAdapter extends PagerAdapter {
	public List<View> mListViews;

	private Context context;

	private ViewPager viewPager;

	public SignInPagerAdapter(Context context, List<View> mListViews,
			ViewPager viewPager) {
		this.mListViews = mListViews;
		this.context = context;
		this.viewPager = viewPager;
	}

	@Override
	public void destroyItem(View arg0, int position, Object arg2) {
		// ((ViewPager)arg0).removeView(mListViews.get(position %
		// mListViews.size()));
	}

	@Override
	public void finishUpdate(View arg0) {
	}

	@Override
	public int getCount() {
		return mListViews.size();
	}

	@Override
	public Object instantiateItem(View arg0, final int position) {
		ViewParent parent = mListViews.get(position).getParent();
		if (parent != null) {
			viewPager.removeView(mListViews.get(position));
		}
		((ViewPager) arg0).addView(mListViews.get(position), 0);
		return mListViews.get(position);
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == (arg1);
	}

	@Override
	public void restoreState(Parcelable arg0, ClassLoader arg1) {
	}

	@Override
	public Parcelable saveState() {
		return null;
	}

	@Override
	public void startUpdate(View arg0) {
	}
}
