package com.bcinfo.photoselector.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bcinfo.photoselector.model.PhotoModel;
import com.huawei.vodafone.R;
import com.huawei.vodafone.util.ToastUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * @author Aizaz AZ
 * 
 */

public class PhotoItem extends LinearLayout implements OnCheckedChangeListener,
		OnLongClickListener, View.OnClickListener {

	private ImageView ivPhoto;
	private CheckBox cbPhoto;
	private onPhotoItemCheckedListener listener;
	private onPhotoItemClickedListener listener1;
	private PhotoModel photo;
	private boolean isCheckAll;
	private onItemClickListener l;
	private int position;

	private PhotoItem(Context context) {
		super(context);
	}

	public PhotoItem(Context context, onPhotoItemCheckedListener listener,
			onPhotoItemClickedListener clickedListener) {
		this(context);
		LayoutInflater.from(context).inflate(R.layout.layout_photoitem, this,
				true);
		this.listener = listener;
		this.listener1 = clickedListener;
		setOnLongClickListener(this);
		ivPhoto = (ImageView) findViewById(R.id.iv_photo_lpsi);
		cbPhoto = (CheckBox) findViewById(R.id.cb_photo_lpsi);
		if (listener != null) {
			cbPhoto.setOnCheckedChangeListener(this); //
		}
		if (clickedListener != null) {
			cbPhoto.setVisibility(View.GONE);
			ivPhoto.setOnClickListener(this); //
		}
		cbPhoto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if(isChecked){
		if(listener.totalSize()==5&&!listener.isContain(photo)){
			ToastUtil.showToast(getContext(), "最多添加5张!");
			buttonView.setChecked(false);
			return;
		}
		}
		if (!isCheckAll) {
			listener.onCheckedChanged(photo, buttonView, isChecked);
		}

		if (isChecked) {
			setDrawingable();
			ivPhoto.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
		} else {
			ivPhoto.clearColorFilter();
		}
		photo.setChecked(isChecked);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		listener1.onClicked(photo);
	}

	public void setImageDrawable(final PhotoModel photo) {
		this.photo = photo;
		// You may need this setting form some custom ROM(s)
		/*
		 * new Handler().postDelayed(new Runnable() {
		 * 
		 * @Override public void run() { ImageLoader.getInstance().displayImage(
		 * "file://" + photo.getOriginalPath(), ivPhoto); } }, new
		 * Random().nextInt(10));
		 */

		ImageLoader.getInstance().displayImage(
				"file://" + photo.getOriginalPath(), ivPhoto);
	}

	private void setDrawingable() {
		ivPhoto.setDrawingCacheEnabled(true);
		ivPhoto.buildDrawingCache();
	}

	@Override
	public void setSelected(boolean selected) {
		if (photo == null) {
			return;
		}
		isCheckAll = true;
		cbPhoto.setChecked(selected);
		isCheckAll = false;
	}

	public void setOnClickListener(onItemClickListener l, int position) {
		this.l = l;
		this.position = position;
	}

	// @Override
	// public void
	// onClick(View v) {
	// if (l != null)
	// l.onItemClick(position);
	// }

	public static interface onPhotoItemCheckedListener {
		public void onCheckedChanged(PhotoModel photoModel,
				CompoundButton buttonView, boolean isChecked);
		
		public int totalSize();
		
		public boolean isContain(PhotoModel photoModel);
	}

	public interface onItemClickListener {
		public void onItemClick(int position);
	}

	@Override
	public boolean onLongClick(View v) {
		if (l != null)
			l.onItemClick(position);
		return true;
	}

	public static interface onPhotoItemClickedListener {
		public void onClicked(PhotoModel photoModel);
	}
}
