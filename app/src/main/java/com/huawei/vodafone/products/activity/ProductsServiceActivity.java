package com.huawei.vodafone.products.activity;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.BookingInfo;
import com.huawei.vodafone.bean.FreeUnitItem;
import com.huawei.vodafone.bean.OfferBean;
import com.huawei.vodafone.bean.OfferInstValue;
import com.huawei.vodafone.bean.UserInfo;
import com.huawei.vodafone.bean.repetitionofferBeanList;
import com.huawei.vodafone.net.IRequest;
import com.huawei.vodafone.net.RequestJSon;
import com.huawei.vodafone.net.RequestListener;
import com.huawei.vodafone.net.URLs;
import com.huawei.vodafone.ui.activity.BaseActivity;
import com.huawei.vodafone.ui.adapter.ProductsServiceApapter;
import com.huawei.vodafone.ui.adapter.ProductsServiceThreeAdapter;
import com.huawei.vodafone.ui.myview.CircleProgressView;
import com.huawei.vodafone.ui.myview.MyListview;
import com.huawei.vodafone.util.DateUtil;
import com.huawei.vodafone.util.DensityUtil;
import com.huawei.vodafone.util.NationalUtils;
import com.huawei.vodafone.util.PreferenceUtils;
import com.huawei.vodafone.util.StringUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductsServiceActivity extends BaseActivity {

	private ImageView back_services;
	private ImageView imageView2;
	private TextView servicePhone;
	private TextView serviceName;
	private ImageView img_left;
	private ImageView service_iv;
	private LinearLayout ll_left;
	private LinearLayout ll_right;
	private ImageView img_right;
	private ProductsServiceApapter productsServiceAdapter;
	private ProductsServiceThreeAdapter productsThreeServiceAdapter;
	private ProductsServiceThreeAdapter productsThreeServiceAdapter1;
	private MyListview serices_listview;
	private MyListview serices_listview1;
	private List<ImageView> images;
	private ViewPagerAdapter adapter;
	private ScrollView scrollView;
	private int currentItem;
	private Bitmap[] imageIds = new Bitmap[2];
	private ArrayList<HashMap<String, Object>> data;
	private ArrayList<HashMap<String, Object>> data1;
	private ArrayList<HashMap<String, Object>> data2;
	private ArrayList<HashMap<String, Object>> data3;
	private ArrayList<HashMap<String, Object>> newdata;
	private ArrayList<HashMap<String, Object>> newDataList = new ArrayList<>();
	private HashMap<String, Object> dataMap;
	private TextView subscribedOfferingsTv;
	private TextView bookingTv;
	private ImageView tipIv;
	private TextView ordersTv;
	private LinearLayout ordersLl;
	private RelativeLayout sericesRl;
	private LinearLayout servicesLinearLayout;
	// 最终的循环的title集合
	private ArrayList<repetitionofferBeanList> temprepetitionofferBeanList = new ArrayList<>();
	private List<OfferBean> offerBeanList = new ArrayList<>();
	/*
	 * 相同id的缓冲集合  id = 12011 初始化多一条数据 其他的 是去除第一条数据的
	 */
	private ArrayList<repetitionofferBeanList> repetitionofferBeanList1 = new ArrayList<repetitionofferBeanList>();
	private ArrayList<FreeUnitItem> freeUnitItem = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_products_service);
		initSecondTitle(getString(R.string.services_context));
		Intent it = getIntent();
		if (it.hasExtra("dataMap"))
			dataMap = (HashMap<String, Object>) getIntent().getSerializableExtra("dataMap");
		if (it.hasExtra("freeUnitItem")) {
			freeUnitItem = (ArrayList<FreeUnitItem>) getIntent().getSerializableExtra("freeUnitItem");
		}
		initView();
		ProcessedData();
		initListener();
		// registerBoradcastReceiver();

	}

	private void ProcessedData() {
		// TODO Auto-generated method stub
		offerBeanList.clear();
		if (freeUnitItem != null) {
			for (int i1 = 0; i1 < freeUnitItem.size(); i1++) {
				if (freeUnitItem.get(i1).getFreeUnitItemDetailItem() != null) {
					if (!"10102".equals(freeUnitItem.get(i1).getFreeUnitItemDetailItem().getFreeUnitOrigin()
							.getOfferingKey().getOfferingID())) {
						OfferBean offerBean = new OfferBean();
						offerBean.setCurrentAmount(freeUnitItem.get(i1).getFreeUnitItemDetailItem().getCurrentAmount());
						offerBean.setEffectiveTime(freeUnitItem.get(i1).getFreeUnitItemDetailItem().getEffectiveTime());
						offerBean.setExpireTime(freeUnitItem.get(i1).getFreeUnitItemDetailItem().getExpireTime());
						offerBean.setInitialAmount(freeUnitItem.get(i1).getFreeUnitItemDetailItem().getInitialAmount());
						offerBean.setOfferId(Integer.parseInt(freeUnitItem.get(i1).getFreeUnitItemDetailItem()
								.getFreeUnitOrigin().getOfferingKey().getOfferingID()));
						offerBean.setOfferName(NationalUtils.getOfferName(freeUnitItem.get(i1)
								.getFreeUnitItemDetailItem().getFreeUnitOrigin().getOfferingKey().getOfferingID()));
						offerBean.setPrice(NationalUtils.getPrice(freeUnitItem.get(i1).getFreeUnitItemDetailItem()
								.getFreeUnitOrigin().getOfferingKey().getOfferingID()));
						offerBean.setType(freeUnitItem.get(i1).getFreeUnitTypeName());

						for (int i = 0; i < offerBeanList.size(); i++) {
							if (freeUnitItem.get(i1).getFreeUnitItemDetailItem().getFreeUnitOrigin().getOfferingKey()
									.getOfferingID().equals(String.valueOf(offerBeanList.get(i).getOfferId()))) {
								offerBeanList.get(i).setTag(offerBeanList.get(i).getTag() + 1);
								offerBean.setTag(-1);
								repetitionofferBeanList repetitionofferBean = new repetitionofferBeanList();
								repetitionofferBean.setOfferList(offerBean);
								repetitionofferBean.setTag(i);
								repetitionofferBeanList1.add(repetitionofferBean);

								continue;
							}
						}
						if (offerBean.getTag() != -1) {
							offerBeanList.add(offerBean);
						}
					}
				} else {
					for (int j = 0; j < freeUnitItem.get(i1).getFreeUnitItemDetailArray().size(); j++) {
						if (!"10102".equals(freeUnitItem.get(i1).getFreeUnitItemDetailArray().get(j).getFreeUnitOrigin()
								.getOfferingKey().getOfferingID())) {
							OfferBean offerBean = new OfferBean();
							offerBean.setCurrentAmount(
									freeUnitItem.get(i1).getFreeUnitItemDetailArray().get(j).getCurrentAmount());
							offerBean.setEffectiveTime(
									freeUnitItem.get(i1).getFreeUnitItemDetailArray().get(j).getEffectiveTime());
							offerBean.setExpireTime(
									freeUnitItem.get(i1).getFreeUnitItemDetailArray().get(j).getExpireTime());
							offerBean.setInitialAmount(
									freeUnitItem.get(i1).getFreeUnitItemDetailArray().get(j).getInitialAmount());
							offerBean.setOfferId(Integer.parseInt(freeUnitItem.get(i1).getFreeUnitItemDetailArray()
									.get(j).getFreeUnitOrigin().getOfferingKey().getOfferingID()));
							offerBean.setOfferName(
									NationalUtils.getOfferName(freeUnitItem.get(i1).getFreeUnitItemDetailArray().get(j)
											.getFreeUnitOrigin().getOfferingKey().getOfferingID()));
							offerBean.setPrice(NationalUtils.getPrice(freeUnitItem.get(i1).getFreeUnitItemDetailArray()
									.get(j).getFreeUnitOrigin().getOfferingKey().getOfferingID()));
							offerBean.setType(freeUnitItem.get(i1).getFreeUnitTypeName());

							for (int i = 0; i < offerBeanList.size(); i++) {
								if (freeUnitItem.get(i1).getFreeUnitItemDetailArray().get(j).getFreeUnitOrigin()
										.getOfferingKey().getOfferingID()
										.equals(String.valueOf(offerBeanList.get(i).getOfferId()))) {
									offerBeanList.get(i).setTag(offerBeanList.get(i).getTag() + 1);
									offerBean.setTag(-1);
									repetitionofferBeanList repetitionofferBean = new repetitionofferBeanList();
									repetitionofferBean.setOfferList(offerBean);
									repetitionofferBean.setTag(i);
									repetitionofferBeanList1.add(repetitionofferBean);
								}
							}
							if (offerBean.getTag() != -1) {
								offerBeanList.add(offerBean);
							}
						}
					}
				}
			}
		}

	}

	public void initView() {
		back_services = (ImageView) findViewById(R.id.back);
		img_left = (ImageView) findViewById(R.id.service_img_left);
		service_iv = (ImageView) findViewById(R.id.service_iv);
		img_right = (ImageView) findViewById(R.id.service_img_right);
		serices_listview = (MyListview) findViewById(R.id.serices_listview);
		serices_listview1 = (MyListview) findViewById(R.id.serices_listview1);
		scrollView = (ScrollView) findViewById(R.id.service_scrollView);
		servicePhone = (TextView) findViewById(R.id.service_phone);
		serviceName = (TextView) findViewById(R.id.service_name);
		ll_left = (LinearLayout) findViewById(R.id.ll_left);
		ll_right = (LinearLayout) findViewById(R.id.ll_right);
		subscribedOfferingsTv = (TextView) findViewById(R.id.subscribed_offerings_tv);
		bookingTv = (TextView) findViewById(R.id.booking_tv);
		tipIv = (ImageView) findViewById(R.id.tip_iv);
		scrollView.smoothScrollTo(0, 20);
		serviceName.setText(UserInfo.getUserName() + "'s phone");
		servicePhone.setText(UserInfo.getUserMobile());
		data = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 2; i++) {
			if (i == 1 && !PreferenceUtils.getBoolean(this, "haveDiy"))
				continue;
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("aa", "aa");
			data.add(map);
		}
		productsServiceAdapter = new ProductsServiceApapter(this, data, 1, dataMap);
		serices_listview.setAdapter(productsServiceAdapter);

		data1 = new ArrayList<HashMap<String, Object>>();
		data2 = new ArrayList<HashMap<String, Object>>();
		data3 = new ArrayList<HashMap<String, Object>>();
		newdata = new ArrayList<HashMap<String, Object>>();
		productsThreeServiceAdapter = new ProductsServiceThreeAdapter(this, data1);
		serices_listview1.setAdapter(productsThreeServiceAdapter);
		productsThreeServiceAdapter1 = new ProductsServiceThreeAdapter(this, data2);
		getData();
		service_iv.setImageBitmap(UserInfo.getIcon(getBaseContext()));
		subscribedOfferingsTv.setOnClickListener(this);
		bookingTv.setOnClickListener(this);
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				tipIv.getLayoutParams().width = subscribedOfferingsTv.getWidth();
			}
		}, 100);
		subscribedOfferingsTv.getPaint().setFakeBoldText(true);
		ordersTv = (TextView) findViewById(R.id.orders_tv);
		ordersLl = (LinearLayout) findViewById(R.id.orders_ll);
		sericesRl = (RelativeLayout) findViewById(R.id.serices_rl);
		servicesLinearLayout = (LinearLayout) findViewById(R.id.serices_linearlayout);

	}

	public void addView(final int i) {
		final OfferBean offerBean = offerBeanList.get(i);
		View view = LayoutInflater.from(this).inflate(R.layout.services_layout, null);
		LinearLayout title = (LinearLayout) view.findViewById(R.id.title);
		RelativeLayout contract_details = (RelativeLayout) view.findViewById(R.id.contract_details);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		layoutParams.topMargin = DensityUtil.dip2px(this, 10);
		contract_details.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent it = new Intent(ProductsServiceActivity.this, ContractDetailsActivity.class);
				it.putExtra("offerBean", offerBean);
				ProductsServiceActivity.this.startActivity(it);
			}
		});

		/*
		 * offerBean.getTag()  id==12011 tag初始化为1 其他为0
		 */
		if (offerBean.getOfferId() == 12011) {
			offerBean.setTag(offerBean.getTag()-1);
		}
		if (offerBean.getTag() > 0) {
			temprepetitionofferBeanList.clear();
			repetitionofferBeanList temp = new repetitionofferBeanList();
			temp.setOfferList(offerBean);
			temp.setTag(i);
			temprepetitionofferBeanList.add(temp);
			for (int j = 0; j < repetitionofferBeanList1.size(); j++) {
				if (i == repetitionofferBeanList1.get(j).getTag()) {
					temprepetitionofferBeanList.add(repetitionofferBeanList1.get(j));
				}
			}
			for (int j = 0; j < temprepetitionofferBeanList.size(); j++) {
				addTitleView(temprepetitionofferBeanList.get(j).getOfferList(), title);
			}
		} else {
			addTitleView(offerBean, title);
		}

		servicesLinearLayout.addView(view, layoutParams);

	}

	private void addTitleView(OfferBean offerBean, LinearLayout title) {
		View titleView = LayoutInflater.from(this).inflate(R.layout.titlelayout, null);
		TextView productName = (TextView) titleView.findViewById(R.id.tv_products_one);
		TextView left = (TextView) titleView.findViewById(R.id.tv_products_two);
		CircleProgressView circleProgressView = (CircleProgressView) titleView.findViewById(R.id.circleProgressView);
		if (StringUtils.isEmpty(offerBean.getOfferName())) {
			offerBean.setOfferName("Free");
		}
		productName.setText(offerBean.getOfferName());
		if (offerBean.getOfferId() == 12011) {
			left.setVisibility(View.GONE);
			circleProgressView.setVisibility(View.GONE);
		} else {
			left.setVisibility(View.VISIBLE);
			circleProgressView.setVisibility(View.VISIBLE);
			if (offerBean.getType().contains("Data")) {
				if (Integer.parseInt(offerBean.getCurrentAmount()) / 1024 % 1024 == 0) {
					left.setText(Integer.parseInt(offerBean.getCurrentAmount()) / 1024 / 1024 + "GB left");
				} else {
					left.setText(Integer.parseInt(offerBean.getCurrentAmount()) / 1024 + "MB left");
				}
			} else if (offerBean.getOfferName().contains("Voice")) {
				left.setText(offerBean.getCurrentAmount() + "Min left");
			} else {
				left.setText(offerBean.getCurrentAmount() + " left");

			}
			if (Integer.parseInt(offerBean.getInitialAmount()) == 0) {
				circleProgressView.setProgress(0);
			} else {
				circleProgressView.setProgress((int) (Integer.parseInt(offerBean.getCurrentAmount())
						/ Integer.parseInt(offerBean.getInitialAmount()) * 100));
			}
		}
		// circleProgressView.setProgress(100);
		title.addView(titleView);
	}

	private void initListener() {
		back_services.setOnClickListener(this);
		img_left.setOnClickListener(this);
		img_right.setOnClickListener(this);
		ll_left.setOnClickListener(this);
		ll_right.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.ll_left:
			// service_vp.setCurrentItem(currentItem - 1);
			break;
		case R.id.ll_right:
			// service_vp.setCurrentItem(currentItem + 1);
			break;
		case R.id.back:
			onBackPressed();
			break;
		case R.id.subscribed_offerings_tv:
			if (tipIv.getX() != 0) {
				subscribedOfferingsTv.getPaint().setFakeBoldText(true);
				bookingTv.getPaint().setFakeBoldText(false);
				subscribedOfferingsTv.invalidate();
				bookingTv.invalidate();
				tipAnimate(0);
				data1.clear();
				if (data3.size() > 0) {
					data1.addAll(data3);
				} else {
					data1.addAll(newdata);
				}

				// serices_listview1.setAdapter(productsThreeServiceAdapter);
				productsThreeServiceAdapter.notifyDataSetChanged();
			}

			break;
		case R.id.booking_tv:
			if (tipIv.getX() != subscribedOfferingsTv.getWidth()) {
				bookingTv.getPaint().setFakeBoldText(true);
				subscribedOfferingsTv.getPaint().setFakeBoldText(false);
				subscribedOfferingsTv.invalidate();
				bookingTv.invalidate();
				tipAnimate(subscribedOfferingsTv.getWidth());
				data1.clear();
				data1.addAll(data2);
				// serices_listview1.setAdapter(productsThreeServiceAdapter1);
				productsThreeServiceAdapter.notifyDataSetChanged();
			}
			break;
		default:
			break;
		}
	}

	private class ViewPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return images.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup view, int position, Object object) {
			view.removeView(images.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup view, int position) {
			view.addView(images.get(position));
			return images.get(position);
		}

	}

	private void getData() {
		IRequest.get(3, URLs.OFFERINSTLIST, RequestJSon.ReferInfo(), new RequestListener() {

			@Override
			public void requestSuccess(Object tag, String json) {
				// TODO Auto-generated method stub
				data1.clear();
				data3.clear();
				JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
				if (jsonObject.get("body") == null || jsonObject.get("body").equals("null"))
					return;
				// if(jsonObject.get("body").getAsJsonObject().get("offerInstList")==null)return;
				if (!jsonObject.get("body").isJsonObject())
					return;

				JsonArray jsonArray = jsonObject.get("body").getAsJsonObject().get("offerInstList").getAsJsonArray();

				for (int i = 0; i < jsonArray.size(); i++) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					OfferInstValue field = new Gson().fromJson(jsonArray.get(i), OfferInstValue.class);
					if (!field.getOfferType().equals("A"))
						continue;
					map.put("offName", field.getOfferName());
					map.put("offDesc", field.getOfferDesc());
					if (field.getPeriodicFee() != null) {
						if (field.getPeriodicFee().getCurrencyValue() != 0) {
							float price = field.getPeriodicFee().getCurrencyValue() / 10000;
							DecimalFormat decimalFormat = new DecimalFormat(".00");// 构造方法的字符格式这里如果小数不足2位,会以0补足.
							String p = decimalFormat.format(price);// format
																	// 返回的是字符串
							map.put("offPrice", p);
						} else {
							map.put("offPrice", "0");
						}
					} else
						map.put("offPrice", "0");
					map.put("date", DateUtil.formateDateToTimeStr1(field.getEffectiveDate().getUtcDateTime()));
					data1.add(map);
					data3.add(map);
				}
				// HashMap<String, Object> map = new HashMap<String,
				// Object>();
				// map.put("aa", "aa");
				// data1.add(map);
				productsThreeServiceAdapter.notifyDataSetChanged();
			}

			@Override
			public void requestError(Object tag, VolleyError e) {
				// TODO Auto-generated method stub

			}
		});
		IRequest.get(15, URLs.ALLBOOKINFO, RequestJSon.BookingHistory(), new RequestListener() {

			@Override
			public void requestSuccess(Object tag, String json) {
				// TODO Auto-generated method stub
				JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
				if (jsonObject.get("body") == null || jsonObject.get("body").equals("null"))
					return;
				if (!jsonObject.get("body").isJsonObject()) {
					return;
				}
				JsonArray jsonArray = jsonObject.get("body").getAsJsonObject().get("BookingInfo").getAsJsonArray();
				OfferBean offerBean = new OfferBean();
				List<OfferBean> tempOfferBeanList = new ArrayList<>();
				for (int i = 0; i < jsonArray.size(); i++) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					BookingInfo field = new Gson().fromJson(jsonArray.get(i), BookingInfo.class);
					if (!field.getOfferType().equals("A"))
						continue;
					map.put("offName", field.getOfferName());
					map.put("offDesc", null);
					map.put("offPrice", "0");
					map.put("offeringInstStatus", field.getOfferingInstStatus());
					map.put("date", field.getCreateTime().getUtcDate().replaceAll("-", "."));
					data2.add(map);
					if ("12011".equals(field.getOfferId())) {
						offerBean.setOfferName(field.getOfferName());
						offerBean.setOfferId(12011);
						offerBean.setEffectiveTime(field.getCreateTime().getUtcDate());
						offerBean.setTag(offerBean.getTag() + 1);
						repetitionofferBeanList repetitionofferBean = new repetitionofferBeanList();
						repetitionofferBean.setOfferList(offerBean);
						repetitionofferBean.setTag(offerBeanList.size());
						repetitionofferBeanList1.add(repetitionofferBean);
						tempOfferBeanList.add(offerBean);
					}
				}
				newdata.clear();
				for (int i = 0; i < data2.size(); i++) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map = data2.get(i);
					if (map.get("offeringInstStatus").equals("2")) {
						newdata.add(map);
					}

				}
				data1.addAll(newdata);
				productsThreeServiceAdapter.notifyDataSetChanged();
				if(repetitionofferBeanList1.size()>0){
					repetitionofferBeanList1.remove(repetitionofferBeanList1.size()-1);
				}
				if (tempOfferBeanList.size() > 0) {
					offerBeanList.add(tempOfferBeanList.get(tempOfferBeanList.size() - 1));
				}
				for (int j = 0; j < offerBeanList.size(); j++) {
					addView(j);
				}
			}

			@Override
			public void requestError(Object tag, VolleyError e) {
				// TODO Auto-generated method stub
				for (int j = 0; j < offerBeanList.size(); j++) {
					addView(j);
				}
			}
		});
	}

	// public void registerBoradcastReceiver() {
	// IntentFilter myIntentFilter = new IntentFilter();
	// myIntentFilter.addAction("com.vodafone.refreshDIYData");
	// // 注册广播
	// registerReceiver(mBroadcastReceiver, myIntentFilter);
	// }
	//
	// private void unRegisterBoradcastReceiver() {
	// unregisterReceiver(mBroadcastReceiver);
	// }

	// private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
	//
	// @Override
	// public void onReceive(Context context, Intent intent) {
	// String action = intent.getAction();
	// if ("com.vodafone.refreshDIYData".equals(action)) {
	// dataMap = (HashMap<String, Object>)
	// intent.getSerializableExtra("dataMap");
	// productsServiceAdapter.notifyDataSetChanged();
	// }
	// }
	// };

	// protected void onDestroy() {
	// super.onDestroy();
	// unRegisterBoradcastReceiver();
	// };

	private void tipAnimate(int end) {
		ValueAnimator animator = ValueAnimator.ofFloat(tipIv.getX(), end);
		animator.setTarget(tipIv);
		animator.setDuration(200).start();
		animator.addUpdateListener(new AnimatorUpdateListener() {

			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				// TODO Auto-generated method stub
				float value = (Float) animation.getAnimatedValue();
				tipIv.setX(value);
			}
		});
	}
}
