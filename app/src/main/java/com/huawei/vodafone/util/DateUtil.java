package com.huawei.vodafone.util;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期相关帮助类
 * 
 * @function
 * @author JiangCS
 * @version 1.0, 2014年12月16日 上午11:31:57
 */
public class DateUtil {
	/**
	 * 获取两个日期之间的所有日期
	 * 
	 * @param startDay
	 * @param endDay
	 * @return
	 */
	public static ArrayList<String> getDaysBetweenDate(Calendar startDay, Calendar endDay) {
		if (startDay == null || endDay == null) {
			return null;
		}
		startDay.set(Calendar.HOUR, 0);
		startDay.set(Calendar.MINUTE, 0);
		startDay.set(Calendar.SECOND, 0);
		endDay.set(Calendar.HOUR, 0);
		endDay.set(Calendar.MINUTE, 0);
		endDay.set(Calendar.SECOND, 0);
		if (startDay.compareTo(endDay) > 0) {
			return null;
		}
		ArrayList<String> dateList = new ArrayList<String>();
		Calendar currentPrintDay = startDay;
		dateList.add(getFormateDate(currentPrintDay));
		while (true) {
			// 日期加一
			currentPrintDay.add(Calendar.DATE, 1);
			// 判断是否达到终了日
			if (currentPrintDay.compareTo(endDay) > 0) {
				break;
			}
			dateList.add(getFormateDate(currentPrintDay));
		}
		return dateList;
	}

	public static String getPreviousDate(Date date, int day) {
		long time = date.getTime() + day * 86400000;
		return ConverToString(new Date(time), "yyyy-MM-dd");
	}

	public static String getPreviousDate(int day) {
		long time = (new Date()).getTime() + day * 86400000;
		return ConverToString(new Date(time), "yyyy-MM-dd");
	}

	/**
	 * 当前距离月底的时间
	 * 
	 */
	public static int MonthLeftDate() {
		Calendar cal = Calendar.getInstance();
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH) - cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 日期格式化 yy-MM-dd
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static String getFormateDate(int year, int month, int day) {
		StringBuilder builder = new StringBuilder();
		builder.append(year);
		builder.append("-");
		builder.append(month < 10 ? "0" + month : month);
		builder.append("-");
		builder.append((day < 10) ? "0" + day : day);
		return builder.toString();
	}

	/**
	 * 日期格式化 yy-MM-dd
	 * 
	 * @param calendar
	 * @return
	 */
	public static String getFormateDate(Calendar calendar) {
		StringBuilder builder = new StringBuilder();
		builder.append(calendar.get(Calendar.YEAR));
		builder.append("-");
		builder.append((calendar.get(Calendar.MONTH) + 1) < 10 ? "0" + (calendar.get(Calendar.MONTH) + 1)
				: (calendar.get(Calendar.MONTH) + 1));
		builder.append("-");
		builder.append((calendar.get(Calendar.DAY_OF_MONTH) < 10) ? "0" + calendar.get(Calendar.DAY_OF_MONTH)
				: calendar.get(Calendar.DAY_OF_MONTH));
		return builder.toString();
	}

	public static String formateDateToTimeStr(String time) {
		String timeOut = "2015年01月01日";
		if (time == null) {
			return timeOut;
		}
		SimpleDateFormat sdfIn = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdfOut = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date date = sdfIn.parse(time);
			timeOut = sdfOut.format(date);
		} catch (ParseException e) {
			return timeOut;
		}
		return timeOut;
	}

	public static String formateDateToTime(String time) {
		String timeOut = "2015/01/01";
		if (time == null) {
			return timeOut;
		}
		SimpleDateFormat sdfIn = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdfOut = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date date = sdfIn.parse(time);
			timeOut = sdfOut.format(date);
		} catch (ParseException e) {
			return timeOut;
		}
		return timeOut;
	}

	public static String getFormateDate(String timeIn) {
		String timeOut = "2015年01月01日 00:00:00";
		if (timeIn == null) {
			return timeOut;
		}
		SimpleDateFormat sdfIn = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdfOut = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			Date date = sdfIn.parse(timeIn);
			timeOut = sdfOut.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timeOut;
	}

	public static long getTimeInMillis(String time) {
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(new SimpleDateFormat("yyyyMMddHHmmss").parse(time + "000000"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c.getTimeInMillis();
	}

	public static long formatStrtoLong(String time) {
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(new SimpleDateFormat("yyyyMMddHHmmss").parse(time));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c.getTimeInMillis();
	}

	public static long getcurrentTimeMillis() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		// System.out.println(cal.getTimeInMillis());
		// SimpleDateFormat sdfOut = new
		// SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// String timeOut = sdfOut.format(cal.getTimeInMillis());
		// System.out.println("timeOut=" + timeOut);
		return cal.getTimeInMillis();
	}

	public static boolean isBeyondMaxDay(String beginDate, String endDate, int day) {
		long millis = getTimeInMillis(endDate) - getTimeInMillis(beginDate);
		long countDay = millis / (3600 * 24 * 1000);
		if (countDay > day) {
			return true;
		} else {
			return false;
		}
	}

	public static String getCurrentTimeStr() {
		Format format = new SimpleDateFormat("yyyyMMddHHmmss");
		String timString = format.format(new Date());
		return timString;
	}

	// 把日期转为字符串
	public static String ConverToString(Date date, String format) {
		DateFormat df = new SimpleDateFormat(format);// format中填形如"yyyy/MM/dd
														// HH:mm"
		if (date == null) {
			return "- -";
		}
		return df.format(date);
	}

	// 把字符串转为日期
	public static Date ConverToDate(String strDate, String format) {
		DateFormat df = new SimpleDateFormat(format);// format中填形如
														// yyyyMMddHHmmss
		Date date = null;
		try {
			date = df.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 功能描述：返回小
	 *
	 * @param date
	 *            日期
	 * @return 返回小时
	 */
	public static int getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 功能描述：返回小
	 *
	 * @param date
	 *            日期
	 * @return 返回天
	 */
	public static int getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	public static int getDay(long date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	public static String formateTime(String time) {
		String timeOut = "";
		if (time == null) {
			return "";
		}
		SimpleDateFormat sdfIn = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdfOut = new SimpleDateFormat("hh.mm");
		try {
			Date date = sdfIn.parse(time);
			if (getHour(date) > 12) {
				timeOut = sdfOut.format(date) + "pm";
			} else {
				timeOut = sdfOut.format(date) + "am";
			}

		} catch (ParseException e) {
			return timeOut;
		}
		return timeOut;
	}

	public static String formateDateToTimeStr1(String time) {
		if (time == null) {
			return time;
		}
		SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdfOut = new SimpleDateFormat("yyyy.MM.dd");
		try {
			Date date = sdfIn.parse(time);
			time = sdfOut.format(date);
		} catch (ParseException e) {
			return time;
		}
		return time;
	}

	public static String getPreNMonthDay(int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -n);
		return ConverToString(calendar.getTime(), "yyyy-MM-dd");
	}

	public static String formateDateToUSADate(String time) {
		if (time == null) {
			return time;
		}
		SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdfOut = new SimpleDateFormat("dd MMMMM yyyy", Locale.US);
		try {
			Date date = sdfIn.parse(time);
			time = sdfOut.format(date);
		} catch (ParseException e) {
			return time;
		}
		return time;
	}

	/**
	 * 获取当月的 天数
	 */
	public static int getCurrentMonthDay() {

		Calendar a = Calendar.getInstance();
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	public static String getEnglishMonth(int month) {
		switch (month) {
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			break;
		}
		return "";
	}
}
