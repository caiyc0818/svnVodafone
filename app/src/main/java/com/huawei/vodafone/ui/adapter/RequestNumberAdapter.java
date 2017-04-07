package com.huawei.vodafone.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

public class RequestNumberAdapter extends BaseAdapter {
	private List<User> mList;
	private Context context;
	private LayoutInflater inflater;
	public RequestNumberAdapter(List<User> mList, Context context) {
		this.mList = mList;
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {

		return mList == null ? 0 : mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		ViewHolder holder;
		if (convertView == null) {
			view = inflater.inflate( R.layout.request_call_number_item, null);

			holder = new ViewHolder();
			holder.numTv = (TextView) view
					.findViewById(R.id.num_tv);
			holder.nameTv = (TextView) view
					.findViewById(R.id.name_tv);
			view.setTag(holder);
		} else {
			view = convertView;
			holder = (ViewHolder) view.getTag();
		}

		User pc = mList.get(position);
		holder.numTv.setText(pc.getNumber());
		holder.nameTv.setText("("+pc.getNickname()+"'s mobile)");
		return view;
	}

	static class ViewHolder {
		public TextView numTv;
		public TextView nameTv;
	}
}
