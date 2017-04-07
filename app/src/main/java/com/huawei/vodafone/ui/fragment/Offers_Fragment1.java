package com.huawei.vodafone.ui.fragment;

import java.util.ArrayList;
import java.util.List;

import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.PlansItem;
import com.huawei.vodafone.ui.activity.SettingsOffersAndExtrarsPlansActivity;
import com.huawei.vodafone.ui.activity.SettingsOffersAndExtrarsPlansDetailsActivity;
import com.huawei.vodafone.util.DiyUtils;
import com.huawei.vodafone.util.PreferenceUtils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author weich
 * @date 2016-1-25 下午3:31:31 个人中心
 */
public class Offers_Fragment1 extends BaseFragment implements OnClickListener {
	private int mCurIndex;
	private List<PlansItem> plansList = new ArrayList<PlansItem>();
	private TextView title, data, call, money;
	private ImageView image;
	StringBuffer callAndSms  = new StringBuffer();

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment1, null);
		initView(view);
		return view;
	}

	@SuppressWarnings("unchecked")
	private void initView(View view) {
		Bundle bundle = getArguments();
		mCurIndex = bundle.getInt("type");
		plansList.addAll((ArrayList<PlansItem>) bundle.getSerializable("DiyList"));

		title = (TextView) view.findViewById(R.id.title);
		data = (TextView) view.findViewById(R.id.data);
		call = (TextView) view.findViewById(R.id.call);
		money = (TextView) view.findViewById(R.id.money);
		image = (ImageView) view.findViewById(R.id.image);
		image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), SettingsOffersAndExtrarsPlansDetailsActivity.class);
				Bundle extras = new Bundle();
				extras.putSerializable("plans_details", plansList.get(mCurIndex));
				intent.putExtras(extras);
				getActivity().startActivity(intent);
			}
		});
		for (int i = 0; i < plansList.get(mCurIndex).getLevelList().size(); i++) {
			if ("C_DATA_LEVEL".equals(plansList.get(mCurIndex).getLevelList().get(i).getItemId())) {
				data.setText(DiyUtils.getDataValue(Integer.parseInt(plansList.get(mCurIndex).getLevelList().get(i).getLevelId())) + " UK data");
				title.setText(Html.fromHtml("Red " + "<b>" + DiyUtils.getDataValue(Integer.parseInt(plansList.get(mCurIndex).getLevelList().get(i).getLevelId()))
						+ "</b>" + " Bundle"));
			}
			if ("C_UNIT_LEVEL".equals(plansList.get(mCurIndex).getLevelList().get(i).getItemId())) {
				callAndSms.append(
						DiyUtils.getVoiceValue(Integer.parseInt(plansList.get(mCurIndex).getLevelList().get(i).getLevelId()))+" calls & unlimited texts");
			}
			if ("C_SMS_LEVEL".equals(plansList.get(mCurIndex).getLevelList().get(i).getItemId())) {
				callAndSms.substring(0, callAndSms.length()-23);
				callAndSms.append(" & "
						+ DiyUtils.getSmsValue(Integer.parseInt(plansList.get(mCurIndex).getLevelList().get(i).getLevelId()))+" texts");
			}
		}
		call.setText(callAndSms);
		double money = 0;
		int unit = Integer.valueOf(plansList.get(mCurIndex).getFee().getCurrencyUnit());
		money = money + plansList.get(mCurIndex).getFee().getCurrencyValue() * Math.pow(10, -unit);
		this.money.setText("€" + money + " " + getResources().getString(R.string.settings_per_month2));

	}

	@Override
	public void onClick(View v) {

	}
}
