package com.huawei.vodafone.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.Map.Entry;

import android.text.TextUtils;

/**
 * 与业务无关的公共方法
 * 
 * @author luow
 */
public class MethodUtils {

	/**
	 * 根据value获取key
	 * 
	 * @param statusMap
	 * @param stStr
	 * @return
	 */
	public static String getStatusId(HashMap<String, String> statusMap, String stStr) {
		if (stStr == null || statusMap == null) {
			return "-1";
		}

		Iterator<Entry<String, String>> it = statusMap.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			if (stStr.equals(entry.getValue())) {
				return entry.getKey();
			}
		}
		return "-1";
	}

	/***
	 * 在map中取数据，处理一些默认的错误
	 * 
	 * @param info
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static String getValueFormMap(HashMap<String, String> info, String key, String defValue) {

		if (info == null || info.size() <= 0) {
			return defValue;
		}
		Object ob = info.get(key);
		if (ob == null) {
			return defValue;
		}
		return (String) ob.toString();
	}

	// 是否是电话号码
	public static boolean isPhone(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		String reg = "^1[0-9]{10}$";
		return str.matches(reg);
	}

	// 是否是手机号码
	public static boolean isMobile(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		String reg = "^1([3][0-9]{1}|[4][5,7]{1}|[5][0-3,5-9]{1}|[7][0,6-8]{1}|[8][0-9]{1})[0-9]{8}$";
		return str.matches(reg);
	}

	// 是否是纯数字
	public static boolean isAllNumber(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		String reg = "[0-9]*";
		return str.matches(reg);
	}

	// 是否是年龄
	public static boolean isAge(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		try {
			if (Integer.parseInt(str) > 150) {
				return false;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 密码为6~16位字母数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isFitPassword(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		String reg = "[0-9a-zA-Z]{6,16}";
		return str.matches(reg);

	}

	/**
	 * 是否有中文
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isHasHanZi(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		String ms = "^[^\u4e00-\u9fa5]*$";
		return str.matches(ms);

	}

	public static boolean isNumber(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		String ms = "[0-9]+(\\.[0-9]+){0,1}";
		return str.matches(ms);

	}

	/**
	 * 短信验证码
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isFitNote(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		String reg = "[0-9]{6}";
		return str.matches(reg);

	}

	/***
	 * 对List进行拍重复操作
	 * 
	 * @param preData
	 *            数据
	 * @param keys
	 *            需要比较的map中的key数组
	 * @return
	 */
	public static ArrayList<HashMap<String, String>> removeRepeat(ArrayList<HashMap<String, String>> preData) {
		try {
			HashMap<String, HashMap<String, String>> map = new HashMap<String, HashMap<String, String>>(preData.size());
			for (HashMap<String, String> row : preData) {
				String key = "";
				String[] keys = row.keySet().toArray(new String[0]);
				for (String value : keys) {
					key = key + "_" + MethodUtils.getValueFormMap(row, value, "");
				}
				map.put(key, row);
			}
			preData.clear();
			preData.addAll(map.values());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return preData;
	}

	/***
	 * 对List进行拍重复操作
	 * 
	 * @param preData
	 *            数据
	 * @param keys
	 *            需要比较的map中的key数组
	 * @return
	 */
	public static ArrayList<HashMap<String, Object>> removeRepeat(ArrayList<HashMap<String, Object>> preData,
			String... keys) {
		try {
			HashMap<String, HashMap<String, Object>> map = new LinkedHashMap<String, HashMap<String, Object>>(
					preData.size());
			for (HashMap<String, Object> row : preData) {
				String key = "";

				if (keys == null || keys.length == 0) {
					keys = row.keySet().toArray(new String[0]);
				}

				for (String value : keys) {
					key = key + "_" + MethodUtils.getValueFormMap(value, "", row);
				}
				map.put(key, row);
			}

			preData.clear();
			preData.addAll(map.values());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return preData;
	}

	public static String getValueFormMap(String key, String defValue, HashMap<String, Object> info) {
		if (info == null || info.size() <= 0) {
			return defValue;
		}
		Object ob = info.get(key);
		if (ob == null) {
			return defValue;
		}
		if ("".equals(ob) || ob.toString().equals("null")) {
			return defValue;
		}
		return (String) ob.toString();
	}

	public static String getUnit(String unit) {
		// TODO Auto-generated method stub
		if (unit == null) {
			return "次";
		}
		String unit_1 = null;
		switch (Integer.parseInt(unit)) {
		case 0:
			unit_1 = "次";
			break;
		case 1:
			unit_1 = "周";
			break;
		case 2:
			unit_1 = "月";
			break;
		case 3:
			unit_1 = "季度";
			break;
		case 4:
			unit_1 = "半年";
			break;
		case 5:
			unit_1 = "年";
			break;
		}
		return unit_1;
	}

	/**
	 * 是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isStringNull(String str) {
		if (str == null || str.equals("")) {
			return true;
		}
		return false;

	}

	/**
	 * 根据value获取key的值
	 * 
	 * @param info
	 * @param value
	 * @return
	 */
	public static String getMapKeyByValue(HashMap<String, String> info, String value) {
		String val = "";
		if (info != null && info.size() > 0 && value != null) {
			Iterator<Entry<String, String>> it = info.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, String> entry = it.next();
				if (entry.getValue().equals(value)) {
					val = entry.getKey();
					break;
				}
			}
		}
		return val;
	}

	/**
	 * 获取map中的value集合
	 * 
	 * @param info
	 * @return
	 */
	public static List<String> getMapValues(HashMap<String, String> info) {
		List<String> values = new ArrayList<String>();
		if (info != null && info.size() > 0)
			values.addAll(info.values());
		return values;
	}

	/**
	 * 根据最大长度 截取字符串
	 * 
	 * @param str
	 * @param maxLen
	 */
	public static String cutStr(String str, int maxLen) {
		if (isStringNull(str)) {
			return "";
		}
		if (str.length() <= maxLen) {
			return str;
		}

		return str.substring(0, maxLen);
	}

	/**
	 * 
	 * 截取名字 指定长度
	 * 
	 */
	public static String getCutName(String name) {
		int length = 4;
		if (!TextUtils.isEmpty(name)) {
			if (name.length() > length) {
				name = name.substring(0, length);
				return name + "...";
			}
		}
		return name;
	}

	public static boolean fixUserNameRules(String userName) {
		// TODO Auto-generated method stub
		String reg = "[0-9a-zA-Z\\_]{4,30}";
		return userName.matches(reg);
	}

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}
