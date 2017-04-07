package com.huawei.vodafone.ui.myview.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.huawei.vodafone.R;

public class SuccessDialog extends Dialog implements OnClickListener {

	private Context mContext;
	private TextView tv_success;
	private static SuccessDialog dialog;

	public static void show(Context context) {
		if (dialog == null) {
			dialog = new SuccessDialog(context);
		}
		dialog.show();
	}

	public SuccessDialog(Context context) {
		super(context, R.style.pop_dialog);
		this.mContext = context;
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.success_dialog, null);
		setContentView(layout);
		Window win = this.getWindow();
		win.getDecorView().setPadding(0, 0, 0, 0);
		WindowManager.LayoutParams lp = win.getAttributes();
		lp.width = WindowManager.LayoutParams.MATCH_PARENT;
		lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
		lp.gravity = Gravity.BOTTOM;
		win.setAttributes(lp);
		win.setWindowAnimations(R.style.anim_popup_dir);
		setCanceledOnTouchOutside(true);

		tv_success = (TextView) findViewById(R.id.tv_success);
		hander();
		setwindow();
	}

	private void setwindow() {

	}

	private void hander() {
		(new Handler()).postDelayed(new Runnable() {

			@Override
			public void run() {
				if (isShowing()) {
					cancel();
				}
			}
		}, 5000);
	}

	public void settext(String text) {

		tv_success.setText(text);

	}

	@Override
	public void onClick(View v) {

	}

}
