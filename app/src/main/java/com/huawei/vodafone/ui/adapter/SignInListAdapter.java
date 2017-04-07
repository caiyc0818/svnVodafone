package com.huawei.vodafone.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.vodafone.R;

/**
 */
public class SignInListAdapter extends BaseAdapter {

	private final Context context;

	private int day;

	public SignInListAdapter(Context context, int day) {
		this.context = context;
		this.day = day;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public void addOne(int day) {
		this.day = day;
		notifyDataSetChanged();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.sign_in_main_item, null);
			holder.gift = (ImageView) convertView
					.findViewById(R.id.sign_in_gift);
			holder.point = (ImageView) convertView
					.findViewById(R.id.select_point);
			holder.text = (TextView) convertView
					.findViewById(R.id.sign_in_item_text);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		if (position < day) {
			holder.point.setImageResource(R.drawable.select_point);
			holder.text.setTextColor(ContextCompat.getColor(context,
					R.color.white));
		} else {
			holder.point.setImageResource(R.drawable.normal_point);
			holder.text.setTextColor(ContextCompat.getColor(context,
					R.color.blue_dark));
		}
		if (position == 9) {
			holder.gift.setVisibility(View.VISIBLE);
		} else {
			holder.gift.setVisibility(View.INVISIBLE);
		}
		holder.text.setText((position + 1) + "DAY");
		return convertView;
	}

	static class ViewHolder {
		private ImageView gift;

		private ImageView point;

		private TextView text;
	}

}
