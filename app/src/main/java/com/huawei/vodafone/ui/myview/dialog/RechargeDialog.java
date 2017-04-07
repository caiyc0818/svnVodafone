package com.huawei.vodafone.ui.myview.dialog;

import com.huawei.vodafone.R;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.WindowManager.LayoutParams;

public class RechargeDialog extends Dialog {
	private LayoutParams lp;

	public RechargeDialog(Context context) {
		super(context, R.style.myDialog1);
		setContentView(R.layout.recharge_dialog);
		// 设置window属性
		lp = getWindow().getAttributes();
		lp.width = LayoutParams.FILL_PARENT;
		lp.height = LayoutParams.FILL_PARENT;
		getWindow().setAttributes(lp);
	}

}
