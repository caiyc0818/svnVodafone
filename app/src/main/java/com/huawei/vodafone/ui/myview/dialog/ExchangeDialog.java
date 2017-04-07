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

public class ExchangeDialog extends Dialog {
	private Context mContext;

	private LayoutInflater inflater;

	private LayoutParams lp;

	private ImageView close;

	private Click click;

	private TextView dialog_yes;

	private TextView dialog_no;

	public ExchangeDialog(Context context) {
		super(context, R.style.pw_anim_style);
		redeem(context, R.layout.sign_in_credits_dialog);
	}

	/**
	 * 
	 * 这个的参数没有封装，注意三个按钮命名一致
	 */
	public ExchangeDialog(Context context, int xml, String title) {
		super(context, R.style.pw_anim_style);
		redeem(context, xml);
		TextView titleText = (TextView) findViewById(R.id.title);
		titleText.setText(title);
		ImageView back = (ImageView) findViewById(R.id.back);
		back.setVisibility(View.GONE);
	}

	private void redeem(Context context, int xml) {
		this.mContext = context;
		inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(xml, null);
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
		close.setOnClickListener(mOnCancelListener);
		dialog_yes.setOnClickListener(mOnCancelListener);
		dialog_no.setOnClickListener(mOnCancelListener);
	}

	android.view.View.OnClickListener mOnCancelListener = new android.view.View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.close:
				cancel();
				break;
			case R.id.dialog_yes:
				if (click != null) {
					click.onClicked(0, 0, "", true);
				}
				cancel();
				break;
			case R.id.dialog_no:
				if (click != null) {
					click.onClicked(0, 0, "", false);
				}
				cancel();
				break;
			default:
				break;
			}
		}
	};

	public void setClick(Click click) {
		this.click = click;

	}
}
