package com.huawei.vodafone.ui.adapter;

import java.util.List;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * ViewPager适配器
 * @function
 * @author     JiangCS  
 * @version   1.0, 2015年4月7日 下午5:02:21
 */
public class FaqsPagerAdapter extends PagerAdapter
{
    public List<View> mListViews;

    public FaqsPagerAdapter(List<View> mListViews)
    {
        this.mListViews = mListViews;
    }

    @Override
    public void destroyItem(View arg0, int arg1, Object arg2)
    {
        ((ViewPager) arg0).removeView(mListViews.get(arg1));
    }

    @Override
    public void finishUpdate(View arg0)
    {
    }

    @Override
    public int getCount()
    {
        return mListViews.size();
    }

    @Override
    public Object instantiateItem(View arg0, final int arg1)
    {
        ((ViewPager) arg0).addView(mListViews.get(arg1), 0);
        return mListViews.get(arg1);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1)
    {
        return arg0 == (arg1);
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1)
    {
    }

    @Override
    public Parcelable saveState()
    {
        return null;
    }

    @Override
    public void startUpdate(View arg0)
    {
    }
}
