package com.huawei.vodafone.ui.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.huawei.vodafone.R;
import com.huawei.vodafone.products.activity.ContractDetailsActivity;
import com.huawei.vodafone.ui.myview.MyListview;
import com.huawei.vodafone.util.UnitUtil;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ProductsServiceApapter extends BaseAdapter {

	private Context context;
	private ArrayList<HashMap<String, Object>> data;
	private HashMap<String, Object> dataMap;
	
	private LayoutInflater inflater;
	private int i;

	public ProductsServiceApapter(Context context, ArrayList<HashMap<String, Object>> data, int i,HashMap<String, Object> dataMap) {
		this.context = context;
		this.data = data;
		this.i = i;
		inflater = LayoutInflater.from(context);
		this.dataMap=dataMap;
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
	public View getView(final int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_products_service_adapter, null);
			holder.ll_title = (LinearLayout) convertView.findViewById(R.id.ll_title);
			holder.product_text = (TextView) convertView.findViewById(R.id.product_text);
			holder.title_one = (TextView) convertView.findViewById(R.id.title_one);
			holder.title_two = (TextView) convertView.findViewById(R.id.title_two);
			holder.title_three = (TextView) convertView.findViewById(R.id.title_three);
			holder.title_four = (TextView) convertView.findViewById(R.id.title_four);
			holder.adapter_list = (MyListview) convertView.findViewById(R.id.adapter_list);
			holder.serviceLine = (View) convertView.findViewById(R.id.service_line);
			holder.view_line2 = (View) convertView.findViewById(R.id.view_line2);
			holder.contract_details = (RelativeLayout) convertView.findViewById(R.id.contract_details);
			holder.mainPackageRl = (RelativeLayout) convertView.findViewById(R.id.main_package_rl);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		ArrayList<HashMap<String, Object>> data1 = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 3; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("a1", "10GB data");
			map.put("a11", "3.8GB left");
			map.put("a111", 50);
			data1.add(map);
		}
		ProductsServiceSecondAdapter adapter = new ProductsServiceSecondAdapter(context, data1, i);
		holder.adapter_list.setAdapter(adapter);
		if (position == 1) {
			holder.mainPackageRl.setVisibility(View.GONE);
			holder.ll_title.setVisibility(View.VISIBLE);
			holder.mainPackageRl.setVisibility(View.GONE);
			holder.adapter_list.setVisibility(View.VISIBLE);
			holder.serviceLine.setVisibility(View.VISIBLE);
			holder.view_line2.setVisibility(View.VISIBLE);
			holder.view_line2.setVisibility(View.GONE);
			holder.title_three.setVisibility(View.VISIBLE);
			holder.product_text.setText("Extras");
			if (i == 1) {
				if(dataMap!=null){
					holder.title_one.setVisibility(View.VISIBLE);
					((View)holder.title_three.getParent()).setVisibility(View.VISIBLE);
				holder.title_one.setText(dataMap.get("offerName").toString());
				holder.title_three.setText(UnitUtil.getSign("EUP")+dataMap.get("offerPrice").toString());
				}else{
					holder.title_one.setVisibility(View.GONE);
					((View)holder.title_three.getParent()).setVisibility(View.GONE);
				}
				holder.title_four.setText(" per month");
			} else {
				if(dataMap!=null){
					holder.title_one.setVisibility(View.VISIBLE);
					((View)holder.title_three.getParent()).setVisibility(View.VISIBLE);
					holder.title_one.setText(dataMap.get("offerName").toString());
					holder.title_three.setText(UnitUtil.getSign("EUP")+dataMap.get("offerPrice").toString());
					}else{
						holder.title_one.setVisibility(View.GONE);
						((View)holder.title_three.getParent()).setVisibility(View.GONE);
					}
//				holder.title_one.setText("Red 5GB Bundle");
//				holder.title_three.setText("€35.20 ");
				holder.title_four.setText(" per month");
			}
			
		} else if (position == 0) {
			holder.mainPackageRl.setVisibility(View.VISIBLE);
			holder.ll_title.setVisibility(View.GONE);
//			holder.title_three.setVisibility(View.GONE);
//			holder.product_text.setText("Extras");
			holder.adapter_list.setVisibility(View.GONE);
			holder.serviceLine.setVisibility(View.VISIBLE);
			holder.view_line2.setVisibility(View.VISIBLE);
			holder.title_one.setText("Red Main Package");
//			holder.title_two.setText("Premium subscription");
			holder.title_three.setText("€0");
			holder.title_four.setText(" per month");
		}
		holder.title_two.setVisibility(View.GONE);
		holder.contract_details.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent it=new Intent(context, ContractDetailsActivity.class);
				if (position == 1) 
				it.putExtra("dataMap", dataMap);
				context.startActivity(it);
			}
		});

		return convertView;
	}

	class ViewHolder {
		LinearLayout ll_title;
		TextView product_text;
		TextView title_one;
		TextView title_two;
		TextView title_three;
		TextView title_four;
		View serviceLine;
		View view_line2;
		MyListview adapter_list;
		RelativeLayout contract_details;
		RelativeLayout mainPackageRl;
	}

}