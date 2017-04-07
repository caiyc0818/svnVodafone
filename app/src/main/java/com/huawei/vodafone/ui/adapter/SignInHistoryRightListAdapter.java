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
import com.huawei.vodafone.util.StringUtils;

/**
 */
public class SignInHistoryRightListAdapter extends BaseAdapter {

	private final Context context;

	private List<SignInInfo> list;

	public SignInHistoryRightListAdapter(Context context, int num) {
		this.context = context;
		init();
	}

	private void init() {
		DBSignInAdapter db = new DBSignInAdapter(context);
		db.openDb();
		list = db.queryAllRecord(2);
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
					R.layout.sign_in_history_item_right, null);
			holder.history_time = (TextView) convertView
					.findViewById(R.id.history_time);
			holder.history_title = (TextView) convertView
					.findViewById(R.id.history_title);
			holder.history_num = (TextView) convertView
					.findViewById(R.id.history_num);
			holder.history_view = (View) convertView
					.findViewById(R.id.history_view);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.history_title.setText(list.get(position).getTitle());
		holder.history_time.setText(list.get(position).getTime());
		String point = StringUtils.formatDecimalFloat(list.get(position)
				.getPoint(), 0);
		holder.history_num.setText(point);
		if (position + 1 == list.size()) {
			holder.history_view.setVisibility(View.GONE);
		} else {
			holder.history_view.setVisibility(View.VISIBLE);
		}
		return convertView;
	}

	static class ViewHolder {

		private TextView history_time, history_title, history_num;

		private View history_view;
	}

}
