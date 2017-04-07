package com.huawei.vodafone.ui.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.huawei.vodafone.R;
import com.huawei.vodafone.db.DBAdapter;
import com.huawei.vodafone.db.JokeMsg;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NotificationAdapter extends BaseAdapter {
	private Context context;
	private List<JokeMsg> data;
	private LayoutInflater inflater;
	private int flag;

	public NotificationAdapter(Context context, List<JokeMsg> data, int flag) {
		this.context = context;
		this.data = data;
		this.flag=flag;
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

	public void delete(int position) {
		DBAdapter db = new DBAdapter(context);
		db.openDb();
		db.delete(data.get(position).getIdd());	
		Log.d("position", data.get(position).getIdd());
		data.remove(position);
		notifyDataSetChanged();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_list_notification, null);
			holder.tv = (TextView) convertView.findViewById(R.id.tv_name);
			holder.image = (ImageView) convertView.findViewById(R.id.ic_images);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		if (data.get(position).getCode().equals("1")) {
			holder.tv.setTextColor(context.getResources().getColor(R.color.gray));
		} else {
			holder.tv.setTextColor(context.getResources().getColor(R.color.gray_bg));
		}

		if (data.get(position).getType().equals("usage")) {
			holder.image.setImageResource(R.drawable.bg_usage);
			holder.tv.setText(data.get(position).getContent());
		} else if (data.get(position).getType().equals("billing")) {
			holder.image.setImageResource(R.drawable.bg_billing);
			holder.tv.setText(data.get(position).getContent());
		} else if (data.get(position).getType().toString().equals("offers")) {
			holder.image.setImageResource(R.drawable.bg_offer);
			holder.tv.setText(data.get(position).getContent());
		} 
		return convertView;
	}

	class ViewHolder {
		TextView tv;
		ImageView image;
	}
}