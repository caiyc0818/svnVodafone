package com.huawei.vodafone.ui.adapter;

import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.SignInInfo;
import com.huawei.vodafone.db.DBSignInAdapter;

/**
 */
public class SignInHistoryleftListAdapter extends BaseAdapter {

	private final Context context;

	private List<SignInInfo> list;

	public SignInHistoryleftListAdapter(Context context, int num) {
		this.context = context;
		init();
	}

	private void init() {
		DBSignInAdapter db = new DBSignInAdapter(context);
		db.openDb();
		list = db.queryAllRecord(1);
		db.closeDb();
		Collections.reverse(list);
	}

	@Override
	public int getCount() {
		return list.size();
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
					R.layout.sign_in_history_item_left, null);
			holder.history_time = (TextView) convertView
					.findViewById(R.id.history_time);
			holder.history_view = (View) convertView
					.findViewById(R.id.history_view);
			holder.sign_number = (TextView) convertView
					.findViewById(R.id.sign_number);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.history_time.setText(list.get(position).getTime());
		if (holder.sign_number == null) {
			int a = 0;
		}
		holder.sign_number.setText("+" + list.get(position).getReserved1());
		if (position + 1 == list.size()) {
			holder.history_view.setVisibility(View.GONE);
		} else {
			holder.history_view.setVisibility(View.VISIBLE);
		}
		return convertView;
	}

	static class ViewHolder {

		private TextView history_time;

		private View history_view;

		private TextView sign_number;
	}

}
