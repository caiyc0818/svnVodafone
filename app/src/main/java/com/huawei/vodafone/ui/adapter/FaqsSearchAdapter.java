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

public class FaqsSearchAdapter extends BaseAdapter implements Filterable {
	private ArrayFilter mFilter;
	private List<String> mList;
	private Context context;
	private ArrayList<String> mUnfilteredData;
	private LayoutInflater inflater;
	public FaqsSearchAdapter(List<String> mList, Context context) {
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

	@Override
	public Filter getFilter() {
		if (mFilter == null) {
			mFilter = new ArrayFilter();
		}
		return mFilter;
	}

	private class ArrayFilter extends Filter {

		@Override
		protected FilterResults performFiltering(CharSequence prefix) {
			FilterResults results = new FilterResults();

			if (mUnfilteredData == null) {
				mUnfilteredData = new ArrayList<String>(mList);
			}

			if (prefix == null || prefix.length() == 0) {
				ArrayList<String> list = mUnfilteredData;
				results.values = list;
				results.count = list.size();
			} else {
				String prefixString = prefix.toString().toLowerCase();

				ArrayList<String> unfilteredValues = mUnfilteredData;
				int count = unfilteredValues.size();

				ArrayList<String> newValues = new ArrayList<String>(count);

				for (int i = 0; i < count; i++) {
					String pc = unfilteredValues.get(i).toLowerCase();

					if (pc != null && pc.startsWith(prefixString)) {

						newValues.add(pc);
					}
				}

				results.values = newValues;
				results.count = newValues.size();
			}

			return results;
		}

		@Override
		protected void publishResults(CharSequence constraint,
				FilterResults results) {
			// noinspection unchecked
			mList = (List<String>) results.values;
			if (results.count > 0) {
				notifyDataSetChanged();
			} else {
				notifyDataSetInvalidated();
			}
		}

	}
}
