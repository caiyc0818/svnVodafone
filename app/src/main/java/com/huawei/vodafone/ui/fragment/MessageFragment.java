package com.huawei.vodafone.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.MessageInfo;
import com.huawei.vodafone.ui.adapter.MeaasgeListAdapter;
import com.huawei.vodafone.ui.myview.dialog.SelectPicDialog;
import com.huawei.vodafone.ui.myview.dialog.SelectPicDialog.OperationListener;
import com.huawei.vodafone.ui.myview.msglistview.MsgListView;
import com.huawei.vodafone.ui.myview.msglistview.MsgListView.IXListViewListener;
import com.huawei.vodafone.util.DateUtil;
import com.huawei.vodafone.util.StringUtils;
import com.huawei.vodafone.util.ViewUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageFragment extends BaseFragment implements OnClickListener,
		IXListViewListener {

	private MsgListView msgLv;
	private List<MessageInfo> messageList = new ArrayList<MessageInfo>();
	private MeaasgeListAdapter messageAdapter;
	private EditText sendEt;
	private ImageView sendIv;
	private ImageView photoIv;

	private String path = "";

	private Uri uri;
	private ImageView closeIv;
	private ImageView minIv;

	private boolean isInit=true;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.chat_to_us_main, null);
		initViews(view);
		addMessageData();
		return view;
	}

	/**
	 * 初始化组件
	 */
	private void initViews(View v) {
		msgLv = (MsgListView) v.findViewById(R.id.msg_listView);
		msgLv.setPullLoadEnable(false);
		msgLv.setXListViewListener(this);
		sendEt = (EditText) v.findViewById(R.id.send_et);
		sendIv = (ImageView) v.findViewById(R.id.send_iv);
		photoIv = (ImageView) v.findViewById(R.id.photo_iv);
		sendIv.setOnClickListener(this);
		photoIv.setOnClickListener(this);
		minIv = (ImageView) v.findViewById(R.id.chat_to_us_minimize_iv);
		closeIv = (ImageView) v.findViewById(R.id.close_iv);
		minIv.setOnClickListener(this);
		closeIv.setOnClickListener(this);
		ViewUtils.setButtonStateChangeListener(sendIv);
		ViewUtils.setButtonStateChangeListener(photoIv);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.send_iv:
			sendMessage();
			break;
		case R.id.photo_iv:
			new SelectPicDialog(getActivity(), mOperationListener).show();
			break;
		case R.id.close_iv:
		case R.id.chat_to_us_minimize_iv:
			getActivity().finish();
			break;
		default:
			break;
		}
	}

	// private void addMessageData() {
	// messageAdapter = new MeaasgeListAdapter(getActivity(), messageList);
	// msgLv.setAdapter(messageAdapter);
	// String[] chatWhats = getResources().getStringArray(
	// R.array.chat_what_array);
	// for (int i = 0; i < chatWhats.length; i++) {
	// MessageInfo messageInfo = new MessageInfo();
	// if (i % 2 == 0) {
	// messageInfo.getSender().setUserId("1");
	// messageInfo.getSender().setNickname("You");
	// } else {
	// messageInfo.getSender().setUserId("2");
	// messageInfo.getSender().setNickname("Claire");
	// }
	// messageInfo.setContent(chatWhats[i]);
	// messageInfo.setCreatetime(DateUtil.getCurrentTimeStr());
	// messageList.add(messageInfo);
	//
	// }
	// messageAdapter.notifyDataSetChanged();
	// msgLv.setSelection(messageList.size() - 1);
	// }

	private void addMessageData() {
		messageAdapter = new MeaasgeListAdapter(getActivity(), messageList);
		msgLv.setAdapter(messageAdapter);

		msgLv.postDelayed(new Runnable() {
			@Override
			public void run() {
				if(isInit){
				MessageInfo messageInfo = new MessageInfo();
				messageInfo.getSender().setUserId("2");
				messageInfo.getSender().setNickname("Claire");
				messageInfo.setContent("Hello!May I help you?");
				messageInfo.setCreatetime(DateUtil.getCurrentTimeStr());
				messageList.add(messageInfo);}
				else{
					MessageInfo messageInfo = new MessageInfo();
					messageInfo.getSender().setUserId("2");
					messageInfo.getSender().setNickname("Claire");
					messageInfo.setContent("Hey there explorer!");
					messageInfo.setCreatetime(DateUtil.getCurrentTimeStr());
					messageList.add(messageInfo);
					
					MessageInfo messageInfo1 = new MessageInfo();
					messageInfo1.getSender().setUserId("2");
					messageInfo1.getSender().setNickname("Claire");
					messageInfo1.setContent("Want to use your phone care free abroad?");
					messageInfo1.setCreatetime(DateUtil.getCurrentTimeStr());
					messageList.add(messageInfo1);
				}
				messageAdapter.notifyDataSetChanged();
			}
		}, 1000);
	}

	public void setInit(boolean isInit) {
		this.isInit = isInit;
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		msgLv.stopRefresh();
	}

	@Override
	public void onLoadMore() {
		// TODO Auto-generated method stub

	}

	private void sendMessage() {
		String content = sendEt.getText().toString();
		if (StringUtils.isEmpty(content))
			return;
		MessageInfo messageInfo = new MessageInfo();
		messageInfo.getSender().setUserId("1");
		messageInfo.getSender().setNickname("You");
		messageInfo.setContent(content);
		messageInfo.setCreatetime(DateUtil.getCurrentTimeStr());
		messageList.add(messageInfo);
		messageAdapter.notifyDataSetChanged();
		msgLv.smoothScrollToPositionFromTop(messageList.size() - 1, 100, 200);
		sendEt.setText("");
	}

	OperationListener mOperationListener = new OperationListener() {
		@Override
		public void operationPhoto(int witch) {
			// TODO Auto-generated method stub
			Intent intent = null;
			switch (witch) {
			case 1:
				Intent intent1 = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(intent1, 0);
				break;
			case 2:
				String haveSD = Environment.getExternalStorageState();
				if (!haveSD.equals(Environment.MEDIA_MOUNTED)) {
					Toast.makeText(getActivity(), "存储卡不可用", Toast.LENGTH_LONG)
							.show();
					return;
				}
				File dir = new File(Environment.getExternalStorageDirectory()
						+ "/" + "tripaway");
				if (!dir.exists()) {
					dir.mkdirs();
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");// 获取当前时间，进一步转化为字符串
				Date date = new Date();
				String str = format.format(date);
				path = Environment.getExternalStorageDirectory() + "/"
						+ "tripaway" + "/" + str + "photo.jpg";
				intent = new Intent(
						android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				File imgFile = new File(dir, str + "photo.jpg");
				uri = Uri.fromFile(imgFile);
				intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
				startActivityForResult(intent, 2);
				break;
			default:
			}
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if (savedInstanceState != null) {
			path = savedInstanceState.getString("path");
			uri = savedInstanceState.getParcelable("uri");
		}
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// Save away the original text, so we still have it if the activity
		// needs to be killed while paused.
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putString("path", path);
		savedInstanceState.putParcelable("uri", uri);
	}

	@Override
	public void onActivityResult(int arg0, int arg1, Intent arg2) {
		// TODO Auto-generated method stub
		super.onActivityResult(arg0, arg1, arg2);
		switch (arg0) {
		case 0:
			if (arg0 == 0 && arg1 == Activity.RESULT_OK && null != arg2) {
				Uri selectedImage = arg2.getData();
				String[] filePathColumn = { MediaStore.Images.Media.DATA };

				Cursor cursor = getActivity().getContentResolver().query(
						selectedImage, filePathColumn, null, null, null);
				cursor.moveToFirst();

				int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
				String picturePath = cursor.getString(columnIndex);
				cursor.close();
				if (null == picturePath)
					return;
				sendImageMessage(picturePath);

			}
			break;
		case 2:
			if (null == path)
				return;
			sendImageMessage(path);
			break;
		}
	}

	private void sendImageMessage(String picturePath) {
		MessageInfo messageInfo = new MessageInfo();
		messageInfo.getSender().setUserId("1");
		messageInfo.setContent("");
		messageInfo.getSender().setNickname("You");
		messageInfo.setLocalImage(picturePath);
		// messageInfo.setImage(picturePath);
		messageInfo.setCreatetime(DateUtil.getCurrentTimeStr());
		messageList.add(messageInfo);
		messageAdapter.notifyDataSetChanged();
		msgLv.smoothScrollToPositionFromTop(messageList.size() - 1, 100, 200);
	}
}
