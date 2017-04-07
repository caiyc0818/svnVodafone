package com.huawei.vodafone.ui.fragment;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.ui.activity.SupportActivity;
import com.huawei.vodafone.ui.adapter.ChatWhatAdapter;
import com.huawei.vodafone.ui.myview.MyListview;
import com.huawei.vodafone.util.StringUtils;
import com.huawei.vodafone.util.ToastUtil;
import com.huawei.vodafone.util.ViewUtils;

public class ChatToUsFragment extends BaseFragment implements OnClickListener {

	private RelativeLayout chatWhatRl;
	private MyListview chatWhatLv;
	private TextView questionManuallyTv;
	private ScrollView chatToUsSv;
	private TextView typeQuestionTv;
	private TextView startChattingTv;
	private TextView chatWhatTv;

	private List<String> chatWhatStrs = new ArrayList<String>();
	private ChatWhatAdapter chatWhatAdapter;
	private ImageView chatWhatIv;
	private EditText numberEt;
	private EditText emailEt;
	private EditText questionEt;
	private View closeIv;
	private View minIv;
	private TextView chatWhatTipTv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.chat_to_us, null);
		initViews(view);
		return view;
	}

	/**
	 * 初始化组件
	 */
	private void initViews(View v) {
		chatToUsSv = (ScrollView) v.findViewById(R.id.chat_to_us_sv);
		chatWhatLv = (MyListview) v.findViewById(R.id.chat_what_lv);
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
		chatWhatIv = (ImageView) v.findViewById(R.id.chat_what_iv);
		questionManuallyTv = (TextView) v
				.findViewById(R.id.question_manually_tv);
		typeQuestionTv = (TextView) v.findViewById(R.id.type_question_tv);
		typeQuestionTv.setVisibility(View.GONE);

		questionManuallyTv.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); // 下划线
		questionManuallyTv.getPaint().setAntiAlias(true);// 抗锯齿
		startChattingTv = (TextView) v.findViewById(R.id.start_chatting_tv);
		chatWhatRl.setOnClickListener(this);
		questionManuallyTv.setOnClickListener(this);
		startChattingTv.setOnClickListener(this);
		startChattingTv.setEnabled(false);

		numberEt = (EditText) v.findViewById(R.id.number_et);
		emailEt = (EditText) v.findViewById(R.id.email_et);
		questionEt = (EditText) v.findViewById(R.id.question_et);
		questionEt.setVisibility(View.GONE);

		chatWhatIv = (ImageView) v.findViewById(R.id.chat_what_iv);

		numberEt.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				setStartChatState();
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

		emailEt.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				setStartChatState();
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

		chatWhatTv.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				setStartChatState();
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

		questionEt.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				setStartChatState();
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
		minIv = v.findViewById(R.id.chat_to_us_minimize_iv);
		minIv.setOnClickListener(this);
		closeIv =  v.findViewById(R.id.close_iv);
		closeIv.setOnClickListener(this);
		chatWhatTipTv = (TextView) v.findViewById(R.id.chat_what_tip_tv);
		ViewUtils.setButtonStateChangeListener(chatWhatTv);
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
		case R.id.question_manually_tv:
			typeQuestionTv.setVisibility(View.VISIBLE);
			questionEt.setVisibility(View.VISIBLE);
			questionManuallyTv.setVisibility(View.GONE);
			chatWhatRl.setVisibility(View.GONE);
			chatWhatLv.setVisibility(View.GONE);
			chatWhatTipTv.setVisibility(View.GONE);
			break;
		case R.id.start_chatting_tv:
			String num = numberEt.getText().toString();
			String email = emailEt.getText().toString();
			if (!StringUtils.isMobileNumber(num)) {
				ToastUtil.showToast(getActivity(),
						getString(R.string.mobile_invalid));
				return;
			}
			if (!StringUtils.isEmail(email)) {
				ToastUtil.showToast(getActivity(),
						getString(R.string.email_invalid));
				return;
			}
			((SupportActivity) getActivity()).toMessageView();
			break;
		case R.id.close_iv:
		case R.id.chat_to_us_minimize_iv:
			getActivity().finish();
			break;
		default:
			break;
		}
	}

	private void addChatWhatData() {
		chatWhatStrs.clear();
		String[] chatWhats = getResources().getStringArray(
				R.array.chat_what_array);
		for (int i = 0; i < chatWhats.length; i++) {
			chatWhatStrs.add(chatWhats[i]);
		}
		chatWhatAdapter.notifyDataSetChanged();
	}

	private void setStartChatState() {
		String number = numberEt.getText().toString();
		String email = emailEt.getText().toString();
		String chatWhat = chatWhatTv.getText().toString();
		String question = questionEt.getText().toString();
		if (StringUtils.isEmpty(number)
				|| StringUtils.isEmpty(email)
				|| ((StringUtils.isEmpty(chatWhat) || chatWhat
						.equals(getResources().getString(
								R.string.select_an_option))) && StringUtils
						.isEmpty(question))) {
			startChattingTv.setEnabled(false);
			startChattingTv.setBackgroundResource(R.color.support_disable);
		} else {
			startChattingTv.setEnabled(true);
			startChattingTv.setBackgroundResource(R.color.support_red);
		}
	}
}
