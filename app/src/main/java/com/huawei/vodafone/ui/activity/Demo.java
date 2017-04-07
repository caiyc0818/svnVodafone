package com.huawei.vodafone.ui.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.QuickCheckInfo;
import com.huawei.vodafone.net.IRequest;
import com.huawei.vodafone.net.RequestJSon;
import com.huawei.vodafone.net.RequestListener;
import com.huawei.vodafone.net.URLs;
import com.huawei.vodafone.util.JsonUtils;

/**
 * @author weich
 * @date 2016-1-25 下午3:31:31 demo
 */
public class Demo extends BaseActivity implements OnClickListener,
		RequestListener {
	private TextView Textview1;
	private EditText edittext;
	private EditText edittext1;
	private EditText edittext2;
	private EditText edittext3;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo);
		initView();
	}

	private void initView() {
		Button Button1 = (Button) findViewById(R.id.Button1);
		Button Button2 = (Button) findViewById(R.id.Button2);
		edittext = (EditText) findViewById(R.id.edittext);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		edittext2 = (EditText) findViewById(R.id.edittext2);
		edittext3 = (EditText) findViewById(R.id.edittext3);
		Textview1 = (TextView) findViewById(R.id.Textview1);
		Button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				edittext.setText("");
				Textview1.setText("");
			}
		});
		Button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					Request(Integer.valueOf(edittext.getText().toString()));
				} catch (NumberFormatException e) {

				}
			}
		});

	}

	private void Request(int num) {
		switch (num) {
		case 1:
			IRequest.post(num, URLs.UPDATE_SUB_INFO,
					RequestJSon.UpdateSubInfo(), this);
			break;
		case 2:
			IRequest.get(num, URLs.OFFERINST, RequestJSon.OfferingRentCycle(),
					this);
			break;
		case 3:
			IRequest.get(num, URLs.OFFERINSTLIST, RequestJSon.ReferInfo(), this);
			break;
		case 4:
			IRequest.get(num, URLs.DIYPRICE, RequestJSon.DiyPrice(), this);
			break;
		case 5:
			IRequest.post(num, URLs.ADDOPTIONAL,
					RequestJSon.Optionaloffering("", "","", true), this);
			break;
		case 6:
			IRequest.post(num, URLs.MODIFYOPTIONAL, RequestJSon.modify("","","","",""), this);
			break;
		case 7:
			IRequest.post(num, URLs.REMOVEOPTIONAL,
					RequestJSon.removeOptional("120003", "101991010007036"),
					this);
			break;
		case 8:
			IRequest.get(num, URLs.BALANCEINFO, RequestJSon.ReferInfo(), this);
			break;
		case 9:
			IRequest.get(num, URLs.CDRSUB, RequestJSon.CDRs(), this);
			break;
		case 10:
			IRequest.get(num, URLs.RECHARGELOG, RequestJSon.CDRs(), this);
			break;
		case 11:
			IRequest.get(num, URLs.PAYMENTHISTORY, RequestJSon.Payment(), this);
			break;
		case 12:
			IRequest.get(num, URLs.USAGE, RequestJSon.Usage(), this);
			break;
		case 13:
			IRequest.get(num, URLs.QUICKCHECK,
					RequestJSon.ReferInfo(edittext1.getText().toString()), this);
			break;
		case 14:
			IRequest.get(num, URLs.OFFERS_DIYRANKS,
					RequestJSon.OffersAndDIYRanks(), this);
			break;
		case 15:
			IRequest.get(num, URLs.ALLBOOKINFO, RequestJSon.BookingHistory(),
					this);
			break;
		case 16:
			IRequest.get(num, URLs.RANK_COMBINATION_AND_PRICE,
					RequestJSon.rankCombinationAndPrice(), this);
			break;
		case 17:
			IRequest.get(num, URLs.REPORT_USER_LOACTION,
					RequestJSon.reportUserLocation(), this);
			break;
		case 18:
			IRequest.get(num, URLs.QUERY_PROMOTION_OFFER,
					RequestJSon.queryPromotionOffer(), this);
			break;
		default:
			break;
		}

	}

	@Override
	public void onClick(View v) {

	}

	@Override
	public void requestSuccess(Object tag, String json) {
		Textview1.setText("tag==" + tag + " json-->" + json);
		if (tag.equals(13)) {
			QuickCheckInfo info = JsonUtils.getBodyObject(json,
					QuickCheckInfo.class);
			info.getBalanceInfoList().size();
		}
	}

	@Override
	public void requestError(Object tag, VolleyError e) {
		Textview1.setText("tag==" + tag + " json-->" + e);
	}

	protected void sendNotification(Context mContext) {
		Notification mNotification = new Notification(R.drawable.ic_launcher,
				"dds", System.currentTimeMillis());
		// TODO Auto-generated method stub
		// 1.实例化intent和获取通知的服务。
		Intent mIntent = new Intent();
		NotificationManager notificationManager = (NotificationManager) mContext
				.getSystemService(Context.NOTIFICATION_SERVICE);
		mIntent.setClass(mContext, MainSelectServiceActivity.class);
		PendingIntent mPendingIntent = PendingIntent.getActivity(mContext, 0,
				mIntent, 0);
		// 2.设置通知的相应属性
		// mNotification.fullScreenIntent =
		// mPendingIntent;//这句话的作用是决定通知是否自动弹出那个可跳转的activity。
		mNotification.defaults |= Notification.DEFAULT_SOUND;// 设置通知是否播放声音。
		mNotification.flags = Notification.FLAG_ONGOING_EVENT;
		// 在4.0的expendview里多显示一张图片，2.3系统会报错
		// mNotification.largeIcon =
		// BitmapFactory.decodeResource(getResources(),
		// R.drawable.ic_action_search);
		// 显示通知调用下面的方法是必须的，但在api11会被deprecated，使用Notification.Builder代替。
//		mNotification.setLatestEventInfo(mContext, "dds", "", mPendingIntent);
		// 3.唤醒通知
		notificationManager.notify(R.drawable.ic_launcher, mNotification);
	}
}
