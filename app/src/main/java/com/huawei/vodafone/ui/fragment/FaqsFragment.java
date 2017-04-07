package com.huawei.vodafone.ui.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.R.integer;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.Faq;
import com.huawei.vodafone.ui.adapter.FaqsDetailAdapter;
import com.huawei.vodafone.ui.adapter.FaqsSearchAdapter;
import com.huawei.vodafone.ui.myview.MyListview;
import com.huawei.vodafone.util.DensityUtil;
import com.huawei.vodafone.util.StringUtils;
import com.huawei.vodafone.util.ViewUtils;
import com.wefika.flowlayout.FlowLayout;

public class FaqsFragment extends BaseFragment implements OnClickListener {

	private HorizontalScrollView tabSV;
	private LinearLayout tabLl;
	private ImageView tabTip;
	private ViewPager detailVp;

	private List<View> faqViews;
	private FlowLayout popularFl;
	private LinearLayout searchLl;
	private ImageView supportSearch;
	private LinearLayout detailLl;
	private ImageView deleteIv;
	private AutoCompleteTextView searchEt;
	private MyListview searchResultLv;
	private LinearLayout searchResultLl;
	private ImageView searchGoIv;
	private LinearLayout popularLl;
	private MyListview detailLv;
	private ImageView loadingIv;
	private Animation myAnimation;
	private LinearLayout searchErrorLl;
	private TextView moreFaqsTV;
	private ImageView closeIv;
	private View loading;
	private LinearLayout searchArrowLl;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.faqs, null);
		initViews(view);
		addFaqsAndTabData();
		addPopularData();
		addSearchData();
		return view;
	}

	/**
	 * 初始化组件
	 */
	private void initViews(View v) {
		tabSV = (HorizontalScrollView) v.findViewById(R.id.tab_sv);
		detailVp = (ViewPager) v.findViewById(R.id.detail_vp);
		tabTip = (ImageView) v.findViewById(R.id.tab_tip);
		supportSearch = (ImageView) v.findViewById(R.id.support_search_iv);
		deleteIv = (ImageView) v.findViewById(R.id.delete_iv);
		deleteIv.setVisibility(View.GONE);
		searchGoIv = (ImageView) v.findViewById(R.id.search_go_iv);
		tabLl = (LinearLayout) v.findViewById(R.id.tab_ll);
		detailLl = (LinearLayout) v.findViewById(R.id.detail_ll);
		searchLl = (LinearLayout) v.findViewById(R.id.search_ll);
		searchResultLl = (LinearLayout) v.findViewById(R.id.search_result_ll);
		searchEt = (AutoCompleteTextView) v.findViewById(R.id.search_et);
		searchEt.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				if(s.length()==0){
					deleteIv.setVisibility(View.GONE);
				}else{
					popularLl.setVisibility(View.GONE);
					deleteIv.setVisibility(View.VISIBLE);
				}
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
		searchResultLv = (MyListview) v.findViewById(R.id.search_result_lv);
		searchLl.setVisibility(View.GONE);
		searchResultLl.setVisibility(View.GONE);
		popularFl = (FlowLayout) v.findViewById(R.id.popular_fl);
		popularLl = (LinearLayout) v.findViewById(R.id.popular_ll);
		searchErrorLl = (LinearLayout) v.findViewById(R.id.search_error_ll);
		supportSearch.setOnClickListener(this);
		deleteIv.setOnClickListener(this);
		searchGoIv.setOnClickListener(this);
		detailLv = (MyListview) v.findViewById(R.id.detail_lv);
		loadingIv = (ImageView) v.findViewById(R.id.loading_iv);
		moreFaqsTV = (TextView) v.findViewById(R.id.more_faqs_tv);
		myAnimation = AnimationUtils.loadAnimation(getActivity(),
				R.anim.faqs_loading_rotate);
		LinearInterpolator lir = new LinearInterpolator();
		myAnimation.setInterpolator(lir);
		closeIv = (ImageView) v.findViewById(R.id.close_iv);
		searchArrowLl = (LinearLayout) v.findViewById(R.id.faq_search_arrow_ll);
		closeIv.setOnClickListener(this);
		searchArrowLl.setOnClickListener(this);
		ViewUtils.setButtonStateChangeListener(searchGoIv);
		loading =  v.findViewById(R.id.loading);
		loading.setVisibility(View.GONE);
	}

	String[] strs = { "Most Popular", "Home broadband", "Mobile voice",
			"Mobile text" };

	private void addFaqsAndTabData() {
		addTabData(strs);
		List<HashMap> tabs = new ArrayList<HashMap>();

		// for (int i = 0; i < strs.length; i++) {
		HashMap<String, List<Faq>> faqMap = new HashMap<String, List<Faq>>();
		List<Faq> faqs = new ArrayList<Faq>();
		Faq faq = new Faq();
		faq.setTitle("How do I get Netflix?");
		faq.getMap()
				.put("Should I be concerned?",
						"Did you receive a text message telling you about a \"verification code\" and that you should \"continue the Forgotten Password process on our website\", but you never started the Forgotten Password process for My Vodafone? If so, there's no need for concern. ");
		faq.getMap()
				.put("What is this message?",
						"This text message is part of the process for people to sign in to My Vodafone when they can't remember what their password is. We text them out a verification code, which they need to enter on the website, and then they change their password and have access to My Vodafone. ");
		faq.getMap()
				.put("Can I delete this message?",
						"if you didn't start this Forgot your Password process, but received the text message, then most likely someone accidentally typed in your phone number instead of their own. Regardless, as long as you have your phone, there's no risk of someone being able to sign in to your My Vodafone account, because they would need that verification code to do so. So go ahead and just delete the text message. That verification code will soon expire. And your My Vodafone password will remain unchanged.   Related questions");
		faqs.add(faq);
		Faq faq1 = new Faq();
		faq1.setTitle("How do I register my Mobile Broadband for My Vodafone?");
		faq1.getMap()
				.put("Can I delete this message?",
						"if you didn't start this Forgot your Password process, but received the text message, then most likely someone accidentally typed in your phone number instead of their own. Regardless, as long as you have your phone, there's no risk of someone being able to sign in to your My Vodafone account, because they would need that verification code to do so. So go ahead and just delete the text message. That verification code will soon expire. And your My Vodafone password will remain unchanged.   Related questions");
		faqs.add(faq1);
		// faqMap.put(strs[i], faqs);
		// tabs.add(faqMap);
		// }
		faqViews = new ArrayList<View>();
		// for (int i = 0; i < strs.length; i++) {
		// View view = LayoutInflater.from(getActivity()).inflate(
		// R.layout.faqs_detail, null);
		// faqViews.add(view);
		// MyListview detailLv = (MyListview) view
		// .findViewById(R.id.detail_lv);
		FaqsDetailAdapter faqsDetailAdapter = new FaqsDetailAdapter(
				getActivity(), faqs);
		detailLv.setAdapter(faqsDetailAdapter);
		// }
		// TODO 设置填充ViewPager页面的适配器********当滚动主题有时再放开下面代码******
		// detailVp.setAdapter(new PagerAdapter() {
		//
		// @Override
		// public void destroyItem(View arg0, int arg1, Object arg2) {
		// if (arg1 == strs.length) {
		//
		// return;
		// }
		// ((ViewPager) arg0).removeView(faqViews.get(arg1));
		// }
		//
		// @Override
		// public void finishUpdate(View arg0) {
		// }
		//
		// @Override
		// public int getCount() {
		// return faqViews.size();
		// }
		//
		// @Override
		// public boolean isViewFromObject(View arg0, Object arg1) {
		// return arg0 == (arg1);
		// }
		//
		// @Override
		// public void restoreState(Parcelable arg0, ClassLoader arg1) {
		// }
		//
		// @Override
		// public Parcelable saveState() {
		// return null;
		// }
		//
		// @Override
		// public void startUpdate(View arg0) {
		// }
		//
		// @Override
		// public Object instantiateItem(View arg0, final int arg1) {
		// // mListViews.get(arg1).setBackgroundResource(resId[arg1]);
		// if (arg1 == strs.length) {
		//
		// return null;
		// }
		// ((ViewPager) arg0).addView(faqViews.get(arg1), 0);
		// return faqViews.get(arg1);
		// }
		//
		// });
		// detailVp.setOnPageChangeListener(new OnPageChangeListener() {
		//
		// @Override
		// public void onPageSelected(int arg0) {
		// // TODO Auto-generated method stub
		// tabScroll(arg0);
		// }
		//
		// @Override
		// public void onPageScrolled(int arg0, float arg1, int arg2) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void onPageScrollStateChanged(int arg0) {
		// // TODO Auto-generated method stub
		//
		// }
		// });
	}

	private void addTabData(String[] str) {
		for (int i = 0; i < str.length; i++) {
			TextView tv = new TextView(getActivity());
			tv.setText(str[i]);
			tv.setTextColor(getResources().getColor(R.color.support_gray_more));
			tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);

			LayoutParams ll = new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT);
			if (i != 0) {
				ll.leftMargin = DensityUtil.dip2px(getActivity(), 38);
				tv.setTextColor(getResources().getColor(
						R.color.support_gray_little));
			} else {
				tv.setTextColor(getResources().getColor(
						R.color.support_gray_more));
			}
			tv.setLayoutParams(ll);
			tabLl.addView(tv);
			if (i == 0) {
				float w = tv.getPaint().measureText(str[i]);
				// tabLl.getPaddingLeft()+w/2
				tabTip.setX(tabLl.getPaddingLeft() + w / 2
						- tabTip.getLayoutParams().width / 2);
			}
			tv.setTag(i);
			tv.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(final View v) {
					// TODO Auto-generated method stub
					// tabSV.smoothScrollTo(v.getLeft(), 0);
					detailVp.setCurrentItem((Integer) v.getTag());
					// tabScroll((Integer) v.getTag());
				}
			});
		}

	}

	private void tabScroll(int i) {
		final View v = tabLl.getChildAt(i);
		for (int j = 0; j < tabLl.getChildCount(); j++) {
			((TextView) tabLl.getChildAt(j)).setTextColor(getResources()
					.getColor(R.color.support_gray_little));
		}
		((TextView) v).setTextColor(getResources().getColor(
				R.color.support_gray_more));
		if (v.getRight() - tabSV.getScrollX() > screenWidth) {
			tabSV.smoothScrollBy(
					v.getRight() - screenWidth + tabLl.getPaddingRight(), 0);
		} else if (v.getLeft() - tabSV.getScrollX() < 0) {

			tabSV.smoothScrollTo(v.getLeft() - tabLl.getPaddingLeft(), 0);
		}
		ValueAnimator animator = ValueAnimator.ofFloat(tabTip.getX(),
				v.getLeft() + v.getWidth() / 2 - tabTip.getWidth() / 2);
		animator.setTarget(tabTip);
		animator.setDuration(100).start();
		animator.addUpdateListener(new AnimatorUpdateListener() {

			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				// TODO Auto-generated method stub
				float value = (Float) animation.getAnimatedValue();
				tabTip.setX(value);
			}
		});
	}

	private void addFlowView(List<String> strs, FlowLayout flowLayout) {
		for (int i = 0; i < strs.size(); i++) {
			TextView newView = new TextView(getActivity());
			newView.setBackgroundResource(R.drawable.shape_faqs_popular_item_bg);
			newView.setText(strs.get(i));
			newView.setTag(i);
			newView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
			newView.setGravity(Gravity.CENTER);
			newView.setTextColor(Color.WHITE);
			FlowLayout.LayoutParams params = new FlowLayout.LayoutParams(
					FlowLayout.LayoutParams.WRAP_CONTENT,
					FlowLayout.LayoutParams.WRAP_CONTENT);
			params.rightMargin = DensityUtil.dip2px(getActivity(), 8);
			params.bottomMargin = DensityUtil.dip2px(getActivity(), 8);
			newView.setLayoutParams(params);
			flowLayout.addView(newView);
			newView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					searchEt.setText(((TextView)v).getText().toString());
					loading.setVisibility(View.VISIBLE);
					loadingIv.startAnimation(myAnimation);
					searchResultLl.setVisibility(View.GONE);
					popularLl.setVisibility(View.GONE);
					searchErrorLl.setVisibility(View.GONE);
					searchGoIv.postDelayed(new Runnable() {

						@Override
						public void run() {
							loading.setVisibility(View.GONE);
							loadingIv.clearAnimation();
							if (StringUtils.isEmpty(searchEt.getText().toString())) {
								searchErrorLl.setVisibility(View.VISIBLE);
							} else {
								searchResultLl.setVisibility(View.VISIBLE);
								addSearchResultData();
							}
						}
					}, 2000);
				}
			});
		}
	}

	private void addPopularData() {
		List<String> strs = new ArrayList<String>();
		strs.add("Setting up text messaging");
		strs.add("Voicemail");
		strs.add("Useful numbers");
		strs.add("Call diverts");
		strs.add("Vodafone Callback");
		addFlowView(strs, popularFl);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.support_search_iv:
			searchLl.setVisibility(View.VISIBLE);
			detailLl.setVisibility(View.GONE);

			loadingIv.startAnimation(myAnimation);
			break;
		case R.id.delete_iv:
			searchEt.setText("");
			break;
		case R.id.search_go_iv:
			loading.setVisibility(View.VISIBLE);
			loadingIv.startAnimation(myAnimation);
			searchResultLl.setVisibility(View.GONE);
			popularLl.setVisibility(View.GONE);
			searchErrorLl.setVisibility(View.GONE);
			searchGoIv.postDelayed(new Runnable() {

				@Override
				public void run() {
					loading.setVisibility(View.GONE);
					loadingIv.clearAnimation();
					if (StringUtils.isEmpty(searchEt.getText().toString())) {
						searchErrorLl.setVisibility(View.VISIBLE);
					} else {
						searchResultLl.setVisibility(View.VISIBLE);
						addSearchResultData();
					}
				}
			}, 2000);
			break;
		case R.id.close_iv:
			getActivity().finish();
			break;
		case R.id.faq_search_arrow_ll:
			popularLl.setVisibility(View.VISIBLE);
			searchResultLl.setVisibility(View.GONE);
			break;
		default:
			break;
		}
	}

	private void addSearchData() {
		List<String> strs = new ArrayList<String>();
		strs.add("Vodafone Faqs");
		strs.add("Callback");
		strs.add("send message");
		strs.add("My order");
		strs.add("Useful numbers");
		strs.add("My bill");
		FaqsSearchAdapter faqsSearchAdapter = new FaqsSearchAdapter(strs,
				getActivity());
		searchEt.setAdapter(faqsSearchAdapter);
		searchEt.setThreshold(1); // 设置输入一个字符 提示，默认为2
		searchEt.setDropDownAnchor(R.id.search_rl);
	}

	private void addSearchResultData() {
		List<Faq> faqs = new ArrayList<Faq>();
		Faq faq = new Faq();
		faq.setTitle("How do I get Netflix?");
		faq.getMap()
				.put("Should I be concerned?",
						"Did you receive a text message telling you about a \"verification code\" and that you should \"continue the Forgotten Password process on our website\", but you never started the Forgotten Password process for My Vodafone? If so, there's no need for concern. ");
		faq.getMap()
				.put("What is this message?",
						"This text message is part of the process for people to sign in to My Vodafone when they can't remember what their password is. We text them out a verification code, which they need to enter on the website, and then they change their password and have access to My Vodafone. ");
		faq.getMap()
				.put("Can I delete this message?",
						"if you didn't start this Forgot your Password process, but received the text message, then most likely someone accidentally typed in your phone number instead of their own. Regardless, as long as you have your phone, there's no risk of someone being able to sign in to your My Vodafone account, because they would need that verification code to do so. So go ahead and just delete the text message. That verification code will soon expire. And your My Vodafone password will remain unchanged.   Related questions");
		faqs.add(faq);
		Faq faq1 = new Faq();
		faq1.setTitle("How do I register my Mobile Broadband for My Vodafone?");
		faq1.getMap()
				.put("Can I delete this message?",
						"if you didn't start this Forgot your Password process, but received the text message, then most likely someone accidentally typed in your phone number instead of their own. Regardless, as long as you have your phone, there's no risk of someone being able to sign in to your My Vodafone account, because they would need that verification code to do so. So go ahead and just delete the text message. That verification code will soon expire. And your My Vodafone password will remain unchanged.   Related questions");
		faqs.add(faq1);
		FaqsDetailAdapter faqsDetailAdapter = new FaqsDetailAdapter(
				getActivity(), faqs);
		searchResultLv.setAdapter(faqsDetailAdapter);
	}
}
