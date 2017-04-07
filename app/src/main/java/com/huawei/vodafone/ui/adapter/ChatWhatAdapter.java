package com.huawei.vodafone.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import com.huawei.vodafone.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

public class ChatWhatAdapter extends BaseAdapter {
	private List<String> mList;
	private Context context;
	private LayoutInflater inflater;
	public ChatWhatAdapter(List<String> mList, Context context) {
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
			view = inflater.inflate( R.layout.faqs_search_item, null);

			holder = new ViewHolder();
			holder.contentTv = (TextView) view
					.findViewById(R.id.search_content_tv);
			view.setTag(holder);
		} else {
			view = convertView;
			holder = (ViewHolder) view.getTag();
		}

		String pc = mList.get(position);
		holder.contentTv.setText(pc);
		return view;
	}

	static class ViewHolder {
		public TextView contentTv;
	}
}
