package com.huawei.vodafone.util;

import android.util.Log;

/**
 * @author hanweipeng
 * @category日志工具类
 */
public class DebugLog {

	private DebugLog() {
	}

	private static boolean LOG_ENABLED = true;
	private static int showCount = 3500;

	public static void v(String tag, String msg) {
		if (LOG_ENABLED) {
			Log.v(tag, msg);
		}
	}

	public static void d(String tag, String msg) {
		if (LOG_ENABLED) {
			Log.d(tag, msg);
		}
	}

	public static void i(String tag, String msg) {
		if (LOG_ENABLED) {
			Log.i(tag, msg);
		}
	}

	public static void w(String tag, String msg) {
		if (LOG_ENABLED) {
			Log.w(tag, msg);
		}
	}

	public static void e(String tag, String msg) {
		if (LOG_ENABLED) {
			Log.e(tag, msg);
		}
	}

	public static void v(String tag, String msg, Throwable tr) {
		if (LOG_ENABLED) {
			Log.v(tag, msg, tr);
		}
	}

	public static void i(String tag, String msg, Throwable tr) {
		if (LOG_ENABLED) {
			Log.i(tag, msg, tr);
		}
	}

	public static void d(String tag, String msg, Throwable tr) {
		if (LOG_ENABLED) {
			Log.d(tag, msg, tr);
		}
	}

	public static void w(String tag, String msg, Throwable tr) {
		if (LOG_ENABLED) {
			Log.w(tag, msg, tr);
		}
	}

	public static void e(String tag, String msg, Throwable tr) {
		if (LOG_ENABLED) {
			Log.e(tag, msg, tr);
		}
	}

	public static void printException(Exception e, boolean sendBugsense) {
		e.printStackTrace();
		if (sendBugsense) {
			// BugSenseHandler.sendException(e);
		}
	}

	public static void printException(String tag, Exception e,
			boolean sendBugsense) {

		DebugLog.e(
				tag,
				"Exception cause: " + e.getCause() + " message: "
						+ e.getMessage());
		e.printStackTrace();
		if (sendBugsense) {
			// BugSenseHandler.sendExceptionMessage("Exception", tag, e);
		}
	}

	public static void printException(String tag, String secondLevelMsg,
			Exception e, boolean sendBugsense) {
		if (LOG_ENABLED) {
			e(tag, secondLevelMsg + " :Exception cause: " + e.getCause()
					+ " message: " + e.getMessage());
			e.printStackTrace();
			if (sendBugsense) {
				// BugSenseHandler.sendExceptionMessage("Exception", tag, e);
			}
		}
	}

	public static String exceptionMessageGenerator(Exception e) {
		return " :Exception cause: " + e.getCause() + " message: "
				+ e.getMessage();
	}

	/**
	 * 分段打印出较长log文本
	 * 
	 */
	public static void i(String tag, String msg, boolean cut) {
		if (cut) {
			while (msg.length() > showCount) {
				i(tag, msg.substring(0, showCount));
				msg = msg.substring(showCount);
			}
			if (msg.length() > 0) {
				i(tag, msg);
			}
		} else {
			i(tag, msg);
		}
	}

}
