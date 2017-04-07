package com.huawei.vodafone.net;

import java.util.Map;

import com.android.volley.Request;
import com.google.gson.JsonObject;
import com.huawei.vodafone.util.DebugLog;

/**
 * Created by hanweipeng on 2015/8/31. 网络请求类
 */
public class IRequest {
	/**
	 * 返回String get
	 */
	public static void get(Object tag, String url, Map<String, Object> params,
			RequestListener l) {
		RequestManager.get(url, params, tag, l);
	}

	/**
	 * 返回String get
	 * 
	 */
	public static void get(Object tag, String url, JsonObject jsonObject,
			RequestListener l) {
		RequestManager.get(url, jsonObject, tag, l);
	}

	/**
	 * 返回对象 post
	 * 
	 */
	public static <T> void get(Object tag, String url, Class<T> classOfT,
			JsonObject jsonObject, RequestJsonListener<T> l) {
		RequestManager.get(url, jsonObject, tag, classOfT, l);
	}

	/**
	 * 返回String 带进度条 get
	 * 
	 */
	public static void get(Object tag, String url, Map<String, Object> params,
			String progressTitle, RequestListener l) {
		RequestManager.get(url, params, tag, progressTitle, l);
	}

	/**
	 * 返回对象 get
	 * 
	 */
	public static <T> void get(Object tag, String url,
			Map<String, Object> params, Class<T> classOfT,
			RequestJsonListener<T> l) {
		RequestManager.get(url, params, tag, classOfT, null, false, l);
	}

	/**
	 * 返回对象 带进度条 get
	 * 
	 */
	public static <T> void get(Object tag, String url,
			Map<String, Object> params, Class<T> classOfT,
			String progressTitle, RequestJsonListener<T> l) {
		RequestManager.get(url, params, tag, classOfT, progressTitle, true, l);

	}

	/**
	 * 返回对象 带进度条 get 可选择显示进度 适合带分页
	 * 
	 */
	public static <T> void get(Object tag, String url,
			Map<String, Object> params, Class<T> classOfT,
			String progressTitle, boolean LoadingShow, RequestJsonListener<T> l) {
		RequestManager.get(url, params, tag, classOfT, progressTitle,
				LoadingShow, l);

	}

	/**
	 * 返回String post
	 * 
	 */
	public static void post(Object tag, String url, JsonObject jsonObject,
			RequestListener l) {
		RequestManager.post(url, tag, jsonObject, l);
	}

	/**
	 * 返回对象 post
	 * 
	 */
	public static <T> void post(Object tag, String url, Class<T> classOfT,
			JsonObject jsonObject, RequestJsonListener<T> l) {
		RequestManager.post(url, tag, classOfT, jsonObject, null, false, l);
	}

	/**
	 * 返回String 带进度条 post
	 * 
	 */
	public static void post(Object tag, String url, JsonObject jsonObject,
			String progressTitle, RequestListener l) {
		RequestManager.post(url, tag, jsonObject, progressTitle, l);
	}

	/**
	 * 返回对象 带进度条 post
	 * 
	 */
	public static <T> void post(Object tag, String url, Class<T> classOfT,
			JsonObject jsonObject, String progressTitle,
			RequestJsonListener<T> l) {
		RequestManager.post(url, tag, classOfT, jsonObject, progressTitle,
				true, l);

	}

	/**
	 * 返回对象 带进度条 post 可选择显示进度 适合带分页
	 * 
	 */
	public static <T> void post(Object tag, String url, Class<T> classOfT,
			JsonObject jsonObject, String progressTitle, boolean LoadingShow,
			RequestJsonListener<T> l) {
		RequestManager.post(url, tag, classOfT, jsonObject, progressTitle,
				true, l);
	}
	
	
	public static void post(String url, Object tag, String str,
			RequestListener listener) {
		RequestManager.post(url,tag,str,listener);
	}
}
