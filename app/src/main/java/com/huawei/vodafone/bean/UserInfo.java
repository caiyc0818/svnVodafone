package com.huawei.vodafone.bean;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.huawei.vodafone.MyApplication;
import com.huawei.vodafone.R;
import com.huawei.vodafone.util.AESOperator;
import com.huawei.vodafone.util.PreferenceUtils;
import com.huawei.vodafone.util.StringUtils;

/**
 * 
 * 
 * @function
 * @author Weich
 * @version 1.0,用户信息
 */
public class UserInfo {

	private static UserInfo INSTANCE;

	/** 获取UserInfo实例 ,单例模式 */
	public static UserInfo getInstance() {
		synchronized (UserInfo.class) {
			if (null == INSTANCE) {
				INSTANCE = new UserInfo();
			}
		}
		return INSTANCE;
	}

	public void SaveUserInfo(AllPersonalInfo logininfo) {
		ArrayList<PersonalInfo> list = logininfo.getPersonalInfos();
		for (int j = 0; j < list.size(); j++) {
			SavePersonalInfo(j, list.get(j));
		}

		Method[] methods = AllPersonalInfo.class.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			try {
				if (methods[i].getName().startsWith("get")
						&& !methods[i].getName().endsWith("getPersonalInfos")) {
					Object object = methods[i].invoke(logininfo);
					encrypt(methods[i].getName().replace("get", ""),
							object.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * 设置信息list
	 */
	public void SavePersonalInfo(int position, PersonalInfo logininfo) {
		Method[] methods = PersonalInfo.class.getDeclaredMethods();// 获得类的方法集合
		// 遍历方法集合
		for (int i = 0; i < methods.length; i++) {
			// 获取所有getXX()的返回值
			// methods[i].getName()方法返回方法名
			try {
				if (methods[i].getName().startsWith("get")) {
					Object object = methods[i].invoke(logininfo);
					encrypt(position + methods[i].getName().replace("get", ""),
							object.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 加密
	 */
	private static void encrypt(String name, String key) throws Exception {
		PreferenceUtils.setString(MyApplication.applicationContext, AESOperator
				.getInstance().encrypt(name), AESOperator.getInstance()
				.encrypt(key));
	}

	public void clearUserInfo() {

		Method[] methods = PersonalInfo.class.getDeclaredMethods();// 获得类的方法集合

		for (int i = 0; i < getListsize(); i++) {
			for (int j = 0; j < methods.length; j++) {
				try {
					if (methods[j].getName().startsWith("get")) {
						delString(i + methods[j].getName().replace("get", ""));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		Method[] allpersonalinfo = AllPersonalInfo.class.getDeclaredMethods();
		for (int i = 0; i < allpersonalinfo.length; i++) {
			try {
				if (allpersonalinfo[i].getName().startsWith("get")
						&& !allpersonalinfo[i].getName().endsWith(
								"getPersonalInfos")) {
					delString(allpersonalinfo[i].getName().replace("get", ""));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 解密
	 */
	private void delString(String name) throws Exception {
		PreferenceUtils.delString(MyApplication.applicationContext, AESOperator
				.getInstance().encrypt(name));
	}

	private static String getInfo(int position, String name) {
		try {
			if (position == -1) {
				return AESOperator.getInstance().decrypt(
						PreferenceUtils.getString(
								MyApplication.applicationContext, AESOperator
										.getInstance().encrypt(name)));
			} else {
				return AESOperator.getInstance().decrypt(
						PreferenceUtils
								.getString(
										MyApplication.applicationContext,
										AESOperator.getInstance().encrypt(
												position + name)));
			}
		} catch (Exception e) {
		}
		return "";
	}

	private static void setInfo(int position, String name, String key) {
		try {
			if (name.equals("Select") || name.equals("Listsize")) {
				encrypt(name, position + "");
			} else {
				encrypt(position + name, key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<PersonalInfo> orderByTime() {
		ArrayList<PersonalInfo> list = new ArrayList<PersonalInfo>();
		for (int i = 0; i < UserInfo.getListsize(); i++) {
			PersonalInfo item = new PersonalInfo();
			item.setUserName(UserInfo.getUserName(i));
			item.setUserMobile(UserInfo.getUserMobile(i));
			if (StringUtils.isEmpty(UserInfo.getTime(i))) {
				item.setTime("0");
			} else {
				item.setTime(UserInfo.getTime(i));
			}
			item.setPosition(i + "");
			list.add(item);
		}
		Comparator comp = new SortComparator();
		Collections.sort(list, comp);
		return list;
	}

	private static class SortComparator implements Comparator {
		@Override
		public int compare(Object lhs, Object rhs) {
			PersonalInfo a = (PersonalInfo) lhs;
			PersonalInfo b = (PersonalInfo) rhs;
			long num = Long.valueOf(b.getTime()) - Long.valueOf(a.getTime());
			return (int) num;
		}
	}

	public static Bitmap getIcon(Context context) {
		return getIcon(context, getUserMobile());
	}

	public static Bitmap getIcon(Context context, String phone) {
		int ic = R.drawable.david_ic;
		switch (phone.substring(phone.length() - 1)) {
		case "0":
		case "5":
			ic = R.drawable.david_ic;
			break;
		case "1":
		case "6":
			ic = R.drawable.peter_hunt_ic;
			break;
		case "2":
		case "7":
			ic = R.drawable.martha_cozza_ic;
			break;
		case "3":
		case "8":
			ic = R.drawable.lucy_ic;
			break;
		case "4":
		case "9":
			ic = R.drawable.hanna_ic;
			break;
		default:
			break;
		}
		Bitmap mBitmap = PreferenceUtils.getBitmap(context, "image" + phone);
		if (mBitmap == null) {
			mBitmap = BitmapFactory.decodeStream(context.getResources()
					.openRawResource(ic));
		}
		return mBitmap;
	}

	// 对应的写，需要啥写啥，不要全公开
	public static int getSelect() {
		return getInfo(-1, "Select") == null
				|| getInfo(-1, "Select").equals("") ? 0 : Integer
				.valueOf(getInfo(-1, "Select"));
	}

	public static void setSelect(int position) {
		setInfo(position, "Select", "");
	}

	public static int getListsize() {
		return getInfo(-1, "Listsize") == null
				|| getInfo(-1, "Listsize").equals("") ? 0 : Integer
				.valueOf(getInfo(-1, "Listsize"));
	}

	public static void setListsize(int position) {
		setInfo(position, "Listsize", "");
	}

	public static String getUserName(int position) {
		return getInfo(position, "UserName");
	}

	public static String getUserName() {
		return getInfo(getSelect(), "UserName");
	}

	public static void setUserName(String userName) {
		setInfo(getSelect(), "UserName", userName);
	}

	public static void setUserName(int position, String userName) {
		setInfo(position, "UserName", userName);
	}

	public static String getUserMobile(int position) {
		return getInfo(position, "UserMobile");
	}

	public static String getUserMobile() {
		return getInfo(getSelect(), "UserMobile");
	}

	public static String getAllData() {
		return getInfo(getSelect(), "AllData");
	}

	public static void setAllData(String allData) {
		setInfo(getSelect(), "AllData", allData);
	}

	public static String getAddData() {
		return getInfo(getSelect(), "AddData");
	}

	public static void setAddData(String addData) {
		setInfo(getSelect(), "AddData", addData);
	}

	public static String getLeftData() {
		return getInfo(getSelect(), "LeftData");
	}

	public static void setLeftData(String leftData) {
		setInfo(getSelect(), "LeftData", leftData);
	}

	public static String getBalance() {
		return getInfo(getSelect(), "Balance");
	}

	public static void setBalance(String balance) {
		setInfo(getSelect(), "Balance", balance);
	}

	public static String getSign() {
		return StringUtils.isEmpty(getInfo(getSelect(), "Sign")) ? "€"
				: getInfo(getSelect(), "Sign");
	}

	public static void setSign(String sign) {
		setInfo(getSelect(), "Sign", sign);
	}

	public static String getBalanceWithSign() {
		return getSign() + getBalance();
	}

	public static void setBalanceWithSign(String balanceWithSign) {
		String[] balance = balanceWithSign.split("JianGe");
		setSign(balance[0]);
		setBalance(balance[1]);
	}

	public static String getAllUnit() {
		return getInfo(getSelect(), "AllUnit");
	}

	public static void setAllUnit(String allUnit) {
		setInfo(getSelect(), "AllUnit", allUnit);
	}

	public static String getLeftUnit() {
		return getInfo(getSelect(), "LeftUnit");
	}

	public static void setLeftUnit(String leftUnit) {
		setInfo(getSelect(), "LeftUnit", leftUnit);
	}

	public static String getAddUnit() {
		return getInfo(getSelect(), "AddUnit");
	}

	public static void setAddUnit(String addUnit) {
		setInfo(getSelect(), "AddUnit", addUnit);
	}

	public static String getDiydataall() {
		return getInfo(getSelect(), "Diydataall");
	}

	public static void setDiydataall(String diydataall) {
		setInfo(getSelect(), "Diydataall", diydataall);
	}

	public static String getDiysmsall() {
		return getInfo(getSelect(), "Diysmsall");
	}

	public static void setDiysmsall(String diysmsall) {
		setInfo(getSelect(), "Diysmsall", diysmsall);
	}

	public static String getDiysmsleft() {
		return getInfo(getSelect(), "Diysmsleft");
	}

	public static void setDiysmsleft(String diysmsleft) {
		setInfo(getSelect(), "Diysmsleft", diysmsleft);
	}

	public static String getDiydataleft() {
		return getInfo(getSelect(), "Diydataleft");
	}

	public static void setDiydataleft(String diydataleft) {
		setInfo(getSelect(), "Diydataleft", diydataleft);
	}

	public static String getDiyunitall() {
		return getInfo(getSelect(), "Diyunitall");
	}

	public static void setDiyunitall(String diyunitall) {
		setInfo(getSelect(), "Diyunitall", diyunitall);
	}

	public static String getDiyunitleft() {
		return getInfo(getSelect(), "Diyunitleft");
	}

	public static void setDiyunitleft(String diyunitleft) {
		setInfo(getSelect(), "Diyunitleft", diyunitleft);
	}

	public static String getTime(int select) {
		return getInfo(select, "Time");
	}

	public static String getTime() {
		return getInfo(getSelect(), "Time");
	}

	public static void setTime(String time) {
		setInfo(getSelect(), "Time", time);
	}
}
