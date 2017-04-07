package com.huawei.vodafone.ui.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.vodafone.R;

/**
 * @author hanweipeng
 * @date 2014年12月29日 下午10:38:29
 */
public class RechargeAdapter extends BaseAdapter {

	private final Context context;

	private final List<String> List;

	private boolean isMore;

	private int selectPosition = -1;

	public RechargeAdapter(Context context, List<String> List) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.List = List;
	}

	public void setIsMore(boolean isMore) {
		this.isMore = isMore;
	}

	public void setSeceltPosition(int selectPosition) {
		this.selectPosition = selectPosition;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return List.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return List.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.recharge_popwindow_item, null);
			holder.eneType = (TextView) convertView.findViewById(R.id.type_txt);
			holder.rightArrowImg = (ImageView) convertView
					.findViewById(R.id.right_arrow);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.eneType.setText(List.get(position));

		return convertView;
	}

	static class ViewHolder {
		private TextView eneType;

		private ImageView rightArrowImg;
	}

}
