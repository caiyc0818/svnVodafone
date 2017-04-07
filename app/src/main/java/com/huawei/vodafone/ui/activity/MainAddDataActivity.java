package com.huawei.vodafone.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.QuickCheckInfo;
import com.huawei.vodafone.bean.UserInfo;
import com.huawei.vodafone.listener.Listener.Click;
import com.huawei.vodafone.net.IRequest;
import com.huawei.vodafone.net.RequestJSon;
import com.huawei.vodafone.net.RequestListener;
import com.huawei.vodafone.net.URLs;
import com.huawei.vodafone.ui.myview.dialog.ErrorDialog;
import com.huawei.vodafone.ui.myview.dialog.SuccessDialog;
import com.huawei.vodafone.ui.myview.dialog.WaitDialog;
import com.huawei.vodafone.util.JsonUtils;
import com.huawei.vodafone.util.PreferenceUtils;
import com.huawei.vodafone.util.TAGUtil;
import com.huawei.vodafone.util.UnitUtil;

/**
 * @author weich 增加流量和语音
 */
public class MainAddDataActivity extends BaseActivity implements
		RequestListener {
	private LinearLayout one_gb;
	private LinearLayout two_gb;
	private LinearLayout five_gb;
	private LinearLayout starbucks_layout;
	private ImageView data_tab;
	private Button bug_data;
	private Button no_thanks;
	private Button browse_all_extras;
	private Animation alpha;
	private int data = 2;
	private Animation alout;
	private boolean onlyone = false;
	private int type;
	private TextView data_name1, data_name2, data_name3;
	private TextView data_money1, data_money2, data_money3;
	private TextView main_add_data_title;
	private TextView data_add_on;
	private WaitDialog wait;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_add_data);
		initSecondTitle(getString(R.string.Data_add_on), false, true);
		initView();
	}

	private void initView() {
		one_gb = (LinearLayout) findViewById(R.id.one_gb);
		two_gb = (LinearLayout) findViewById(R.id.two_gb);
		five_gb = (LinearLayout) findViewById(R.id.five_gb);
		starbucks_layout = (LinearLayout) findViewById(R.id.starbucks_layout);
		data_tab = (ImageView) findViewById(R.id.data_tab);
		bug_data = (Button) findViewById(R.id.bug_data);
		no_thanks = (Button) findViewById(R.id.no_thanks);
		browse_all_extras = (Button) findViewById(R.id.browse_all_extras);
		data_name1 = (TextView) findViewById(R.id.data_name1);
		data_money1 = (TextView) findViewById(R.id.data_money1);
		data_name2 = (TextView) findViewById(R.id.data_name2);
		data_money2 = (TextView) findViewById(R.id.data_money2);
		data_name3 = (TextView) findViewById(R.id.data_name3);
		data_money3 = (TextView) findViewById(R.id.data_money3);
		main_add_data_title = (TextView) findViewById(R.id.main_add_data_title);
		data_add_on = (TextView) findViewById(R.id.title);

		one_gb.setOnClickListener(this);
		two_gb.setOnClickListener(this);
		five_gb.setOnClickListener(this);
		bug_data.setOnClickListener(this);
		no_thanks.setOnClickListener(this);
		browse_all_extras.setOnClickListener(this);
		alpha = AnimationUtils.loadAnimation(getBaseContext(), R.anim.alpha);
		alout = AnimationUtils.loadAnimation(getBaseContext(), R.anim.alout);
		type = getIntent().getIntExtra("type", 0);
		final int add = getIntent().getIntExtra("add", 0);
		if (type == 0) {
			if (add == 1) {
				onlyone = true;
				setchooseinit(1);
			} else if (add == 2) {
				onlyone = true;
				setchooseinit(2);
			} else if (add == 3) {
				onlyone = true;
				setchooseinit(3);
			}
		} else if (type == 1) {
			onlyone = true;
			one_gb.setVisibility(View.GONE);
			two_gb.setBackgroundResource(R.drawable.red_cirle);
			five_gb.setVisibility(View.GONE);
			bug_data.setText("Buy a 500Min calls add-on");
			data = 2;
			data_name2.setText("500Min");
			data_money2.setText("€10");
			main_add_data_title
					.setText("Based on your current spend we think a 500Min calls add-on should keep you going until your allowance renews next month.");
			data_add_on.setText("Calls add-on");
		} else if (type == 2) {
			onlyone = true;
			one_gb.setVisibility(View.GONE);
			two_gb.setBackgroundResource(R.drawable.red_cirle);
			five_gb.setVisibility(View.GONE);
			bug_data.setText("Buy a 5GB add-on for Facebook");
			data = 2;
			data_name2.setText("5GB");
			data_money2.setText("€40");
			main_add_data_title
					.setText("Based on your current Facebook usage, we recommend you buy a 5GB Facebook add-on.");
			data_add_on.setText("Facebook add-on");
		} else if (type == 3) {
			onlyone = true;
			one_gb.setVisibility(View.GONE);
			two_gb.setBackgroundResource(R.drawable.red_cirle);
			five_gb.setVisibility(View.GONE);
			bug_data.setText("Buy a 2GB add-on for Netflix");
			data = 3;
			data_name2.setText("2GB");
			data_money2.setText("€5");
			main_add_data_title
					.setText("Based on your current Netflix usage, we recommend you buy a 2GB Netflix add-on.");
			data_add_on.setText("Netflix add-on");
		} else if (type == 4) {
			onlyone = true;
			one_gb.setVisibility(View.GONE);
			two_gb.setBackgroundResource(R.drawable.red_cirle);
			five_gb.setVisibility(View.GONE);
			bug_data.setText("Buy a 1GB International Roaming Data");
			data = 3;
			data_name2.setText("1GB");
			data_money2.setText("€10");
			main_add_data_title
					.setText("Based on your current spend we think a 1GB International Roaming Data should keep you going until your allowance renews next month.");
			data_add_on.setText("International Roaming Data");
		} else if (type == 5) {
			onlyone = true;
			one_gb.setVisibility(View.GONE);
			two_gb.setBackgroundResource(R.drawable.starbucks);
			five_gb.setVisibility(View.GONE);
			starbucks_layout.setVisibility(View.VISIBLE);
			data_tab.setVisibility(View.GONE);
			bug_data.setText("Yes");
			data = 3;
			data_name2.setText("");
			data_money2.setText("");
			main_add_data_title
					.setText("Congratulations! Now you can enjoy €2 Starbucks coupon, come and enjoy the best coffee and espresso drinks!");
			data_add_on.setText("Starbucks Coupon");
		}
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.one_gb:
			if (!onlyone)
				setchoose(1);
			break;
		case R.id.two_gb:
			if (!onlyone)
				setchoose(2);
			break;
		case R.id.five_gb:
			if (!onlyone)
				setchoose(3);
			break;
		case R.id.bug_data:
			Request(0);
			break;
		case R.id.no_thanks:
			Intent intent1 = new Intent();
			setResult(TAGUtil.tag4, intent1);
			finish();
			activityAnimationDown();
			break;
		case R.id.browse_all_extras:

			break;

		default:
			break;
		}
	}

	private void setchoose(int num) {
		one_gb.setBackgroundResource(R.drawable.gray_cirle);
		two_gb.setBackgroundResource(R.drawable.gray_cirle);
		five_gb.setBackgroundResource(R.drawable.gray_cirle);
		choose(num);
	}

	private void setchooseinit(int num) {
		switch (num) {
		case 1:
			two_gb.setVisibility(View.GONE);
			five_gb.setVisibility(View.GONE);
			data_tab.setVisibility(View.GONE);
			break;
		case 2:
			one_gb.setVisibility(View.GONE);
			five_gb.setVisibility(View.GONE);
			break;
		case 3:
			one_gb.setVisibility(View.GONE);
			two_gb.setVisibility(View.GONE);
			data_tab.setVisibility(View.GONE);
			break;
		default:
			break;
		}
		choose(num);
	}

	private void choose(int num) {
		switch (num) {
		case 1:
			one_gb.setBackgroundResource(R.drawable.red_cirle);
			bug_data.setText("Buy a 500MB data add-on");
			data = 1;
			data_name1.setTextColor(getResources().getColor(R.color.white));
			data_money1.setTextColor(getResources().getColor(R.color.white));
			data_name2.setTextColor(getResources().getColor(R.color.black));
			data_money2.setTextColor(getResources().getColor(R.color.black));
			data_name3.setTextColor(getResources().getColor(R.color.black));
			data_money3.setTextColor(getResources().getColor(R.color.black));
			break;
		case 2:
			two_gb.setBackgroundResource(R.drawable.red_cirle);
			bug_data.setText("Buy a 1GB data add-on");
			data = 2;
			data_name1.setTextColor(getResources().getColor(R.color.black));
			data_money1.setTextColor(getResources().getColor(R.color.black));
			data_name2.setTextColor(getResources().getColor(R.color.white));
			data_money2.setTextColor(getResources().getColor(R.color.white));
			data_name3.setTextColor(getResources().getColor(R.color.black));
			data_money3.setTextColor(getResources().getColor(R.color.black));
			break;
		case 3:
			five_gb.setBackgroundResource(R.drawable.red_cirle);
			bug_data.setText("Buy a 2GB data add-on");
			data = 5;
			data_name1.setTextColor(getResources().getColor(R.color.black));
			data_money1.setTextColor(getResources().getColor(R.color.black));
			data_name2.setTextColor(getResources().getColor(R.color.black));
			data_money2.setTextColor(getResources().getColor(R.color.black));
			data_name3.setTextColor(getResources().getColor(R.color.white));
			data_money3.setTextColor(getResources().getColor(R.color.white));
			break;
		default:
			break;
		}
	}

	private void Request(int num) {
		if (num == 0) {
			if (wait == null)
				wait = new WaitDialog(MainAddDataActivity.this);
			wait.show();
			IRequest.get(num, URLs.BALANCEINFO, RequestJSon.ReferInfo(), this);
		} else {
			if (type == 0) {
				if (data == 1) {
					IRequest.post(num, URLs.ADDOPTIONAL, RequestJSon
							.Optionaloffering("12012", "", "", false), this);
				} else if (data == 2) {
					IRequest.post(num, URLs.ADDOPTIONAL, RequestJSon
							.Optionaloffering("12013", "", "", false), this);
				} else {
					IRequest.post(num, URLs.ADDOPTIONAL, RequestJSon
							.Optionaloffering("12014", "", "", false), this);
				}

			} else if (type == 1) {
				IRequest.post(num, URLs.ADDOPTIONAL,
						RequestJSon.Optionaloffering("120010", "", "", false),
						this);
			} else if (type == 2) {
				IRequest.post(num, URLs.ADDOPTIONAL,
						RequestJSon.Optionaloffering("120006", "", "", false),
						this);
			} else if (type == 3) {
				IRequest.post(num, URLs.ADDOPTIONAL,
						RequestJSon.Optionaloffering("12016", "", "", false),
						this);
			} else if (type == 4) {
				IRequest.post(num, URLs.ADDOPTIONAL,
						RequestJSon.Optionaloffering("12010", "", "", false),
						this);
			} else if (type == 5) {
				IRequest.post(num, URLs.ADDOPTIONAL,
						RequestJSon.Optionaloffering("12011", "", "", false),
						this);
			}
		}
	}

	@Override
	public void requestSuccess(Object tag, String json) {
		if (tag.equals(0)) {
			if (JsonUtils.getHeadCode(json).equals("0")) {
				QuickCheckInfo quickcheckinfo = JsonUtils.getBodyObject(json,
						QuickCheckInfo.class);
				if (quickcheckinfo == null) {
					myrequest("-1", "");
				} else {
					UserInfo.setBalanceWithSign(UnitUtil
							.getBalance(quickcheckinfo.getBalanceInfoList()));

					float balance = Float.valueOf(UserInfo.getBalance()
							.replace(",", ""));
					int money = 0;
					if (type == 0) {
						if (data == 1) {
							money = 3;
						} else if (data == 2) {
							money = 5;
						} else {
							money = 8;
						}

					} else if (type == 1) {
						money = 10;
					} else if (type == 2) {
						money = 40;
					} else if (type == 3) {
						money = 5;
					} else if (type == 4) {
						money = 10;
					} else if (type == 5) {
						money = 0;
					}
					if (balance < money) {
						wait.cancel();
						ErrorDialog dialog = new ErrorDialog(
								MainAddDataActivity.this);
						dialog.setMessage(
								"Dear customer your balance is low.If you want to buy the add on.Please Top-UP.",
								"We've noticed...", "Top-up", "No,thanks");
						dialog.show();
						dialog.setClick(new Click() {
							@Override
							public void onClicked(Object num, int num1,
									String num2, boolean num3) {
								if (num3) {
									Intent resultIntent = new Intent(
											getBaseContext(),
											RechargeActivity.class);
									startActivityForResult(resultIntent,
											TAGUtil.tag7);
									activityAnimationOpen();
								}
							}
						});
						return;
					}
					Request(1);
				}
			} else {
				myrequest("-1", "");
			}
		} else {
			myrequest(JsonUtils.getHeadCode(json),
					JsonUtils.getHeadMessage(json));
		}

	}

	@Override
	public void requestError(Object tag, VolleyError e) {
		myrequest("-1", e.toString());
	}

	private void myrequest(String code, String message) {
		if (code.equals("0")) {
			PreferenceUtils.setBoolean(getBaseContext(), "BugDataOrUnit", true);
			Intent intent = new Intent();
			intent.putExtra("code", code);
			String text = "Successful", text2 = "Successful";
			if (type == 0) {
				if (data == 1) {
					text = "You've successfully bought 500MB Data.";
					text2 = "You've now got an extra <b>500M</b> of data to keep you going.";
				} else if (data == 2) {
					text = "You've successfully bought 1GB Data.";
					text2 = "You've now got an extra <b>1G</b> of data to keep you going.";
				} else {
					text = "You've successfully bought 2GB Data.";
					text2 = "You've now got an extra <b>2G</b> of data to keep you going.";
				}
			} else if (type == 1) {
				text = "You've successfully bought 500Min Calls.";
				text2 = "You've now got an extra <b>500Min</b> of calls to keep you going.";
			} else if (type == 2) {
				text = "You've successfully bought 5GB data for Facebook.";
				text2 = "You've now got an extra <b>5GB</b> of data to keep you going.";
			} else if (type == 3) {
				text = "You've successfully bought 2GB data for Netflix.";
				text2 = "You've now got an extra <b>2GB</b> for Netflix to keep you going.";
			} else if (type == 4) {
				text = "You've successfully bought 1GB International Roaming Data";
				text2 = "You've now got an extra <b>1GB</b> of International Roaming Data to keep you going.";
			} else if (type == 5) {
				text = "You've successfully get €2 for Starbucks coupon";
				text2 = "You've now got an extra <b>€2</b> for Starbucks coupon";
			}
			intent.putExtra("message", text);
			intent.putExtra("messageTwo", text2);
			intent.putExtra("type", type);
			intent.putExtra("data", data);
			setResult(TAGUtil.tag3, intent);
			finish();
			activityAnimationDown();
		} else {
			ErrorDialog dialog = new ErrorDialog(MainAddDataActivity.this);
			dialog.show();
			dialog.setClick(new Click() {

				@Override
				public void onClicked(Object num, int num1, String num2,
						boolean num3) {
					Request(0);
				}
			});
		}
		wait.cancel();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == TAGUtil.tag8) {
			SuccessDialog dialog = new SuccessDialog(this);
			dialog.settext("Your payment was successful");
			dialog.show();
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
}
