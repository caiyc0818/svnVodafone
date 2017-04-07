package com.huawei.vodafone.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.PlansItem;
import com.huawei.vodafone.bean.QuickCheckInfo;
import com.huawei.vodafone.bean.UserInfo;
import com.huawei.vodafone.listener.Listener.Click;
import com.huawei.vodafone.net.IRequest;
import com.huawei.vodafone.net.RequestJSon;
import com.huawei.vodafone.net.RequestListener;
import com.huawei.vodafone.net.URLs;
import com.huawei.vodafone.ui.myview.dialog.ErrorDialog;
import com.huawei.vodafone.ui.myview.dialog.WaitDialog;
import com.huawei.vodafone.util.DensityUtil;
import com.huawei.vodafone.util.DiyUtils;
import com.huawei.vodafone.util.JsonUtils;
import com.huawei.vodafone.util.PreferenceUtils;
import com.huawei.vodafone.util.TAGUtil;
import com.huawei.vodafone.util.UnitUtil;

public class SettingsOffersAndExtrarsPlansDetailsActivity extends BaseActivity
		implements OnClickListener, RequestListener {

	private ImageView back;
	private TextView text1;
	private TextView text2;
	private TextView text3;
	private TextView text4;
	private LinearLayout intrduce1;
	private LinearLayout intrduce2;
	private LinearLayout ll1;
	private LinearLayout ll2;
	private LinearLayout ll3;
	private LinearLayout inclusive;
	private RelativeLayout rela1;
	private RelativeLayout rela2;
	private TextView tv_success;
	private TextView intrduce11;

	private TextView tips_number;
	private PlansItem plansDetail;
	private RelativeLayout buy;
	private int tag;
	private int tag2;
	private int tag3;
	private int tag4;
	private int tag5;
	private TextView intrduce22;
	private int tag1;
	private WaitDialog wait;

	private static final int WHAT_TAG = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_offers_and_extras_for_you_plans_detail);
		initSecondTitle("Plans");
		plansDetail = (PlansItem) getIntent().getSerializableExtra("plans_details");
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		back = (ImageView) findViewById(R.id.back);
		text1 = (TextView) findViewById(R.id.text1);
		text2 = (TextView) findViewById(R.id.text2);
		text3 = (TextView) findViewById(R.id.text3);
		text4 = (TextView) findViewById(R.id.text4);
		intrduce11 = (TextView) findViewById(R.id.intrduce11);
		intrduce1 = (LinearLayout) findViewById(R.id.intrduce1);
		intrduce2 = (LinearLayout) findViewById(R.id.intrduce2);
		intrduce22 = (TextView) findViewById(R.id.intrduce22);
		ll2 = (LinearLayout) findViewById(R.id.ll2);
		ll1 = (LinearLayout) findViewById(R.id.ll1);
		ll3 = (LinearLayout) findViewById(R.id.ll3);
		rela1 = (RelativeLayout) findViewById(R.id.rela1);
		rela2 = (RelativeLayout) findViewById(R.id.rela2);
		inclusive = (LinearLayout) findViewById(R.id.inclusive);
		intrduce1.setOnClickListener(this);
		intrduce2.setOnClickListener(this);
		ll2.setOnClickListener(this);
		ll1.setOnClickListener(this);
		ll3.setOnClickListener(this);
		tv_success = (TextView) findViewById(R.id.tv_success);

		buy = (RelativeLayout) findViewById(R.id.buy);
		tips_number = (TextView) findViewById(R.id.tips_text);
		back.setOnClickListener(this);
		buy.setOnClickListener(this);
		if (plansDetail.getLevelList() != null) {
			for (int i = 0; i < plansDetail.getLevelList().size(); i++) {
				if ("C_DATA_LEVEL".equals(plansDetail.getLevelList().get(i).getItemId())) {
					text1.setText(DiyUtils.getDataValue(Integer.parseInt(plansDetail.getLevelList().get(i).getLevelId())));
					tips_number.setText(
							" " + DiyUtils.getDataValue(Integer.parseInt(plansDetail.getLevelList().get(i).getLevelId())) + " ");
				} else if ("C_UNIT_LEVEL".equals(plansDetail.getLevelList().get(i).getItemId())) {
					text2.setText(
							DiyUtils.getVoiceValue(Integer.parseInt(plansDetail.getLevelList().get(i).getLevelId())) + "Min");
				} else if ("C_SMS_LEVEL".equals(plansDetail.getLevelList().get(i).getItemId())) {
					text3.setText(DiyUtils.getSmsValue(Integer.parseInt(plansDetail.getLevelList().get(i).getLevelId())));
				}
			}
			double money = 0;
			int unit = Integer.valueOf(plansDetail.getFee().getCurrencyUnit());
			money = money + plansDetail.getFee().getCurrencyValue() * Math.pow(10, -unit);
			text4.setText("€" + money + " " + getResources().getString(R.string.settings_per_month));
			Log.i("====", String.valueOf(money));
		}
		if (PreferenceUtils.getBoolean(SettingsOffersAndExtrarsPlansDetailsActivity.this, "haveDiy")) {
			buy.setEnabled(false);
			buy.setBackgroundResource(R.drawable.settings_resetpin_back2);
		}
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.ll1:
			tag++;
			if (tag % 2 == 0) {
				intrduce11.setMaxLines(2);
				android.view.ViewGroup.LayoutParams pp = rela1.getLayoutParams();
				pp.height = LayoutParams.WRAP_CONTENT;// DensityUtil.dip2px(SettingsOffersAndExtrarsPlansDetailsActivity.this,
														// 165);
				rela1.setLayoutParams(pp);
				((ImageView) ll1.getChildAt(0)).setImageResource(R.drawable.settings_go_down);
			} else {
				intrduce11.setMaxLines(Integer.MAX_VALUE);
				android.view.ViewGroup.LayoutParams pp = rela1.getLayoutParams();
				pp.height = LayoutParams.WRAP_CONTENT;// DensityUtil.dip2px(SettingsOffersAndExtrarsPlansDetailsActivity.this,
														// 310);
				rela1.setLayoutParams(pp);
				((ImageView) ll1.getChildAt(0)).setImageResource(R.drawable.settings_go_up);
			}
			break;
		case R.id.ll2:
			tag1++;
			if (tag1 % 2 == 0) {
				intrduce22.setMaxLines(2);
				android.view.ViewGroup.LayoutParams pp = rela2.getLayoutParams();
				pp.height = LayoutParams.WRAP_CONTENT;// DensityUtil.dip2px(
				// SettingsOffersAndExtrarsPlansDetailsActivity.this, 165);
				rela2.setLayoutParams(pp);
				((ImageView) ll2.getChildAt(0)).setImageResource(R.drawable.settings_go_down);
			} else {
				intrduce22.setMaxLines(Integer.MAX_VALUE);
				android.view.ViewGroup.LayoutParams pp = rela2.getLayoutParams();
				pp.height = LayoutParams.WRAP_CONTENT;// DensityUtil.dip2px(
				// SettingsOffersAndExtrarsPlansDetailsActivity.this, 310);
				rela2.setLayoutParams(pp);
				((ImageView) ll2.getChildAt(0)).setImageResource(R.drawable.settings_go_up);
			}
			break;
		case R.id.ll3:
			tag3++;
			if (tag3 % 2 == 0) {
				inclusive.getChildAt(1).setVisibility(View.GONE);
				inclusive.getChildAt(2).setVisibility(View.GONE);
				inclusive.getChildAt(3).setVisibility(View.GONE);
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
						DensityUtil.dip2px(SettingsOffersAndExtrarsPlansDetailsActivity.this, 85));
				params.setMargins(DensityUtil.dip2px(SettingsOffersAndExtrarsPlansDetailsActivity.this, 8), 0,
						DensityUtil.dip2px(SettingsOffersAndExtrarsPlansDetailsActivity.this, 8), 0);
				inclusive.setLayoutParams(params);

				((ImageView) ll3.getChildAt(0)).setImageResource(R.drawable.settings_go_down);
				// inclusive.setBackgroundResource(R.drawable.settings_item_back);
			} else {
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
						DensityUtil.dip2px(SettingsOffersAndExtrarsPlansDetailsActivity.this, 290));
				params.setMargins(DensityUtil.dip2px(SettingsOffersAndExtrarsPlansDetailsActivity.this, 8), 0,
						DensityUtil.dip2px(SettingsOffersAndExtrarsPlansDetailsActivity.this, 8), 0);
				inclusive.setLayoutParams(params);
				// inclusive
				// .setBackgroundResource(R.drawable.settings_person_service_expanded);
				inclusive.getChildAt(1).setVisibility(View.VISIBLE);
				inclusive.getChildAt(2).setVisibility(View.VISIBLE);
				inclusive.getChildAt(3).setVisibility(View.VISIBLE);
				((ImageView) ll3.getChildAt(0)).setImageResource(R.drawable.settings_go_up);
			}
			break;
		case R.id.intrduce1:
			tag4++;
			if (tag4 % 2 == 0) {
				intrduce1.setBackgroundResource(R.drawable.white_black);

				((TextView) intrduce1.getChildAt(1)).setText("Select Now TV");
				// intrduce2.setBackgroundResource(R.drawable.black_black);
				// ((TextView) intrduce2.getChildAt(1))
				// .setText("Netflix Selected");
				((TextView) intrduce1.getChildAt(1)).setTextColor(getResources().getColor(R.color.black));
				// ((TextView) intrduce2.getChildAt(1))
				// .setTextColor(getResources().getColor(R.color.white));
				((ImageView) intrduce1.getChildAt(0)).setVisibility(View.GONE);
				// ((ImageView) intrduce2.getChildAt(0))
				// .setVisibility(View.VISIBLE);
				tag5 = 1;
			} else {
				intrduce2.setBackgroundResource(R.drawable.white_black);
				((TextView) intrduce2.getChildAt(1)).setText("Select Netflix");
				intrduce1.setBackgroundResource(R.drawable.black_black);
				((TextView) intrduce1.getChildAt(1)).setText("Now TV Selected");
				((TextView) intrduce1.getChildAt(1)).setTextColor(getResources().getColor(R.color.white));
				((TextView) intrduce2.getChildAt(1)).setTextColor(getResources().getColor(R.color.black));
				((ImageView) intrduce2.getChildAt(0)).setVisibility(View.GONE);
				((ImageView) intrduce1.getChildAt(0)).setVisibility(View.VISIBLE);
				tag5 = 0;
			}
			break;
		case R.id.intrduce2:
			tag5++;
			if (tag5 % 2 == 0) {
				intrduce2.setBackgroundResource(R.drawable.white_black);
				((TextView) intrduce2.getChildAt(1)).setText("Select Netflix");
				// intrduce1.setBackgroundResource(R.drawable.black_black);
				// ((TextView)
				// intrduce1.getChildAt(1)).setText("Now TV Selected");
				// ((TextView) intrduce1.getChildAt(1))
				// .setTextColor(getResources().getColor(R.color.white));
				((TextView) intrduce2.getChildAt(1)).setTextColor(getResources().getColor(R.color.black));
				((ImageView) intrduce2.getChildAt(0)).setVisibility(View.GONE);
				// ((ImageView) intrduce1.getChildAt(0))
				// .setVisibility(View.VISIBLE);
				tag4 = 1;
			} else {
				intrduce1.setBackgroundResource(R.drawable.white_black);
				((TextView) intrduce1.getChildAt(1)).setText("Select Now TV");
				intrduce2.setBackgroundResource(R.drawable.black_black);
				((TextView) intrduce2.getChildAt(1)).setText("Netflix Selected");
				((TextView) intrduce1.getChildAt(1)).setTextColor(getResources().getColor(R.color.black));
				((TextView) intrduce2.getChildAt(1)).setTextColor(getResources().getColor(R.color.white));
				((ImageView) intrduce1.getChildAt(0)).setVisibility(View.GONE);
				((ImageView) intrduce2.getChildAt(0)).setVisibility(View.VISIBLE);
				tag4 = 0;
			}
			break;

		case R.id.buy:
			Request();
			break;

		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case 1001:
			if (resultCode == -1) {
				buy.setVisibility(View.GONE);
				tv_success.setVisibility(View.VISIBLE);
				PreferenceUtils.setBoolean(SettingsOffersAndExtrarsPlansDetailsActivity.this, "haveDiy", true);
				new Thread(new Runnable() {
					public void run() {
						Message msg = new Message();
						msg.what = WHAT_TAG;
						handler1.sendMessageDelayed(msg, 2000);
					}
				}).start();
			}

			break;

		default:
			break;
		}
	}

	private Handler handler1 = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case WHAT_TAG:
				buy.setVisibility(View.VISIBLE);
				tv_success.setVisibility(View.GONE);
				buy.setEnabled(false);
				buy.setBackgroundResource(R.drawable.settings_resetpin_back2);
				break;
			}
		};
	};

	private void Request() {
		if (wait == null)
			wait = new WaitDialog(SettingsOffersAndExtrarsPlansDetailsActivity.this);
		wait.show();
		IRequest.get(0, URLs.BALANCEINFO, RequestJSon.ReferInfo(), this);
	}

	@Override
	public void requestSuccess(Object tag, String json) {
		wait.cancel();
		if (JsonUtils.getHeadCode(json).equals("0")) {
			QuickCheckInfo quickcheckinfo = JsonUtils.getBodyObject(json, QuickCheckInfo.class);
			if (quickcheckinfo == null) {
				mydialog(1);
			} else {
				UserInfo.setBalanceWithSign(UnitUtil.getBalance(quickcheckinfo.getBalanceInfoList()));

				float balance = Float.valueOf(UserInfo.getBalance().replace(",", ""));
				double money = 0;
				int unit = Integer.valueOf(plansDetail.getFee().getCurrencyUnit());
				money = money + plansDetail.getFee().getCurrencyValue() * Math.pow(10, -unit);
				if (balance < money) {
					mydialog(2);
					return;
				}
				Intent intent = new Intent(SettingsOffersAndExtrarsPlansDetailsActivity.this, BuyActivity.class);
				Bundle extras = new Bundle();
				extras.putSerializable("plans_details", plansDetail);
				intent.putExtras(extras);
				startActivityForResult(intent, 1001);
				activityAnimationUp();
			}
		} else {
			mydialog(1);
		}

	}

	@Override
	public void requestError(Object tag, VolleyError e) {
		wait.cancel();
		mydialog(1);
	}

	private void mydialog(int num) {
		ErrorDialog dialog = new ErrorDialog(SettingsOffersAndExtrarsPlansDetailsActivity.this);
		dialog.show();
		dialog.setTag(num);
		switch (num) {
		case 1:

			break;
		case 2:
			dialog.setMessage("Dear customer your balance is low.If you want to buy the DIY plan.Please Top-UP.",
					"We've noticed...", "Top-up", "No,thanks");
			break;
		default:
			break;
		}
		dialog.setClick(new Click() {

			@Override
			public void onClicked(Object num, int num1, String num2, boolean num3) {
				switch ((Integer) num) {
				case 1:
					if (num3) {
						Request();
					}
					break;
				case 2:
					if (num3) {
						Intent intent3 = new Intent(SettingsOffersAndExtrarsPlansDetailsActivity.this,
								RechargeActivity.class);
						startActivityForResult(intent3, TAGUtil.tag7);
						activityAnimationUp();
					}
					break;
				default:
					break;
				}
			}
		});
	}

}
