package com.huawei.vodafone.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.vodafone.R;

/**
 */
public class SearchListAdapter extends BaseAdapter {

	private final Context context;

	private int num;
	private int type;

	public SearchListAdapter(Context context, int num, int type) {
		this.context = context;
		this.num = num;
		this.type = type;
	}

	@Override
	public int getCount() {
		return num;
	}

	@Override
	public Object getItem(int position) {
		return position;
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
					R.layout.search_detail_item, null);
			holder.image = (ImageView) convertView
					.findViewById(R.id.search_item_image);
			holder.title = (TextView) convertView
					.findViewById(R.id.search_item_title);
			holder.text = (TextView) convertView
					.findViewById(R.id.search_item_text);
			holder.price = (TextView) convertView
					.findViewById(R.id.search_item_price);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		switch (position) {
		case 0:
			if (type == 0) {
				holder.title.setText("500M data");
				holder.text.setText("500M extra data in current month");
				holder.price.setText("€10.00");
			} else {
				holder.title.setText("500Min calls");
				holder.text.setText("500Min extra calls in current month");
				holder.price.setText("€10.00");
			}
			break;
		case 1:
			holder.title.setText("1G data");
			holder.text.setText("1G extra data in current month");
			holder.price.setText("€20.00");
			break;
		case 2:
			holder.title.setText("10G data");
			holder.text.setText("10G extra data in current month");
			holder.price.setText("€70.00");
			break;
		case 3:
			holder.title.setText("15G data");
			holder.text.setText("15G extra data in current month");
			holder.price.setText("€35.00");
			break;
		case 4:
			holder.title.setText("25G data");
			holder.text.setText("25G extra data in current month");
			holder.price.setText("€39.00");
			break;
		default:
			break;
		}
		return convertView;
	}

	static class ViewHolder {
		private ImageView image;

		private TextView title;

		private TextView text;

		private TextView price;
	}

}
