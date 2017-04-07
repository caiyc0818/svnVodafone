package com.huawei.vodafone.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.PersonItemInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PersonAdapter extends BaseAdapter implements OnClickListener {
	private List<PersonItemInfo> mList;
	private Context context;
	private LayoutInflater inflater;

	public PersonAdapter(ArrayList<PersonItemInfo> mList, Context context) {
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
			view = inflater.inflate(R.layout.person_item, null);

			holder = new ViewHolder();
			holder.text1 = (TextView) view.findViewById(R.id.title);
			holder.text = (TextView) view.findViewById(R.id.content);
			view.setTag(holder);
		} else {
			view = convertView;
			holder = (ViewHolder) view.getTag();
		}

		final PersonItemInfo PersonItemInfo = mList.get(position);
		holder.text1.setText(PersonItemInfo.getTitle());

		holder.text.setText(PersonItemInfo.getContent());

		return view;
	}

	static class ViewHolder {
		public TextView text;
		public TextView text1;

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
