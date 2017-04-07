package com.huawei.vodafone.products.activity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.OfferBean;
import com.huawei.vodafone.ui.activity.ArgeementActivity;
import com.huawei.vodafone.ui.activity.BaseActivity;
import com.huawei.vodafone.util.DateHandler;
import com.huawei.vodafone.util.DateUtil;
import com.huawei.vodafone.util.PreferenceUtils;

public class ContractDetailsActivity extends BaseActivity {

	private ImageView back_details;
	private ImageView imageView2;
	private TextView textView1;
	private RelativeLayout details_terms;
	private LinearLayout addresss;
	private HashMap<String, Object> dataMap;
	private TextView offerNameTv;
	private TextView priceTv;
	private TextView durationTv;
	private TextView fromTv;
	private boolean isOffer;
	private OfferBean offerBean;
	private int openDateIndex;
	private int endDateIndex;
	private TextView cost;
	private String openDate;
	private String endDate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contract_details);
		initSecondTitle("Contract details");
		Intent it = getIntent();
		if (it.hasExtra("dataMap"))
			dataMap = (HashMap<String, Object>) getIntent().getSerializableExtra("dataMap");
		if (it.hasExtra("offerBean")) {
			isOffer = true;
			dataMap = new HashMap<>();
			offerBean = (OfferBean) it.getExtras().get("offerBean");
			if (offerBean.getOfferId() == 12011) {
				dataMap.put("offerId", "12011");
				dataMap.put("offerName", offerBean.getOfferName());
				dataMap.put("effectiveDate", offerBean.getEffectiveTime().replace("-", ""));
				dataMap.put("expireDate", afterNDay(30, offerBean.getEffectiveTime().replace("-", "")));
			} else {
				dataMap.put("offerId", offerBean.getOfferId());
				dataMap.put("offerName", offerBean.getOfferName());
				dataMap.put("offerPrice", (float) offerBean.getPrice() * 0.0001);
				dataMap.put("effectiveDate", offerBean.getEffectiveTime());
				dataMap.put("expireDate", offerBean.getExpireTime());
			}
		}
		initView();
	}

	public String afterNDay(int n, String data) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date;
		try {
			date = sdf.parse(data);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, n);
			Date d2 = c.getTime();
			String s = sdf.format(d2);
			return s;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}

	public void initView() {
		back_details = (ImageView) findViewById(R.id.back);
		textView1 = (TextView) findViewById(R.id.title);
		cost = (TextView) findViewById(R.id.cost);
		durationTv = (TextView) findViewById(R.id.duration_tv);
		fromTv = (TextView) findViewById(R.id.from_tv);
		details_terms = (RelativeLayout) findViewById(R.id.details_terms);
		addresss = (LinearLayout) findViewById(R.id.addresss);
		back_details.setOnClickListener(this);
		details_terms.setOnClickListener(this);
		offerNameTv = (TextView) findViewById(R.id.offerName_tv);
		priceTv = (TextView) findViewById(R.id.price_tv);
		if (dataMap != null) {
			offerNameTv.setText(dataMap.get("offerName").toString());
			if (dataMap.get("offerId") == null) {
				priceTv.setText("€" + dataMap.get("offerPrice").toString());
			} else if ("12011".equals(dataMap.get("offerId"))) {
				priceTv.setText(getResources().getString(R.string.Free_for_30days));
				details_terms.setVisibility(View.GONE);
				cost.setText(getResources().getString(R.string.cost2));
				addresss.setVisibility(View.GONE);
			} else {
				priceTv.setText("€" + dataMap.get("offerPrice").toString());
			}
			if (isOffer) {
				openDate = dataMap.get("effectiveDate").toString();
				endDate = dataMap.get("expireDate").toString();
			} else {
				openDate = PreferenceUtils.getString(this, "effectiveDate");
				endDate = PreferenceUtils.getString(this, "expireDate");
			}
			if (openDate != null && endDate != null) {
				if (isOffer) {
					String fromDate = openDate.substring(6, 8) + " "
							+ DateUtil.getEnglishMonth(Integer.parseInt(openDate.substring(4, 6))) + " "
							+ openDate.substring(0, 4);
					String toDate1 = endDate.substring(6, 8) + " "
							+ DateUtil.getEnglishMonth(Integer.parseInt(endDate.substring(4, 6))) + " "
							+ endDate.substring(0, 4);
					if ("12011".equals(dataMap.get("offerId"))) {
						durationTv.setText("30 days");
					} else {
						durationTv.setText(
								DateHandler.remainDateToString(openDate.substring(0, 8), endDate.substring(0, 8)));
					}
					fromTv.setText("From " + fromDate + " to " + toDate1);
				} else {
					// for (int i = 0; i < openDate.length(); i++) {
					// openDateIndex = openDate.indexOf("2");
					// }
					// for (int i = 0; i < endDate.length(); i++) {
					// endDateIndex = endDate.indexOf("2");
					// }
					// String fromDate = openDate.substring(openDateIndex + 6,
					// openDateIndex + 8) + " "
					// +
					// DateUtil.getEnglishMonth(Integer.parseInt(openDate.substring(4,
					// 6))) + " "
					// + openDate.substring(endDateIndex + 0, endDateIndex + 4);
					// String toDate1 = endDate.substring(endDateIndex + 6,
					// endDateIndex + 8) + " "
					// + DateUtil.getEnglishMonth(
					// Integer.parseInt(endDate.substring(endDateIndex + 4,
					// endDateIndex + 6)))
					// + " " + endDate.substring(endDateIndex + 0, endDateIndex
					// + 4);
					// durationTv.setText(
					// DateHandler.remainDateToString(openDate.substring(openDateIndex,
					// openDateIndex + 8),
					// endDate.substring(endDateIndex, endDateIndex + 8)));
					// fromTv.setText("From " + fromDate + " to " + toDate1);

					String fromDate = openDate.substring(6, 8) + " "
							+ DateUtil.getEnglishMonth(Integer.parseInt(openDate.substring(4, 6))) + " "
							+ openDate.substring(0, 4);
					String toDate1 = endDate.substring(6, 8) + " "
							+ DateUtil.getEnglishMonth(Integer.parseInt(endDate.substring(4, 6))) + " "
							+ endDate.substring(0, 4);
					durationTv
							.setText(DateHandler.remainDateToString(openDate.substring(0, 8), endDate.substring(0, 8)));
					fromTv.setText("From " + fromDate + " to " + toDate1);
				}
			}
		}
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.back:
			onBackPressed();
			break;
		case R.id.details_terms:
			Intent it = new Intent(ContractDetailsActivity.this, ArgeementActivity.class);
			it.putExtra("from", "tc");
			startActivity(it);
			break;
		default:
			break;
		}
	}

}
