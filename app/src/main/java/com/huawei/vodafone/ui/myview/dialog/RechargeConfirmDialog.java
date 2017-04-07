package com.huawei.vodafone.ui.myview.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.vodafone.R;

public class RechargeConfirmDialog extends Dialog {
	private Context mContext;

	private LayoutInflater inflater;

	private LayoutParams lp;
	private ImageView close;
	private TextView yes;
	private TextView no;
	private OnClickListener listener;

	public RechargeConfirmDialog(Context context) {
		super(context, R.style.myDialog1);
		this.mContext = context;
		inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.recharge_confirm_dialog, null);
		setContentView(view);
		lp = getWindow().getAttributes();
		lp.width = LayoutParams.MATCH_PARENT;
		lp.height = LayoutParams.MATCH_PARENT;
		getWindow().setAttributes(lp);
		close = (ImageView) view.findViewById(R.id.close);
		yes = (TextView) view.findViewById(R.id.tv_log_out_yes);
		no = (TextView) view.findViewById(R.id.tv_log_out_no);
		ImageView back = (ImageView) findViewById(R.id.back);
		back.setVisibility(View.GONE);
		TextView title = (TextView) findViewById(R.id.title);
		title.setText(context.getText(R.string.want_to_recharge));
		close.setOnClickListener(new android.view.View.OnClickListener() {

			@Override
			public void onClick(View v) {
				dismiss();
			}
		});
		yes.setOnClickListener(new android.view.View.OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.onclickYes();
			}
		});
		no.setOnClickListener(new android.view.View.OnClickListener() {

			@Override
			public void onClick(View v) {
				dismiss();
			}
		});
	}

	public void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}

	public interface OnClickListener {
		void onclickYes();
	}

}
