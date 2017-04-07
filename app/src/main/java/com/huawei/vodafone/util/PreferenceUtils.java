package com.huawei.vodafone.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.Base64;

/**
 * 保存数据至preference
 * 
 * @author hanweipeng
 * @version V1.0 创建时间：2013-12-25 下午6:30:32
 */
public class PreferenceUtils {
	/**
	 * 存入文件中的工程名
	 */
	public static final String PREFERENCES_NAME = "com.huawei.vodafone.client_preferences";

	/**
	 * 保存至preferences中
	 * 
	 * @param key
	 * @return
	 */
	public static void setString(Context context, String key, String value) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString(key, value);
		editor.commit();
	}

	/**
	 * 从preferences中获取
	 * 
	 * @param key
	 * @param value
	 */
	public static String getString(Context context, String key) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME,
				Context.MODE_PRIVATE);
		return sp.getString(key, "");
	}

	public static String getString1(Context context, String key) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME,
				Context.MODE_PRIVATE);
		return sp.getString(key, "123456");
	}

	public static String getString2(Context context, String key) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME,
				Context.MODE_PRIVATE);
		return sp.getString(key, "0");
	}

	/**
	 * 保存至preferences中
	 * 
	 * @param key
	 * @return
	 */
	public static void setInt(Context context, String key, int value) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putInt(key, value);
		editor.commit();
	}

	/**
	 * 从preferences中获取
	 * 
	 * @param key
	 * @param value
	 */
	public static int getInt(Context context, String key) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME,
				Context.MODE_PRIVATE);
		return sp.getInt(key, -1);
	}

	/**
	 * 从preferences中获取
	 * 
	 * @param key
	 * @param value
	 */
	public static int getInt(Context context, String key, int def) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME,
				Context.MODE_PRIVATE);
		return sp.getInt(key, def);
	}

	/**
	 * 从preferences中获取
	 * 
	 * @param key
	 * @param value
	 */
	public static String getStringWithDefault(Context context, String key) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME,
				Context.MODE_PRIVATE);
		return sp.getString(key, "0");
	}

	/**
	 * 删除preferences中的数据
	 * 
	 * @param key
	 * @return
	 */
	public static void delString(Context context, String key) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.remove(key);
		editor.commit();
	}

	/**
	 * 保存至preferences中
	 * 
	 * @param key
	 * @return
	 */
	public static void setLong(Context context, String key, Long value) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putLong(key, value);
		editor.commit();
	}

	/**
	 * 从preferences中获取
	 * 
	 * @param key
	 * @param value
	 */
	public static Long getLong(Context context, String key, long def) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME,
				Context.MODE_PRIVATE);
		return sp.getLong(key, def);
	}

	public static void setBoolean(Context context, String key, boolean value) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	public static boolean getBoolean(Context context, String key) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME,
				Context.MODE_PRIVATE);
		return sp.getBoolean(key, false);
	}

	public static boolean getBoolean(Context context, String key, boolean def) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME,
				Context.MODE_PRIVATE);
		return sp.getBoolean(key, def);
	}

	public static void setBitmap(Context context, String key, Bitmap bitmap) {
		// 第一步:将Bitmap压缩至字节数组输出流ByteArrayOutputStream
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
		// 第二步:利用Base64将字节数组输出流中的数据转换成字符串String
		byte[] byteArray = byteArrayOutputStream.toByteArray();
		String imageString = new String(Base64.encodeToString(byteArray,
				Base64.DEFAULT));
		// 第三步:将String保持至SharedPreferences
		SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString(key, imageString);
		editor.commit();
	}

	public static Bitmap getBitmap(Context context, String key) {
		SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME,
				Context.MODE_PRIVATE);
		String imageString = sp.getString(key, "");
		if (StringUtils.isEmpty(imageString)) {
			return null;
		} else {
			byte[] byteArray = Base64.decode(imageString, Base64.DEFAULT);
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
					byteArray);
			return BitmapFactory.decodeStream(byteArrayInputStream);
		}
	}
}
