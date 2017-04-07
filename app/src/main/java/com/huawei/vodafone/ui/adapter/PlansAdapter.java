package com.huawei.vodafone.ui.adapter;

import java.util.List;

import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.PlansItem;
import com.huawei.vodafone.util.DiyUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlansAdapter extends BaseAdapter implements OnClickListener {
	private List<PlansItem> mList;
	private Context context;
	private LayoutInflater inflater;

	public PlansAdapter(List<PlansItem> mList, Context context) {
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
			view = inflater.inflate(R.layout.plans_item, null);

			holder = new ViewHolder();
			holder.text1 = (TextView) view.findViewById(R.id.text1);
			holder.uk_data = (TextView) view.findViewById(R.id.uk_date);
			holder.money = (TextView) view.findViewById(R.id.un3);
			holder.text = (TextView) view.findViewById(R.id.un22);
			holder.min = (TextView) view.findViewById(R.id.un);
			holder.plus_choose = (LinearLayout) view.findViewById(R.id.plus_choose);
			holder.go_details = (ImageView) view.findViewById(R.id.go_details);
			view.setTag(holder);
		} else {
			view = convertView;
			holder = (ViewHolder) view.getTag();
		}

		PlansItem pc = mList.get(position);
		if (position == mList.size() - 1) {
			holder.plus_choose.setVisibility(View.VISIBLE);
			holder.plus_choose.setOnClickListener(this);
		} else {
			holder.plus_choose.setVisibility(View.GONE);
		}
		double money = 0;
		int unit = Integer.valueOf(pc.getFee().getCurrencyUnit());
		money = money + pc.getFee().getCurrencyValue() * Math.pow(10, -unit);
		holder.money.setText("€" + money + " " + context.getString(R.string.settings_per_month));
		if (pc.getLevelList() != null) {
			for (int i = 0; i < pc.getLevelList().size(); i++) {
				if ("C_DATA_LEVEL".equals(pc.getLevelList().get(i).getItemId())) {
					holder.uk_data
							.setText(DiyUtils.getDataValue(Integer.parseInt(pc.getLevelList().get(i).getLevelId())));
					holder.text1
							.setText(DiyUtils.getDataValue(Integer.parseInt(pc.getLevelList().get(i).getLevelId())));
				} else if ("C_UNIT_LEVEL".equals(pc.getLevelList().get(i).getItemId())) {
					holder.min.setText(DiyUtils.getVoiceValue(Integer.parseInt(pc.getLevelList().get(i).getLevelId())));
				} else if ("C_SMS_LEVEL".equals(pc.getLevelList().get(i).getItemId())) {
					holder.text.setText(
							DiyUtils.getSmsValue(Integer.parseInt(pc.getLevelList().get(i).getLevelId())) + " ");
				}
			}

		}
		return view;
	}

	static class ViewHolder {
		public TextView text;
		public TextView text1;
		public TextView uk_data;
		public TextView money;
		public LinearLayout plus_choose;
		public TextView min;
		public ImageView go_details;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.plus_choose:

			break;

		default:
			break;
		}
	}

}
