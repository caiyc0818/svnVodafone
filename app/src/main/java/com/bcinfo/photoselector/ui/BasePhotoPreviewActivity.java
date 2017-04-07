package com.bcinfo.photoselector.ui;

/**
 * 
 * @author Aizaz AZ
 *
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bcinfo.photoselector.model.PhotoModel;
import com.bcinfo.photoselector.util.AnimationUtil;
import com.huawei.vodafone.R;

import java.util.ArrayList;

public class BasePhotoPreviewActivity extends Activity implements OnPageChangeListener, OnClickListener {

	private ViewPager mViewPager;
	private RelativeLayout layoutTop;
	private ImageButton btnBack;
	private TextView tvPercent;
	protected ArrayList<PhotoModel> photos;
	protected int current;
	private ImageView delBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
		setContentView(R.layout.activity_photopreview);
		layoutTop = (RelativeLayout) findViewById(R.id.layout_top_app);
		btnBack = (ImageButton) findViewById(R.id.btn_back_app);
		tvPercent = (TextView) findViewById(R.id.tv_percent_app);
		mViewPager = (ViewPager) findViewById(R.id.vp_base_app);
		delBtn = (ImageView) findViewById(R.id.detail_delete_btn);
		delBtn.setOnClickListener(this);
		btnBack.setOnClickListener(this);
		mViewPager.addOnPageChangeListener(this);

		overridePendingTransition(R.anim.activity_alpha_action_in, 0); // 渐入效果

	}

	/** 绑定数据，更新界面 */
	protected void bindData() {
		mViewPager.setAdapter(mPagerAdapter);
		mViewPager.setCurrentItem(current);
	}

	private PagerAdapter mPagerAdapter = new PagerAdapter() {

		@Override
		public int getCount() {
			if (photos == null) {
				return 0;
			} else {
				return photos.size();
			}
		}

		@Override
		public View instantiateItem(final ViewGroup container, final int position) {
			PhotoPreview photoPreview = new PhotoPreview(getApplicationContext());
			((ViewPager) container).addView(photoPreview);
			photoPreview.loadImage(photos.get(position));
			photoPreview.setOnClickListener(photoItemClickListener);
			return photoPreview;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public int getItemPosition(Object object) {
			return POSITION_NONE;// 删除必须要加的东西！！！！
		}

	};
	protected boolean isUp;

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_back_app) {
			Intent data = new Intent();
			Bundle bundle = new Bundle();
			bundle.putSerializable("photos", photos);
			data.putExtras(bundle);
			setResult(RESULT_OK, data);
			finish();
		} else if (v.getId() == R.id.detail_delete_btn) {
			new AlertDialog.Builder(this).setTitle("确认删除吗？")
					.setPositiveButton("确认", new android.content.DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							delItem();
							dialog.dismiss();
						}
					}).setNegativeButton("取消", new android.content.DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
						}
					}).show();
		}
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int arg0) {
		current = arg0;
		updatePercent();
	}

	protected void updatePercent() {
		tvPercent.setText((current + 1) + "/" + photos.size());
	}

	/** 图片点击事件回调 */
	private OnClickListener photoItemClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (!isUp) {
				new AnimationUtil(getApplicationContext(), R.anim.translate_up)
						.setInterpolator(new LinearInterpolator()).setFillAfter(true).startAnimation(layoutTop);
				isUp = true;
			} else {
				new AnimationUtil(getApplicationContext(), R.anim.translate_down_current)
						.setInterpolator(new LinearInterpolator()).setFillAfter(true).startAnimation(layoutTop);
				isUp = false;
			}
		}
	};

	private void delItem() {
		if (photos.size() > 0) {
			photos.remove(current);
			if (photos.size() > 0) {
				if (current > 0)
					--current;
				updatePercent();
				mPagerAdapter.notifyDataSetChanged();
				mViewPager.setCurrentItem(current);
			} else {
				mPagerAdapter.notifyDataSetChanged();
				Intent data = new Intent();
				Bundle bundle = new Bundle();
				bundle.putSerializable("photos", photos);
				data.putExtras(bundle);
				setResult(RESULT_OK, data);
				finish();
			}
		}
	}
}
