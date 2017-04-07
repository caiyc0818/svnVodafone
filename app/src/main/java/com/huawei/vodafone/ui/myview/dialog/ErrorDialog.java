package com.huawei.vodafone.ui.myview.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.vodafone.R;
import com.huawei.vodafone.listener.Listener.Click;

public class ErrorDialog extends Dialog {

	private Context mContext;

	private LayoutInflater inflater;

	private LayoutParams lp;

	private ImageView close;

	private Click click;

	private TextView dialog_yes;

	private TextView title;

	private TextView text;

	private TextView dialog_no;

	private int tag = 0;

	public ErrorDialog(Context context) {
		super(context, R.style.pw_anim_style);
		this.mContext = context;
		inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.error_dialog, null);
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
		close = (ImageView) findViewById(R.id.close);
		dialog_yes = (TextView) findViewById(R.id.dialog_yes);
		dialog_no = (TextView) findViewById(R.id.dialog_no);
		ImageView back = (ImageView) findViewById(R.id.back);
		back.setVisibility(View.GONE);
		text = (TextView) findViewById(R.id.text);
		title = (TextView) findViewById(R.id.title);
		title.setText("We're Sorry");
		close.setOnClickListener(mOnCancelListener);
		dialog_yes.setOnClickListener(mOnCancelListener);
		dialog_no.setOnClickListener(mOnCancelListener);
	}

	android.view.View.OnClickListener mOnCancelListener = new android.view.View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.close:
				break;
			case R.id.dialog_yes:
				if (click != null) {
					click.onClicked(tag, 0, "", true);
				}
				break;
			case R.id.dialog_no:
				if (click != null) {
					click.onClicked(tag, 0, "", false);
				}
				break;
			default:
				break;
			}
			cancel();
		}
	};

	public void setClick(Click click) {
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
		dialog_no.setVisibility(View.VISIBLE);
	}

	public void setrestore() {
		title.setText("We're Sorry");
		text.setText(mContext.getString(R.string.error_text));
		dialog_yes.setText("Retry");
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
