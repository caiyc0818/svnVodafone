package com.huawei.vodafone.ui.fragment;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {
	private ArrayList<Fragment> fragments;
	private FragmentManager fm;

	public FragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		this.fm = fm;
	}

	public FragmentPagerAdapter(FragmentManager fragmentManager, ArrayList<Fragment> fragments) {
		super(fragmentManager);
		this.fm = fragmentManager;
		this.fragments = fragments;
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}

//	public void setFragments(ArrayList<Fragment> fragments) {
//		if (this.fragments != null) {
//			FragmentTransaction ft = fm.beginTransaction();
//			for (Fragment f : this.fragments) {
//				ft.remove(f);
//			}
//			ft.commit();
//			ft = null;
//			fm.executePendingTransactions();
//		}
//		this.fragments = fragments;
//		notifyDataSetChanged();
//	}

	
//	@Override
//	public Object instantiateItem(ViewGroup container, final int position) {
//		Object obj = super.instantiateItem(container, position);
//		return obj;
//	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
//		super.destroyItem(container, position, object);
//		FragmentTransaction ft = fm.beginTransaction();
//		ft.detach((Fragment) object); // 把fragment从Activity中detach掉

	}

}