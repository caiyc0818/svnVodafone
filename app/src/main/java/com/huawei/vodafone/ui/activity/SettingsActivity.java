package com.huawei.vodafone.ui.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager.LayoutParams;
import android.support.v7.widget.SwitchCompat;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.util.PreferenceUtils;
import com.huawei.vodafone.util.SPUtils;
import com.huawei.vodafone.util.StringUtils;

import skin.support.SkinCompatManager;



public class SettingsActivity extends BaseActivity implements OnClickListener, CompoundButton.OnCheckedChangeListener {
    private ImageView image_pin;
    private RelativeLayout image_persona;
    private ImageView back;
    private ImageView my_account_is_default_cb;
    private ImageView image_wife;
    private RelativeLayout image_language;
    private RelativeLayout image_password;
    private ImageView check_notification;
    private RelativeLayout image_sim;
    private RelativeLayout image_terms;
    private String lanAtr;
    protected String language;
    protected TextView change_language;
    private Boolean isChecked = false;
    private Boolean isDefault = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_lay);
        initSecondTitle(getString(R.string.settings_title));
        lanAtr = getIntent().getStringExtra("lanAtr");
        language = getIntent().getStringExtra("language");

        SharedPreferences sp = getSharedPreferences("lanAtr",
                Activity.MODE_PRIVATE);
        String lanAtr2 = sp.getString("lanAtr", "en");
        initView();
        if ("de".equals(lanAtr2)) {
            change_language.setText(getResources().getString(
                    R.string.setting_German2));
        } else if ("en".equals(lanAtr2)) {
            change_language.setText(getResources().getString(
                    R.string.settings_App_language2));
        }
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(500);
                    Message message = new Message();
                    message.what = 1;
                    mHandler.sendMessage(message);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        if (!StringUtils.isEmpty(lanAtr)) {
            thread.start();
        }

        registerBoradcastReceiver();
    }
    private void initView() {
        // TODO Auto-generated method stub
        image_pin = (ImageView) findViewById(R.id.image_pin);
        my_account_is_default_cb = (ImageView) findViewById(R.id.my_account_is_default_cb);
        image_persona = (RelativeLayout) findViewById(R.id.image_persona);
        back = (ImageView) findViewById(R.id.back);
        image_wife = (ImageView) findViewById(R.id.image_wife);
        image_language = (RelativeLayout) findViewById(R.id.image_language);
        check_notification = (ImageView) findViewById(R.id.check_notification);
        image_terms = (RelativeLayout) findViewById(R.id.image_terms);
        image_password = (RelativeLayout) findViewById(R.id.image_password);
        back.setOnClickListener(this);
        image_password.setOnClickListener(this);
        image_sim = (RelativeLayout) findViewById(R.id.image_sim);
        change_language = (TextView) findViewById(R.id.change_language);
        image_sim.setOnClickListener(this);
        check_notification.setOnClickListener(this);
        my_account_is_default_cb.setOnClickListener(this);
        // 是否接收通知
        check_notification.setBackgroundResource(R.drawable.toggle_on);
        isChecked = PreferenceUtils.getBoolean(SettingsActivity.this,
                "notification_ischecked", true);
        if (isChecked) {
            check_notification.setBackgroundResource(R.drawable.toggle_on);
        } else {
            check_notification.setBackgroundResource(R.drawable.toggle_off);
        }
        // 自动登录的TAG
        my_account_is_default_cb.setBackgroundResource(R.drawable.toggle_off);
        isDefault = PreferenceUtils.getBoolean(SettingsActivity.this,
                "automaticLogon");
        if (isDefault) {
            my_account_is_default_cb
                    .setBackgroundResource(R.drawable.toggle_on);
        } else {
            my_account_is_default_cb
                    .setBackgroundResource(R.drawable.toggle_off);
        }
        check_notification.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (isChecked) {
                    showNPopuwindow();
                } else {
                    isChecked = true;
                    check_notification
                            .setBackgroundResource(R.drawable.toggle_on);
                    PreferenceUtils.setBoolean(SettingsActivity.this,
                            "notification_ischecked", true);
                }
            }
        });
        image_pin.setOnClickListener(this);
        image_persona.setOnClickListener(this);
        image_wife.setOnClickListener(this);
        image_language.setOnClickListener(this);
        image_terms.setOnClickListener(this);
        SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.day_night_switch);
        switchCompat.setOnCheckedChangeListener(this);
    }
    @Override
    public void onCheckedChanged(CompoundButton button, boolean checked) {
//        if (checked) {
////         做我们要实现的一些操作
//            mDayNightHelper.setMode(DayNight.NIGHT);
//            setTheme(R.style.NightTheme);
//            switchMode();
//            mText.setText("Night");
//            mSwitchCompat.setChecked(true);
//            mSwitchCompat2.setChecked(true);
//            mSwitch2.setChecked(true);
//        } else {
//
//            mDayNightHelper.setMode(DayNight.DAY);
//            setTheme(R.style.DayTheme);
//            switchMode();
//            mText.setText("Day");
//            mSwitchCompat.setChecked(false);
//            mSwitchCompat2.setChecked(false);
//            mSwitch2.setChecked(false);
//        }
        if (!SPUtils.getInstance().getNightMode()) {
            SPUtils.getInstance().setCurSkin(SkinCompatManager.getInstance().getCurSkinName()).commitEditor();
            SkinCompatManager.getInstance().loadSkin("night.skin");
        } else {
            SkinCompatManager.getInstance().loadSkin(SPUtils.getInstance().getCurSkin());
        }
        SPUtils.getInstance().setNightMode(!SPUtils.getInstance().getNightMode()).commitEditor();
        button.setChecked(SPUtils.getInstance().getNightMode());
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        super.onClick(v);
        switch (v.getId()) {
            case R.id.image_pin:
                // Intent intent = new Intent(Settings.this,
                // Settings_reset_Pin.class);
                // startActivity(intent);
                // activityAnimationOpen();
                break;
            case R.id.image_password:
                Intent intent = new Intent(SettingsActivity.this,
                        SettingsResetPasswordActivity.class);
                startActivity(intent);
                activityAnimationOpen();
                break;
            case R.id.image_persona:
                Intent intent2 = new Intent(SettingsActivity.this,
                        SettingsPersonaliseYourSerActivity.class);
                startActivity(intent2);
                activityAnimationOpen();

                break;
            case R.id.back:
                if (PreferenceUtils.getBoolean(SettingsActivity.this, "name")) {
                    setResult(1001);
                }
                finish();
                activityAnimationClose();
                break;
            case R.id.image_wife:
                // Intent intent3 = new Intent(Settings.this,
                // Settings_Finder_wifi.class);
                // startActivity(intent3);
                // activityAnimationOpen();

                break;
            case R.id.image_language:
                Intent intent4 = new Intent(SettingsActivity.this,
                        SettingsSelectLanguageActivity.class);
                startActivity(intent4);
                activityAnimationOpen();

                break;
            case R.id.image_sim:
                Intent intent6 = new Intent(SettingsActivity.this,
                        SettingsSimDetailsActivity.class);
                startActivity(intent6);
                activityAnimationOpen();

                break;
            case R.id.image_terms:
                Intent intent7 = new Intent(SettingsActivity.this,
                        ArgeementActivity.class);
                intent7.putExtra("from", "tc");
                startActivity(intent7);
                activityAnimationOpen();
                break;
            case R.id.my_account_is_default_cb:
                if (isDefault) {
                    PreferenceUtils.setBoolean(SettingsActivity.this,
                            "automaticLogon", false);
                    my_account_is_default_cb
                            .setBackgroundResource(R.drawable.toggle_off);
                    isDefault = false;
                } else {
                    PreferenceUtils.setBoolean(SettingsActivity.this,
                            "automaticLogon", true);
                    my_account_is_default_cb
                            .setBackgroundResource(R.drawable.toggle_on);
                    isDefault = true;
                }
                break;
            default:
                break;
        }
    }

    public void registerBoradcastReceiver() {
        IntentFilter myIntentFilter = new IntentFilter();
        myIntentFilter.addAction("com.vodafone.reset_pin_sucess");
        myIntentFilter.addAction("com.vodafone.set_language_sucess");
        myIntentFilter.addAction("com.vodafone.reset_password_sucess");

        // 注册广播
        SettingsActivity.this.registerReceiver(mBroadcastReceiver,
                myIntentFilter);
    }

    private void unRegisterBoradcastReceiver() {
        SettingsActivity.this.unregisterReceiver(mBroadcastReceiver);
    }

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("com.vodafone.reset_pin_sucess".equals(action)) {
                showPopuwindow2(R.string.settings_pin_success);
            }
            if ("com.vodafone.reset_password_sucess".equals(action)) {
                showPopuwindow2(R.string.settings_password_success);
            }
            if ("com.vodafone.set_language_sucess".equals(action)) {
                String lanAtr = intent.getStringExtra("lanAtr");
                String language = intent.getStringExtra("language");
                finish();
                Intent i = new Intent(SettingsActivity.this,
                        SettingsActivity.class);
                i.putExtra("lanAtr", lanAtr);
                i.putExtra("language", language);
                startActivity(i);

            }
        }
    };
    private PopupWindow pw;
    private int screenW;

    private void showPopuwindow(int resId) {
        // 获取屏幕宽度
        DisplayMetrics metrics = new DisplayMetrics();
        SettingsActivity.this.getWindowManager().getDefaultDisplay()
                .getMetrics(metrics);
        screenW = metrics.widthPixels;
        View convView = LayoutInflater.from(SettingsActivity.this).inflate(
                R.layout.settings_popuw, null);
        pw = new PopupWindow(convView, screenW, LayoutParams.WRAP_CONTENT);
        // 设置pw中的控件可点击
        pw.setFocusable(true);
        // 调用展示方法，设置展示位置
        /*
		 * 在展示pw的同时，让窗口的其余部分显示半透明的颜色
		 */
        WindowManager.LayoutParams params = SettingsActivity.this.getWindow()
                .getAttributes();
        params.alpha = 1.0f;
        SettingsActivity.this.getWindow().setAttributes(params);

        // 设置pw可以在点击外部区域时关闭显示
        pw.setBackgroundDrawable(new BitmapDrawable());
        pw.setOutsideTouchable(true);
        pw.setTouchable(true);

        // 设置pw弹出和隐藏时的动画效果
		/*
		 * 注意：此处的动画效果是通过style样式指定的
		 */

        // 设置pw中button的点击事件
        TextView photo = (TextView) convView
                .findViewById(R.id.setting_set_sucess);
        photo.setText(getString(resId) + " " + language);
        // 展示对话框，并设置展示位置
        pw.showAtLocation(back, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0,
                0);
    }

    private void showPopuwindow2(int resId) {
        // 获取屏幕宽度
        DisplayMetrics metrics = new DisplayMetrics();
        SettingsActivity.this.getWindowManager().getDefaultDisplay()
                .getMetrics(metrics);
        screenW = metrics.widthPixels;
        View convView = LayoutInflater.from(SettingsActivity.this).inflate(
                R.layout.settings_popuw, null);
        pw = new PopupWindow(convView, screenW, LayoutParams.WRAP_CONTENT);
        // 设置pw中的控件可点击
        pw.setFocusable(true);
        // 调用展示方法，设置展示位置
		/*
		 * 在展示pw的同时，让窗口的其余部分显示半透明的颜色
		 */
        WindowManager.LayoutParams params = SettingsActivity.this.getWindow()
                .getAttributes();
        params.alpha = 1.0f;
        SettingsActivity.this.getWindow().setAttributes(params);

        // 设置pw可以在点击外部区域时关闭显示
        pw.setBackgroundDrawable(new BitmapDrawable());
        pw.setOutsideTouchable(true);
        pw.setTouchable(true);

        // 设置pw弹出和隐藏时的动画效果
		/*
		 * 注意：此处的动画效果是通过style样式指定的
		 */

        // 设置pw中button的点击事件
        TextView photo = (TextView) convView
                .findViewById(R.id.setting_set_sucess);
        photo.setText(getString(resId));

        // 展示对话框，并设置展示位置
        pw.showAtLocation(back, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0,
                0);
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        unRegisterBoradcastReceiver();
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        registerBoradcastReceiver();

    }

    public Handler mHandler = new Handler() {
        // public static Handler mHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            if ("de".equals(lanAtr)) {
                showPopuwindow(R.string.settings_set_language_sucess);
                change_language.setText(getResources().getString(
                        R.string.setting_German2));
            } else if ("en".equals(lanAtr)) {
                showPopuwindow(R.string.settings_set_language_sucess);
                change_language.setText(getResources().getString(
                        R.string.settings_App_language2));
            }
        }

    };

    protected int tag = 0;

    private void showNPopuwindow() {
        check_notification.setBackgroundResource(R.drawable.toggle_off);
        // 获取屏幕宽度
        DisplayMetrics metrics = new DisplayMetrics();
        SettingsActivity.this.getWindowManager().getDefaultDisplay()
                .getMetrics(metrics);
        screenW = metrics.widthPixels;
        View convView = LayoutInflater.from(SettingsActivity.this).inflate(
                R.layout.settings_set_notifi_popu, null);
        pw = new PopupWindow(convView, screenW, LayoutParams.WRAP_CONTENT);
        // 设置pw中的控件可点击
        pw.setFocusable(true);
        // 调用展示方法，设置展示位置
		/*
		 * 在展示pw的同时，让窗口的其余部分显示半透明的颜色
		 */
        WindowManager.LayoutParams params = SettingsActivity.this.getWindow()
                .getAttributes();
        params.alpha = 0.2f;
        SettingsActivity.this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);//此行代码主要是解决在华为手机上半透明效果无效的bug
        SettingsActivity.this.getWindow().setAttributes(params);

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
                WindowManager.LayoutParams params = SettingsActivity.this
                        .getWindow().getAttributes();
                params.alpha = 1;
                SettingsActivity.this.getWindow().setAttributes(params);
                if (tag != 0) {
                    if (isChecked == true) {
                        check_notification
                                .setBackgroundResource(R.drawable.toggle_on);
                        PreferenceUtils.setBoolean(SettingsActivity.this,
                                "notification_ischecked", true);
                        tag = 0;
                    } else {
                        check_notification
                                .setBackgroundResource(R.drawable.toggle_off);
                        PreferenceUtils.setBoolean(SettingsActivity.this,
                                "notification_ischecked", false);

                    }
                } else {
                    check_notification
                            .setBackgroundResource(R.drawable.toggle_on);
                    PreferenceUtils.setBoolean(SettingsActivity.this,
                            "notification_ischecked", true);
                }
            }
        });

        // 设置pw中button的点击事件
        TextView cancel = (TextView) convView.findViewById(R.id.cancel);
        cancel.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                isChecked = true;
                tag++;
                pw.dismiss();
            }
        });
        TextView change = (TextView) convView.findViewById(R.id.turn_off);
        change.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                isChecked = false;
                tag++;
                pw.dismiss();
            }
        });
        // 展示对话框，并设置展示位置
        pw.showAtLocation(back, Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0,
                0);
    }

}
