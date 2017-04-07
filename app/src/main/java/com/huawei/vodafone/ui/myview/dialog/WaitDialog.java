package com.huawei.vodafone.ui.myview.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.vodafone.R;

public class WaitDialog extends Dialog {
	private LayoutParams lp;
	private Context mContext;
	private FrameLayout wait_bg;
	private TextView wait_text;
	private ImageView wait_image;
	private static WaitDialog dialog;

	public WaitDialog(Context context) {
		super(context, R.style.myDialog1);
		this.mContext = context;
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.wait_dialog, null);
		setContentView(layout);
		// 设置window属性
		lp = getWindow().getAttributes();
		lp.width = LayoutParams.MATCH_PARENT;
		lp.height = LayoutParams.MATCH_PARENT;
		getWindow().setAttributes(lp);

		wait_bg = (FrameLayout) findViewById(R.id.wait_bg);
		wait_text = (TextView) findViewById(R.id.wait_text);
		wait_image = (ImageView) findViewById(R.id.wait_image);
	}

	public void setLogin() {
		wait_bg.setBackgroundResource(R.drawable.main_bg);
		wait_image.setVisibility(View.VISIBLE);
		wait_text.setText("Loading...");
		wait_text.setVisibility(View.VISIBLE);
	}
}
