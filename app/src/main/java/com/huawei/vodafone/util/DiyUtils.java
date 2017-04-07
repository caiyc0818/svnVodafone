package com.huawei.vodafone.util;

public class DiyUtils {

	public static String getDataValue(int id) {
		String value = "";
		if (id == 100000) {
			value = "300MB";
		} else if (id == 100001) {
			value = "500MB";
		} else if (id == 100002) {
			value = "800MB";
		} else if (id == 100038) {
			value = "500MB";
		} else if (id == 100039) {
			value = "1GB";
		} else if (id == 100040) {
			value = "2GB";
		} else if (id == 100041) {
			value = "4GB";
		}else {
			value = "0";
		}
		return value;

	}

	public static String getVoiceValue(int id) {
		String value = "";
		if (id == 100006) {
			value = "100";
		} else if (id == 100007) {
			value = "300";
		} else if (id == 100008) {
			value = "500";
		} else if (id == 100020) {
			value = "100";
		} else if (id == 100021) {
			value = "200";
		} else if (id == 100034) {
			value = "200";
		} else if (id == 100035) {
			value = "500";
		} else if (id == 100036) {
			value = "1000";
		} else if (id == 100037) {
			value = "2000";
		}else {
			value = "0";
		}
		return value;

	}

	public static String getSmsValue(int id) {
		String value = "";
		if (id == 100042) {
			value = "100";
		} else if (id == 100043) {
			value = "500";
		} else if (id == 100044) {
			value = "1000";
		} else if (id == 100045) {
			value = "200";
		}else {
			value = "0";
		}
		return value;

	}
}
