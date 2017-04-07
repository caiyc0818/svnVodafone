package com.huawei.vodafone.ui.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.huawei.vodafone.R;
import com.huawei.vodafone.db.DBSignInAdapter;
import com.huawei.vodafone.listener.Listener.Click;
import com.huawei.vodafone.net.IRequest;
import com.huawei.vodafone.net.RequestJSon;
import com.huawei.vodafone.net.RequestListener;
import com.huawei.vodafone.net.URLs;
import com.huawei.vodafone.ui.adapter.SignInPagerAdapter;
import com.huawei.vodafone.ui.myview.dialog.ErrorDialog;
import com.huawei.vodafone.ui.myview.dialog.ExchangeDialog;
import com.huawei.vodafone.ui.myview.dialog.SuccessDialog;
import com.huawei.vodafone.ui.myview.dialog.WaitDialog;
import com.huawei.vodafone.util.DateUtil;
import com.huawei.vodafone.util.JsonUtils;
import com.huawei.vodafone.util.PreferenceUtils;
import com.huawei.vodafone.util.StringUtils;

/**
 * @author weich 签到rules
 */
public class SignCreditsDetailActivity extends BaseActivity implements
		RequestListener {
	/**
	 * android-support-v4中的滑动组件
	 */
	private ViewPager viewPager;

	/**
	 * 滑动的图片集合
	 */
	private List<View> imageViews;

	/**
	 * 图片数量
	 */
	private int count;

	/**
	 * 点的父布局
	 */
	private LinearLayout dotsLayout;

	/**
	 * 图片标题正文的那些点
	 */
	private List<View> dots;

	/**
	 * 当前图片的索引号
	 */
	private int currentItem = 0;
	/**
	 * 定时器
	 */
	Handler handler = new Handler();
	private TextView exchange_now;
	private TextView credits_point;
	private TextView credits_ecchanged;

	private int num = 0;
	private int points;
	private int[] draw = new int[3];
	private TextView sign_shop_title;

	private WaitDialog wait;
	private TextView see_all_wares;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_in_credits_detail);
		initSecondTitle(getString(R.string.detail));
		initView();
	}

	private void initView() {
		dotsLayout = (LinearLayout) findViewById(R.id.card_discount_dots);
		viewPager = (ViewPager) findViewById(R.id.card_discount_vp);
		exchange_now = (TextView) findViewById(R.id.exchange_now);
		credits_point = (TextView) findViewById(R.id.credits_point);
		credits_ecchanged = (TextView) findViewById(R.id.credits_ecchanged);
		sign_shop_title = (TextView) findViewById(R.id.sign_shop_title);
		see_all_wares = (TextView) findViewById(R.id.see_all_wares);

		see_all_wares.setOnClickListener(this);

		handler.postDelayed(new ScrollTask(), 3000);
		num = getIntent().getIntExtra("num", 0);
		points = PreferenceUtils.getInt(getBaseContext(), "SignInPoints");
		initimage();
		initview();
		addAds();
	}

	private void initview() {
		if (num == 0) {
			if (PreferenceUtils.getInt(getBaseContext(), "1GData") < 5000) {
				exchange_now.setOnClickListener(this);
				if (points < 500) {
					exchange_now
							.setBackgroundResource(R.drawable.gray_btn_bg_normal);
				}
			} else {
				exchange_now.setEnabled(false);
				exchange_now
						.setBackgroundResource(R.drawable.gray_btn_bg_normal);
				exchange_now.setText("Sold out");
			}
			credits_point.setText("100 Points");
			credits_ecchanged.setText(StringUtils.formatDecimalFloat(
					PreferenceUtils.getInt(getBaseContext(), "1GData"), 0)
					+ " Redeemed");
			count = 1;
			sign_shop_title.setText("1GB Data");
		} else if (num == 1) {
			if (PreferenceUtils.getInt(getBaseContext(), "2GData") < 5000) {
				exchange_now.setOnClickListener(this);
				if (points < 500) {
					exchange_now
							.setBackgroundResource(R.drawable.gray_btn_bg_normal);
				}
			} else {
				exchange_now
						.setBackgroundResource(R.drawable.gray_btn_bg_normal);
				exchange_now.setText("Sold out");
				exchange_now.setEnabled(false);
			}
			credits_point.setText("200 Points");
			credits_ecchanged.setText(StringUtils.formatDecimalFloat(
					PreferenceUtils.getInt(getBaseContext(), "2GData"), 0)
					+ " Redeemed");
			count = 1;
			sign_shop_title.setText("2GB Data");
		} else if (num == 2) {
			if (PreferenceUtils.getInt(getBaseContext(), "huaweimate8") < 400) {
				exchange_now.setOnClickListener(this);
				if (points < 500000) {
					exchange_now
							.setBackgroundResource(R.drawable.gray_btn_bg_normal);
				}
			} else {
				exchange_now
						.setBackgroundResource(R.drawable.gray_btn_bg_normal);
				exchange_now.setText("Sold out");
				exchange_now.setEnabled(false);
			}
			credits_point.setText("500,000 Points");
			credits_ecchanged.setText(StringUtils.formatDecimalFloat(
					PreferenceUtils.getInt(getBaseContext(), "huaweimate8"), 0)
					+ " Redeemed");
			count = 3;
			sign_shop_title.setText("Huawei Mate8");
		}
	}

	private void Request() {
		if (num == 0) {
			IRequest.post(num, URLs.ADDOPTIONAL,
					RequestJSon.Optionaloffering("120098", "","", false), this);
		} else if (num == 1) {
			IRequest.post(num, URLs.ADDOPTIONAL,
					RequestJSon.Optionaloffering("120096", "", "",false), this);
		}
	}

	private void addAds() {
		imageViews = new ArrayList<View>();
		dots = new ArrayList<View>();
		imageViews.clear();
		dots.clear();
		dotsLayout.removeAllViews();
		int[] imgId = { R.drawable.ic_launcher };
		for (int i = 0; i < count; i++) {
			// 初始化图片资源
			ImageView imageView = new ImageView(SignCreditsDetailActivity.this);
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			imageView.setLayoutParams(layoutParams);
			imageView.setScaleType(ScaleType.CENTER_INSIDE);
			imageView.setImageResource(draw[i]);
			imageViews.add(imageView);

			// 添加标题下面的点
			ImageView dotsView = new ImageView(SignCreditsDetailActivity.this);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			params.setMargins(5, 0, 5, 5);
			dotsView.setLayoutParams(params);
			dotsView.setBackgroundResource(R.drawable.banner2);
			if (0 == i) {
				dotsView.setBackgroundResource(R.drawable.banner1);
			}
			if (count != 1) {
				dotsLayout.addView(dotsView);
				dots.add(dotsView);
			}
		}
		// 设置填充ViewPager页面的适配器
		viewPager.setAdapter(new SignInPagerAdapter(
				SignCreditsDetailActivity.this, imageViews, viewPager));
		// 设置一个监听器，当ViewPager中的页面改变时调用
		viewPager.addOnPageChangeListener(new MyPageChangeListener());
		viewPager.setCurrentItem(0);
	}

	private void initimage() {
		switch (num) {
		case 0:
			draw[0] = R.drawable.detailm10;
			break;
		case 1:
			draw[0] = R.drawable.detailm20;
			break;
		case 2:
			draw[0] = R.drawable.mate8_detail1;
			draw[1] = R.drawable.mate8_detail2;
			draw[2] = R.drawable.mate8_detail3;
			break;
		default:
			break;
		}
	}

	/**
	 * 换行切换任务
	 * 
	 * @version [2013-6-18]
	 * @see [相关类/方法]
	 */
	private class ScrollTask implements Runnable {
		@Override
		public void run() {
			synchronized (viewPager) {
				if (imageViews != null) {
					if (imageViews.size() != 0) {
						currentItem = currentItem + 1;
						if (currentItem >= imageViews.size()) {
							currentItem = 0;
						}
						viewPager.setCurrentItem(currentItem);
					}
					// 通过Handler切换图片
					handler.postDelayed(this, 3000);
				}
			}
		}
	}

	/**
	 * 当ViewPager中页面的状态发生改变时调用
	 * 
	 */
	private class MyPageChangeListener implements OnPageChangeListener {
		private int oldPosition = 0;

		@Override
		public void onPageSelected(int position) {
			currentItem = position;
			dots.get(oldPosition).setBackgroundResource(R.drawable.banner2);
			dots.get(position).setBackgroundResource(R.drawable.banner1);
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
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.exchange_now:
			if (num == 0) {
				if (points < 100) {
					Toast.makeText(getBaseContext(), "Points is not enough",
							Toast.LENGTH_SHORT).show();
					return;
				}
			} else if (num == 1) {
				if (points < 200) {
					Toast.makeText(getBaseContext(), "Points is not enough",
							Toast.LENGTH_SHORT).show();
					return;
				}
			} else if (num == 2) {
				if (points < 500000) {
					Toast.makeText(getBaseContext(), "Points is not enough",
							Toast.LENGTH_SHORT).show();
					return;
				}
			}

			ExchangeDialog dialog = new ExchangeDialog(
					SignCreditsDetailActivity.this);
			dialog.show();
			dialog.setClick(new Click() {
				@Override
				public void onClicked(Object tag, int num1, String num2,
						boolean num3) {
					if (num3) {
						if (wait == null)
							wait = new WaitDialog(
									SignCreditsDetailActivity.this);
						wait.show();
						Request();
					}
				}
			});
			break;
		case R.id.see_all_wares:
			finish();
			activityAnimationClose();
			break;
		default:
			break;
		}
	}

	@Override
	public void requestSuccess(Object tag, String json) {
		myrequest(JsonUtils.getHeadCode(json), JsonUtils.getHeadMessage(json));

	}

	@Override
	public void requestError(Object tag, VolleyError e) {
		myrequest("-1", e.toString());
	}

	private void myrequest(String code, String message) {
		wait.cancel();
		if (code.equals("0")) {
			int signhistorynum = PreferenceUtils.getInt(getBaseContext(),
					"signhistorynum");
			PreferenceUtils.setInt(getBaseContext(), "signhistorynum",
					++signhistorynum);
			DBSignInAdapter db = new DBSignInAdapter(getBaseContext());
			db.openDb();
			if (num == 0) {
				db.insert("1GB Data",
						DateUtil.ConverToString(new Date(), "yyyy-MM-dd"),
						-100, 2);

				PreferenceUtils.setInt(getBaseContext(), "SignInPoints",
						points - 100);
				int exchanged = PreferenceUtils.getInt(getBaseContext(),
						"1GData");
				PreferenceUtils.setInt(getBaseContext(), "1GData",
						exchanged + 1);
			} else if (num == 1) {
				db.insert("2GB Data",
						DateUtil.ConverToString(new Date(), "yyyy-MM-dd"),
						-200, 2);

				PreferenceUtils.setInt(getBaseContext(), "SignInPoints",
						points - 200);
				int exchanged = PreferenceUtils.getInt(getBaseContext(),
						"2GData");
				PreferenceUtils.setInt(getBaseContext(), "2GData",
						exchanged + 1);
			} else if (num == 2) {
				db.insert("Huawei Mate8",
						DateUtil.ConverToString(new Date(), "yyyy-MM-dd"),
						-500000, 2);

				PreferenceUtils.setInt(getBaseContext(), "SignInPoints",
						points - 500000);
				int exchanged = PreferenceUtils.getInt(getBaseContext(),
						"huaweimate8");
				PreferenceUtils.setInt(getBaseContext(), "huaweimate8",
						exchanged + 1);
			}
			db.closeDb();
			initview();
			SuccessDialog dialog = new SuccessDialog(this);
			if (0 == num) {
				dialog.settext("You've successfully redeemed 1GB Data");
			} else if (1 == num) {
				dialog.settext("You've successfully redeemed 2GB Data");
			}
			dialog.show();
		} else {
			ErrorDialog dialog = new ErrorDialog(SignCreditsDetailActivity.this);
			dialog.show();
			dialog.setClick(new Click() {

				@Override
				public void onClicked(Object num, int num1, String num2,
						boolean num3) {
					if (wait == null)
						wait = new WaitDialog(SignCreditsDetailActivity.this);
					wait.show();
					Request();
				}
			});
		}

	}

}
