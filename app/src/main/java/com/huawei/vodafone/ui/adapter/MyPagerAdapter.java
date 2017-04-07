package com.huawei.vodafone.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.huawei.vodafone.MyApplication;
import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.DialogInfo;
import com.huawei.vodafone.bean.UserInfo;
import com.huawei.vodafone.listener.Listener.ClickTwo;

/**
 * @author weich
 */
public class MyPagerAdapter extends PagerAdapter {
	public List<DialogInfo> list;

	private Context context;

	private ViewPager viewPager;

	public List<View> mListViews;

	private ClickTwo click;

	public MyPagerAdapter(Context context, List<DialogInfo> list,
			ViewPager viewPager) {
		this.list = list;
		this.context = context;
		this.viewPager = viewPager;
		mListViews = new ArrayList<View>();
		init();
	}

	private void init() {
		mListViews.clear();
		LayoutInflater mInflater = ((Activity) context).getLayoutInflater();
		final LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) viewPager
				.getLayoutParams();
		if (list.size() == 0) {
			mListViews.add(mInflater.inflate(R.layout.main_news_dialog, null));
			setWelcomeName();
			mListViews.get(0).measure(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT);
			linearParams.height = mListViews.get(0).getMeasuredHeight();
		} else {
			for (int i = 0; i < list.size(); i++) {
				mListViews.add(mInflater.inflate(
						R.layout.main_news_white_dialog, null));
			}
			boolean aa = false;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getId().equals("Content Bundle")
						|| list.get(j).getId().equals("UpSell Bundle")
						|| list.get(j).getId().equals("LowBalance")
						|| list.get(j).getId()
								.equals("InternationalRoamingData")
						|| list.get(j).getId().equals("StarbucksCoupon")) {
					if (MyApplication.getLarge() > 1700) {
						linearParams.height = 700;
					} else {
						linearParams.height = 500;
					}
					aa = true;
				}
			}
			if (!aa) {
				mListViews.get(0).measure(LayoutParams.WRAP_CONTENT,
						LayoutParams.WRAP_CONTENT);
				linearParams.height = mListViews.get(0).getMeasuredHeight();
			}
		}
		(new Handler()).postDelayed(new Runnable() {
			@Override
			public void run() {
				viewPager.setLayoutParams(linearParams);
			}
		}, 30);
	}

	View.OnClickListener myoncliek = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (click == null) {
				return;
			}
			int num = (Integer) v.getTag();
			if (num % 2 == 0) {
				click.onClicked(num / 2, list.get(num / 2).getId(),
						list.get(num / 2).getChannel(), true);
			} else {
				click.onClicked(num / 2, list.get(num / 2).getId(),
						list.get(num / 2).getChannel(), false);
			}
		}
	};

	@Override
	public void destroyItem(View arg0, int position, Object arg2) {
		// ((ViewPager) arg0).removeView(mListViews.get(position));
	}

	@Override
	public void finishUpdate(View arg0) {
	}

	@Override
	public int getCount() {
		return list.size() == 0 ? 1 : list.size();
	}

	public void setWelcomeName() {
		if (list.size() == 0) {
			TextView text = (TextView) mListViews.get(0).findViewById(
					R.id.welcome_name);
			text.setText("Hello " + UserInfo.getUserName());
		}
	}

	@Override
	public Object instantiateItem(View arg0, int position) {
		ViewParent parent = mListViews.get(position).getParent();
		if (parent != null) {
			viewPager.removeView(mListViews.get(position));
		}
		((ViewPager) arg0).addView(mListViews.get(position), 0);

		if (list.size() != 0) {
			if (list.get(position).getTitle().contains("<b>")) {
				getTitle(position).setText(
						Html.fromHtml(list.get(position).getTitle()));
			} else {
				getTitle(position).setText(list.get(position).getTitle());
			}
			if (list.get(position).getContent().contains("<b>")) {
				getContent(position).setText(
						Html.fromHtml(list.get(position).getContent()));
			} else {
				getContent(position).setText(list.get(position).getContent());
			}
			if (list.get(position).getConfirm().contains("<b>")) {
				getOk(position).setText(
						Html.fromHtml(list.get(position).getConfirm()));
			} else {
				getOk(position).setText(list.get(position).getConfirm());
			}
			if (list.get(position).getCancel().contains("<b>")) {
				getNo(position).setText(
						Html.fromHtml(list.get(position).getCancel()));
			} else {
				getNo(position).setText(list.get(position).getCancel());
			}
			getOk(position).setTag(position * 2);
			getNo(position).setTag(position * 2 + 1);
			getOk(position).setOnClickListener(myoncliek);
			getNo(position).setOnClickListener(myoncliek);

		}
		return mListViews.get(position);
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == (arg1);
	}

	@Override
	public void restoreState(Parcelable arg0, ClassLoader arg1) {
	}

	@Override
	public Parcelable saveState() {
		return null;
	}

	@Override
	public void startUpdate(View arg0) {
	}

	public void setListener(ClickTwo click) {
		this.click = click;

	}

	public void setList(List<DialogInfo> list) {
		this.list = list;
		init();
	}

	private TextView getTitle(int position) {
		return (TextView) mListViews.get(position)
				.findViewById(R.id.bill_ready);
	}

	private TextView getContent(int position) {
		return (TextView) mListViews.get(position).findViewById(
				R.id.bill_ready_text);
	}

	private Button getOk(int position) {
		return (Button) mListViews.get(position).findViewById(R.id.dialog_ok);
	}

	private Button getNo(int position) {
		return (Button) mListViews.get(position).findViewById(R.id.dialog_no);
	}
}
