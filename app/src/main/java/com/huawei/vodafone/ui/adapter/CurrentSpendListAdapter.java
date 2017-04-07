package com.huawei.vodafone.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.vodafone.R;

public class CurrentSpendListAdapter extends BaseAdapter {
	private Context mContext;
	private int num;

	public CurrentSpendListAdapter(Context mContext, int num) {
		super();
		this.mContext = mContext;
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
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.main_activity_item, parent, false);
			holder.left = (TextView) convertView
					.findViewById(R.id.current_spend_text_left);
			holder.right = (TextView) convertView
					.findViewById(R.id.current_spend_text_right);
			holder.image = (ImageView) convertView
					.findViewById(R.id.current_spend_type_image);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		fake(holder, position);
		return convertView;
	}

	private void fake(ViewHolder holder, int position) {
		switch (position) {
		case 0:
			holder.left.setText("Voice roaming while abroad");
			holder.right.setText("€5.00");
			holder.image.setImageResource(R.drawable.current_spend_abroad);
			break;
		case 1:
			holder.left.setText("2GB data add-on");
			holder.right.setText("€2.99");
			holder.image.setImageResource(R.drawable.current_spend_data);
			break;
		// case 0:
		// holder.left.setText("Making or receiving calls while abroad");
		// holder.right.setText("€3.00");
		// holder.image.setImageResource(R.drawable.current_spend_abroad);
		// break;
		// case 1:
		// holder.left.setText("Data roaming while abroad");
		// holder.right.setText("€5.00");
		// holder.image.setImageResource(R.drawable.current_spend_abroad);
		// break;
		// case 2:
		// holder.left.setText("2GB data bolt-on");
		// holder.right.setText("€2.99");
		// holder.image.setImageResource(R.drawable.current_spend_data);
		// break;
		// case 3:
		// holder.left.setText("Non-inclusive UK calls");
		// holder.right.setText("€2.01");
		// holder.image.setImageResource(R.drawable.current_spend_calls);
		// break;

		default:
			break;
		}
	}

	class ViewHolder {
		TextView left, right;
		ImageView image;
	}
}
