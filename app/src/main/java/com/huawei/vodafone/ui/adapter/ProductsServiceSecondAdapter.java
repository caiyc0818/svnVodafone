package com.huawei.vodafone.ui.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.UserInfo;
import com.huawei.vodafone.ui.myview.CircleProgressView;

public class ProductsServiceSecondAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<HashMap<String, Object>> data;
	private LayoutInflater inflater;
	int i;

	public ProductsServiceSecondAdapter(Context context,
			ArrayList<HashMap<String, Object>> data, int i) {
		this.context = context;
		this.data = data;
		this.i = i;
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
					R.layout.item_products_service_second_adapter, null);
			holder.tv_products_one = (TextView) convertView
					.findViewById(R.id.tv_products_one);
			holder.circleProgressView = (CircleProgressView) convertView
					.findViewById(R.id.circleProgressView);
			holder.tv_products_two = (TextView) convertView
					.findViewById(R.id.tv_products_two);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		if (i == 1) {
			if (position == 0) {
				float allData = Float.parseFloat(UserInfo.getDiydataall()
						.replace(",", ""));
				float leftData = Float.parseFloat(UserInfo.getDiydataleft()
						.replace(",", ""));
				holder.tv_products_one.setText(UserInfo.getDiydataall()
						+ "GB data");
				holder.tv_products_two.setText(UserInfo.getDiydataleft()
						+ "GB left");
				if (allData == 0) {
					holder.circleProgressView.setProgress(0);
				} else {
					holder.circleProgressView.setProgress((int) (leftData
							/ allData * 100));
				}
			} else if (position == 1) {
				int allUnit = Integer.parseInt(UserInfo.getDiyunitall()
						.replace(",", ""));
				int leftUnit = Integer.parseInt(UserInfo.getDiyunitleft()
						.replace(",", ""));
				holder.tv_products_one.setText(allUnit + " calls");
				holder.tv_products_two.setText(leftUnit + " left");
				if (allUnit == 0) {
					holder.circleProgressView.setProgress(0);
				} else {
					holder.circleProgressView.setProgress(leftUnit / allUnit
							* 100);
				}

			} else if (position == 2) {
				int allUnit = Integer.parseInt(UserInfo.getDiysmsall()
						.replace(",", ""));
				int leftUnit = Integer.parseInt(UserInfo.getDiysmsleft()
						.replace(",", ""));
				holder.tv_products_one.setText(allUnit + " texts");
				holder.tv_products_two.setText(leftUnit + " left");
				if (allUnit == 0) {
					holder.circleProgressView.setProgress(0);
				} else {
					holder.circleProgressView.setProgress(leftUnit / allUnit
							* 100);
				}
			}
		} else {
			if (position == 0) {
				float allData = Float.parseFloat(UserInfo.getDiydataall()
						.replace(",", ""));
				float leftData = Float.parseFloat(UserInfo.getDiydataleft()
						.replace(",", ""));
				holder.tv_products_one.setText(UserInfo.getDiydataall()
						+ "GB data");
				holder.tv_products_two.setText(UserInfo.getDiydataleft()
						+ "GB left");
				if (allData == 0) {
					holder.circleProgressView.setProgress(0);
				} else {
					holder.circleProgressView.setProgress((int) (leftData
							/ allData * 100));
				}

				// holder.tv_products_one.setText("5GB data");
				// holder.tv_products_two.setText("10GB left");
				// holder.circleProgressView.setProgress(30);

			} else if (position == 1) {
				int allUnit = Integer.parseInt(UserInfo.getDiyunitall()
						.replace(",", ""));
				int leftUnit = Integer.parseInt(UserInfo.getDiyunitleft()
						.replace(",", ""));
				holder.tv_products_one.setText(allUnit + " UK minutes");
				holder.tv_products_two.setText(leftUnit + " left");
				if (allUnit == 0) {
					holder.circleProgressView.setProgress(0);
				} else {
					holder.circleProgressView.setProgress(leftUnit / allUnit
							* 100);
				}

				// holder.tv_products_one.setText("400 UK minutes");
				// holder.tv_products_two.setText("80 left");
				// holder.circleProgressView.setProgress(65);
			} else if (position == 2) {
				int allUnit = Integer.parseInt(UserInfo.getDiysmsall()
						.replace(",", ""));
				int leftUnit = Integer.parseInt(UserInfo.getDiysmsleft()
						.replace(",", ""));
				holder.tv_products_one.setText(allUnit + " texts");
				holder.tv_products_two.setText(leftUnit + " left");
				if (allUnit == 0) {
					holder.circleProgressView.setProgress(0);
				} else {
					holder.circleProgressView.setProgress(leftUnit / allUnit
							* 100);
				}
			}
		}

		return convertView;
	}

	class ViewHolder {
		TextView tv_products_one;
		CircleProgressView circleProgressView;
		TextView tv_products_two;
	}
}
