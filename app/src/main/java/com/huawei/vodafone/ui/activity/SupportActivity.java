package com.huawei.vodafone.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.ui.fragment.ChatToUsFragment;
import com.huawei.vodafone.ui.fragment.FaqsFragment;
import com.huawei.vodafone.ui.fragment.MessageFragment;
import com.huawei.vodafone.ui.fragment.RequestCallFragment;

public class SupportActivity extends FragmentActivity implements
		OnClickListener {

	private FaqsFragment faqsFragment;
	private LinearLayout faqsLl;
	private LinearLayout chatToUsLl;
	private LinearLayout requestCallLl;
	private LinearLayout communitiesLl;
	private FrameLayout supportFrame;
	private ChatToUsFragment chatToUsFragment;
	private MessageFragment msgFragment;
	private RequestCallFragment requestCallFragment;

	private LinearLayout[] buttomLl = new LinearLayout[4];

	private int currentButtomIndex = -1;
	private int messageNum;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.support);
		messageNum = getIntent().getIntExtra("messageNum", 0);
		initViews();
	}

	/**
	 * 初始化组件
	 */
	private void initViews() {
		faqsLl = (LinearLayout) findViewById(R.id.faqs_ll);
		chatToUsLl = (LinearLayout) findViewById(R.id.chat_to_us_ll);
		requestCallLl = (LinearLayout) findViewById(R.id.request_call_ll);
		communitiesLl = (LinearLayout) findViewById(R.id.communities_ll);
		supportFrame = (FrameLayout) findViewById(R.id.support_frame);
		// supportFrame.getLayoutParams().height=screenHeight-DensityUtil.dip2px(this,
		// 95);
		faqsLl.setOnClickListener(this);
		chatToUsLl.setOnClickListener(this);
		requestCallLl.setOnClickListener(this);
		// changeButtomState(faqsLl, true);
		// changeButtomState(chatToUsLl, false);
		// changeButtomState(requestCallLl, false);
		// changeButtomState(communitiesLl, false);
		buttomLl[0] = faqsLl;
		buttomLl[1] = chatToUsLl;
		buttomLl[2] = requestCallLl;
		buttomLl[3] = communitiesLl;
		if (messageNum > 0) {
			setTabSelection(5);
			changeButtomState(1);
			msgFragment.setInit(false);
		} else {
			setTabSelection(1);
			changeButtomState(0);
		}
	}

	/**
	 * 将所有的Fragment都置为隐藏状态。
	 * 
	 * @param transaction
	 *            用于对Fragment执行操作的事务
	 */
	private void hideFragments(FragmentTransaction transaction) {

		if (faqsFragment != null) {
			transaction.hide(faqsFragment);
		}
		if (chatToUsFragment != null) {
			transaction.hide(chatToUsFragment);
		}
		if (msgFragment != null) {
			transaction.hide(msgFragment);
		}
		if (requestCallFragment != null) {
			transaction.hide(requestCallFragment);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.faqs_ll:
			setTabSelection(1);
			changeButtomState(0);
			break;
		case R.id.chat_to_us_ll:
			setTabSelection(2);
			changeButtomState(1);
			break;
		case R.id.request_call_ll:
			setTabSelection(3);
			changeButtomState(2);
			break;
		default:
			break;
		}
	}

	private void setTabSelection(int index) {
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		hideFragments(transaction);
		switch (index) {
		case 1:
			if (faqsFragment == null) {
				faqsFragment = new FaqsFragment();
				transaction.add(R.id.support_frame, faqsFragment);
			} else {
				transaction.show(faqsFragment);
			}
			break;
		case 2:
			if (msgFragment != null) {
				transaction.show(msgFragment);
			} else {
				if (chatToUsFragment == null) {
					chatToUsFragment = new ChatToUsFragment();
					transaction.add(R.id.support_frame, chatToUsFragment);
				} else {
					transaction.show(chatToUsFragment);
				}
			}
			break;
		case 3:
			if (requestCallFragment == null) {
				requestCallFragment = new RequestCallFragment();
				;
				transaction.add(R.id.support_frame, requestCallFragment);
			} else {
				transaction.show(requestCallFragment);
			}
			break;
		case 5:
			if (msgFragment == null) {
				msgFragment = new MessageFragment();
				transaction.add(R.id.support_frame, msgFragment);
			} else {
				transaction.show(msgFragment);
			}
			break;
		default:
			break;
		}
		transaction.commitAllowingStateLoss();
	}

	private void changeButtomState(LinearLayout ll, boolean isPressed) {
		if (isPressed) {
			((ImageView) ((LinearLayout) ll.getChildAt(0)).getChildAt(0))
					.setSelected(true);
			((TextView) ll.getChildAt(1)).setTextColor(getResources().getColor(
					R.color.support_gray_more));
		} else {
			((ImageView) ((LinearLayout) ll.getChildAt(0)).getChildAt(0))
					.setSelected(false);
			((TextView) ll.getChildAt(1)).setTextColor(getResources().getColor(
					R.color.support_gray_more_little));
		}
	}

	private void changeButtomState(int i) {
		if (currentButtomIndex != i) {
			for (int j = 0; j < buttomLl.length; j++) {
				if (i == j) {
					changeButtomState(buttomLl[j], true);
				} else {
					changeButtomState(buttomLl[j], false);
				}
			}
		}
	}

	public void toMessageView() {
		setTabSelection(5);
	}
}
