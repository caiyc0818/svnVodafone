package com.huawei.vodafone.ui.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.PersonalInfo;
import com.huawei.vodafone.bean.UserInfo;

public class SelectServceListAdapter extends BaseAdapter {
	private Context mContext;
	private ArrayList<PersonalInfo> list;

	public SelectServceListAdapter(Context mContext) {
		super();
		this.mContext = mContext;
		list = UserInfo.orderByTime();
	}

	public int getselect(int position) {
		return Integer.valueOf(list.get(position).getPosition());
	}

	@Override
	public int getCount() {
		return UserInfo.getListsize();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	// public void setList(ArrayList<OfferInstValue> data) {
	// this.list = data;
	// notifyDataSetChanged();
	// }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.main_select_servce_item, parent, false);
			holder.name = (TextView) convertView
					.findViewById(R.id.select_service_name);
			holder.num = (TextView) convertView
					.findViewById(R.id.select_service_num);
			holder.image = (ImageView) convertView
					.findViewById(R.id.select_service_image);
			holder.select = (ImageView) convertView
					.findViewById(R.id.search_selector_image);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		fake(holder, position);
		return convertView;
	}

	private void fake(ViewHolder holder, int position) {
		holder.name.setText(list.get(position).getUserName() + "'s phone");
		holder.num.setText(list.get(position).getUserMobile());
		holder.image.setImageBitmap(UserInfo.getIcon(mContext,
				list.get(position).getUserMobile()));
		if (position == 0) {
			holder.select.setSelected(true);
		} else {
			holder.select.setSelected(false);
		}
	}

	class ViewHolder {
		TextView name, num;
		ImageView image, select;
	}
}
