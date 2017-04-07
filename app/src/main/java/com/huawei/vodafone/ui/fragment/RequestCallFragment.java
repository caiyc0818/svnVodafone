package com.huawei.vodafone.ui.fragment;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.PersonalInfo;
import com.huawei.vodafone.bean.User;
import com.huawei.vodafone.bean.UserInfo;
import com.huawei.vodafone.ui.adapter.ChatWhatAdapter;
import com.huawei.vodafone.ui.adapter.RequestNumberAdapter;
import com.huawei.vodafone.ui.myview.MyListview;
import com.huawei.vodafone.util.StringUtils;
import com.huawei.vodafone.util.ToastUtil;
import com.huawei.vodafone.util.ViewUtils;

import java.util.ArrayList;
import java.util.List;

public class RequestCallFragment extends BaseFragment implements
		OnClickListener {

	private LinearLayout step1Ll;
	private LinearLayout step2Ll;
	private LinearLayout step3Ll;

	private LinearLayout[] stepLls = new LinearLayout[3];
	private TextView numberManuallyTv;
	private TextView updateTv;
	private MyListview chatWhatLv;
	private RelativeLayout chatWhatRl;
	private TextView chatWhatTv;

	private List<String> chatWhatStrs = new ArrayList<String>();
	private ChatWhatAdapter chatWhatAdapter;
	private EditText numberEt;
	private ImageView numberIv;
	private ImageView chatWhatIv;
	private TextView requestCallTv;
	private TextView callNum1Tv;
	private TextView callNum2Tv;
	private MyListview numberLv;

	private List<User> users = new ArrayList<User>();
	private RequestNumberAdapter requestNumberAdapter;
	private RelativeLayout numberRl;
	private TextView nameTv;
	private TextView callNumberTv;
	private TextView callWhatTv;
	private ImageView closeIv;
	private TextView cancelCallTv;
	
	private ArrayList<PersonalInfo> list;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.request_call, null);
		initViews(view);
		initData();
		return view;
	}

	/**
	 * 初始化组件
	 */
	private void initViews(View v) {
		step1Ll = (LinearLayout) v.findViewById(R.id.step1_ll);
		step2Ll = (LinearLayout) v.findViewById(R.id.step2_ll);
		step3Ll = (LinearLayout) v.findViewById(R.id.step3_ll);
		stepLls[0] = step1Ll;
		stepLls[1] = step2Ll;
		stepLls[2] = step3Ll;
		setWhichStepLl(0);
		numberManuallyTv = (TextView) v.findViewById(R.id.number_manually_tv);
		numberManuallyTv.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); // 下划线
		numberManuallyTv.getPaint().setAntiAlias(true);// 抗锯齿
		numberManuallyTv.setOnClickListener(this);
		updateTv = (TextView) v.findViewById(R.id.update_tv);
		updateTv.setVisibility(View.GONE);
		updateTv.setOnClickListener(this);
		chatWhatLv = (MyListview) v.findViewById(R.id.chat_what_lv);
		chatWhatIv = (ImageView) v.findViewById(R.id.chat_what_iv);
		chatWhatAdapter = new ChatWhatAdapter(chatWhatStrs, getActivity());
		chatWhatLv.setAdapter(chatWhatAdapter);
		chatWhatRl = (RelativeLayout) v.findViewById(R.id.chat_what_rl);
		chatWhatRl.setOnClickListener(this);
		chatWhatTv = (TextView) v.findViewById(R.id.chat_what_tv);
		chatWhatLv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				chatWhatTv.setText(chatWhatStrs.get(arg2));
				chatWhatStrs.clear();
				chatWhatAdapter.notifyDataSetChanged();
				chatWhatIv.animate().rotation(0);
				chatWhatRl.setBackgroundResource(R.drawable.shape_faqs_et_bg);
			}
		});
		chatWhatTv.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				setRequestCallState();
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

		numberLv = (MyListview) v.findViewById(R.id.number_lv);
		numberRl = (RelativeLayout) v.findViewById(R.id.number_rl);
		numberRl.setOnClickListener(this);
		requestNumberAdapter = new RequestNumberAdapter(users, getActivity());
		numberLv.setAdapter(requestNumberAdapter);
		numberEt = (EditText) v.findViewById(R.id.number_et);
		numberEt.setText(UserInfo.getUserMobile());
		numberEt.setEnabled(false);
		nameTv = (TextView) v.findViewById(R.id.name_tv);
		nameTv.setText("("+UserInfo.getUserName()+ "'s mobile)");
		numberIv = (ImageView) v.findViewById(R.id.number_iv);
		requestCallTv = (TextView) v.findViewById(R.id.request_call_tv);
		requestCallTv.setEnabled(false);
		requestCallTv.setOnClickListener(this);
		numberLv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				User user = users.get(arg2);
				numberEt.setText(user.getNumber());
				nameTv.setText("(" + user.getNickname() + "'s mobile)");
				users.clear();
				requestNumberAdapter.notifyDataSetChanged();
				numberIv.animate().rotation(0);
				numberRl.setBackgroundResource(R.drawable.shape_faqs_et_bg);
			}
		});
		numberEt.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				if (updateTv.getVisibility() == View.VISIBLE) {
					if (arg0.length() > 0) {
						updateTv.setBackgroundResource(R.color.support_red);
					} else {
						updateTv.setBackgroundResource(R.color.support_disable);
					}
					setRequestCallState();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub

			}
		});

		callNum1Tv = (TextView) v.findViewById(R.id.call_num1_tv);
		callNum2Tv = (TextView) v.findViewById(R.id.call_num2_tv);
		callNum1Tv.setOnClickListener(this);
		callNum2Tv.setOnClickListener(this);
		callNumberTv = (TextView) v.findViewById(R.id.call_number_tv);
		callWhatTv = (TextView) v.findViewById(R.id.call_what_tv);
		closeIv = (ImageView) v.findViewById(R.id.close_iv);
		closeIv.setOnClickListener(this);
		cancelCallTv = (TextView) v.findViewById(R.id.cancel_call_tv);
		cancelCallTv.setOnClickListener(this);
		ViewUtils.setButtonStateChangeListener(requestCallTv);
		ViewUtils.setButtonStateChangeListener(callNum1Tv);
		ViewUtils.setButtonStateChangeListener(callNum2Tv);
	}

	private void initData(){
		list = UserInfo.orderByTime();
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.chat_what_rl:
			if (chatWhatStrs.isEmpty()) {
				addChatWhatData();
				chatWhatRl.setBackgroundResource(R.drawable.shape_faqs_et_bg1);
				chatWhatIv.animate().rotation(180);
			} else {
				chatWhatRl.setBackgroundResource(R.drawable.shape_faqs_et_bg);
				chatWhatStrs.clear();
				chatWhatAdapter.notifyDataSetChanged();
				chatWhatIv.animate().rotation(0);
			}
			break;
		case R.id.number_rl:
			if (users.isEmpty()) {
				addUsersData();
				numberRl.setBackgroundResource(R.drawable.shape_faqs_et_bg1);
				numberIv.animate().rotation(180);
			} else {
				numberRl.setBackgroundResource(R.drawable.shape_faqs_et_bg);
				users.clear();
				requestNumberAdapter.notifyDataSetChanged();
				numberIv.animate().rotation(0);
			}
			break;
		case R.id.number_manually_tv:
			numberIv.setVisibility(View.GONE);
			numberManuallyTv.setVisibility(View.GONE);
			updateTv.setVisibility(View.VISIBLE);
			numberEt.setText("");
			numberEt.setFocusable(true);
			numberEt.requestFocus();
			numberRl.setEnabled(false);
			numberEt.setEnabled(true);
			numberEt.getLayoutParams().width = LayoutParams.MATCH_PARENT;
			nameTv.setVisibility(View.GONE);
			numberLv.setVisibility(View.GONE);
			break;
		case R.id.request_call_tv:
			if (!StringUtils.isMobileNumber(numberEt.getText().toString())) {
				ToastUtil.showToast(getActivity(),
						getString(R.string.mobile_invalid));
				return;
			}
			setWhichStepLl(1);
			break;
		case R.id.call_num1_tv:
		case R.id.call_num2_tv:
			setWhichStepLl(2);
			callNumberTv.setText(numberEt.getText());
			callWhatTv.setText(chatWhatTv.getText());
			break;
		case R.id.close_iv:
			getActivity().finish();
			break;
		case R.id.update_tv:
			if (!StringUtils.isMobileNumber(numberEt.getText().toString())) {
				ToastUtil.showToast(getActivity(),
						getString(R.string.mobile_invalid));
				return;
			}
			break;
		case R.id.cancel_call_tv:
			setWhichStepLl(0);
			break;
		default:
			break;
		}
	}

	private void setWhichStepLl(int i) {
		for (int j = 0; j < stepLls.length; j++) {
			if (j == i) {
				stepLls[j].setVisibility(View.VISIBLE);
			} else {
				stepLls[j].setVisibility(View.GONE);
			}
		}
	}

	private void addChatWhatData() {
		chatWhatStrs.clear();
		String[] chatWhats = getResources().getStringArray(
				R.array.chat_what_array1);
		for (int i = 0; i < chatWhats.length; i++) {
			chatWhatStrs.add(chatWhats[i]);
		}
		chatWhatAdapter.notifyDataSetChanged();
	}

	private void addUsersData() {
		String number = numberEt.getText().toString();
		for(PersonalInfo personalInfo:list){
			if(personalInfo.getUserMobile().equals(number)) {
				continue;
			}
			User userInfo = new User();
			userInfo.setNumber(personalInfo.getUserMobile());
			userInfo.setNickname(personalInfo.getUserName());

			users.add(userInfo);
		}
		requestNumberAdapter.notifyDataSetChanged();
	}

	private void setRequestCallState() {
		String number = numberEt.getText().toString();
		String chatWhat = chatWhatTv.getText().toString();
		if (StringUtils.isEmpty(number)
				|| StringUtils.isEmpty(chatWhat)
				|| chatWhat.equals(getResources().getString(
						R.string.select_an_option))) {
			requestCallTv.setEnabled(false);
			requestCallTv.setBackgroundResource(R.color.support_disable);
		} else {
			requestCallTv.setEnabled(true);
			requestCallTv.setBackgroundResource(R.color.support_red);
		}
	}
}
