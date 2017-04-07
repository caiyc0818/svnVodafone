package com.huawei.vodafone.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.huawei.vodafone.R;

/**
 * @author weich
 * @date 2016-1-25 下午3:31:31 个人中心
 */
public class Test_fragment extends BaseFragment implements OnClickListener {
	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.activity_bills, null);
		initView(view);
		return view;
	}

	private void initView(View view) {

	}

	@Override
	public void onClick(View v) {

	}
}
