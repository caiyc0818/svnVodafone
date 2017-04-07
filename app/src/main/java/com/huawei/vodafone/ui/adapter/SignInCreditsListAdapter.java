package com.huawei.vodafone.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.util.PreferenceUtils;
import com.huawei.vodafone.util.StringUtils;

/**
 */
public class SignInCreditsListAdapter extends BaseAdapter {

	private final Context context;

	private int num;

	public SignInCreditsListAdapter(Context context, int num) {
		this.context = context;
		this.num = num;
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
					R.layout.sign_in_credits_item, null);
			holder.credits_image = (ImageView) convertView
					.findViewById(R.id.credits_image);
			holder.credits_name = (TextView) convertView
					.findViewById(R.id.credits_name);
			holder.credits_point = (TextView) convertView
					.findViewById(R.id.credits_point);
			holder.credits_ecchanged = (TextView) convertView
					.findViewById(R.id.credits_ecchanged);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		if (position == 0) {
			holder.credits_image.setImageResource(R.drawable.iconm10);
			holder.credits_name.setText("1GB Data");
			holder.credits_point.setText("100 Points");

			String num = StringUtils.formatDecimalFloat(
					PreferenceUtils.getInt(context, "1GData"), 0);
			holder.credits_ecchanged.setText(num + " redeemed");
		} else if (position == 1) {
			holder.credits_image.setImageResource(R.drawable.iconm20);
			holder.credits_name.setText("2GB Data");
			holder.credits_point.setText("200 Points");

			String num = StringUtils.formatDecimalFloat(
					PreferenceUtils.getInt(context, "2GData"), 0);
			holder.credits_ecchanged.setText(num + " redeemed");
		} else {
			holder.credits_image.setImageResource(R.drawable.iphone_image2);
			holder.credits_name.setText("Huawei Mate8");
			holder.credits_point.setText("500,000 Points");

			String num = StringUtils.formatDecimalFloat(
					PreferenceUtils.getInt(context, "huaweimate8"), 0);
			holder.credits_ecchanged.setText(num + " redeemed");

		}
		return convertView;
	}

	static class ViewHolder {
		private ImageView credits_image;

		private TextView credits_name;

		private TextView credits_point;

		private TextView credits_ecchanged;
	}

}
