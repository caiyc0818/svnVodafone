package com.huawei.vodafone.ui.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.vodafone.R;

import skin.support.app.SkinCompatActivity;

/**
 * @author hanweipeng
 * @date 2015-8-27 下午2:16:12
 */
public class BaseFragmentActivity extends SkinCompatActivity implements
		OnClickListener {

	/*
	 * 屏幕高度
	 */
	public static int screenHeight = 0;

	/*
	 * 屏幕宽度
	 */
	public static int screenWidth = 0;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		// ChangeBounds();
		getScreenData();
	}

	/**
	 * 获取屏幕像素数据
	 */
	private void getScreenData() {
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		screenHeight = dm.heightPixels;
		screenWidth = dm.widthPixels;
	}

	private void ChangeBounds() {
		// 透明状态栏
		getWindow()
				.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		// 透明导航栏
		// getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	/**
	 * @function 初始化二级标题
	 * @param resId
	 *            字符串资源id
	 * @param showRight
	 *            是否显示右边按钮
	 */
	protected void initSecondTitle(int resId) {
		initSecondTitle(getString(resId), true, false);
	}

	protected void initSecondTitle(String resId) {
		initSecondTitle(resId, true, false);
	}

	protected void initSecondTitle(String resId, boolean showleft,
			boolean showRight) {
		ImageView backBtn = (ImageView) findViewById(R.id.back);
		TextView titleTv = (TextView) findViewById(R.id.title);
		ImageView rightBtn = (ImageView) findViewById(R.id.close);

		titleTv.setText(resId);
		if (showRight) {
			rightBtn.setVisibility(View.VISIBLE);
			rightBtn.setOnClickListener(this);
		} else {
			rightBtn.setVisibility(View.INVISIBLE);
		}
		if (showleft) {
			backBtn.setOnClickListener(this);
			backBtn.setVisibility(View.VISIBLE);
		} else {
			backBtn.setVisibility(View.INVISIBLE);
		}
	}

	/**
	 * @function 二级标题更改右边按钮图片
	 * @param resId
	 *            图片资源id
	 */
	protected void changeRightBtnImage(int resId) {
		ImageView rightBtn = (ImageView) findViewById(R.id.close);
		rightBtn.setImageResource(resId);
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.back:
			finish();
			activityAnimationClose();
			break;
		case R.id.close:
			finish();
			activityAnimationDown();
			break;
		default:
			break;
		}
	}

	/**
	 * 界面启动的动画-右滑
	 */
	public void activityAnimationOpen() {
		overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
	}

	/**
	 * 界面关闭的动画-左滑
	 */
	protected void activityAnimationClose() {
		overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
	}

	/**
	 * 界面启动的动画-上滑
	 */
	public void activityAnimationUp() {
		overridePendingTransition(R.anim.activity_up_enter,
				R.anim.activity_up_exit);
	}

	/**
	 * 界面关闭的动画-下滑
	 */
	protected void activityAnimationDown() {
		overridePendingTransition(R.anim.activity_down_enter,
				R.anim.activity_down_exit);
	}

	protected void send_notification(Class class1, String title, String text,
			int id, int Number) {
		/*
		 * class1 跳转
		 * 
		 * title 通知标题
		 * 
		 * text 通知内容
		 * 
		 * id 图片资源
		 * 
		 * Number 通知数量
		 */
		NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		NotificationCompat.Builder builder = new NotificationCompat.Builder(
				this);
		builder.setContentTitle(title);
		builder.setContentText(text);
		// 设置大图片
		Bitmap icon = BitmapFactory.decodeResource(getResources(), id);
		builder.setLargeIcon(icon);

		Intent intent = new Intent(this, class1);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 1,
				intent, PendingIntent.FLAG_CANCEL_CURRENT);
		builder.setContentIntent(pendingIntent);

		builder.setSmallIcon(id);
		builder.setNumber(Number);
		Notification notification = builder.build();
		notification.flags = Notification.FLAG_AUTO_CANCEL;
		nm.notify(2, notification);
	}
}
