package com.huawei.vodafone.ui.activity;

import io.card.payment.CardIOActivity;
import io.card.payment.CreditCard;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.UserInfo;
import com.huawei.vodafone.listener.Listener.Click;
import com.huawei.vodafone.net.IRequest;
import com.huawei.vodafone.net.RequestJSon;
import com.huawei.vodafone.net.RequestListener;
import com.huawei.vodafone.net.URLs;
import com.huawei.vodafone.ui.adapter.RechargeAdapter;
import com.huawei.vodafone.ui.myview.datepicker.DatePickerTwoDialog;
import com.huawei.vodafone.ui.myview.dialog.ErrorDialog;
import com.huawei.vodafone.ui.myview.dialog.RechargeConfirmDialog;
import com.huawei.vodafone.ui.myview.dialog.RechargeConfirmDialog.OnClickListener;
import com.huawei.vodafone.ui.myview.dialog.RechargeDialog;
import com.huawei.vodafone.util.PreferenceUtils;
import com.huawei.vodafone.util.StringUtils;
import com.huawei.vodafone.util.SystemUtils;
import com.huawei.vodafone.util.TAGUtil;
import com.huawei.vodafone.util.ToastUtil;

/**
 * @author weich
 * @date 充值
 */
public class RechargeActivity extends BaseActivity implements OnClickListener {

	private PopupWindow mPop;
	private ListView listView;
	private ArrayList<ArrayList<String>> text;
	private TextView mobliepop;
	private TextView paymentPop;
	private LinearLayout warning;
	private TextView someone;
	private RelativeLayout mobile_rl;
	private TextView mobile_rl_update;
	private EditText mobile_number;
	private ImageView delete_mobile;
	private TextView data_five;
	private TextView data_ten;
	private TextView data_twenty;
	private TextView data_other;
	private LinearLayout data_select;
	private RelativeLayout amount_lv;
	private ImageView delete_amount;
	private EditText amount_data;
	private TextView amount_update;
	private LinearLayout paypal;
	private LinearLayout visa_debit;
	private TextView proceed;
	private TextView scan;
	private EditText visa_debit_number;
	private TextView time_date;
	private int select = -1;

	String selectedNums;
	String nums[] = new String[UserInfo.getListsize()];
	private RechargeDialog dialog;
	private float money;

	private String payType[] = { "Visa debit", "Paypal" };
	private EditText name;
	private EditText code;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recharge_activity);
		initSecondTitle(getString(R.string.top_up), false, true);
		initView();
	}

	private void initView() {
		mobliepop = (TextView) findViewById(R.id.moblie_pop);
		paymentPop = (TextView) findViewById(R.id.payment_pop);
		warning = (LinearLayout) findViewById(R.id.warning);
		someone = (TextView) findViewById(R.id.someone_else);
		mobile_rl = (RelativeLayout) findViewById(R.id.mobile_rl);
		mobile_rl_update = (TextView) findViewById(R.id.mobile_rl_update);
		mobile_number = (EditText) findViewById(R.id.mobile_number);
		delete_mobile = (ImageView) findViewById(R.id.delete_mobile);
		data_five = (TextView) findViewById(R.id.data_five);
		data_ten = (TextView) findViewById(R.id.data_ten);
		data_twenty = (TextView) findViewById(R.id.data_twenty);
		data_other = (TextView) findViewById(R.id.data_other);
		data_select = (LinearLayout) findViewById(R.id.data_select);
		amount_lv = (RelativeLayout) findViewById(R.id.amount_lv);
		delete_amount = (ImageView) findViewById(R.id.delete_amount);
		amount_data = (EditText) findViewById(R.id.amount_data);
		amount_update = (TextView) findViewById(R.id.amount_update);
		paypal = (LinearLayout) findViewById(R.id.paypal);
		visa_debit = (LinearLayout) findViewById(R.id.visa_debit);
		proceed = (TextView) findViewById(R.id.proceed);
		scan = (TextView) findViewById(R.id.scan);
		visa_debit_number = (EditText) findViewById(R.id.visa_debit_number);
		name = (EditText) findViewById(R.id.name);
		time_date = (TextView) findViewById(R.id.time_date);
		code = (EditText) findViewById(R.id.code);

		mobliepop.setOnClickListener(this);
		paymentPop.setOnClickListener(this);
		someone.setOnClickListener(this);
		mobile_rl_update.setOnClickListener(this);
		delete_mobile.setOnClickListener(this);
		data_five.setOnClickListener(this);
		data_ten.setOnClickListener(this);
		data_twenty.setOnClickListener(this);
		data_other.setOnClickListener(this);
		amount_update.setOnClickListener(this);
		delete_amount.setOnClickListener(this);
		proceed.setOnClickListener(this);
		time_date.setOnClickListener(this);
		scan.setOnClickListener(this);
		code.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				verifyProceedEnabled();
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});
		time_date.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				verifyProceedEnabled();
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});
		name.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				verifyProceedEnabled();
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});
		amount_data.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				verifyProceedEnabled();
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});
		visa_debit_number.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				verifyProceedEnabled();
				if (count == 1 || count == -1) {
					int mlength = s.toString().length();
					if ((mlength - 4) % 5 == 0) {
						visa_debit_number.setText(s + " ");
						visa_debit_number.setSelection(visa_debit_number
								.getText().toString().length());
					}
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				if (StringUtils.isEmpty(toString())) {
					scan.setText(Html.fromHtml("<u>Scan your card</u>"));
				} else {
					scan.setText(Html.fromHtml("<u>Scan another card</u>"));
				}
			}
		});
		fake();
		if (getIntent().getIntExtra("number", 0) == 20) {
			dataselect(3);
		}
		mobile_number.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				mobliepop.setBackgroundResource(R.drawable.my_border_white);
				warning.setVisibility(View.GONE);
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});
		proceed.setBackgroundColor(Color.parseColor("#999999"));
		proceed.setEnabled(false);
	}

	private void fake() {
		ArrayList<String> phone = new ArrayList<String>();
		for (int i = 0; i < UserInfo.getListsize(); i++) {
			nums[i] = UserInfo.getUserMobile(i);
			phone.add(UserInfo.getUserName(i) + "'s phone(" + nums[i] + ")");
		}
		text = new ArrayList<ArrayList<String>>();
		text.add(phone);
		ArrayList<String> payment = new ArrayList<String>();
		payment.add(payType[0]);
		payment.add(payType[1]);
		text.add(payment);

		selectedNums = nums[UserInfo.getSelect()];
		mobliepop.setText(UserInfo.getUserName() + "'s phone("
				+ nums[UserInfo.getSelect()] + ")");
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.moblie_pop:
			showPopWindow(mobliepop, 0);
			break;
		case R.id.payment_pop:
			showPopWindow(paymentPop, 1);
			break;
		case R.id.someone_else:
			mobliepop.setVisibility(View.GONE);
			someone.setVisibility(View.GONE);
			mobile_rl.setVisibility(View.VISIBLE);
			mobile_rl_update.setVisibility(View.VISIBLE);
			if (warning.isShown()) {
				warning.setVisibility(View.GONE);
			}
			break;
		case R.id.mobile_rl_update:
			if (StringUtils.isEmail(mobile_number.getText().toString())
					|| !StringUtils.isMobileNumber(mobile_number.getText()
							.toString())) {
				// Toast.makeText(getBaseContext(), "phone number is invaid",
				// Toast.LENGTH_SHORT).show();
				mobliepop.setBackgroundResource(R.drawable.my_border_yellow);
				warning.setVisibility(View.VISIBLE);
				return;
			}
			mobliepop.setBackgroundResource(R.drawable.my_border_white);
			warning.setVisibility(View.GONE);
			someone.setVisibility(View.GONE);
			mobile_rl_update.setVisibility(View.GONE);
			mobile_number.setEnabled(false);
			break;
		case R.id.delete_mobile:
			mobile_number.setEnabled(true);
			mobile_rl_update.setVisibility(View.VISIBLE);
			mobile_number.setText("");
			break;
		case R.id.amount_update:
			if (StringUtils.isEmail(amount_data.getText().toString())
					|| !StringUtils.isNumber(amount_data.getText().toString())) {
				Toast.makeText(getBaseContext(), "amount is invaid",
						Toast.LENGTH_SHORT).show();
				return;
			}
			amount_update.setVisibility(View.GONE);
			amount_data.setEnabled(false);
			break;
		case R.id.delete_amount:
			amount_data.setEnabled(true);
			amount_update.setVisibility(View.VISIBLE);
			amount_data.setText("");
			break;
		case R.id.data_five:
			dataselect(1);
			break;
		case R.id.data_ten:
			dataselect(2);
			break;
		case R.id.data_twenty:
			dataselect(3);
			break;
		case R.id.data_other:
			dataselect(4);
			break;
		case R.id.proceed:
			if (select == -1
					|| (select == 4 && StringUtils.isEmpty(amount_data
							.getText().toString()))) {
				Toast.makeText(getBaseContext(), "Please fill in the amount",
						Toast.LENGTH_SHORT).show();
				return;
			}
			RechargeConfirmDialog rechargeConfirmDialog = new RechargeConfirmDialog(
					this);
			rechargeConfirmDialog.setOnClickListener(this);
			rechargeConfirmDialog.show();
			break;
		case R.id.time_date:
			DatePickerTwoDialog.showStartTime(RechargeActivity.this, time_date,
					null, time_date.getWidth());

			break;
		case R.id.scan:
			if (!CardIOActivity.canReadCardWithCamera()) {
				ErrorDialog dialog = new ErrorDialog(RechargeActivity.this);
				dialog.show();
				dialog.setMessage(
						"We have not permission to open the camera, please go to mobile phone permissions page to set.",
						"We've noticed...", "Yes,please", "No,thanks");
				dialog.setClick(new Click() {
					@Override
					public void onClicked(Object num, int num1, String num2,
							boolean num3) {
						if (num3) {
							if (!SystemUtils.permission(RechargeActivity.this)) {
								Toast.makeText(
										getBaseContext(),
										"Fail to open, please yourself to open",
										Toast.LENGTH_SHORT).show();
							}
						}
					}
				});
				return;
			}
			Intent scanIntent = new Intent(this, CardIOActivity.class);
			scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, true);
			scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_CVV, false);
			scanIntent
					.putExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, false);
			scanIntent.putExtra(CardIOActivity.EXTRA_SUPPRESS_MANUAL_ENTRY,
					true);
			scanIntent.putExtra(CardIOActivity.EXTRA_KEEP_APPLICATION_THEME,
					false);
			scanIntent.putExtra(CardIOActivity.EXTRA_RETURN_CARD_IMAGE, true);
			scanIntent.putExtra(CardIOActivity.EXTRA_LANGUAGE_OR_LOCALE,
					"en_AU");
			scanIntent.putExtra(CardIOActivity.EXTRA_SUPPRESS_CONFIRMATION,
					true);
			scanIntent.putExtra(CardIOActivity.EXTRA_HIDE_CARDIO_LOGO, true);
			scanIntent.putExtra(CardIOActivity.EXTRA_SCAN_OVERLAY_LAYOUT_ID,
					R.layout.recharge_activity_top);// 覆盖物
			startActivityForResult(scanIntent, TAGUtil.tag13);
			break;
		default:
			break;
		}
	}

	private void dataselect(int num) {
		select = num;
		data_five.setBackgroundResource(R.drawable.gray_cirle);
		data_ten.setBackgroundResource(R.drawable.gray_cirle);
		data_twenty.setBackgroundResource(R.drawable.gray_cirle);
		data_other.setBackgroundResource(R.drawable.gray_cirle);
		data_five.setTextColor(getResources().getColor(
				R.color.support_gray_more));
		data_ten.setTextColor(getResources()
				.getColor(R.color.support_gray_more));
		data_twenty.setTextColor(getResources().getColor(
				R.color.support_gray_more));
		data_other.setTextColor(getResources().getColor(
				R.color.support_gray_more));
		switch (num) {
		case 1:
			data_five.setBackgroundResource(R.drawable.red_cirle);
			data_five.setTextColor(getResources().getColor(R.color.white));
			break;
		case 2:
			data_ten.setBackgroundResource(R.drawable.red_cirle);
			data_ten.setTextColor(getResources().getColor(R.color.white));
			break;
		case 3:
			data_twenty.setBackgroundResource(R.drawable.red_cirle);
			data_twenty.setTextColor(getResources().getColor(R.color.white));
			break;
		case 4:
			data_select.setVisibility(View.GONE);
			amount_lv.setVisibility(View.VISIBLE);
			amount_update.setVisibility(View.VISIBLE);
			break;
		default:
			break;
		}
		verifyProceedEnabled();
	}

	// PopupWindow类型窗口
	public void showPopWindow(View view, int num) {
		LayoutInflater mLayoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		ViewGroup typeListView = (ViewGroup) mLayoutInflater.inflate(
				R.layout.recharge_popwindow, null, true);
		mPop = new PopupWindow(typeListView, view.getWidth(),
				LayoutParams.WRAP_CONTENT, true);
		listView = (ListView) typeListView.findViewById(R.id.type_lst);

		listView.setAdapter(new RechargeAdapter(RechargeActivity.this, text
				.get(num)));
		getClick(view, num);

	}

	/**
	 * 
	 * 展示
	 */
	public void getClick(View view, final int num) {
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (mPop != null) {
					mPop.dismiss();
					if (num == 0) {
						mobliepop.setText(text.get(num).get(position));
						// ArrayList<String> phone = new ArrayList<String>();
						// if (text.get(num).get(position).contains(nums[1])) {
						// selectedNums = nums[1];
						// phone.add(UserInfo.getUserName(0) + "'s phone("
						// + nums[0] + ")");
						// } else {
						// selectedNums = nums[0];
						// phone.add(UserInfo.getUserName(1) + "'s phone("
						// + nums[1] + ")");
						// }
						// text.remove(0);
						// text.add(0, phone);
						selectedNums = nums[position];
						((BaseAdapter) parent.getAdapter())
								.notifyDataSetChanged();
						// if (position == 1) {
						// mobliepop
						// .setBackgroundResource(R.drawable.my_border_yellow);
						// warning.setVisibility(View.VISIBLE);
						// } else {
						mobliepop
								.setBackgroundResource(R.drawable.my_border_white);
						warning.setVisibility(View.GONE);
						// }
					} else if (num == 1) {
						paymentPop.setText(text.get(num).get(position));
						// if (position == 0) {
						// paypal.setVisibility(View.GONE);
						// visa_debit.setVisibility(View.VISIBLE);
						// scan.setVisibility(View.VISIBLE);
						// } else {
						// paypal.setVisibility(View.VISIBLE);
						// visa_debit.setVisibility(View.GONE);
						// scan.setVisibility(View.GONE);
						// }
						ArrayList<String> payment = new ArrayList<String>();
						if (text.get(num).get(position).equals(payType[1])) {
							payment.add(payType[0]);
							paypal.setVisibility(View.VISIBLE);
							visa_debit.setVisibility(View.GONE);
							scan.setVisibility(View.GONE);
						} else {
							paypal.setVisibility(View.GONE);
							visa_debit.setVisibility(View.VISIBLE);
							scan.setVisibility(View.VISIBLE);
							payment.add(payType[1]);

						}
						text.remove(1);
						text.add(payment);
						((BaseAdapter) parent.getAdapter())
								.notifyDataSetChanged();
						verifyProceedEnabled();
					}
					mPop = null;
				}
			}
		});
		mPop.setOnDismissListener(new OnDismissListener() {

			@Override
			public void onDismiss() {
			}
		});
		mPop.setOutsideTouchable(true);
		mPop.setFocusable(true);
		mPop.setBackgroundDrawable(new ColorDrawable(
				android.graphics.Color.TRANSPARENT));
		mPop.showAsDropDown(view, 0, -4);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (data != null && data.hasExtra(CardIOActivity.EXTRA_SCAN_RESULT)) {
			CreditCard scanResult = data
					.getParcelableExtra(CardIOActivity.EXTRA_SCAN_RESULT);
			visa_debit_number.setText(scanResult.getFormattedCardNumber());
		}

	}

	@Override
	public void onclickYes() {
		// TODO Auto-generated method stub
		money = 0;
		if (select == 1) {
			money = 5;
		} else if (select == 2) {
			money = 10;
		} else if (select == 3) {
			money = 20;
		} else if (select == 4) {
			money = Float.valueOf(amount_data.getText().toString());
		}
		dialog = new RechargeDialog(this);
		dialog.show();
		IRequest.post(URLs.RECHARGE, TAGUtil.RECHARGE,
				RequestJSon.recharge(selectedNums, (int) (money * 10000)),
				new RequestListener() {

					@Override
					public void requestSuccess(Object tag, String json) {
						// TODO Auto-generated method stub

						dialog.dismiss();
						int i = json.indexOf("</cbs:ResultCode>");
						if (i != -1) {
							char code = json.charAt(i - 1);
							if (code == '0') {
								int num = (int) money;
								if (money == num) {
									PreferenceUtils.setString(getBaseContext(),
											"Addbalance", String.valueOf(num));
								} else {
									PreferenceUtils.setString(getBaseContext(),
											"Addbalance", String.valueOf(money));
								}
								float mymoney = Float.valueOf(UserInfo
										.getBalance().replace(",", "")) + money;
								UserInfo.setBalance(StringUtils
										.formatDecimalFloat(mymoney, 2));

								Intent it = new Intent();
								setResult(TAGUtil.tag8, it);
								finish();
								activityAnimationDown();
								return;
							}
						}
						ToastUtil.showToast(getApplicationContext(),
								getString(R.string.recharge_failure));
					}

					@Override
					public void requestError(Object tag, VolleyError e) {
						// TODO Auto-generated method stub
						ToastUtil.showToast(getApplicationContext(),
								getString(R.string.recharge_failure));
						dialog.dismiss();
					}
				});

	}

	private void verifyProceedEnabled() {
		boolean condition1 = select == 1
				|| select == 2
				|| select == 3
				|| (select == 4 && !StringUtils.isEmpty(amount_data.getText()
						.toString()));
		String type = paymentPop.getText().toString();
		boolean condition2 = type.equals(payType[0])
				&& !StringUtils.isEmpty(visa_debit_number.getText().toString())
				&& !StringUtils.isEmpty(name.getText().toString())
				&& !StringUtils.isEmpty(time_date.getText().toString())
				&& !StringUtils.isEmpty(code.getText().toString());

		boolean condition3 = type.equals(payType[1]);
		if (condition1 && (condition2 || condition3)) {
			proceed.setBackgroundColor(Color.parseColor("#E60000"));
			proceed.setEnabled(true);
		} else {
			proceed.setBackgroundColor(Color.parseColor("#999999"));
			proceed.setEnabled(false);
		}

	}
}
