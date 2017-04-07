package com.huawei.vodafone.broadcast;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.WindowManager;

import com.android.volley.VolleyError;
import com.huawei.vodafone.MyApplication;
import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.UserInfo;
import com.huawei.vodafone.listener.Listener.ClickTwo;
import com.huawei.vodafone.listener.Listener.MyReceiver;
import com.huawei.vodafone.net.IRequest;
import com.huawei.vodafone.net.RequestListener;
import com.huawei.vodafone.net.URLs;
import com.huawei.vodafone.ui.myview.dialog.NotificationDialog;
import com.huawei.vodafone.util.AndroidUtils;
import com.huawei.vodafone.util.PreferenceUtils;
import com.huawei.vodafone.util.StringUtils;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.PushManager;

public class PushReceiver extends BroadcastReceiver {
	private static MyReceiver receiver;
	private static int notifynum = 0;// id不能重复
	private NotificationDialog dialog;
	private ClickTwo click;

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		if (bundle != null) {
			switch (bundle.getInt(PushConsts.CMD_ACTION)) {
			case PushConsts.GET_MSG_DATA:
				// 获取透传数据
				String appid = bundle.getString("appid");
				byte[] payload = bundle.getByteArray("payload");

				String taskid = bundle.getString("taskid");
				String messageid = bundle.getString("messageid");

				// smartPush第三方回执调用接口，actionid范围为90000-90999，可根据业务场景执行
				boolean result = PushManager.getInstance().sendFeedbackMessage(
						context, taskid, messageid, 90001);
				System.out.println("第三方回执接口调用" + (result ? "成功" : "失败"));

				if (payload != null) {
					String data = new String(payload);
					showwhat(context, data);
				}
				break;
			case PushConsts.GET_CLIENTID:
				Log.d("", "-----" + bundle.getString("clientid"));

				if (!StringUtils.isEmpty(bundle.getString("clientid"))) {
					// if (PreferenceUtils.getString(context, "CID").equals(
					// bundle.getString("clientid"))) {
					// if (!PreferenceUtils.getBoolean(context, "IsSendCID",
					// false)
					// && !StringUtils.isEmpty(UserInfo
					// .getUserMobile())) {
					// pushpost(context, bundle.getString("clientid"));
					// }
					// } else {
					// pushpost(context, bundle.getString("clientid"));
					// }
					PreferenceUtils.setString(context, "CID",
							bundle.getString("clientid"));
				}
				break;
			case PushConsts.THIRDPART_FEEDBACK:
				break;
			}
		}
	}

	private void showwhat(Context context, String data) {
		Log.d("", "-----" + data);
		try {
			JSONObject json = new JSONObject(data);
			if (json.optString("content").equals("error")) {
				return;
			}
			Parse(context, json.optString("channel"),
					json.optString("content"), json.optString("title"));
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 不能换签名，换了无法跳转，得重启手机
	 */
	private void Parse(Context context, String channel, String content,
			String title) {
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				context);
		mBuilder.setTicker("Smart Pricing");
		mBuilder.setSmallIcon(R.drawable.logo);
		mBuilder.setContentTitle(title);
		mBuilder.setContentText(content);
		mBuilder.setDefaults(Notification.DEFAULT_SOUND
				| Notification.DEFAULT_VIBRATE | Notification.DEFAULT_LIGHTS);
		// 设置点击一次后消失（如果没有点击事件，则该方法无效。）
		mBuilder.setAutoCancel(true);

		Intent resultIntent = new Intent(context,
				com.huawei.vodafone.ui.activity.MainActivity.class);
		resultIntent.putExtra("channel", channel);
		resultIntent.putExtra("content", content);
		resultIntent.putExtra("title", title);
		resultIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		PendingIntent pIntent = PendingIntent.getActivity(context, notifynum++,
				resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		mBuilder.setContentIntent(pIntent);

		if (AndroidUtils.getModel().equals("EVA-AL00")) {
			if (!AndroidUtils.isAppOnForeground()) {
				getNotificationManager().notify(notifynum, mBuilder.build());
				showdialog(context, channel, content, title);
			} else {
				if (receiver == null) {
					getNotificationManager()
							.notify(notifynum, mBuilder.build());
					return;
				}
				playBeepSoundAndVibrate(context);
				receiver.onClicked(channel, content, title);
			}
		} else {
			switch (AndroidUtils.isAppRun(context)) {
			case "-1":
			case "2":
				getNotificationManager().notify(notifynum, mBuilder.build());
				showdialog(context, channel, content, title);
				break;
			default:
				if (receiver == null) {
					getNotificationManager()
							.notify(notifynum, mBuilder.build());
					return;
				}
				playBeepSoundAndVibrate(context);
				receiver.onClicked(channel, content, title);
				break;
			}
		}

	}

	private void playBeepSoundAndVibrate(Context context) {
		Vibrator vibrator = (Vibrator) context
				.getSystemService(Context.VIBRATOR_SERVICE);
		// 震动一次
		vibrator.vibrate(new long[] { 0, 300, 200, 300 }, -1);
		// 第一个参数，指代一个震动的频率数组。每两个为一组，每组的第一个为等待时间，第二个为震动时间。
		// 比如 [2000,500,100,400],会先等待2000毫秒，震动500，再等待100，震动400
		// 第二个参数，repest指代从 第几个索引（第一个数组参数） 的位置开始循环震动。
		// 会一直保持循环，我们需要用 vibrator.cancel()主动终止
		// vibrator.vibrate(new long[]{300,500},0);
	}

	private void showdialog(final Context context, final String channel,
			final String content, final String title) {
		if (dialog == null) {
			dialog = new NotificationDialog(context);
			click = new ClickTwo() {

				@Override
				public void onClicked(Object num, String num1, String num2,
						boolean num3) {
					if (num3) {
						Intent resultIntent = new Intent(
								context,
								com.huawei.vodafone.ui.activity.MainActivity.class);
						resultIntent.putExtra("channel", channel);
						resultIntent.putExtra("content", content);
						resultIntent.putExtra("title", title);
						resultIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
								| Intent.FLAG_ACTIVITY_NEW_TASK);
						MyApplication.applicationContext
								.startActivity(resultIntent);
					}
				}
			};
		}
		if (!dialog.isShowing()) {
			dialog.setMessage(content, title, "Yes please", "No thanks");
			dialog.getWindow().setType(
					WindowManager.LayoutParams.TYPE_SYSTEM_DIALOG); // 系统中关机对话框就是这个属性
			dialog.getWindow().setType(
					WindowManager.LayoutParams.TYPE_SYSTEM_ALERT); // 窗口可以获得焦点，响应操作
			dialog.setClick(click);
			dialog.show();
		}
	}

	public static void MyReceiver(MyReceiver myreceiver) {
		receiver = myreceiver;
	}

	public NotificationManager getNotificationManager() {
		NotificationManager mNotificationManager = (NotificationManager) MyApplication.applicationContext
				.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
		return mNotificationManager;
	}

	private void pushpost(Context context, String clientid) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mobile", UserInfo.getUserMobile());
		params.put("deviceToken", clientid);
		params.put("fromType", 0);
		IRequest.get(1, URLs.GETUI, params, new RequestListener() {

			@Override
			public void requestSuccess(Object tag, String json) {

			}

			@Override
			public void requestError(Object tag, VolleyError e) {
			}
		});
	}
}
