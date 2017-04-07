package com.huawei.vodafone.ui.activity;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

import com.huawei.vodafone.R;

public class SettingsSelectLanguageActivity extends BaseActivity implements
		OnClickListener {
	private Button rb1;
	private Button rb4;
	private ImageView back;
	private int screenW;
	private PopupWindow pw;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_select_language);
		initSecondTitle(getString(R.string.settings_title));
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		SharedPreferences sp = getSharedPreferences("lanAtr",
				Activity.MODE_PRIVATE);
		String lanAtr = sp.getString("lanAtr", "en");

		rb1 = (Button) findViewById(R.id.rb1);
		rb4 = (Button) findViewById(R.id.rb4);
		back = (ImageView) findViewById(R.id.back);
		back.setOnClickListener(this);
		if (lanAtr.equals("en")) {
			rb4.setBackgroundResource(R.drawable.settings_personalise_your_app_select_your_homescreen_service_07);
			rb1.setBackgroundResource(R.drawable.setting_sucess);
			rb4.setEnabled(true);
			rb1.setEnabled(false);
		} else {
			rb1.setBackgroundResource(R.drawable.settings_personalise_your_app_select_your_homescreen_service_07);
			rb4.setBackgroundResource(R.drawable.setting_sucess);
			rb4.setEnabled(false);
			rb1.setEnabled(true);
		}
		rb4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				showPopuwindow("German");

			}
		});
		rb1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showPopuwindow("English");
			}
		});

	}

	private void showPopuwindow(final String string) {
		if (string.equals("German")) {
			rb1.setBackgroundResource(R.drawable.settings_personalise_your_app_select_your_homescreen_service_07);
			rb4.setBackgroundResource(R.drawable.setting_sucess);
		} else {
			rb4.setBackgroundResource(R.drawable.settings_personalise_your_app_select_your_homescreen_service_07);
			rb1.setBackgroundResource(R.drawable.setting_sucess);
		}
		// 获取屏幕宽度
		DisplayMetrics metrics = new DisplayMetrics();
		SettingsSelectLanguageActivity.this.getWindowManager()
				.getDefaultDisplay().getMetrics(metrics);
		screenW = metrics.widthPixels;
		View convView = LayoutInflater
				.from(SettingsSelectLanguageActivity.this).inflate(
						R.layout.settings_set_language_popu, null);
		pw = new PopupWindow(convView, screenW, LayoutParams.WRAP_CONTENT);
		// 设置pw中的控件可点击
		pw.setFocusable(true);
		// 调用展示方法，设置展示位置
		/*
		 * 在展示pw的同时，让窗口的其余部分显示半透明的颜色
		 */
		WindowManager.LayoutParams params = SettingsSelectLanguageActivity.this
				.getWindow().getAttributes();
		params.alpha = 0.6f;
		SettingsSelectLanguageActivity.this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);//此行代码主要是解决在华为手机上半透明效果无效的bug
		SettingsSelectLanguageActivity.this.getWindow().setAttributes(params);

		// 设置pw可以在点击外部区域时关闭显示
		pw.setBackgroundDrawable(new BitmapDrawable());
		pw.setOutsideTouchable(true);
		pw.setTouchable(true);
		// 设置pw弹出和隐藏时的动画效果
		/*
		 * 注意：此处的动画效果是通过style样式指定的
		 */
		pw.setAnimationStyle(R.style.pw_anim_style);

		// 监控pw何时被关闭，并且，在pw被关闭的时候，将窗口的背景色调节回来
		pw.setOnDismissListener(new OnDismissListener() {
			public void onDismiss() {
				// TODO Auto-generated method stub
				// 将窗口颜色调回完全透明
				WindowManager.LayoutParams params = SettingsSelectLanguageActivity.this
						.getWindow().getAttributes();
				params.alpha = 1;
				SettingsSelectLanguageActivity.this.getWindow().setAttributes(
						params);
				if (string.equals("German")) {
					rb4.setBackgroundResource(R.drawable.settings_personalise_your_app_select_your_homescreen_service_07);
					rb4.setEnabled(true);
					rb1.setEnabled(false);
					rb1.setBackgroundResource(R.drawable.setting_sucess);

				} else {
					rb1.setBackgroundResource(R.drawable.settings_personalise_your_app_select_your_homescreen_service_07);
					rb4.setBackgroundResource(R.drawable.setting_sucess);
					rb1.setEnabled(true);
					rb4.setEnabled(false);
				}
			}
		});

		// 设置pw中button的点击事件
		TextView cancel = (TextView) convView.findViewById(R.id.cancel);
		cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pw.dismiss();
			}
		});
		TextView change = (TextView) convView.findViewById(R.id.change_to);
		change.setText(getString(R.string.settings_change_to) + " " + string);
		change.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (string.equals("German")) {
					SharedPreferences sp = getSharedPreferences("lanAtr",
							Activity.MODE_PRIVATE);

					// 如果以前没有打开过，那就显示当前的导航页面
					// 记录已经打开过
					Editor editor = sp.edit();
					editor.putString("lanAtr", "de");
					editor.commit();

					changeAppLanguage(getResources(), "de");
					finish();

					Intent it2 = new Intent("com.vodafone.set_language_sucess");
					it2.putExtra("language", string);
					it2.putExtra("lanAtr", "de");
					SettingsSelectLanguageActivity.this.sendBroadcast(it2);
					activityAnimationClose();
				} else {
					changeAppLanguage(getResources(), "en");
					SharedPreferences sp = getSharedPreferences("lanAtr",
							Activity.MODE_PRIVATE);

					// 如果以前没有打开过，那就显示当前的导航页面
					// 记录已经打开过
					Editor editor = sp.edit();
					editor.putString("lanAtr", "en");
					editor.commit();
					finish();
					Intent it2 = new Intent("com.vodafone.set_language_sucess");
					it2.putExtra("language", string);
					it2.putExtra("lanAtr", "en");
					SettingsSelectLanguageActivity.this.sendBroadcast(it2);
					activityAnimationClose();
				}

			}
		});
		TextView dialog_title = (TextView) convView
				.findViewById(R.id.dialog_title);
		dialog_title
				.setText(getString(R.string.setting_Would_you_like_to_change_the_app_language_to)
						+ " " + string + "?");
		// 展示对话框，并设置展示位置
		pw.showAtLocation(back, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0,
				0);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {

		case R.id.back:
			finish();
			activityAnimationClose();
			break;
		case R.id.save:

			finish();
			activityAnimationClose();
			break;
		default:
			break;
		}
	}

	public static void changeAppLanguage(Resources resources, String lanAtr) {
		Configuration config = resources.getConfiguration();
		DisplayMetrics dm = resources.getDisplayMetrics();
		if (lanAtr.equals("de")) {
			config.locale = Locale.GERMAN;
		} else if (lanAtr.equals("en")) {
			config.locale = Locale.ENGLISH;
		}
		resources.updateConfiguration(config, dm);

	}

}
