package com.huawei.vodafone.ui.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.Faq;

public class FaqsDetailAdapter extends BaseAdapter {
	private List<Faq> faqs = new ArrayList<Faq>();

	private Context mContext;

	private LayoutInflater inflater;

	public FaqsDetailAdapter(Context mContext, List<Faq> faqs) {
		this.mContext = mContext;
		this.faqs = faqs;
		inflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return faqs.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return faqs.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		final Faq faq = faqs.get(position);
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.faqs_detail_item, null);
			holder.faqTitle = (TextView) convertView
					.findViewById(R.id.faq_title_tv);
			holder.showIv = (ImageView) convertView.findViewById(R.id.show_iv);
			holder.contentLl = (LinearLayout) convertView
					.findViewById(R.id.content_ll);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.faqTitle.setText(faq.getTitle());
		((View)holder.showIv.getParent()).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				faq.setShow(!faq.isShow());
				notifyDataSetChanged();

			}
		});

		if (!faq.isShow()) {
			holder.contentLl.setVisibility(View.GONE);
//			holder.showIv.setImageResource(R.drawable.show_down);
			holder.showIv.animate().rotation(0);
		} else {
			holder.contentLl.setVisibility(View.VISIBLE);
//			holder.showIv.setImageResource(R.drawable.show_up);
			holder.showIv.animate().rotation(180);
			holder.contentLl.removeAllViews();
			for (Map.Entry<String, String> entry : faq.getMap().entrySet()) {
				View view = inflater.inflate(R.layout.faq_content, null);
				TextView subTitle = (TextView) view
						.findViewById(R.id.subTitle_tv);
				TextView content = (TextView) view
						.findViewById(R.id.content_tv);
				subTitle.setText(entry.getKey());
				content.setText(entry.getValue());
				holder.contentLl.addView(view);
			}
		}
		return convertView;
	}

	private class ViewHolder {
		private TextView faqTitle;
		private ImageView showIv;
		private LinearLayout contentLl;
	}

}
