package com.huawei.vodafone.ui.myview.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.listener.Listener.ClickTwo;

public class NotificationDialog extends Dialog {

	private Context mContext;

	private LayoutInflater inflater;

	private LayoutParams lp;

	private ClickTwo click;

	private TextView dialog_yes;

	private TextView title;

	private TextView text;

	private TextView dialog_no;

	private int tag = 0;

	public NotificationDialog(Context context) {
		super(context, R.style.myDialog2);
		this.mContext = context;
		inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.main_news_white_dialog, null);
		setContentView(layout);
		// 设置window属性
		lp = getWindow().getAttributes();
		lp.width = LayoutParams.MATCH_PARENT;
		lp.height = LayoutParams.MATCH_PARENT;
		lp.gravity = Gravity.BOTTOM;
		// lp.dimAmount = (float) 0.9f; // 去背景遮盖
		// lp.alpha = 0.9f;
		getWindow().setAttributes(lp);
		getWindow().setWindowAnimations(R.style.pw_anim_style); // 设置窗口弹出动画
		dialog_yes = (TextView) findViewById(R.id.dialog_ok);
		dialog_no = (TextView) findViewById(R.id.dialog_no);
		text = (TextView) findViewById(R.id.bill_ready_text);
		title = (TextView) findViewById(R.id.bill_ready);
		dialog_yes.setOnClickListener(mOnCancelListener);
		dialog_no.setOnClickListener(mOnCancelListener);
	}

	android.view.View.OnClickListener mOnCancelListener = new android.view.View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.dialog_ok:
				if (click != null) {
					click.onClicked(tag, "", "", true);
				}
				break;
			case R.id.dialog_no:
				if (click != null) {
					click.onClicked(tag, "", "", false);
				}
				break;
			default:
				break;
			}
			cancel();
		}
	};

	public void setClick(ClickTwo click) {
		this.click = click;

	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public void setMessage(String content, String title, String yestext,
			String notext) {
		text.setText(content);
		this.title.setText(title);
		dialog_yes.setText(yestext);
		dialog_no.setText(notext);
	}

	public void setContentText(String text) {
		this.text.setText(text);
	}

	public void setTitle(String text) {
		this.title.setText(text);
	}

	public void setYesText(String text) {
		this.dialog_yes.setText(text);
	}

	public void setNoText(String text) {
		this.dialog_no.setText(text);
	}
}
