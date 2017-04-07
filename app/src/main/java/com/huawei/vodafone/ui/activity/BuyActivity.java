package com.huawei.vodafone.ui.activity;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.VolleyError;
import com.google.gson.JsonObject;
import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.PlansItem;
import com.huawei.vodafone.net.IRequest;
import com.huawei.vodafone.net.RequestJSon;
import com.huawei.vodafone.net.RequestListener;
import com.huawei.vodafone.net.URLs;
import com.huawei.vodafone.ui.myview.dialog.WaitDialog;
import com.huawei.vodafone.util.DiyUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author kanl
 *
 * @create 2016年7月29日 下午5:06:58
 */
public class BuyActivity extends BaseActivity implements RequestListener {
	private TextView tv_yes, tv_no, tv_center;
	private PlansItem plansDetail;
	private String dataId;
	private String callId;
	private String smsId;
	private WaitDialog wait;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.plans_buy_activity);
		initSecondTitle("", false, true);
		plansDetail = (PlansItem) getIntent().getSerializableExtra("plans_details");
		initView();
	}

	private void initView() {
		tv_yes = (TextView) findViewById(R.id.tv_yes);
		tv_no = (TextView) findViewById(R.id.tv_no);
		tv_center = (TextView) findViewById(R.id.tv_center);
		tv_yes.setOnClickListener(this);
		tv_no.setOnClickListener(this);
		for (int i = 0; i < plansDetail.getLevelList().size(); i++) {
			if ("C_DATA_LEVEL".equals(plansDetail.getLevelList().get(i).getItemId())) {
				tv_center.setText(getString(R.string.settings_do_you) + " "
						+ DiyUtils.getDataValue(Integer.parseInt(plansDetail.getLevelList().get(i).getLevelId()))
						+ " "+getString(R.string.settings_bundle) + "?");
				dataId = plansDetail.getLevelList().get(i).getLevelId();
			} else if ("C_UNIT_LEVEL".equals(plansDetail.getLevelList().get(i).getItemId())) {
				callId = plansDetail.getLevelList().get(i).getLevelId();
			} else if ("C_SMS_LEVEL".equals(plansDetail.getLevelList().get(i).getItemId())) {
				smsId = plansDetail.getLevelList().get(i).getLevelId();
			}
		}

	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.tv_yes:
			IRequest.post(5, URLs.ADDOPTIONAL, RequestJSon.Optionaloffering(dataId, callId, smsId, true),
					BuyActivity.this);
			wait = new WaitDialog(BuyActivity.this);
			wait.show();
			break;
		case R.id.tv_no:
			finish();
			activityAnimationDown();
			break;

		default:
			break;
		}
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
		activityAnimationDown();
	}

	@Override
	public void requestSuccess(Object tag, String json) {
		// TODO Auto-generated method stub
		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(json);
			JSONObject obj = jsonObj.getJSONObject("header");
			String code = obj.getString("resultCode");
			if ("0".equals(code) || "1".equals(code)) {
				setResult(-1);
				Intent intent = new Intent("offer_diy_successed");
				sendBroadcast(intent);
			} else {
				setResult(-2);
			}
			finish();
			activityAnimationDown();
			wait.cancel();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void requestError(Object tag, VolleyError e) {
		// TODO Auto-generated method stub

	}

}
