package com.huawei.vodafone.ui.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.util.UnitUtil;

public class ProductsServiceThreeAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<HashMap<String, Object>> data;
	private LayoutInflater inflater;

	public ProductsServiceThreeAdapter(Context context,
			ArrayList<HashMap<String, Object>> data) {
		this.context = context;
		this.data = data;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(
					R.layout.item_products_three_service_adapter, null);
			holder.iv_data = (ImageView) convertView.findViewById(R.id.iv_data);
			holder.tv_data = (TextView) convertView.findViewById(R.id.tv_data);
			holder.tv_data_details = (TextView) convertView
					.findViewById(R.id.tv_data_details);
			holder.tv_data_cost = (TextView) convertView
					.findViewById(R.id.tv_data_cost);
			holder.tv_data_time = (TextView) convertView
					.findViewById(R.id.tv_data_time);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		HashMap<String, Object> map = data.get(position);
		// if(position!=data.size()-1){
		Object offeringInstStatus = map.get("offeringInstStatus");
		if (offeringInstStatus != null && !offeringInstStatus.equals("2")) {
			holder.iv_data.setBackgroundResource(R.drawable.data_red_icon_gray);
		} else {
			holder.iv_data.setBackgroundResource(R.drawable.data_red_icon);
		}
		if (map.get("offName") != null)
			holder.tv_data.setText(map.get("offName").toString());
		else {
			holder.tv_data.setVisibility(View.GONE);
		}
		if (map.get("offDesc") != null)
			holder.tv_data_details.setText(map.get("offDesc").toString());
		else {
			holder.tv_data_details.setVisibility(View.GONE);
		}
		holder.tv_data_cost.setText(UnitUtil.getSign("EUR")
				+ map.get("offPrice").toString());
		holder.tv_data_time.setText(map.get("date").toString());
		// }
		// else{
		// holder.iv_data.setBackgroundResource(R.drawable.request_call_pressed);
		// holder.tv_data.setText("200Min calls");
		// holder.tv_data_details.setText("200Min extra calls in current month");
		// holder.tv_data_cost.setText("€15.00");
		// }

		return convertView;
	}

	class ViewHolder {
		ImageView iv_data;
		TextView tv_data;
		TextView tv_data_details;
		TextView tv_data_cost;
		TextView tv_data_time;
	}

	public static Drawable tintDrawable(Drawable drawable, ColorStateList colors) {
		DrawableCompat.setTintList(drawable, colors);
		return drawable;
	}
}