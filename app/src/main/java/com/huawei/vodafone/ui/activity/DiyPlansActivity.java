package com.huawei.vodafone.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import java.util.ArrayList;

import com.android.volley.VolleyError;
import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.FreeUnitItem;
import com.huawei.vodafone.bean.FreeUnitItemDetail;
import com.huawei.vodafone.bean.QuickCheckInfo;
import com.huawei.vodafone.bean.UserInfo;
import com.huawei.vodafone.listener.Listener.Click;
import com.huawei.vodafone.net.IRequest;
import com.huawei.vodafone.net.RequestJSon;
import com.huawei.vodafone.net.RequestListener;
import com.huawei.vodafone.net.URLs;
import com.huawei.vodafone.ui.myview.ProgressTextView;
import com.huawei.vodafone.ui.myview.dialog.ErrorDialog;
import com.huawei.vodafone.ui.myview.dialog.SuccessDialog;
import com.huawei.vodafone.ui.myview.dialog.WaitDialog;
import com.huawei.vodafone.util.DebugLog;
import com.huawei.vodafone.util.DiyUtilsFromId;
import com.huawei.vodafone.util.JsonUtils;
import com.huawei.vodafone.util.PreferenceUtils;
import com.huawei.vodafone.util.StringUtils;
import com.huawei.vodafone.util.TAGUtil;
import com.huawei.vodafone.util.UnitUtil;

public class DiyPlansActivity extends BaseActivity
		implements OnSeekBarChangeListener, OnClickListener, RequestListener {

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.settings_offers_and_extras_for_you_plans_diy);
		initSecondTitle(getString(R.string.settings_diy_plan));
		initViews();
	}

	private SeekBar costSb;
	private ProgressTextView costTv;
	private SeekBar dataSb;
	private ProgressTextView dataTv;
	private SeekBar callSb;
	private ProgressTextView callTv;
	private RelativeLayout buy;
	private static final float ratio = 1 / 4.0f;
	private static final int maxCost = 9;
	private static final int maxData = 7;
	private static final int maxCall = 9;
	private TextView data;
	private TextView call;
	private TextView text;
	private TextView text_buy;
	private TextView money;
	private TextView tv_success;
	private String Tag;
	private FrameLayout frameLayout;
	private static final int WHAT_TAG = 0;

	/**
	 * 初始化组件
	 */
	private void initViews() {
		costSb = (SeekBar) findViewById(R.id.cost_sb);
		frameLayout = (FrameLayout) findViewById(R.id.frameLayout1);
		costTv = (ProgressTextView) findViewById(R.id.cost_tv);
		dataSb = (SeekBar) findViewById(R.id.data_sb);
		dataTv = (ProgressTextView) findViewById(R.id.data_tv);
		callSb = (SeekBar) findViewById(R.id.call_sb);
		callTv = (ProgressTextView) findViewById(R.id.call_tv);
		buy = (RelativeLayout) findViewById(R.id.buy);
		buy.setOnClickListener(this);
		data = (TextView) findViewById(R.id.text1);
		call = (TextView) findViewById(R.id.text2);
		text = (TextView) findViewById(R.id.text3);
		text_buy = (TextView) findViewById(R.id.text);
		money = (TextView) findViewById(R.id.text4);
		tv_success = (TextView) findViewById(R.id.tv_success);
		costTv.setmMaxProgress(maxCost);
		dataTv.setmMaxProgress(maxData);
		callTv.setmMaxProgress(maxCall);
		costSb.setOnSeekBarChangeListener(this);
		dataSb.setOnSeekBarChangeListener(this);
		callSb.setOnSeekBarChangeListener(this);
		Thread costThread = new InitThread(1);
		Thread dataThread = new InitThread(2);
		Thread callThread = new InitThread(3);
		costThread.start();
		dataThread.start();
		callThread.start();
		// 判断 是否有diy
		isShoworHint(PreferenceUtils.getString(DiyPlansActivity.this, "C_DATA_LEVEL"),
				PreferenceUtils.getString(DiyPlansActivity.this, "C_UNIT_LEVEL"),
				PreferenceUtils.getString(DiyPlansActivity.this, "C_SMS_LEVEL"));

	}

	private void isShoworHint(String data, String calls, String cost) {
		data = StringUtils.isEmpty(data) ? "-1" : data;
		calls = StringUtils.isEmpty(calls) ? "-1" : calls;
		cost = StringUtils.isEmpty(cost) ? "-1" : cost;
		if (PreferenceUtils.getBoolean(DiyPlansActivity.this, "haveDiy")) {
			int costValue = costSb.getProgress();
			int dataValue = dataSb.getProgress();
			int callValue = callSb.getProgress();
			int callId = 0;
			if (callValue == 0) {
				callId = 100034;
			} else if (callValue == 2) {
				callId = 100035;
			} else if (callValue == 4) {
				callId = 100036;
			} else if (callValue == 9) {
				callId = 100037;
			}

			int dataId = 0;
			if (dataValue == 0) {
				dataId = 100038;
			} else if (dataValue == 1) {
				dataId = 100039;
			} else if (dataValue == 3) {
				dataId = 100040;
			} else if (dataValue == 7) {
				dataId = 100041;
			}
			int costId = 0;
			if (costValue == 0) {
				costId = 100042;
			} else if (costValue == 2) {
				costId = 100045;
			} else if (costValue == 5) {
				costId = 100043;
			} else if (costValue == 9) {
				costId = 100044;
			}
			if (Integer.parseInt(data) == dataId && Integer.parseInt(calls) == callId
					&& Integer.parseInt(cost) == costId) {
				text_buy.setText(getString(R.string.settings_change_diy_plan));
				buy.setEnabled(false);
				buy.setBackgroundResource(R.drawable.settings_resetpin_back2);
			} else {
				text_buy.setText(getString(R.string.settings_change_diy_plan));
				buy.setEnabled(true);
				buy.setBackgroundResource(R.drawable.settings_resetpin_back_red);
				Tag = "change";
			}
		} else {
			text_buy.setText(getString(R.string.settings_buy_diy_plan));
			buy.setEnabled(true);
			buy.setBackgroundResource(R.drawable.settings_resetpin_back_red);
			Tag = "buy";
		}
	}

	class InitThread extends Thread {
		private int type;
		private int i = 1;

		public InitThread(int type) {
			this.type = type;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			int max;
			if (type == 1)
				max = maxCost;
			else if (type == 2)
				max = maxData;
			else
				max = maxCall;
			while (i <= 1) {
				Bundle bundle = new Bundle();
				bundle.putInt("type", type);
				bundle.putInt("progress", i);
				Message msg = handler.obtainMessage();
				msg.setData(bundle);
				handler.sendMessage(msg);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				++i;
			}
		}
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			int i = msg.getData().getInt("progress");
			int type = msg.getData().getInt("type");
			switch (type) {
			case 1:
				costSb.setProgress(0);
				costTv.setProgress(0, (0 + 1) * 100 + "");
				text.setText((0 + 1) * 100 + "");
				break;
			case 2:
				dataSb.setProgress(0);
				dataTv.setProgress(0, (0 + 5) * 100 + "MB");
				data.setText((0 + 5) * 100 + "MB");
				break;
			case 3:
				callSb.setProgress(0);
				callTv.setProgress(0, (0 + 1) * 200 + "Min");
				call.setText((0 + 1) * 200 + "Min");
				break;
			default:
				break;
			}
		};
	};
	private WaitDialog wait;

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		// TODO Auto-generated method stub
		switch (seekBar.getId()) {
		case R.id.cost_sb:
			// 计算钱
			int dataValue = dataSb.getProgress();
			int callValue = callSb.getProgress();
			if (progress <= 0) {
				costTv.setProgress(progress, (progress + 1) * 100 + "");
				text.setText((progress + 1) * 100 + "");
				costSb.setProgress(progress);
				setMoney3(dataValue, callValue, 1);
			} else if (progress > 0 && progress <= 1) {
				progress = 1;
				costTv.setProgress(progress, "200");
				text.setText("200");
				costSb.setProgress(progress);
				setMoney3(dataValue, callValue, 2);
			} else if (progress > 1 && progress <= 4) {
				progress = 4;
				costTv.setProgress(progress, "500");
				text.setText("500");
				costSb.setProgress(progress);
				setMoney3(dataValue, callValue, 3);
			} else if (progress > 4 && progress <= 9) {
				progress = 9;
				costTv.setProgress(progress, "1000");
				text.setText("1000");
				costSb.setProgress(progress);
				setMoney3(dataValue, callValue, 4);
			}
			break;
		case R.id.data_sb:
			// 计算钱
			int callValue1 = callSb.getProgress();
			int costValue1 = costSb.getProgress();

			if (progress <= 0) {
				progress = 0;
				dataTv.setProgress(progress, (progress + 5) * 100 + "MB");
				data.setText((progress + 5) * 100 + "MB");
				dataSb.setProgress(progress);
				setMoney(callValue1, costValue1, 2);
			} else if (progress > 0 && progress <= 1) {
				progress = 1;
				dataTv.setProgress(progress, "1GB");
				data.setText("1GB");
				dataSb.setProgress(progress);
				setMoney(callValue1, costValue1, 3);
			} else if (progress > 1 && progress <= 3) {
				progress = 3;
				dataTv.setProgress(progress, ("2GB"));
				data.setText("2GB");
				dataSb.setProgress(progress);
				setMoney(callValue1, costValue1, 5);
			} else if (progress > 3 && progress <= 7) {
				progress = 7;
				dataTv.setProgress(progress, "4GB");
				data.setText("4GB");
				dataSb.setProgress(progress);
				setMoney(callValue1, costValue1, 7);
			}

			break;
		case R.id.call_sb:
			int dataValue2 = dataSb.getProgress();
			int costValue2 = costSb.getProgress();

			if (progress <= 0) {
				progress = 0;
				callTv.setProgress(progress, (progress + 1) * 200 + "Min");
				call.setText((progress + 1) * 100 + "Min");
				callSb.setProgress(progress);
				setMoney2(dataValue2, costValue2, 1);
			} else if (progress > 0 && progress <= 2) {
				progress = 2;
				callTv.setProgress(progress, "500Min");
				call.setText("500Min");
				callSb.setProgress(progress);
				setMoney2(dataValue2, costValue2, 2);
			} else if (progress > 2 && progress <= 4) {
				progress = 4;
				callTv.setProgress(progress, "1000Min");
				call.setText("1000Min");
				callSb.setProgress(progress);
				setMoney2(dataValue2, costValue2, 3);
			} else if (progress > 4 && progress <= 9) {
				progress = 9;
				callTv.setProgress(progress, "2000Min");
				call.setText("2000Min");
				callSb.setProgress(progress);
				setMoney2(dataValue2, costValue2, 4);
			}

			break;
		default:
			break;
		}
	}

	private void setMoney(int callValue, int costValue, int d) {
		int moneyValue = 0;
		if (callValue == 0) {
			moneyValue = d + 1;
		} else if (callValue == 2) {
			moneyValue = d + 2;
		} else if (callValue == 4) {
			moneyValue = d + 3;
		} else if (callValue == 9) {
			moneyValue = d + 4;
		}

		if (costValue == 0) {
			moneyValue = moneyValue + 1;
		} else if (costValue == 21) {
			moneyValue = moneyValue + 2;
		} else if (costValue == 4) {
			moneyValue = moneyValue + 3;
		} else if (costValue == 9) {
			moneyValue = moneyValue + 4;
		}

		money.setText("" + moneyValue);
		isShoworHint(PreferenceUtils.getString(DiyPlansActivity.this, "C_DATA_LEVEL"),
				PreferenceUtils.getString(DiyPlansActivity.this, "C_UNIT_LEVEL"),
				PreferenceUtils.getString(DiyPlansActivity.this, "C_SMS_LEVEL"));
	}

	private void setMoney2(int dataValue, int costValue, int d) {

		int moneyValue = 0;
		if (dataValue == 0) {
			moneyValue = d + 2;
		} else if (dataValue == 1) {
			moneyValue = d + 3;
		} else if (dataValue == 3) {
			moneyValue = d + 5;
		} else if (dataValue == 7) {
			moneyValue = d + 7;
		}

		if (costValue == 0) {
			moneyValue = moneyValue + 1;
		} else if (costValue == 1) {
			moneyValue = moneyValue + 2;
		} else if (costValue == 4) {
			moneyValue = moneyValue + 3;
		} else if (costValue == 9) {
			moneyValue = moneyValue + 4;
		}

		money.setText("" + moneyValue);
		isShoworHint(PreferenceUtils.getString(DiyPlansActivity.this, "C_DATA_LEVEL"),
				PreferenceUtils.getString(DiyPlansActivity.this, "C_UNIT_LEVEL"),
				PreferenceUtils.getString(DiyPlansActivity.this, "C_SMS_LEVEL"));
	}

	private void setMoney3(int dataValue, int callValue, int d) {

		int moneyValue = 0;
		if (dataValue == 0) {
			moneyValue = d + 2;
		} else if (dataValue == 1) {
			moneyValue = d + 3;
		} else if (dataValue == 3) {
			moneyValue = d + 5;
		} else if (dataValue == 7) {
			moneyValue = d + 7;
		}

		if (callValue == 0) {
			moneyValue = moneyValue + 1;
		} else if (callValue == 2) {
			moneyValue = moneyValue + 2;
		} else if (callValue == 4) {
			moneyValue = moneyValue + 3;
		} else if (callValue == 9) {
			moneyValue = moneyValue + 4;
		}

		money.setText("" + moneyValue);
		isShoworHint(PreferenceUtils.getString(DiyPlansActivity.this, "C_DATA_LEVEL"),
				PreferenceUtils.getString(DiyPlansActivity.this, "C_UNIT_LEVEL"),
				PreferenceUtils.getString(DiyPlansActivity.this, "C_SMS_LEVEL"));
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.close_iv:
			break;
		case R.id.buy:
			if (wait == null)
				wait = new WaitDialog(DiyPlansActivity.this);
			wait.show();
			Request(2);
			break;
		default:
			break;
		}
	}

	private void jump() {
		String moneyValue = (String) money.getText();
		if (Float.parseFloat(UserInfo.getBalance().replace(",", "")) >= Float.parseFloat(moneyValue)) {
			Intent intent = new Intent(DiyPlansActivity.this, BuyDiyPlanActivity.class);
			int costValue = costSb.getProgress();
			int dataValue = dataSb.getProgress();
			int callValue = callSb.getProgress();
			int callId = 0;
			if (callValue == 0) {
				callId = 100034;
			} else if (callValue == 2) {
				callId = 100035;
			} else if (callValue == 4) {
				callId = 100036;
			} else if (callValue == 9) {
				callId = 100037;
			}

			int dataId = 0;
			if (dataValue == 0) {
				dataId = 100038;
			} else if (dataValue == 1) {
				dataId = 100039;
			} else if (dataValue == 3) {
				dataId = 100040;
			} else if (dataValue == 7) {
				dataId = 100041;
			}
			int costId = 0;
			if (costValue == 0) {
				costId = 100042;
			} else if (costValue == 1) {
				costId = 100045;
			} else if (costValue == 4) {
				costId = 100043;
			} else if (costValue == 9) {
				costId = 100044;

			}

			intent.putExtra("money", moneyValue);
			intent.putExtra("callId", callId);
			intent.putExtra("dataId", dataId);
			intent.putExtra("costId", costId);
			intent.putExtra("Tag", Tag);
			startActivityForResult(intent, 1001);
		} else {
			mydialog(2);
		}
		activityAnimationUp();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case 1001:
			if (resultCode == -1) {
				if ("buy".equals(data.getStringExtra("tag"))) {
//					tv_success.setText(getString(R.string.confirm_success));
				} else {
					tv_success.setText(getString(R.string.swap_success));
				}
				buy.setVisibility(View.GONE);
				tv_success.setVisibility(View.VISIBLE);
				text_buy.setText(getString(R.string.settings_change_diy_plan));
//				buy.setEnabled(false);
//				buy.setBackgroundResource(R.drawable.settings_resetpin_back2);
				new Thread(new Runnable() {
					public void run() {
						Message msg = new Message();
						msg.what = WHAT_TAG;
						handler1.sendMessageDelayed(msg, 2000);
					}
				}).start();
			}

			break;
		case TAGUtil.tag7:
			if (resultCode == TAGUtil.tag8) {
				SuccessDialog dialog = new SuccessDialog(this);
				dialog.settext("Your payment was successful");
				dialog.show();
				// 查询钱
				Request(TAGUtil.BALANCEINFO);
			}
		default:

			break;
		}

	}

	private void Request(int num) {
		switch (num) {
		case 2:
		case TAGUtil.BALANCEINFO:
			IRequest.get(num, URLs.BALANCEINFO, RequestJSon.ReferInfo(), this);
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
				isShoworHint(PreferenceUtils.getString(DiyPlansActivity.this, "C_DATA_LEVEL"),
						PreferenceUtils.getString(DiyPlansActivity.this, "C_UNIT_LEVEL"),
						PreferenceUtils.getString(DiyPlansActivity.this, "C_SMS_LEVEL"));
				
				break;
			}
		};
	};
	private QuickCheckInfo quickcheckinfo2;
	private ArrayList<FreeUnitItem> freeUnitItem;

	@Override
	public void requestSuccess(Object tag, String json) {
		// TODO Auto-generated method stub
		switch ((Integer) tag) {
		case TAGUtil.BALANCEINFO:
			quickcheckinfo2 = JsonUtils.getBodyObject(json, QuickCheckInfo.class);
			UserInfo.setBalance(UnitUtil.getBalance(quickcheckinfo2.getBalanceInfoList(), false));
			break;
		case 2:
			wait.cancel();
			if (JsonUtils.getHeadCode(json).equals("0")) {
				QuickCheckInfo quickcheckinfo = JsonUtils.getBodyObject(json, QuickCheckInfo.class);
				if (quickcheckinfo == null) {
					mydialog(1);
				} else {
					UserInfo.setBalance(UnitUtil.getBalance(quickcheckinfo.getBalanceInfoList(), false));
					jump();
				}
			} else {
				mydialog(1);
			}
			break;
		}
	}

	@Override
	public void requestError(Object tag, VolleyError e) {
		if (tag.equals(2)) {
			wait.cancel();
			mydialog(1);
		}
	}

	private void mydialog(int num) {
		ErrorDialog dialog = new ErrorDialog(DiyPlansActivity.this);
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
						if (wait == null)
							wait = new WaitDialog(DiyPlansActivity.this);
						wait.show();
						Request(2);
					}
					break;
				case 2:
					if (num3) {
						Intent intent3 = new Intent(DiyPlansActivity.this, RechargeActivity.class);
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
