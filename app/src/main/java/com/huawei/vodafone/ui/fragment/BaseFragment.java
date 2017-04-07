package com.huawei.vodafone.ui.fragment;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.huawei.vodafone.R;

/**
 * @author hanweipeng
 * @date 2015-8-27 12:17:57
 */
public class BaseFragment extends Fragment {
	
	 /*
     * 屏幕高度
     */
    public static int screenHeight = 0;
    
    /*
     * 屏幕宽度
     */
    public static int screenWidth = 0;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//		ChangeBounds();
		getScreenData();
		return super.onCreateView(inflater, container, savedInstanceState);

	}

	private void ChangeBounds() {
		// 透明状态栏
		getActivity().getWindow().addFlags(
				WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		// 透明导航栏
		// getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

	/**
	 * 界面启动的动画
	 */
	public void activityAnimationOpen() {
		getActivity().overridePendingTransition(R.anim.activity_new,
				R.anim.activity_out);
	}

	/**
	 * 界面关闭的动画
	 */
	protected void activityAnimationClose() {
		getActivity().overridePendingTransition(R.anim.activity_back,
				R.anim.activity_finish);
	}
	
	  /**
     * 获取屏幕像素数据
     */
    private void getScreenData()
    {
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenHeight = dm.heightPixels;
        screenWidth = dm.widthPixels;
    }
	protected void send_notification(Class class1,String title,String text,int id,int Number) {
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
		NotificationManager nm = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
		NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity());
		builder.setContentTitle(title);
		builder.setContentText(text);
		// 设置大图片
		Bitmap icon = BitmapFactory.decodeResource(getResources(),id);
		builder.setLargeIcon(icon);

		Intent intent = new Intent(getActivity(), class1);
		PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 1, intent, PendingIntent.FLAG_CANCEL_CURRENT);
		builder.setContentIntent(pendingIntent);

		builder.setSmallIcon(id);
		builder.setNumber(Number);
		Notification notification = builder.build();
		notification.flags=Notification.FLAG_AUTO_CANCEL; 
		nm.notify(2, notification);
	}
}
