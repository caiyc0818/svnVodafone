package com.huawei.vodafone.listener;

/**
 * 所有回调函数统一管理
 *
 */

public class Listener {

	public interface Click {
		public void onClicked(Object num, int num1, String num2, boolean num3);
	}

	public interface ClickTwo {
		public void onClicked(Object num, String num1, String num2, boolean num3);
	}

	public interface MyReceiver {
		public void onClicked(String num1, String num2, String num3);
	}

	public interface setOkListener {
		public void isOk(boolean isOk);
	}
}
