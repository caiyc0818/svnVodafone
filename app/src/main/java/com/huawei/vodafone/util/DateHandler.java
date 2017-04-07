package com.huawei.vodafone.util;

import android.annotation.SuppressLint;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint("SimpleDateFormat")
public class DateHandler {
	private static Calendar calS = Calendar.getInstance();
	private static Pattern p = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");// 定义整则表达式
	/**
	 * 计算剩余时间
	 * 
	 * @param startDateStr
	 * @param endDateStr
	 * @return
	 */
	@SuppressLint("SimpleDateFormat")
	public static String remainDateToString(String startDateStr, String endDateStr) {
		java.util.Date startDate = null;
		java.util.Date endDate = null;
		try {
			startDate = new SimpleDateFormat("yyyyMMdd").parse(startDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
		try {
			endDate = new SimpleDateFormat("yyyyMMdd").parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
		calS.setTime(startDate);
		int startY = calS.get(Calendar.YEAR);
		int startM = calS.get(Calendar.MONTH);
		int startD = calS.get(Calendar.DATE);
		int startDayOfMonth = calS.getActualMaximum(Calendar.DAY_OF_MONTH);

		calS.setTime(endDate);
		int endY = calS.get(Calendar.YEAR);
		int endM = calS.get(Calendar.MONTH);
		// 处理2011-01-10到2011-01-10，认为服务为一天
		int endD = calS.get(Calendar.DATE) + 1;
		int endDayOfMonth = calS.getActualMaximum(Calendar.DAY_OF_MONTH);

		StringBuilder sBuilder = new StringBuilder();
		if (endDate.compareTo(startDate) < 0) {
			return sBuilder.append("过期").toString();
		}
		int lday = endD - startD;
		if (lday < 0) {
			endM = endM - 1;
			lday = startDayOfMonth + lday;
		}
		// 处理天数问题，如：2011-01-01 到 2013-12-31 2年11个月31天 实际上就是3年
		if (lday == endDayOfMonth) {
			endM = endM + 1;
			lday = 0;
		}
		int mos = (endY - startY) * 12 + (endM - startM);
		int lyear = mos / 12;
		int lmonth = mos % 12;
		if (lyear > 0) {
			if (lyear == 1) {

				sBuilder.append(lyear + "year ");
			} else {
				sBuilder.append(lyear + " years ");
			}
		}
		if (lmonth > 0) {
			if (lmonth == 1) {
				sBuilder.append(lmonth + " month ");
			} else {
				sBuilder.append(lmonth + " months ");
			}
		}
		if (lday > 0) {
			sBuilder.append(lday + " days ");
		}
		return sBuilder.toString();
	}

	/*
	 * 转换 dataAndTime 2013-12-31 23:59:59 到 date 2013-12-31
	 */
	public static String getDate(String dateAndTime) {
		if (dateAndTime != null && !"".equals(dateAndTime.trim())) {
			Matcher m = p.matcher(dateAndTime);
			if (m.find()) {
				return dateAndTime.subSequence(m.start(), m.end()).toString();
			}
		}
		return "data error";
	}

	public static void main(String[] args) {
		System.out.println(remainDateToString("2004-02-29", "2005-04-01"));
		System.out.println("A");
		Date time1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String tm = sdf.format(time1);// tm就是昨天的日期的字符串表示
		System.out.println(tm);
	}
}