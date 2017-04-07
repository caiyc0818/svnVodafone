package com.bcinfo.photoselector.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;

import com.bcinfo.photoselector.model.PhotoModel;
import com.bcinfo.photoselector.ui.PhotoItem.onItemClickListener;
import com.bcinfo.photoselector.ui.PhotoItem.onPhotoItemCheckedListener;
import com.bcinfo.photoselector.ui.PhotoItem.onPhotoItemClickedListener;
import com.huawei.vodafone.R;

import java.util.ArrayList;


/**
 * 
 * @author Aizaz AZ
 * 
 */

public class PhotoSelectorAdapter extends MBaseAdapter<PhotoModel> {

	private int itemWidth;
	private int horizentalNum = 3;
	private onPhotoItemCheckedListener listener;
	private onPhotoItemClickedListener listener1;
	private LayoutParams itemLayoutParams;
	private onItemClickListener mCallback;
	private OnClickListener cameraListener;

	private PhotoSelectorAdapter(Context context, ArrayList<PhotoModel> models) {
		super(context, models);
	}

	public PhotoSelectorAdapter(Context context, ArrayList<PhotoModel> models,
			int screenWidth, onPhotoItemCheckedListener listener,onPhotoItemClickedListener listener1,
			onItemClickListener mCallback, OnClickListener cameraListener) {
		this(context, models);
		setItemWidth(screenWidth);
		this.listener = listener;
		this.listener1 = listener1;
		this.mCallback = mCallback;
		this.cameraListener = cameraListener;
	}

	public void setItemWidth(int screenWidth) {
		int horizentalSpace = context.getResources().getDimensionPixelSize(
				R.dimen.sticky_item_horizontalSpacing);
		this.itemWidth = (screenWidth - (horizentalSpace * (horizentalNum - 1)))
				/ horizentalNum;
		this.itemLayoutParams = new LayoutParams(itemWidth, itemWidth);
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		if(position==0)
			return 0;
		else return 1;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if (models != null) {
			return models.size()+1;
		}
		return 0;
	}
	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 2;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(getItemViewType(position)==0){
			convertView=LayoutInflater.from(context).inflate(R.layout.layout_takephotoitem, null);
			convertView.setLayoutParams(itemLayoutParams);
			convertView.findViewById(R.id.tv_camera_vc).setOnClickListener(cameraListener);
		}else{
		PhotoItem item = null;
		if (convertView == null || !(convertView instanceof PhotoItem)) {
			item = new PhotoItem(context, listener,listener1);
			item.setLayoutParams(itemLayoutParams);
			convertView = item;
		} else {
			item = (PhotoItem) convertView;
		}
		item.setImageDrawable(models.get(position-1));
		item.setSelected(models.get(position-1).isChecked());
		item.setOnClickListener(mCallback, position);
		}
		return convertView;
	}
}
