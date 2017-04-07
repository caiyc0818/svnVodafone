package com.huawei.vodafone.ui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.VolleyError;
import com.huawei.vodafone.MyApplication;
import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.ConsumeAndQuota;
import com.huawei.vodafone.bean.DialogInfo;
import com.huawei.vodafone.bean.DiyUtils2;
import com.huawei.vodafone.bean.Envelope;
import com.huawei.vodafone.bean.FreeUnitItem;
import com.huawei.vodafone.bean.FreeUnitItemDetail;
import com.huawei.vodafone.bean.MySwitch;
import com.huawei.vodafone.bean.PersonalInfo;
import com.huawei.vodafone.bean.QuickCheckInfo;
import com.huawei.vodafone.bean.UserInfo;
import com.huawei.vodafone.bills.activity.BillsActivity;
import com.huawei.vodafone.bills.activity.ItemisedBillActivity;
import com.huawei.vodafone.bills.activity.NetWorkUsageActivity;
import com.huawei.vodafone.broadcast.PushReceiver;
import com.huawei.vodafone.db.DBAdapter;
import com.huawei.vodafone.db.DBSignInAdapter;
import com.huawei.vodafone.db.JokeMsg;
import com.huawei.vodafone.listener.Listener.Click;
import com.huawei.vodafone.listener.Listener.ClickTwo;
import com.huawei.vodafone.listener.Listener.MyReceiver;
import com.huawei.vodafone.net.IRequest;
import com.huawei.vodafone.net.RequestJSon;
import com.huawei.vodafone.net.RequestListener;
import com.huawei.vodafone.net.URLs;
import com.huawei.vodafone.products.activity.ProductsServiceActivity;
import com.huawei.vodafone.ui.adapter.CurrentSpendListAdapter;
import com.huawei.vodafone.ui.adapter.MyPagerAdapter;
import com.huawei.vodafone.ui.myview.CircleImageView;
import com.huawei.vodafone.ui.myview.RoundProgressBar;
import com.huawei.vodafone.ui.myview.dialog.ErrorDialog;
import com.huawei.vodafone.ui.myview.dialog.LogoutDialog;
import com.huawei.vodafone.ui.myview.dialog.LogoutDialog.OnClickLogOutListener;
import com.huawei.vodafone.ui.myview.dialog.SuccessDialog;
import com.huawei.vodafone.util.DateUtil;
import com.huawei.vodafone.util.DebugLog;
import com.huawei.vodafone.util.DiyUtils;
import com.huawei.vodafone.util.DiyUtilsFromId;
import com.huawei.vodafone.util.JsonUtils;
import com.huawei.vodafone.util.NationalUtils;
import com.huawei.vodafone.util.PreferenceUtils;
import com.huawei.vodafone.util.StringUtils;
import com.huawei.vodafone.util.TAGUtil;
import com.huawei.vodafone.util.UnitUtil;
import com.huawei.vodafone.zxing.CaptureActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends BaseActivity implements OnClickListener,
        OnClickLogOutListener, RequestListener, OnLongClickListener {
    /**
     * 侧滑按钮
     */
    private ImageView menuBtn;
    private TextView notification_marks;
    private DrawerLayout DrawerLayout;
    private ImageView backMenu;
    private ImageView networkChooseIcon;
    private LinearLayout networkLayout;
    private RelativeLayout networkChoose;
    private TextView currentSpend;
    private TextView usage_history;
    private TextView notifications;
    private TextView version;
    private TextView products_text;
    private ArrayList<View> dots;
    private List<JokeMsg> data_notification = new ArrayList<JokeMsg>();
    /**
     * 点的父布局
     */
    private LinearLayout dotsLayout;
    /**
     * 消息数量
     */
    private List<List<DialogInfo>> dialoglist;

    private ViewPager newsPager;

    private RoundProgressBar progreessbar;
    private Handler handler;
    private Runnable run;
    private TextView surplusFlow, whichFlow, allFlow;
    private ImageView addCircle;

    private TextView addGb, addMore, refreshed;
    private RelativeLayout currentSpentRela;
    private CircleImageView userPortrait, user_three, user_two;
    private ImageView refreshedImage;
    private Animation rotate, rotateout, rotatein, alpha, alout, alphadelaye,
            aloutdelaye, aloutdelayemore;
    private ImageView speakSelect, callSelect, smsSelect;
    private LinearLayout mGoneImage, dataDisk;
    private View mainPop;
    private FrameLayout fl;
    private FrameLayout circleFrameLayout;
    private LinearLayout for_tip_three;
    private RelativeLayout ll_support;
    private ScrollView scrollView;
    public static MainActivity currentActivity;
    private TextView settings;
    private ListView spendList, allspendList;
    private CurrentSpendListAdapter SpendListAdapter, allSpendListAdapter;
    private ImageView spendChoose, allspendChoose;
    private LinearLayout spendLayout, allspendLayout;
    private TextView addPlus;
    private TextView log_out;
    private MyPagerAdapter newsAdapter;
    private TextView balanceText;
    private TextView userName;
    private TextView offer_extras;
    private ImageView search;
    private ImageView capture;
    private TextView support_text;
    private LogoutDialog logout_dialog;
    private Button itemised_spend;
    private Button billing_history;
    private TextView lastBillTitle;
    private TextView pointsNum;
    private TextView messageNumTv;
    private QuickCheckInfo quickcheckinfo;
    private TextView dayLeftText;
    private ImageView cancel_diy;
    private ClickTwo click;
    private ErrorDialog dialog;
    private ArrayList<FreeUnitItem> freeUnitItem;
    private MySwitch myswitch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        currentActivity = this;
        initView();
        isFirst();

    }

    /**
     * 第一次弹出功能引导
     **/
    private void isFirst() {
        if (!PreferenceUtils.getBoolean(getApplicationContext(), "isFirstOne")) {
            newsPager.setVisibility(View.INVISIBLE);
            showPop();
            PreferenceUtils.setBoolean(getApplicationContext(), "isFirstOne",
                    true);
        }
    }

    /**
     * 初始化组件
     */
    private void initView() {
        DrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout);
        // DrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LsOCKED_CLOSED);//禁止手势滑动
        newsPager = (ViewPager) findViewById(R.id.card_discount_vp);
        menuBtn = (ImageView) findViewById(R.id.menu_btn);
        notification_marks = (TextView) findViewById(R.id.notification_marks);
        backMenu = (ImageView) findViewById(R.id.back_menu);
        search = (ImageView) findViewById(R.id.search);
        capture = (ImageView) findViewById(R.id.capture);
        RelativeLayout signInRela = (RelativeLayout) findViewById(R.id.sign_in_rela);
        RelativeLayout refreshed_rl = (RelativeLayout) findViewById(R.id.refreshed_rl);
        dayLeftText = (TextView) findViewById(R.id.day_left_text);
        itemised_spend = (Button) findViewById(R.id.itemised_spend);
        billing_history = (Button) findViewById(R.id.billing_history);
        userPortrait = (CircleImageView) findViewById(R.id.user_portrait);
        user_two = (CircleImageView) findViewById(R.id.user_two);
        networkChooseIcon = (ImageView) findViewById(R.id.network_choose_icon);
        networkLayout = (LinearLayout) findViewById(R.id.network_layout);
        networkChoose = (RelativeLayout) findViewById(R.id.network_choose);
        currentSpend = (TextView) findViewById(R.id.current_spend);
        usage_history = (TextView) findViewById(R.id.usage_history);
        lastBillTitle = (TextView) findViewById(R.id.last_bill_title);
        notifications = (TextView) findViewById(R.id.notifications);
        version = (TextView) findViewById(R.id.version);
        offer_extras = (TextView) findViewById(R.id.offer_extras);
        dotsLayout = (LinearLayout) findViewById(R.id.card_discount_dots);
        progreessbar = (RoundProgressBar) findViewById(R.id.id_flow_progreessbar);
        settings = (TextView) findViewById(R.id.settings);
        whichFlow = (TextView) findViewById(R.id.which_flow);
        surplusFlow = (TextView) findViewById(R.id.surplus_flow);
        allFlow = (TextView) findViewById(R.id.all_flow);
        addCircle = (ImageView) findViewById(R.id.add_circle);
        userName = (TextView) findViewById(R.id.user_name);
        addPlus = (TextView) findViewById(R.id.add_plus);
        products_text = (TextView) findViewById(R.id.products_text);
        addGb = (TextView) findViewById(R.id.add_gb);
        addMore = (TextView) findViewById(R.id.add_more);
        refreshed = (TextView) findViewById(R.id.refreshed);
        refreshedImage = (ImageView) findViewById(R.id.refreshed_image);
        speakSelect = (ImageView) findViewById(R.id.speak_select);
        callSelect = (ImageView) findViewById(R.id.call_select);
        smsSelect = (ImageView) findViewById(R.id.sms_select);
        user_three = (CircleImageView) findViewById(R.id.user_three);
        fl = (FrameLayout) findViewById(R.id.main_pop);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        mGoneImage = (LinearLayout) findViewById(R.id.image_gone);
        circleFrameLayout = (FrameLayout) findViewById(R.id.prog_frame);
        for_tip_three = (LinearLayout) findViewById(R.id.for_tip_three);
        ll_support = (RelativeLayout) findViewById(R.id.ll_support);
        support_text = (TextView) findViewById(R.id.support_text);
        spendChoose = (ImageView) findViewById(R.id.spend_choose_icon);
        allspendChoose = (ImageView) findViewById(R.id.all_spend_choose_icon);
        spendLayout = (LinearLayout) findViewById(R.id.spend_layout);
        allspendLayout = (LinearLayout) findViewById(R.id.all_spend_layout);
        spendList = (ListView) findViewById(R.id.current_spend_list);
        currentSpentRela = (RelativeLayout) findViewById(R.id.current_spent_rela);
        dataDisk = (LinearLayout) findViewById(R.id.data_disk);
        pointsNum = (TextView) findViewById(R.id.points_num);
        RelativeLayout allCurrentSpentRela = (RelativeLayout) findViewById(R.id.all_current_spent_rela);
        log_out = (TextView) findViewById(R.id.log_out);
        balanceText = (TextView) findViewById(R.id.balance_tv);
        messageNumTv = (TextView) findViewById(R.id.message_num_tv);
        logout_dialog = new LogoutDialog(this);
        logout_dialog.setOnClickLogOutListener(MainActivity.this);
        cancel_diy = (ImageView) findViewById(R.id.cancel_diy);
        cancel_diy.setOnLongClickListener(this);
        menuBtn.setOnClickListener(this);
        backMenu.setOnClickListener(this);
        networkChoose.setOnClickListener(this);
        userPortrait.setOnClickListener(this);
        addCircle.setOnClickListener(this);
        settings.setOnClickListener(this);
        currentSpentRela.setOnClickListener(this);
        notifications.setOnClickListener(this);
        version.setOnClickListener(this);
        allCurrentSpentRela.setOnClickListener(this);
        refreshed_rl.setOnClickListener(this);
        signInRela.setOnClickListener(this);
        addGb.setOnClickListener(this);
        addMore.setOnClickListener(this);
        log_out.setOnClickListener(this);
        callSelect.setOnClickListener(this);
        for_tip_three.setOnClickListener(this);
        products_text.setOnClickListener(this);
        offer_extras.setOnClickListener(this);
        dataDisk.setOnClickListener(this);
        search.setOnClickListener(this);
        capture.setOnClickListener(this);
        ll_support.setOnClickListener(this);
        support_text.setOnClickListener(this);
        itemised_spend.setOnClickListener(this);
        billing_history.setOnClickListener(this);
        speakSelect.setOnClickListener(this);
        smsSelect.setOnClickListener(this);
        currentSpend.setOnClickListener(this);
        usage_history.setOnClickListener(this);

        SpendListAdapter = new CurrentSpendListAdapter(getBaseContext(), 1);
        spendList.setAdapter(SpendListAdapter);
        spendList.setSelector(new ColorDrawable(Color.TRANSPARENT));
        allspendList = (ListView) findViewById(R.id.all_current_spend_list);
        allSpendListAdapter = new CurrentSpendListAdapter(getBaseContext(), 4);
        allspendList.setAdapter(allSpendListAdapter);
        int date = DateUtil.MonthLeftDate() + 1;
        dayLeftText.setText(Html.fromHtml("<b>" + date + " days</b> to reset"));
        myswitch = new MySwitch();

        UserInfo();
        setanim();
        fake(0);
        changeUser(true, UserInfo.getSelect());
        registerBoradcastReceiver();

        Request(TAGUtil.OFFERS_DIYRANKS);
        jump(getIntent());
        startTask();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // DrawerLayout.closeDrawers();
        marks();
        myswitch.proscenium = true;
        if (PreferenceUtils.getBoolean(getBaseContext(), "name", false)) {
            changename();
            PreferenceUtils.setBoolean(getBaseContext(), "name", false);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        myswitch.proscenium = false;
    }

    /**
     * 显示notification未读个数
     **/
    private void marks() {
        myswitch.count = 0;
        DBAdapter db = new DBAdapter(this);
        db.openDb();
        if (db.queryAllRecord() != null) {
            data_notification = db.queryAllRecord();
        }
        for (int i = 0; i < data_notification.size(); i++) {
            if (data_notification.get(i).getCode().equals("0")) {
                myswitch.count++;
            }
        }
        db.closeDb();
        if (myswitch.count == 0) {
            notification_marks.setVisibility(View.GONE);
        } else {
            notification_marks.setVisibility(View.VISIBLE);
            notification_marks.setText(myswitch.count + "");
        }
    }

    /**
     * 切换账户
     */
    private void changeUser(boolean firstin, int select) {
        UserInfo.setSelect(select);
        setempty(false);
        UserInfo.setTime(System.currentTimeMillis() + "");
        changename();
        addAds();
        if (!firstin) {
            Request(TAGUtil.GETUI);
        }
        switch (UserInfo.getListsize()) {
            case 0:
            case 1:
                user_two.setVisibility(View.GONE);
                user_three.setVisibility(View.GONE);
                break;
            case 2:
                user_two.setVisibility(View.VISIBLE);
                user_three.setVisibility(View.GONE);
                if (UserInfo.getSelect() == 0) {
                    user_two.setImageBitmap(UserInfo.getIcon(getBaseContext(),
                            UserInfo.getUserMobile(1)));
                } else {
                    user_two.setImageBitmap(UserInfo.getIcon(getBaseContext(),
                            UserInfo.getUserMobile(0)));
                }
                break;
            default:
                user_two.setVisibility(View.VISIBLE);
                user_three.setVisibility(View.VISIBLE);
                ArrayList<PersonalInfo> list = UserInfo.orderByTime();
                user_two.setImageBitmap(UserInfo.getIcon(getBaseContext(), list
                        .get(1).getUserMobile()));
                user_three.setImageBitmap(UserInfo.getIcon(getBaseContext(), list
                        .get(2).getUserMobile()));
                break;
        }
    }

    private void changename() {
        userName.setText(UserInfo.getUserName() + "'s");
        userPortrait.setImageBitmap(UserInfo.getIcon(getBaseContext()));
        itemised_spend.setText("See " + UserInfo.getUserName()
                + "'s itemised spend");
        lastBillTitle.setText(UserInfo.getUserName() + "'s current spend");
    }

    /**
     * 账户数据
     */
    private void UserInfo() {
        PersonalInfo loginitem = new PersonalInfo();
        String phone = getIntent().getStringExtra("name");
        if (StringUtils.isEmpty(phone)) {
            phone = StringUtils.isEmpty(UserInfo.getUserMobile()) ? "4915298006711"
                    : UserInfo.getUserMobile();
        }
        loginitem.setUserMobile(phone);
        switch (phone.substring(phone.length() - 1)) {
            case "0":
            case "5":
                loginitem.setUserName("David");
                break;
            case "1":
            case "6":
                loginitem.setUserName("Peter Hunt");
                break;
            case "2":
            case "7":
                loginitem.setUserName("Martha Cozza");
                break;
            case "3":
            case "8":
                loginitem.setUserName("Lucy Lin");
                break;
            case "4":
            case "9":
                loginitem.setUserName("Hanna");
                break;
            default:
                break;
        }
        int num = -1;
        for (int i = 0; i < UserInfo.getListsize(); i++) {
            String aa = UserInfo.getUserMobile(i);
            if (phone.equals(aa)) {
                num = i;
                break;
            }
        }
        if (num != -1) {
            UserInfo.setSelect(num);
            UserInfo.setTime(System.currentTimeMillis() + "");
        } else {
            UserInfo.getInstance().SavePersonalInfo(UserInfo.getListsize(),
                    loginitem);
            UserInfo.setSelect(UserInfo.getListsize());
            UserInfo.setListsize(UserInfo.getListsize() + 1);
            UserInfo.setTime(System.currentTimeMillis() + "");
        }
    }

    /**
     * 假数据
     */
    private void fake(int num) {
        PreferenceUtils.setString(getBaseContext(), "Addbalance", "0");
        PreferenceUtils.setBoolean(getBaseContext(), "BugDataOrUnit", false);
        PreferenceUtils.setInt(getBaseContext(), "SignInPoints", 1050);
        PreferenceUtils.setInt(getBaseContext(), "SignInDays", 9);
        PreferenceUtils.setInt(getBaseContext(), "huaweimate8", 399);
        PreferenceUtils.setInt(getBaseContext(), "1GData", 4997);
        PreferenceUtils.setInt(getBaseContext(), "2GData", 4999);

        PreferenceUtils.setLong(getBaseContext(), "SignInTime",
                System.currentTimeMillis() - 86400000);

        DBSignInAdapter db = new DBSignInAdapter(this);
        db.openDb();
        db.delete();
        db.insert("Huawei Mate8", "2016-03-28", -500000, 2);
        db.insert("2GB Data", "2016-06-05", -200, 2);
        db.insert("Huawei Mate8", "2016-03-28", 399, 3);
        db.insert("2GData", "2016-03-28", 4997, 3);
        for (int i = 1; i < 10; i++) {
            db.insert("sign in", DateUtil.getPreviousDate(-i), i, 5, 1);
        }

        pointsNum.setText("1,050 Points");
        if (dialoglist == null) {
            dialoglist = new ArrayList<List<DialogInfo>>();
        } else {
            dialoglist.clear();
        }
        addnotification("", "", "");
        PushReceiver.MyReceiver(new MyReceiver() {

            @Override
            public void onClicked(String channel, String context, String title) {
                addnotification(channel, context, title);
            }
        });

        click = new ClickTwo() {

            @Override
            public void onClicked(Object num, String num1, String num2,
                                  boolean num3) {
                int position = (Integer) num;
                switch (num1) {
                    case "DataUsgNtfctnThrshld1":
                        if (num3) {
                            Intent intent1 = new Intent(MainActivity.this,
                                    MainAddDataActivity.class);
                            intent1.putExtra("type", 0);
                            startActivityForResult(intent1, TAGUtil.tag5);
                            activityAnimationUp();
                        }
                        break;
                    case "RchrgReminder":
                        if (num3) {
                            Intent intent2 = new Intent(MainActivity.this,
                                    RechargeActivity.class);
                            startActivityForResult(intent2, TAGUtil.tag7);
                            activityAnimationUp();
                        }
                        break;
                    case "Content Bundle":
                        if (num3) {
                            Intent intent1 = new Intent(MainActivity.this,
                                    MainAddDataActivity.class);
                            intent1.putExtra("type", 2);
                            startActivityForResult(intent1, TAGUtil.tag5);
                            activityAnimationUp();
                        }
                        break;
                    case "UpSell Bundle":
                        if (num3) {
                            Intent intent4 = new Intent(MainActivity.this,
                                    MainAddDataActivity.class);
                            intent4.putExtra("add", 2);
                            intent4.putExtra("type", 0);
                            startActivityForResult(intent4, TAGUtil.tag5);
                            activityAnimationUp();
                        }
                        break;
                    case "LowBalance":
                        if (num3) {
                            Intent intent2 = new Intent(MainActivity.this,
                                    RechargeActivity.class);
                            intent2.putExtra("number", 20);
                            startActivityForResult(intent2, TAGUtil.tag7);
                            activityAnimationUp();
                        }
                        break;
                    case "DIYNotHave":
                        if (num3) {
                            Intent intent = new Intent(MainActivity.this,
                                    DiyPlansActivity.class);
                            startActivity(intent);
                            activityAnimationOpen();
                        }
                        break;
                    case "Netflix":
                        if (num3) {
                            Intent intent1 = new Intent(MainActivity.this,
                                    MainAddDataActivity.class);
                            intent1.putExtra("type", 3);
                            startActivityForResult(intent1, TAGUtil.tag5);
                            activityAnimationUp();
                        }
                        break;
                    case "InternationalRoamingData":
                        if (num3) {
                            Intent intent1 = new Intent(MainActivity.this,
                                    MainAddDataActivity.class);
                            intent1.putExtra("type", 4);
                            startActivityForResult(intent1, TAGUtil.tag5);
                            activityAnimationUp();
                        }
                        break;
                    case "StarbucksCoupon":
                        if (num3) {
                            Intent intent1 = new Intent(MainActivity.this,
                                    MainAddDataActivity.class);
                            intent1.putExtra("type", 5);
                            startActivityForResult(intent1, TAGUtil.tag5);
                            activityAnimationUp();
                        }
                        break;
                    case "Data Add-on":
                    case "TopUp":
                    case "EuroGift":
                    case "Empty Template":
                        break;
                    default:
                        break;
                }
                removelist(position);
            }
        };
    }

    /**
     * 消息数据
     *
     * @param channel
     * @param context
     * @param title
     */
    private void addnotification(String channel, String context, String title) {

        if (dialoglist.size() <= UserInfo.getListsize()) {
            for (int i = dialoglist.size(); i <= UserInfo.getListsize(); i++) {
                dialoglist.add(new ArrayList<DialogInfo>());
            }
        }
        DialogInfo item = new DialogInfo();
        item.setChannel(channel);
        item.setId(channel);
        item.setTitle(title);
        item.setContent(context);
        item.setConfirm("Yes please");
        item.setCancel("No thanks");
        switch (channel) {
            case "TopUp":
                item.setContent("You topped up <b>€"
                        + PreferenceUtils.getString(getBaseContext(), "Addbalance")
                        + "</b>.<br/> Your credit is now <b>"
                        + UserInfo.getBalanceWithSign() + "</>");
                item.setConfirm("View details");
                item.setCancel("Ok, got it!");
                break;
            case "DIYNotHave":
                item.setContent("Welcome to Smart Pricing.  Would you like to configure your plan?");
                break;
            case "EuroGift":
            case "Data Add-on":
                Request(TAGUtil.QUERY_FREE_UNIT);// 收到通知刷新界面
                item.setCancel("Ok, got it!");
                item.setConfirm("View details");
                break;
            case "DataUsgNtfctnThrshld1":
            case "RchrgReminder":
            case "Content Bundle":
            case "UpSell Bundle":
            case "LowBalance":
            case "Netflix":
            case "InternationalRoamingData":
            case "StarbucksCoupon":
            case "Empty Template":
                Request(TAGUtil.QUERY_FREE_UNIT);// 收到通知刷新界面
                break;
            default:
                break;
        }
        if (!channel.equals(""))
            dialoglist.get(UserInfo.getSelect()).add(item);
        addAds();
    }

    private void removelist(int position) {
        try {
            dialoglist.get(UserInfo.getSelect()).remove(position);
            addAds();
        } catch (IndexOutOfBoundsException e) {

        }
    }

    /**
     * 初始化动画
     */
    private void setanim() {
        // 必须初始化不同实例，否者同一个实例一次只能出现一种状态，改了时间没用
        rotate = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);
        rotateout = AnimationUtils.loadAnimation(getBaseContext(),
                R.anim.rotateout);
        rotatein = AnimationUtils.loadAnimation(getBaseContext(),
                R.anim.rotatein);
        alpha = AnimationUtils.loadAnimation(getBaseContext(), R.anim.alpha);
        alout = AnimationUtils.loadAnimation(getBaseContext(), R.anim.alout);
        alphadelaye = AnimationUtils.loadAnimation(getBaseContext(),
                R.anim.alpha);
        aloutdelaye = AnimationUtils.loadAnimation(getBaseContext(),
                R.anim.alout);
        aloutdelayemore = AnimationUtils.loadAnimation(getBaseContext(),
                R.anim.alout);

        rotateout.setFillAfter(true);// 这句写在xml中不起作用
        rotatein.setFillAfter(true);// 这句写在xml中不起作用
        alphadelaye.setStartOffset(300);
        aloutdelaye.setStartOffset(300);
        aloutdelayemore.setStartOffset(600);
        speakSelect.startAnimation(alout);
        callSelect.startAnimation(aloutdelaye);
        smsSelect.startAnimation(aloutdelayemore);
    }

    /**
     * 进度条
     */
    private void initBar() {
        if (!isNeedRefresh())
            return;
        if (myswitch.select == 0) {
            myswitch.left = Float.valueOf(UserInfo.getLeftData().replace(",",
                    ""));
            myswitch.all = Float
                    .valueOf(UserInfo.getAllData().replace(",", ""));
            myswitch.add = Float
                    .valueOf(UserInfo.getAddData().replace(",", ""));
            myswitch.WhichSelect = "Data";
            myswitch.WhichUnit = "GB";
            surplusFlow.setTextSize(37);
        } else if (myswitch.select == 1) {
            myswitch.left = Float.valueOf(UserInfo.getLeftUnit().replace(",",
                    ""));
            myswitch.all = Float
                    .valueOf(UserInfo.getAllUnit().replace(",", ""));
            myswitch.add = Float
                    .valueOf(UserInfo.getAddUnit().replace(",", ""));
            myswitch.WhichSelect = "Calls";
            myswitch.WhichUnit = "Min";
            surplusFlow.setTextSize(37);
        } else if (myswitch.select == 2) {
            myswitch.left = Float.valueOf(UserInfo.getDiysmsleft().replace(",",
                    ""));
            myswitch.all = Float.valueOf(UserInfo.getDiysmsall().replace(",",
                    ""));
            myswitch.add = 0;

            myswitch.WhichSelect = "Sms";
            myswitch.WhichUnit = "Items";
            surplusFlow.setTextSize(37);
        }
        progreessbar.setProgressth(0, 0);
        if (myswitch.all == 0) {
            myswitch.allangle = myswitch.addangle = 0;
        } else {
            myswitch.allangle = myswitch.left * 100 / myswitch.all;
            myswitch.addangle = myswitch.add * 100 / myswitch.all;
        }
        // 新需求,修改的斑马线
        if (!myswitch.showadddata) {
            myswitch.addangle = 0;
        } else {
            myswitch.showadddata = false;
        }

        myswitch.proadd = myswitch.proall = 0;
        if (handler == null) {
            handler = new Handler();
            run = new Runnable() {

                @Override
                public void run() {
                    if (myswitch.select == 0) {
                        if (myswitch.proall <= myswitch.allangle) {
                            whichFlow.setText(myswitch.WhichSelect);
                            surplusFlow.setText(StringUtils.formatDecimalFloat(
                                    myswitch.proall * myswitch.all / 100, 2));
                            allFlow.setText("of " + myswitch.all
                                    + myswitch.WhichUnit + " left");
                            progreessbar.setProgress(myswitch.proall++);
                        } else if (myswitch.proadd <= myswitch.addangle) {
                            surplusFlow.setText(myswitch.left + "");
                            progreessbar.setProgressth(0, myswitch.proadd++);
                        } else {
                            surplusFlow.setText(myswitch.left + "");
                            progreessbar.setProgressth(myswitch.proadd
                                    - myswitch.addangle, myswitch.proadd++);
                        }
                        if (myswitch.proall <= myswitch.allangle
                                || (myswitch.addangle >= 0 && myswitch.proadd <= myswitch.allangle)) {
                            handler.postDelayed(run, 5);
                        } else if (myswitch.addangle > 0) {
                            myswitch.addangle = 0;
                            handler.postDelayed(run, 5000);
                        }
                    } else if (myswitch.select == 1) {
                        if (myswitch.proall <= myswitch.allangle) {
                            whichFlow.setText(myswitch.WhichSelect);
                            surplusFlow.setText(StringUtils.formatDecimalFloat(
                                    myswitch.proall * myswitch.all / 100, 0));
                            allFlow.setText("of " + UserInfo.getAllUnit()
                                    + myswitch.WhichUnit + " left");
                            progreessbar.setProgress(myswitch.proall++);
                        } else if (myswitch.proadd <= myswitch.addangle) {
                            surplusFlow.setText(UserInfo.getLeftUnit());
                            progreessbar.setProgressth(0, myswitch.proadd++);
                        } else {
                            surplusFlow.setText(UserInfo.getLeftUnit());
                            progreessbar.setProgressth(myswitch.proadd
                                    - myswitch.addangle, myswitch.proadd++);
                        }
                        if (myswitch.proall <= myswitch.allangle
                                || (myswitch.addangle >= 0 && myswitch.proadd <= myswitch.allangle)) {
                            handler.postDelayed(run, 5);
                        } else if (myswitch.addangle > 0) {
                            myswitch.addangle = 0;
                            handler.postDelayed(run, 5000);
                        }
                    } else if (myswitch.select == 2) {
                        if (myswitch.proall <= myswitch.allangle) {
                            whichFlow.setText(myswitch.WhichSelect);
                            surplusFlow.setText(StringUtils.formatDecimalFloat(
                                    myswitch.proall * myswitch.all / 100, 0));
                            allFlow.setText("of " + UserInfo.getDiysmsall()
                                    + myswitch.WhichUnit + " left");
                            progreessbar.setProgress(myswitch.proall++);
                        }
                        if (myswitch.proall <= myswitch.allangle)
                            handler.postDelayed(run, 5);
                    }
                }
            };
        } else {
            handler.removeCallbacks(run);
        }
        handler.postDelayed(run, 5);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_btn:
                DrawerLayout.openDrawer(Gravity.RIGHT);
                break;
            case R.id.back_menu:
                DrawerLayout.closeDrawers();
                break;
            case R.id.network_choose:
                if (networkLayout.isShown()) {
                    networkLayout.setVisibility(View.GONE);
                    networkChooseIcon.setImageResource(R.drawable.down_arrows);
                } else {
                    networkLayout.setVisibility(View.VISIBLE);
                    networkChooseIcon.setImageResource(R.drawable.up_arrows);
                }
                break;
            case R.id.add_circle:
                showdata(true);
                break;
            case R.id.user_portrait:
                Intent intent0 = new Intent(this, MainSelectServiceActivity.class);
                intent0.putExtra("select", UserInfo.getSelect());
                startActivityForResult(intent0, TAGUtil.tag2);
                activityAnimationUp();
                break;
            case R.id.refreshed_rl:
                myswitch.manualRefresh = true;
                Request(TAGUtil.QUERY_FREE_UNIT);
                refreshedImage.startAnimation(rotate);
                break;
            case R.id.settings:
                Intent intent = new Intent(MainActivity.this,
                        SettingsActivity.class);
                startActivityForResult(intent, 1001);
                activityAnimationOpen();
                break;
            case R.id.current_spent_rela:
                if (spendLayout.isShown()) {
                    spendLayout.setVisibility(View.GONE);
                    spendChoose.setImageResource(R.drawable.down_arrows);
                } else {
                    spendLayout.setVisibility(View.VISIBLE);
                    spendChoose.setImageResource(R.drawable.up_arrows);
                }
                break;
            case R.id.all_current_spent_rela:
                // if (allspendLayout.isShown()) {
                // allspendLayout.setVisibility(View.GONE);
                // allspendChoose.setImageResource(R.drawable.down_arrows);
                // } else {
                // allspendLayout.setVisibility(View.VISIBLE);
                // allspendChoose.setImageResource(R.drawable.up_arrows);
                // }
                break;
            case R.id.add_gb:
                if (!PreferenceUtils.getBoolean(this, "haveDiy")) {
                    mydialog(3);
                    return;
                }
                Intent intent1 = new Intent(this, MainAddDataActivity.class);
                intent1.putExtra("add", 2);
                intent1.putExtra("type", myswitch.select);
                startActivityForResult(intent1, TAGUtil.tag5);
                activityAnimationUp();
                break;
            case R.id.add_more:
                if (!PreferenceUtils.getBoolean(this, "haveDiy")) {
                    mydialog(4);
                    return;
                }
                Intent intent2 = new Intent(this, MainAddDataActivity.class);
                intent2.putExtra("type", myswitch.select);
                startActivityForResult(intent2, TAGUtil.tag5);
                activityAnimationUp();
                break;
            case R.id.sign_in_rela:
                Intent intent4 = new Intent(this, SignMainActivity.class);
                startActivityForResult(intent4, TAGUtil.tag9);
                activityAnimationOpen();
                break;
            case R.id.capture:
                Intent intent10 = new Intent(this, CaptureActivity.class);
                startActivityForResult(intent10, TAGUtil.tag10);
                activityAnimationOpen();
                break;
            case R.id.search:
                Intent intent11 = new Intent(this, SearchMainActivity.class);
                startActivityForResult(intent11, TAGUtil.tag11);
                activityAnimationUp();
                break;
            case R.id.for_tip_three:
                Intent intent3 = new Intent(this, RechargeActivity.class);
                startActivityForResult(intent3, TAGUtil.tag7);
                activityAnimationUp();
                break;
            case R.id.log_out:
                DrawerLayout.closeDrawers();
                logout_dialog.show();
                break;

            case R.id.current_spend:
                Intent intent5 = new Intent(this, BillsActivity.class);
                startActivity(intent5);
                activityAnimationOpen();
                break;
            case R.id.notifications:
                Intent intent6 = new Intent(this, NotificationActivity.class);
                startActivity(intent6);
                activityAnimationOpen();
                break;
            case R.id.version:
                Intent intent7 = new Intent(this, SettingsVersionActivity.class);
                startActivity(intent7);
                activityAnimationOpen();
                break;
            case R.id.data_disk:
            case R.id.products_text:
                if (!PreferenceUtils.getBoolean(this, "haveDiy")) {
                    mydialog(2);
                    return;
                }
                Intent intent9 = new Intent(this, ProductsServiceActivity.class);

                // if (quickcheckinfo != null) {
                // List<OfferInstValue> offerInstValues = quickcheckinfo
                // .getOfferInstList();
                // for (OfferInstValue offerInstValue : offerInstValues) {
                // if (offerInstValue.getOfferType().equals("D")) {
                // float price = offerInstValue.getPeriodicFee()
                // .getCurrencyValue() / 10000;
                // DecimalFormat decimalFormat = new DecimalFormat(".00");//
                // 构造方法的字符格式这里如果小数不足2位,会以0补足.
                // String p = decimalFormat.format(price);// format
                // HashMap<String, Object> map = new HashMap<String, Object>();
                // map.put("offerName", offerInstValue.getOfferName());
                // map.put("offerPrice", p);
                // intent9.putExtra("dataMap", map);
                // break;
                // }
                // }
                // }
                if (PreferenceUtils.getBoolean(this, "haveDiy")) {
                    HashMap<String, Object> map = new HashMap<String, Object>();
                    double money = 0;
                    int unit = Integer.valueOf(PreferenceUtils.getString2(this,
                            "moneyUnit"));
                    money = money + PreferenceUtils.getLong(this, "money", 01)
                            * Math.pow(10, -unit);
                    String datava = PreferenceUtils.getString(this, "C_DATA_LEVEL");
                    if (datava.equals("")) {
                        datava = "0";
                        map.put("offerName", "Red " + UserInfo.getDiydataall()
                                + "GB" + " Package");
                    } else {

                        map.put("offerName",
                                "Red "
                                        + DiyUtils.getDataValue(Integer
                                        .parseInt(datava)) + " Package");
                    }
                    map.put("offerPrice", Double.toString(money));
                    intent9.putExtra("dataMap", map);
                }
                intent9.putExtra("freeUnitItem", (Serializable) freeUnitItem);
                startActivity(intent9);
                activityAnimationOpen();
                break;
            case R.id.offer_extras:
                Intent intent8 = new Intent(this,
                        SettingsOffersAndExtrarsActivity.class);
                startActivity(intent8);
                activityAnimationOpen();
                break;
            case R.id.support_text:
            case R.id.ll_support:
                Intent supportIntent = new Intent(this, SupportActivity.class);
                String num = messageNumTv.getText().toString();
                if (!StringUtils.isEmpty(num) && StringUtils.isNumber(num)) {
                    supportIntent.putExtra("messageNum", Integer.parseInt(num));
                    messageNumTv.setText("");
                    messageNumTv.setVisibility(View.GONE);
                }
                startActivity(supportIntent);
                activityAnimationUp();
                break;
            case R.id.itemised_spend:
                Intent intent13 = new Intent(this, ItemisedBillActivity.class);
                startActivity(intent13);
                activityAnimationOpen();
                break;
            case R.id.billing_history:
                Intent intent12 = new Intent(this, BillsActivity.class);
                startActivity(intent12);
                activityAnimationOpen();
                break;
            case R.id.speak_select:
                if (myswitch.select == 0)
                    return;
                if (myswitch.select == 2) {
                    addCircle.setVisibility(View.VISIBLE);
                    addPlus.setVisibility(View.VISIBLE);
                    addCircle.startAnimation(alout);
                    addPlus.startAnimation(alout);
                }
                speakSelect.setImageResource(R.drawable.speak_select2);
                callSelect.setImageResource(R.drawable.call_select);
                smsSelect.setImageResource(R.drawable.sms_select);
                addGb.setText("1GB");
                myswitch.select = 0;
                myswitch.manualRefresh = true;
                initBar();
                break;
            case R.id.call_select:
                if (myswitch.select == 1)
                    return;
                if (myswitch.select == 2) {
                    addCircle.setVisibility(View.VISIBLE);
                    addPlus.setVisibility(View.VISIBLE);
                    addCircle.startAnimation(alout);
                    addPlus.startAnimation(alout);
                }
                speakSelect.setImageResource(R.drawable.speak_select);
                callSelect.setImageResource(R.drawable.call_select2);
                smsSelect.setImageResource(R.drawable.sms_select);
                addGb.setText("500Min");
                myswitch.select = 1;
                myswitch.manualRefresh = true;
                initBar();
                break;
            case R.id.sms_select:
                if (myswitch.select != 2) {
                    addPlus.clearAnimation();
                    addCircle.setVisibility(View.GONE);
                    addPlus.setVisibility(View.GONE);
                    addGb.setVisibility(View.GONE);
                    addMore.setVisibility(View.GONE);
                    myswitch.select = 2;
                    myswitch.manualRefresh = true;
                    initBar();
                }
                speakSelect.setImageResource(R.drawable.speak_select);
                callSelect.setImageResource(R.drawable.call_select);
                smsSelect.setImageResource(R.drawable.sms_select2);
                break;
            case R.id.usage_history:
                if (!PreferenceUtils.getBoolean(this, "haveDiy")) {
                    mydialog(5);
                    return;
                }
                Intent intent14 = new Intent(this, NetWorkUsageActivity.class);
                startActivity(intent14);
                activityAnimationOpen();
                break;

            default:
                break;
        }
    }

    private void showdata(boolean isclose) {
        if (addGb.isShown()) {
            if (isclose) {
                addGb.setVisibility(View.GONE);
                addMore.setVisibility(View.GONE);
                addGb.startAnimation(alphadelaye);
                addMore.startAnimation(alpha);
                addPlus.startAnimation(rotatein);
            }
        } else {
            addGb.setVisibility(View.VISIBLE);
            addMore.setVisibility(View.VISIBLE);
            addGb.startAnimation(alout);
            addMore.startAnimation(aloutdelaye);
            addPlus.startAnimation(rotateout);
        }
    }

    private void addAds() {
        dots = new ArrayList<View>();
        dots.clear();
        dotsLayout.removeAllViews();

        for (int i = 0; i < dialoglist.get(UserInfo.getSelect()).size(); i++) {
            ImageView dotsView = new ImageView(getBaseContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.setMargins(5, 0, 5, 5);
            dotsView.setLayoutParams(params);
            dotsView.setBackgroundResource(R.drawable.banner);
            if (0 == i) {
                dotsView.setBackgroundResource(R.drawable.banner_icon);
            }
            dotsLayout.addView(dotsView);
            dots.add(dotsView);
        }
        if (newsAdapter == null) {
            newsAdapter = new MyPagerAdapter(MainActivity.this,
                    dialoglist.get(UserInfo.getSelect()), newsPager);
        } else {
            newsAdapter.setList(dialoglist.get(UserInfo.getSelect()));
        }
        newsPager.setAdapter(newsAdapter);
        newsAdapter.setListener(click);
        newsPager.setOnPageChangeListener(new MyPageChangeListener());
        newsPager
                .setCurrentItem(dialoglist.get(UserInfo.getSelect()).size() - 1);
    }

    /**
     * 功能引导pop
     */
    private void showPop() {
        if (mainPop == null) {
            mainPop = View.inflate(MainActivity.this, R.layout.activity_tip,
                    null);
            mainPop.setOnTouchListener(new OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    return true;
                }
            });
            Button btnNext = (Button) mainPop.findViewById(R.id.ntxt_tip);
            Button close = (Button) mainPop.findViewById(R.id.close);
            final TextView tv_tip_title = (TextView) mainPop
                    .findViewById(R.id.tv_tip_title);
            TextView tip_user_name = (TextView) mainPop
                    .findViewById(R.id.tip_user_name);
            final RelativeLayout linea_dialog = (RelativeLayout) mainPop
                    .findViewById(R.id.dialog_one);
            final LinearLayout tip_one_linear = (LinearLayout) mainPop
                    .findViewById(R.id.tip_one_linear);
            final LinearLayout tip_two_image = (LinearLayout) mainPop
                    .findViewById(R.id.image_linear);
            final LinearLayout tip_two_linear = (LinearLayout) mainPop
                    .findViewById(R.id.tip_two_linear);
            final RelativeLayout tip_three_circle = (RelativeLayout) mainPop
                    .findViewById(R.id.prog_frame1);
            final LinearLayout tip_three_linear = (LinearLayout) mainPop
                    .findViewById(R.id.tip_three_linear);
            final LinearLayout tip_four_linear = (LinearLayout) mainPop
                    .findViewById(R.id.tip_four_linear);
            final RelativeLayout tip_four_item = (RelativeLayout) mainPop
                    .findViewById(R.id.tip_four_item);
            Button tip_two_next = (Button) mainPop
                    .findViewById(R.id.tip_two_next);
            Button tip_two_close = (Button) mainPop
                    .findViewById(R.id.tip_two_close);
            Button tip_three_next = (Button) mainPop
                    .findViewById(R.id.tip_three_next);
            Button tip_three_close = (Button) mainPop
                    .findViewById(R.id.tip_three_close);
            Button tip_four_start = (Button) mainPop
                    .findViewById(R.id.tip_four_start);

            tip_user_name.setText("Hello " + UserInfo.getUserName());
            // ------------tip four onClick start-----------------------------

            tip_four_start.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    currentSpentRela.setVisibility(View.VISIBLE);
                    fl.removeView(mainPop);
                }
            });

            // ------------tip three onClick start-----------------------------

            tip_three_next.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    tv_tip_title.setText(R.string.tip_two_oneee);
                    for_tip_three.setVisibility(View.VISIBLE);
                    circleFrameLayout.setVisibility(View.VISIBLE);
                    speakSelect.setVisibility(View.VISIBLE);
                    callSelect.setVisibility(View.VISIBLE);
                    smsSelect.setVisibility(View.VISIBLE);
                    ll_support.setVisibility(View.VISIBLE);
                    tip_four_linear.setVisibility(View.VISIBLE);
                    tip_four_item.setVisibility(View.VISIBLE);
                    tip_three_circle.setVisibility(View.GONE);
                    tip_three_linear.setVisibility(View.GONE);
                    currentSpentRela.setVisibility(View.INVISIBLE);
                    userPortrait.setVisibility(View.VISIBLE);
                    mGoneImage.setVisibility(View.VISIBLE);
                }
            });
            tip_three_close.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    for_tip_three.setVisibility(View.VISIBLE);
                    circleFrameLayout.setVisibility(View.VISIBLE);
                    speakSelect.setVisibility(View.VISIBLE);
                    callSelect.setVisibility(View.VISIBLE);
                    smsSelect.setVisibility(View.VISIBLE);
                    ll_support.setVisibility(View.VISIBLE);
                    userPortrait.setVisibility(View.VISIBLE);
                    mGoneImage.setVisibility(View.VISIBLE);
                    fl.removeView(mainPop);
                }
            });

            // ------------tip two onClick start-----------------------------
            tip_two_next.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    tv_tip_title.setText(R.string.tip_two_onee);
                    circleFrameLayout.setVisibility(View.GONE);
                    for_tip_three.setVisibility(View.GONE);
                    speakSelect.setVisibility(View.GONE);
                    callSelect.setVisibility(View.GONE);
                    smsSelect.setVisibility(View.GONE);
                    ll_support.setVisibility(View.GONE);
                    tip_two_image.setVisibility(View.GONE);
                    tip_two_linear.setVisibility(View.GONE);
                    tip_three_circle.setVisibility(View.VISIBLE);
                    tip_three_linear.setVisibility(View.VISIBLE);

                }
            });
            tip_two_close.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    mGoneImage.setVisibility(View.VISIBLE);
                    for_tip_three.setVisibility(View.VISIBLE);
                    circleFrameLayout.setVisibility(View.VISIBLE);
                    userPortrait.setVisibility(View.VISIBLE);

                    fl.removeView(mainPop);
                }
            });
            // ------tip one onClick start-----------------------------
            btnNext.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    tv_tip_title.setText(R.string.tip_two_one);
                    mGoneImage.setVisibility(View.GONE);
                    userPortrait.setVisibility(View.INVISIBLE);
                    tip_one_linear.setVisibility(View.GONE);
                    linea_dialog.setVisibility(View.GONE);
                    tip_two_image.setVisibility(View.VISIBLE);
                    tip_two_linear.setVisibility(View.VISIBLE);
                    newsPager.setVisibility(View.VISIBLE);
                    scrollView.setScrollY(getResources().getDimensionPixelSize(
                            R.dimen.view_scrollx));
                }
            });
            close.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    newsPager.setVisibility(View.VISIBLE);
                    fl.removeView(mainPop);
                }
            });
            // -----------tip one onClick start-----------------------------
            fl.addView(mainPop);
        }

    }

    /**
     * 当ViewPager中页面的状态发生改变时调用
     */
    private class MyPageChangeListener implements OnPageChangeListener {
        private int oldPosition = 0;

        @Override
        public void onPageSelected(int position) {
            dots.get(oldPosition).setBackgroundResource(R.drawable.banner);
            dots.get(position).setBackgroundResource(R.drawable.banner_icon);
            oldPosition = position;
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == TAGUtil.tag9) {

            String text = StringUtils
                    .formatDecimalFloat(PreferenceUtils.getInt(
                            getBaseContext(), "SignInPoints"), 0)
                    + " Points";
            if (!pointsNum.getText().equals(text)) {
                pointsNum.setText(text);
                Request(TAGUtil.QUERY_FREE_UNIT);
            }
        } else if (requestCode == TAGUtil.tag11) {
            if (PreferenceUtils.getBoolean(getBaseContext(), "BugDataOrUnit")) {
                Request(TAGUtil.QUERY_FREE_UNIT);
                PreferenceUtils.setBoolean(getBaseContext(), "BugDataOrUnit",
                        false);
            }
        } else if (requestCode == TAGUtil.tag5) {
            if (resultCode == TAGUtil.tag3) {
                SuccessDialog dialog = new SuccessDialog(this);
                dialog.settext(data.getStringExtra("message"));
                dialog.show();
                Request(TAGUtil.QUERY_FREE_UNIT);
                int type = data.getIntExtra("type", -1);
                String text = data.getStringExtra("messageTwo");
                float getadd = -1;
                if (type == 1) {
                    getadd = Float.valueOf(UserInfo.getAddUnit().replace(",",
                            ""));
                } else {
                    getadd = Float.valueOf(UserInfo.getAddData().replace(",",
                            ""));
                }
                float all = Float.valueOf(UserInfo.getAllData()
                        .replace(",", ""));
                if (all != 0 && getadd == 0) {
                    myswitch.showadddata = true;
                }
                if (text != null) {
                    addnotification("Data Add-on", text, "Congratulations!");
                }
            } else {
                if (!PreferenceUtils.getString(getBaseContext(), "Addbalance")
                        .equals("0")) {
                    Request(TAGUtil.QUERY_FREE_UNIT);
                }
            }
        }

        if (resultCode == TAGUtil.tag1) {
            changeUser(false, data.getIntExtra("select", 0));
            Request(TAGUtil.QUERY_FREE_UNIT);
        } else if (resultCode == TAGUtil.tag8) {
            SuccessDialog dialog = new SuccessDialog(this);
            dialog.settext("Your payment was successful");
            dialog.show();
            Request(TAGUtil.QUERY_FREE_UNIT);
        }
        if (resultCode == 1001) {
            userName.setText(UserInfo.getUserName() + "'s");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private boolean exiteFlag = false;

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        // 监听物理返回键
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_UP) {
            if (!exiteFlag) {
                exiteFlag = true;
                Toast.makeText(MainActivity.this,
                        R.string.again_press_exite_str, Toast.LENGTH_LONG)
                        .show();
                timeHandler.sendEmptyMessageDelayed(0, 3 * 1000);
            } else {
                // 退出软件
                System.exit(0);
            }
        }
        return true;
    }

    private final Handler timeHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            exiteFlag = false;
            super.handleMessage(msg);
        }
    };

    @Override
    public void onclickYes() {
        Intent it = new Intent(MainActivity.this, LoginActivity.class);
        it.putExtra("code", 1);
        startActivity(it);
        logout_dialog.dismiss();
        finish();
    }

    public void registerBoradcastReceiver() {
        IntentFilter myIntentFilter = new IntentFilter();
        myIntentFilter.addAction("com.vodafone.set_pic_sucess");
        myIntentFilter.addAction("offer_diy_successed");
        // 注册广播
        MainActivity.this.registerReceiver(mBroadcastReceiver, myIntentFilter);
    }

    private void unRegisterBoradcastReceiver() {
        MainActivity.this.unregisterReceiver(mBroadcastReceiver);
    }

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("com.vodafone.set_pic_sucess".equals(action)) {
                Bitmap bitmap = intent.getParcelableExtra("bitmap");
                userPortrait.setImageBitmap(bitmap);
            } else if ("offer_diy_successed".equals(action)) {
                Request(TAGUtil.QUERY_FREE_UNIT);
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unRegisterBoradcastReceiver();
        taskTimer.cancel();
    }

    private void Request(int num) {
        switch (num) {
            case TAGUtil.QUICK_CHECK:
                IRequest.get(num, URLs.QUICKCHECK, RequestJSon.ReferInfo(), this);
                break;
            case TAGUtil.DELETE:
                IRequest.post(
                        num,
                        URLs.REMOVEOPTIONAL,
                        RequestJSon.removeOptional("10102",
                                PreferenceUtils.getString(this, "OfferInstId")),
                        this);
                break;
            case TAGUtil.GETUI:
                if (!StringUtils.isEmpty(PreferenceUtils.getString(
                        getBaseContext(), "CID"))) {
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("mobile", UserInfo.getUserMobile());
                    params.put("deviceToken",
                            PreferenceUtils.getString(getBaseContext(), "CID"));
                    params.put("fromType", 0);
                    IRequest.get(num, URLs.GETUI, params, this);
                }
                break;
            case TAGUtil.QUERY_FREE_UNIT:
                IRequest.post(URLs.QUERYFREEUNIT, num, RequestJSon.QueryFreeUnit(),
                        this);
                break;
            case TAGUtil.QUERYCUSTOMERINFO:
                IRequest.post(URLs.QUERYCUSTOMERINFO, num,
                        RequestJSon.QueryCustomerInfo(), this);
                break;
            case TAGUtil.BALANCEINFOTWO:
                IRequest.get(num, URLs.BALANCEINFO, RequestJSon.ReferInfo(), this);
                break;
            case TAGUtil.OFFERS_DIYRANKS:
                IRequest.get(num, URLs.OFFERS_DIYRANKS,
                        RequestJSon.OffersAndDIYRanks(), this);
                break;
        }
    }

    @Override
    public void requestSuccess(Object tag, String json) {
        switch ((Integer) tag) {
            case TAGUtil.QUICK_CHECK:
                initLastData();// 记录上次数据
                // 清空DIY套餐 本地数据 蔡雨成
                clearData();
                refreshedImage.clearAnimation();
                refreshed.setText("Refreshed at "
                        + DateUtil.ConverToString(new Date(), "HH:mm"));
                if (JsonUtils.getHeadCode(json).equals("0")) {
                    quickcheckinfo = JsonUtils.getBodyObject(json,
                            QuickCheckInfo.class);
                    if (quickcheckinfo == null) {
                        setempty(false);
                    } else {
                        DealQuickCheck();
                    }
                } else {
                    setempty(false);
                }
                if (!PreferenceUtils.getString(getBaseContext(), "Addbalance")
                        .equals("0")) {
                    addnotification("TopUp", "", "Congratulations!");
                    PreferenceUtils.setString(getBaseContext(), "Addbalance", "0");
                }
                refreshDIYdata();
                break;

            case TAGUtil.DELETE:
                if (JsonUtils.getHeadCode(json).equals("0")) {
                    // ToastUtil.showToast(this, "退订成功");
                    // 清空DIY套餐 本地数据 蔡雨成
                    clearData();
                    Request(TAGUtil.QUERY_FREE_UNIT);
                } else {
                    // ToastUtil.showToast(this, "退订失败");
                }
                break;
            case TAGUtil.QUERY_FREE_UNIT:
                DebugLog.i("Response.Listener",
                        "xml2JSON-->" + JsonUtils.xml2JSON(json), true);
                initLastData();// 记录上次数据
                // 清空DIY套餐 本地数据 蔡雨成
                clearData();
                refreshedImage.clearAnimation();
                refreshed.setText("Refreshed at "
                        + DateUtil.ConverToString(new Date(), "HH:mm"));

                int i = json.indexOf("</cbs:ResultCode>");
                if (i != -1) {
                    if (json.charAt(i - 1) == '0') {
                        freeUnitItem = JsonUtils.getFreeUnitItem(json);
                        if (freeUnitItem == null) {
                            setempty(false);
                        } else {
                            if (DiyUtilsFromId.isNull()) {
                                Request(TAGUtil.OFFERS_DIYRANKS);
                            } else {
                                DealFreeUnitItem();
                            }
                        }
                    } else {
                        setempty(false);
                    }
                } else {
                    setempty(false);
                }
                Request(TAGUtil.BALANCEINFOTWO);
                refreshDIYdata();
                break;
            case TAGUtil.QUERYCUSTOMERINFO:
                String src = JsonUtils.xml2JSON(json).toString()
                        .replaceAll("(?:bcs:|bcc:|cbs:|soapenv:|xmlns:)", "");
                DebugLog.i("Response.Listener",
                        "xml2JSON-->" + JsonUtils.xml2JSON(json), true);
                DebugLog.i("string2", "string3-->" + src);
                try {
                    JSONArray jb = new JSONObject(src).getJSONObject("Envelope")
                            .getJSONObject("Body")
                            .getJSONObject("QueryCustomerInfoResultMsg")
                            .getJSONObject("QueryCustomerInfoResult")
                            .getJSONObject("Subscriber")
                            .getJSONArray("SupplementaryOffering");
                    List<Envelope.EnvelopeBean.BodyBean.QueryCustomerInfoResultMsgBean.QueryCustomerInfoResultBean.SubscriberBean.SupplementaryOfferingBean> aBodyBean = JSON
                            .parseArray(
                                    jb.toString(),
                                    Envelope.EnvelopeBean.BodyBean.QueryCustomerInfoResultMsgBean.QueryCustomerInfoResultBean.SubscriberBean.SupplementaryOfferingBean.class);
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            case TAGUtil.BALANCEINFOTWO:
                if (JsonUtils.getHeadCode(json).equals("0")) {
                    QuickCheckInfo quickcheckinfo = JsonUtils.getBodyObject(json,
                            QuickCheckInfo.class);
                    if (quickcheckinfo != null) {
                        UserInfo.setBalanceWithSign(UnitUtil
                                .getBalance(quickcheckinfo.getBalanceInfoList()));
                        balanceText.setText(UserInfo.getBalanceWithSign());
                    }

                    if (!PreferenceUtils.getString(getBaseContext(), "Addbalance")
                            .equals("0")) {
                        addnotification("TopUp", "", "Congratulations!");
                        PreferenceUtils.setString(getBaseContext(), "Addbalance",
                                "0");
                    }
                }
                break;
            case TAGUtil.OFFERS_DIYRANKS:
                DiyUtilsFromId.setDiyUtil2(JSON.parseObject(json, DiyUtils2.class));
                NationalUtils.setNationalUtil(JSON.parseObject(json,
                        DiyUtils2.class));
                Request(TAGUtil.QUERY_FREE_UNIT);
                break;
        }
    }

    @Override
    public void requestError(Object tag, VolleyError e) {
        switch ((Integer) tag) {
            case TAGUtil.QUICK_CHECK:
            case TAGUtil.QUERY_FREE_UNIT:
                refreshedImage.clearAnimation();
                refreshed.setText("Refreshed at "
                        + DateUtil.ConverToString(new Date(), "HH:mm"));
                setempty(true);
                break;
            case TAGUtil.OFFERS_DIYRANKS:
                Request(TAGUtil.QUERY_FREE_UNIT);
                break;
        }

    }

    private void clearData() {
        PreferenceUtils.delString(this, "haveDiy");
        PreferenceUtils.setLong(this, "money", 1l);
        PreferenceUtils.delString(this, "moneyUnit");
        PreferenceUtils.delString(this, "C_DATA_LEVEL");
        PreferenceUtils.delString(this, "C_UNIT_LEVEL");
        PreferenceUtils.delString(this, "OfferInstId");
        initdata();
    }

    private void setempty(boolean showdialog) {
        initdata();
        UserInfo.setBalance("0.00");
        balanceText.setText(UserInfo.getBalanceWithSign());
        initBar();
        if (showdialog) {
            mydialog(1);
        }
    }

    private void initdata() {
        UserInfo.setAllData("0");
        UserInfo.setLeftData("0");
        UserInfo.setAddData("0");
        UserInfo.setAllUnit("0");
        UserInfo.setLeftUnit("0");
        UserInfo.setAddUnit("0");
        UserInfo.setDiydataall("0.00");
        UserInfo.setDiydataleft("0.00");
        UserInfo.setDiyunitall("0");
        UserInfo.setDiyunitleft("0");
        UserInfo.setDiysmsall("0");
        UserInfo.setDiysmsleft("0");
    }

    private void DealQuickCheck() {
        UserInfo.setBalanceWithSign(UnitUtil.getBalance(quickcheckinfo
                .getBalanceInfoList()));
        balanceText.setText(UserInfo.getBalanceWithSign());
        double alldata = 0, leftdata = 0, adddata = 0, diydataall = 0, diydataleft = 0;
        double allunit = 0, leftunit = 0, addunit = 0, diyunitall = 0, diyunitleft = 0;

        for (ConsumeAndQuota item : quickcheckinfo.getComsumeAndQuotaList()) {
            if (item.getId().contains("Data")) {
                alldata = alldata
                        + UnitUtil.getValue(item.getTotalValue(), "GB");
                leftdata = leftdata
                        + UnitUtil.getValue(item.getLeftValue(), "GB");
                if (item.getId().contains("DIY_Data")) {
                    diydataall = diydataall
                            + UnitUtil.getValue(item.getTotalValue(), "GB");
                    diydataleft = diydataleft
                            + UnitUtil.getValue(item.getLeftValue(), "GB");
                } else {
                    adddata = adddata
                            + UnitUtil.getValue(item.getTotalValue(), "GB");
                }
            }
            if (item.getId().contains("DIY_Units")) {
                allunit = allunit
                        + UnitUtil.getValue(item.getTotalValue(), "One");
                leftunit = leftunit
                        + UnitUtil.getValue(item.getLeftValue(), "One");
                diyunitall = diyunitall
                        + UnitUtil.getValue(item.getTotalValue(), "One");
                diyunitleft = diyunitleft
                        + UnitUtil.getValue(item.getLeftValue(), "One");
            }
            if (item.getId().contains("C_National_Voie")) {
                allunit = allunit
                        + UnitUtil.getValue(item.getTotalValue(), "Minute");
                leftunit = leftunit
                        + UnitUtil.getValue(item.getLeftValue(), "Minute");
                addunit = addunit
                        + UnitUtil.getValue(item.getTotalValue(), "Minute");
            }
        }
        veryChange(alldata, leftdata, allunit, leftunit, -1, -1);
        UserInfo.setAllData(StringUtils.formatDecimalFloat(alldata, 2));
        UserInfo.setLeftData(StringUtils.formatDecimalFloat(leftdata, 2));

        UserInfo.setAddData(StringUtils.formatDecimalFloat(adddata, 2));

        UserInfo.setAllUnit(StringUtils.formatDecimalFloat(allunit, 0));
        UserInfo.setLeftUnit(StringUtils.formatDecimalFloat(leftunit, 0));
        UserInfo.setAddUnit(StringUtils.formatDecimalFloat(addunit, 0));

        UserInfo.setDiydataall(StringUtils.formatDecimalFloat(diydataall, 2));
        UserInfo.setDiydataleft(StringUtils.formatDecimalFloat(diydataleft, 2));

        UserInfo.setDiyunitall(StringUtils.formatDecimalFloat(diyunitall, 0));
        UserInfo.setDiyunitleft(StringUtils.formatDecimalFloat(diyunitleft, 0));
        initBar();

        // 判断是否有DIY基础套餐 蔡雨成
        if (quickcheckinfo.getOfferInstList().size() != 0) {
            for (int i = 0; i < quickcheckinfo.getOfferInstList().size(); i++) {
                if (!StringUtils.isEmpty(quickcheckinfo.getOfferInstList()
                        .get(i).getOfferId())) {
                    if ("10102".equals(quickcheckinfo.getOfferInstList().get(i)
                            .getOfferId())) {
                        PreferenceUtils.setBoolean(this, "haveDiy", true);
                        PreferenceUtils.setLong(this, "money", quickcheckinfo
                                .getOfferInstList().get(i).getPeriodicFee()
                                .getCurrencyValue());
                        PreferenceUtils.setString(this, "effectiveDate",
                                quickcheckinfo.getOfferInstList().get(i)
                                        .getEffectiveDate().getUtcDateTime());
                        PreferenceUtils.setString(this, "expireDate",
                                quickcheckinfo.getOfferInstList().get(i)
                                        .getExpireDate().getUtcDateTime());

                        PreferenceUtils.setString(this, "moneyUnit",
                                quickcheckinfo.getOfferInstList().get(i)
                                        .getPeriodicFee().getCurrencyUnit());
                        PreferenceUtils.setString(this, "OfferInstId",
                                quickcheckinfo.getOfferInstList().get(i)
                                        .getOfferInstId());
                        for (int j = 0; j < quickcheckinfo.getOfferInstList()
                                .get(i).getInstParameterValueList().size(); j++) {
                            if ("C_DATA_LEVEL".equals(quickcheckinfo
                                    .getOfferInstList().get(i)
                                    .getInstParameterValueList().get(j)
                                    .getParameterCode())) {
                                PreferenceUtils.setString(this, "C_DATA_LEVEL",
                                        quickcheckinfo.getOfferInstList()
                                                .get(i)
                                                .getInstParameterValueList()
                                                .get(j).getParameterId());
                            }
                            if ("C_UNIT_LEVEL".equals(quickcheckinfo
                                    .getOfferInstList().get(i)
                                    .getInstParameterValueList().get(j)
                                    .getParameterCode())) {
                                PreferenceUtils.setString(this, "C_UNIT_LEVEL",
                                        quickcheckinfo.getOfferInstList()
                                                .get(i)
                                                .getInstParameterValueList()
                                                .get(j).getParameterId());
                            }
                        }
                    }
                }

            }
        }
    }

    private void DealFreeUnitItem() {
        double alldata = 0, leftdata = 0, diydataall = 0, diydataleft = 0;
        double allvoice = 0, leftvoice = 0, diyvoiceall = 0, diyvoiceleft = 0;
        double diyallsms = 0, diyleftsms = 0;
        long money = 0;

        for (FreeUnitItem item : freeUnitItem) {
            if (item.getFreeUnitTypeName().contains("Data")) {
                alldata = alldata + UnitUtil.getValueTotal(item, "GB");
                leftdata = leftdata + UnitUtil.getValueUnused(item, "GB");
                if (item.getFreeUnitTypeName().contains("DIY")) {
                    diydataall = diydataall
                            + UnitUtil.getValueTotal(item, "GB");
                    diydataleft = diydataleft
                            + UnitUtil.getValueTotal(item, "GB");
                }
            }

            if (item.getFreeUnitTypeName().contains("Unit")) {
                diyvoiceall = diyallsms = Double.valueOf(item
                        .getTotalInitialAmount());
                diyvoiceleft = diyleftsms = Double.valueOf(item
                        .getTotalUnusedAmount());
                allvoice = allvoice + diyvoiceall;
                leftvoice = leftvoice + diyvoiceleft;

            }
            if (item.getFreeUnitTypeName().contains("Voice")) {
                allvoice = allvoice + UnitUtil.getValueTotal(item, "Minutes");
                leftvoice = leftvoice
                        + UnitUtil.getValueUnused(item, "Minutes");

                if (item.getFreeUnitItemDetailItem() != null
                        && item.getFreeUnitItemDetailItem().getFreeUnitOrigin()
                        .getOfferingKey().getOfferingID()
                        .equals("10102")) {
                    diyvoiceall = diyvoiceall
                            + UnitUtil.getValueTwo(Integer.valueOf(item
                            .getFreeUnitItemDetailItem()
                            .getInitialAmount()), "Minutes", item
                            .getMeasureUnitName());
                    diyvoiceleft = diyvoiceleft
                            + UnitUtil.getValueTwo(Integer.valueOf(item
                            .getFreeUnitItemDetailItem()
                            .getCurrentAmount()), "Minutes", item
                            .getMeasureUnitName());
                } else if (item.getFreeUnitItemDetailArray() != null) {
                    for (FreeUnitItemDetail detail : item
                            .getFreeUnitItemDetailArray()) {
                        if (detail.getFreeUnitOrigin().getOfferingKey()
                                .getOfferingID().equals("10102")) {
                            diyvoiceall = diyvoiceall
                                    + UnitUtil.getValueTwo(
                                    Integer.valueOf(detail
                                            .getInitialAmount()),
                                    "Minutes", item
                                            .getMeasureUnitName());
                            diyvoiceleft = diyvoiceleft
                                    + UnitUtil.getValueTwo(
                                    Integer.valueOf(detail
                                            .getCurrentAmount()),
                                    "Minutes", item
                                            .getMeasureUnitName());
                        }
                    }
                }
            }
            if (item.getFreeUnitTypeName().contains("SMS")) {
                diyallsms = diyallsms
                        + Double.valueOf(item.getTotalInitialAmount());
                diyleftsms = diyleftsms
                        + Double.valueOf(item.getTotalUnusedAmount());
            }
            money = setdiy(item, money);
        }
        PreferenceUtils.setLong(this, "money", money);
        veryChange(alldata, leftdata, allvoice, leftvoice, diyallsms,
                diyleftsms);
        UserInfo.setAllData(StringUtils.formatDecimalFloat(alldata, 2));
        UserInfo.setLeftData(StringUtils.formatDecimalFloat(leftdata, 2));

        UserInfo.setAddData(StringUtils.formatDecimalFloat(
                alldata - diydataall, 2));

        UserInfo.setAllUnit(StringUtils.formatDecimalFloat(allvoice, 0));
        UserInfo.setLeftUnit(StringUtils.formatDecimalFloat(leftvoice, 0));
        UserInfo.setAddUnit(StringUtils.formatDecimalFloat(allvoice
                - diyvoiceall, 0));

        UserInfo.setDiydataall(StringUtils.formatDecimalFloat(diydataall, 2));
        UserInfo.setDiydataleft(StringUtils.formatDecimalFloat(diydataleft, 2));
        UserInfo.setDiyunitall(StringUtils.formatDecimalFloat(diyvoiceall, 0));
        UserInfo.setDiyunitleft(StringUtils.formatDecimalFloat(diyvoiceleft, 0));
        UserInfo.setDiysmsall(StringUtils.formatDecimalFloat(diyallsms, 0));
        UserInfo.setDiysmsleft(StringUtils.formatDecimalFloat(diyleftsms, 0));
        initBar();
    }

    private long setdiy(FreeUnitItem item, long money) {
        if (item.getFreeUnitTypeName().contains("DIY")) {
            PreferenceUtils.setBoolean(this, "haveDiy", true);
            if (item.getFreeUnitItemDetailItem() == null) {
                return 0;// 若是有些账号是array，账号问题，不管他
            }
            PreferenceUtils.setString(this, "effectiveDate", item
                    .getFreeUnitItemDetailItem().getEffectiveTime());
            PreferenceUtils.setString(this, "expireDate", item
                    .getFreeUnitItemDetailItem().getExpireTime());
            PreferenceUtils.setString(this, "moneyUnit", "4");
            PreferenceUtils.setString(this, "OfferInstId", item
                    .getFreeUnitItemDetailItem().getFreeUnitOrigin()
                    .getOfferingKey().getPurchaseSeq());

            PreferenceUtils.setString(this, "C_DATA_LEVEL", String
                    .valueOf(DiyUtilsFromId.getDataId(Integer.parseInt(item
                            .getFreeUnitItemDetailItem().getInitialAmount()))));
            money = money
                    + DiyUtilsFromId.getDataMoney(Integer.parseInt(item
                    .getFreeUnitItemDetailItem().getInitialAmount()));
        }

        if (item.getFreeUnitTypeName().contains("Unit")) {
            money = voiceset(item.getFreeUnitItemDetailItem()
                    .getInitialAmount(), money);
            PreferenceUtils.setString(this, "C_SMS_LEVEL", String
                    .valueOf(DiyUtilsFromId.getSmsId(Integer.parseInt(item
                            .getFreeUnitItemDetailItem().getInitialAmount()))));
        }
        if (item.getFreeUnitTypeName().contains("Voice")) {

            if (item.getFreeUnitItemDetailItem() != null
                    && item.getFreeUnitItemDetailItem().getFreeUnitOrigin()
                    .getOfferingKey().getOfferingID().equals("10102")) {

                money = voiceset(item.getFreeUnitItemDetailItem()
                        .getInitialAmount(), money);

            } else if (item.getFreeUnitItemDetailArray() != null) {
                for (FreeUnitItemDetail detail : item
                        .getFreeUnitItemDetailArray()) {
                    if (detail.getFreeUnitOrigin().getOfferingKey()
                            .getOfferingID().equals("10102")) {
                        money = voiceset(detail.getCurrentAmount(), money);
                    }
                }
            }
        }
        if (item.getFreeUnitTypeName().contains("SMS")) {
            PreferenceUtils.setString(this, "C_SMS_LEVEL", String
                    .valueOf(DiyUtilsFromId.getSmsId(Integer.parseInt(item
                            .getFreeUnitItemDetailItem().getInitialAmount()))));
            money = money
                    + DiyUtilsFromId.getSmsMoney(Integer.parseInt(item
                    .getFreeUnitItemDetailItem().getInitialAmount()));
        }
        return money;
    }

    private long voiceset(String amount, long money) {
        PreferenceUtils.setString(this, "C_UNIT_LEVEL", String
                .valueOf(DiyUtilsFromId.getVoiceId(Integer.parseInt(amount))));
        money = money + DiyUtilsFromId.getVoiceMoney(Integer.parseInt(amount));
        return money;
    }

    private void refreshDIYdata() {
        Intent it = new Intent("com.vodafone.refreshDIYData");
        // if (quickcheckinfo != null) {
        // List<OfferInstValue> offerInstValues = quickcheckinfo
        // .getOfferInstList();
        // for (OfferInstValue offerInstValue : offerInstValues) {
        // if (offerInstValue.getOfferType().equals("D")) {
        // float price = (float) (offerInstValue.getPeriodicFee()
        // .getCurrencyValue()) / 10000;
        // DecimalFormat decimalFormat = new DecimalFormat(".00");//
        // 构造方法的字符格式这里如果小数不足2位,会以0补足.
        // String p = decimalFormat.format(price);// format
        // HashMap<String, Object> map = new HashMap<String, Object>();
        // map.put("offerName", offerInstValue.getOfferName());
        // map.put("offerPrice", p);
        // it.putExtra("dataMap", map);
        // break;
        // }
        // }
        // }
        if (PreferenceUtils.getBoolean(this, "haveDiy")) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            double money = 0;
            int unit = Integer.valueOf(PreferenceUtils.getString2(this,
                    "moneyUnit"));
            money = money + PreferenceUtils.getLong(this, "money", 01)
                    * Math.pow(10, -unit);
            String datava = PreferenceUtils.getString(this, "C_DATA_LEVEL");
            if (datava.equals("")) {
                datava = "0";
                map.put("offerName", "Red " + UserInfo.getDiydataall() + "GB"
                        + " Bundle");
            } else {

                map.put("offerName",
                        "Red "
                                + DiyUtils.getDataValue(Integer
                                .parseInt(datava)) + " Bundle");
            }
            map.put("offerPrice", Double.toString(money));
            it.putExtra("dataMap", map);
        } else if (myswitch.showdiynoti) {
            addnotification("DIYNotHave", "", "Plan Configuration");
            myswitch.showdiynoti = false;
        }
        sendBroadcast(it);
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.cancel_diy:
                // Request(TAGUtil.QUERYCUSTOMERINFO);
//			Request(TAGUtil.DELETE);
            default:

                break;
        }
        return false;
    }
    private void mydialog(int num) {
        if (!myswitch.proscenium) {
            return;
        }
        if (dialog == null) {
            dialog = new ErrorDialog(MainActivity.this);
            dialog.setClick(new Click() {

                @Override
                public void onClicked(Object num, int num1, String num2,
                                      boolean num3) {
                    switch ((Integer) num) {
                        case 1:
                            Request(TAGUtil.QUERY_FREE_UNIT);
                            break;
                        case 2:
                            if (num3) {
                                Intent intent = new Intent(MainActivity.this,
                                        DiyPlansActivity.class);
                                startActivity(intent);
                                activityAnimationOpen();
                            } else {
                                Intent intent9 = new Intent(MainActivity.this,
                                        ProductsServiceActivity.class);

                                if (PreferenceUtils.getBoolean(MainActivity.this,
                                        "haveDiy")) {
                                    HashMap<String, Object> map = new HashMap<String, Object>();
                                    double money = 0;
                                    int unit = Integer.valueOf(PreferenceUtils
                                            .getString2(MainActivity.this,
                                                    "moneyUnit"));
                                    money = money
                                            + PreferenceUtils.getLong(
                                            MainActivity.this, "money", 01)
                                            * Math.pow(10, -unit);
                                    String datava = PreferenceUtils.getString(
                                            MainActivity.this, "C_DATA_LEVEL");
                                    if (datava.equals("")) {
                                        datava = "0";
                                        map.put("offerName",
                                                "Red " + UserInfo.getDiydataall()
                                                        + "GB" + " Bundle");
                                    } else {

                                        map.put("offerName",
                                                "Red "
                                                        + DiyUtils
                                                        .getDataValue(Integer
                                                                .parseInt(datava))
                                                        + " Bundle");
                                    }
                                    map.put("offerPrice", Double.toString(money));
                                    intent9.putExtra("dataMap", map);
                                }
                                intent9.putExtra("freeUnitItem",
                                        (Serializable) freeUnitItem);
                                startActivity(intent9);
                            }
                            break;
                        case 3:
                            if (num3) {
                                Intent intent = new Intent(MainActivity.this,
                                        DiyPlansActivity.class);
                                startActivity(intent);
                                activityAnimationOpen();
                            } else {
                                Intent intent1 = new Intent(MainActivity.this,
                                        MainAddDataActivity.class);
                                intent1.putExtra("add", 2);
                                intent1.putExtra("type", myswitch.select);
                                startActivityForResult(intent1, TAGUtil.tag5);
                                activityAnimationUp();
                            }
                            break;
                        case 4:
                            if (num3) {
                                Intent intent = new Intent(MainActivity.this,
                                        DiyPlansActivity.class);
                                startActivity(intent);
                                activityAnimationOpen();
                            } else {
                                Intent intent2 = new Intent(MainActivity.this,
                                        MainAddDataActivity.class);
                                intent2.putExtra("type", myswitch.select);
                                startActivityForResult(intent2, TAGUtil.tag5);
                                activityAnimationUp();
                            }
                            break;
                        case 5:
                            if (num3) {
                                Intent intent = new Intent(MainActivity.this,
                                        DiyPlansActivity.class);
                                startActivity(intent);
                                activityAnimationOpen();
                            } else {
                                Intent intent14 = new Intent(MainActivity.this,
                                        NetWorkUsageActivity.class);
                                startActivity(intent14);
                                activityAnimationOpen();
                            }
                            break;
                        default:
                            break;
                    }
                }
            });
        }
        if (!dialog.isShowing()) {
            dialog.setTag(num);
            switch (num) {
                case 1:
                    dialog.setrestore();
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    dialog.setMessage(
                            "Welcome to Smart Pricing.  Would you like to configure your plan?",
                            "Plan Configuration", "Yes please", "No thanks");
                    break;
                default:
                    break;
            }
            dialog.show();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        jump(intent);
    }

    private void jump(Intent intent) {
        String channel = intent.getStringExtra("channel") + "";
        Intent resultIntent = null;
        switch (channel) {
            case "DataUsgNtfctnThrshld1":
                resultIntent = new Intent(getBaseContext(),
                        MainAddDataActivity.class);
                resultIntent.putExtra("type", 0);
                startActivityForResult(resultIntent, TAGUtil.tag5);
                break;
            case "RchrgReminder":
                resultIntent = new Intent(getBaseContext(), RechargeActivity.class);
                startActivityForResult(resultIntent, TAGUtil.tag7);
                break;
            case "Content Bundle":
                resultIntent = new Intent(getBaseContext(),
                        MainAddDataActivity.class);
                resultIntent.putExtra("type", 2);
                startActivityForResult(resultIntent, TAGUtil.tag5);
                break;
            case "UpSell Bundle":
                resultIntent = new Intent(getBaseContext(),
                        MainAddDataActivity.class);
                resultIntent.putExtra("add", 2);
                resultIntent.putExtra("type", 0);
                startActivityForResult(resultIntent, TAGUtil.tag5);
                break;
            case "LowBalance":
                resultIntent = new Intent(getBaseContext(), RechargeActivity.class);
                resultIntent.putExtra("number", 20);
                startActivityForResult(resultIntent, TAGUtil.tag7);
                break;
            case "Netflix":
                resultIntent = new Intent(getBaseContext(),
                        MainAddDataActivity.class);
                resultIntent.putExtra("type", 3);
                startActivityForResult(resultIntent, TAGUtil.tag5);
                break;
            case "EuroGift":
                break;
            case "InternationalRoamingData":
                resultIntent = new Intent(getBaseContext(),
                        MainAddDataActivity.class);
                resultIntent.putExtra("type", 4);
                startActivityForResult(resultIntent, TAGUtil.tag5);
                break;
            case "StarbucksCoupon":
                resultIntent = new Intent(getBaseContext(),
                        MainAddDataActivity.class);
                resultIntent.putExtra("type", 5);
                startActivityForResult(resultIntent, TAGUtil.tag5);
                break;
            case "Empty Template":
                break;
            default:
                return;
        }
        addnotification(channel, intent.getStringExtra("content"),
                intent.getStringExtra("title"));
    }

    TimerTask task = new TimerTask() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            if (!MainActivity.this.isFinishing()
                    && MyApplication.getInstance().isNetworkConnected())
                taskHandler.sendEmptyMessage(1);
        }
    };

    private final Timer taskTimer = new Timer();
    Handler taskHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // 要做的事情
            Request(TAGUtil.QUERY_FREE_UNIT);
            super.handleMessage(msg);

        }
    };

    private void startTask() {// 定时任务
        taskTimer.schedule(task, 120 * 1000, 60 * 1000);
    }

    private void initLastData() {
        myswitch.lastAllData = UserInfo.getAllData();
        myswitch.lastLeftData = UserInfo.getLeftData();
        myswitch.lastAllUnit = UserInfo.getAllUnit();
        myswitch.lastLeftUnit = UserInfo.getLeftUnit();
        myswitch.lastAllSms = UserInfo.getDiysmsall();
        myswitch.lastLeftSms = UserInfo.getDiysmsleft();
    }

    private void veryChange(double allData, double leftData, double allUnit,
                            double leftUnit, double allSms, double leftSms) {
        if (myswitch.lastAllData != null
                && myswitch.lastAllData.equals(StringUtils.formatDecimalFloat(
                allData, 2))
                && myswitch.lastLeftData != null
                && myswitch.lastLeftData.equals(StringUtils.formatDecimalFloat(
                leftData, 2))) {
            myswitch.isDataChange = false;
        }
        if (myswitch.lastAllUnit != null
                && myswitch.lastAllUnit.equals(StringUtils.formatDecimalFloat(
                allUnit, 0))
                && myswitch.lastLeftUnit != null
                && myswitch.lastLeftUnit.equals(StringUtils.formatDecimalFloat(
                leftUnit, 0))) {
            myswitch.isUnitChange = false;
        }
        if (myswitch.lastAllSms != null
                && myswitch.lastAllSms.equals(StringUtils.formatDecimalFloat(
                allSms, 0))
                && myswitch.lastLeftSms != null
                && myswitch.lastLeftSms.equals(StringUtils.formatDecimalFloat(
                leftSms, 0)) || allSms == -1 || leftSms == -1) {
            myswitch.isSMSChange = false;
        }
    }

    private boolean isNeedRefresh() {
        if (myswitch.manualRefresh) {
            myswitch.manualRefresh = false;
            return true;
        }
        if (StringUtils.isEmpty(surplusFlow.getText().toString()))
            return true;
        if (myswitch.select == 0) {
            if (!myswitch.isDataChange) {
                myswitch.isDataChange = true;
                return false;
            }
        } else if (myswitch.select == 1) {
            if (!myswitch.isUnitChange) {
                myswitch.isUnitChange = true;
                return false;
            }
        } else if (myswitch.select == 2) {
            if (!myswitch.isSMSChange) {
                myswitch.isSMSChange = true;
                return false;
            }
        }
        return true;
    }
}
