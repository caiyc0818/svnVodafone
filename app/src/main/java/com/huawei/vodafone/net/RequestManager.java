package com.huawei.vodafone.net;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import android.support.v4.app.FragmentActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.huawei.vodafone.MyApplication;
import com.huawei.vodafone.ui.fragment.LoadingFragment;
import com.huawei.vodafone.util.DebugLog;
import com.huawei.vodafone.util.JsonUtils;

/**
 * Created by hanweipeng on 2015/8/31.
 */
public class RequestManager {
	public static RequestQueue mRequestQueue = Volley
			.newRequestQueue(MyApplication.getInstance());

	private RequestManager() {

	}

	/**
	 * 获取Http头域
	 * 
	 * @param application
	 * @param url
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> getHeadersMap() {
		HashMap<String, String> headers = new HashMap<String, String>();

		return headers;
	}

	/**
	 * get请求拼接参数
	 * 
	 * @param p_url
	 * @param params
	 * @return [参数说明]
	 */
	public static String appendURL(String url, Map<String, Object> params) {
		if (params == null) {
			return url;
		}
		StringBuilder newUrl = new StringBuilder(url);
		if (newUrl.indexOf("?") < 0) {
			newUrl.append('?');
		}
		if (params != null) {
			for (String name : params.keySet()) {
				newUrl.append('&');
				newUrl.append(name);
				newUrl.append('=');
				newUrl.append(String.valueOf(params.get(name)));
				// 不做URLEncoder处理
				// url.append(URLEncoder.encode(String.valueOf(params.get(name)),
				// UTF_8));
			}
		}
		return newUrl.toString().replace("?&", "?");
	}

	/**
	 * 返回String
	 * 
	 * @param url
	 *            连接
	 * @param tag
	 *            上下文
	 * @param listener
	 *            回调
	 */
	public static void get(String url, Map<String, Object> params, Object tag,
			RequestListener listener) {
		String requestUrl = appendURL(url, params);
		DebugLog.i("RequestManager", "requestUrl-->" + requestUrl, true);
		ByteArrayRequest request = new ByteArrayRequest(Request.Method.GET,
				requestUrl, null, responseListener(listener, false, null, tag),
				responseError(listener, false, null, tag));
		addRequest(request, tag);
	}

	/**
	 * 返回String
	 * 
	 * @param url
	 *            连接
	 * @param tag
	 *            上下文
	 * @param listener
	 *            回调
	 */
	public static void get(String url, JsonObject jsonObject, Object tag,
			RequestListener listener) {

		DebugLog.i("RequestManager", "url-->" + url);
		DebugLog.i("RequestManager", "jsonObject-->" + jsonObject.toString());
		ByteArrayRequest request = new ByteArrayRequest(Request.Method.GET, url
				+ "/" + jsonObject.toString(), null, responseListener(listener,
				false, null, tag), responseError(listener, false, null, tag));
		addRequest(request, tag);
	}

	public static <T> void get(String url, JsonObject jsonObject, Object tag,
			Class<T> classOfT, RequestJsonListener<T> listener) {
		DebugLog.i("RequestManager", "url-->" + url);
		DebugLog.i("RequestManager", "jsonObject-->" + jsonObject.toString());
		ByteArrayRequest request = new ByteArrayRequest(Request.Method.GET, url
				+ "/" + jsonObject.toString(), null, responseListener(listener,
				classOfT, false, null, tag), responseError(listener, false,
				null, tag));
		addRequest(request, tag);
	}

	/**
	 * 返回String 带进度条
	 * 
	 * @param url
	 *            连接
	 * @param tag
	 *            上下文
	 * @param progressTitle
	 *            进度条文字
	 * @param listener
	 *            回调
	 */
	public static void get(String url, Map<String, Object> params, Object tag,
			String progressTitle, RequestListener listener) {
		String requestUrl = appendURL(url, params);
		DebugLog.i("RequestManager", "requestUrl-->" + requestUrl);
		LoadingFragment dialog = new LoadingFragment();
		dialog.show(((FragmentActivity) tag).getSupportFragmentManager(),
				"Loading");
		dialog.setMsg(progressTitle);
		ByteArrayRequest request = new ByteArrayRequest(Request.Method.GET,
				requestUrl, null,
				responseListener(listener, true, dialog, tag), responseError(
						listener, true, dialog, tag));
		addRequest(request, tag);
	}

	/**
	 * 返回对象
	 * 
	 * @param url
	 *            连接
	 * @param tag
	 *            上下文
	 * @param classOfT
	 *            类对象
	 * @param listener
	 *            回调
	 */
	public static <T> void get(String url, Map<String, Object> params,
			Object tag, Class<T> classOfT, RequestJsonListener<T> listener) {
		String requestUrl = appendURL(url, params);
		DebugLog.i("RequestManager", "requestUrl-->" + requestUrl);
		ByteArrayRequest request = new ByteArrayRequest(Request.Method.GET,
				requestUrl, null, responseListener(listener, classOfT, false,
						null, tag), responseError(listener, false, null, tag));
		addRequest(request, tag);
	}

	/**
	 * 返回对象
	 * 
	 * @param url
	 *            连接
	 * @param tag
	 *            上下文
	 * @param classOfT
	 *            类对象
	 * @param progressTitle
	 *            进度条文字
	 * @param listener
	 *            回调
	 */
	public static <T> void get(String url, Map<String, Object> params,
			Object tag, Class<T> classOfT, String progressTitle,
			boolean LoadingShow, RequestJsonListener<T> listener) {
		String requestUrl = appendURL(url, params);
		DebugLog.i("RequestManager", "requestUrl-->" + requestUrl);
		LoadingFragment dialog = new LoadingFragment();
		if (LoadingShow) {
			dialog.show(((FragmentActivity) tag).getSupportFragmentManager(),
					"Loading");
			dialog.setMsg(progressTitle);
		}
		ByteArrayRequest request = new ByteArrayRequest(Request.Method.GET,
				requestUrl, null, responseListener(listener, classOfT,
						LoadingShow, dialog, tag), responseError(listener,
						LoadingShow, dialog, tag));
		addRequest(request, tag);
	}

	/**
	 * 返回String
	 * 
	 * @param url
	 *            接口
	 * @param tag
	 *            上下文
	 * @param params
	 *            post需要传的参数
	 * @param listener
	 *            回调
	 */
	public static void post(String url, Object tag, JsonObject jsonObject,
			RequestListener listener) {
		DebugLog.i("RequestManager", "url-->" + url);
		DebugLog.i("RequestManager", "jsonObject-->" + jsonObject.toString());
		ByteArrayRequest request = new ByteArrayRequest(Request.Method.POST,
				url, jsonObject, responseListener(listener, false, null, tag),
				responseError(listener, false, null, tag));
		addRequest(request, tag);
	}

	/**
	 * 返回String 带进度条
	 * 
	 * @param url
	 *            接口
	 * @param tag
	 *            上下文
	 * @param params
	 *            post需要传的参数
	 * @param progressTitle
	 *            进度条文字
	 * @param listener
	 *            回调
	 */
	public static void post(String url, Object tag, JsonObject jsonObject,
			String progressTitle, RequestListener listener) {
		DebugLog.i("RequestManager", "url-->" + url);
		DebugLog.i("RequestManager", "jsonObject-->" + jsonObject.toString());
		LoadingFragment dialog = new LoadingFragment();
		dialog.show(((FragmentActivity) tag).getSupportFragmentManager(),
				"Loading");
		dialog.setMsg(progressTitle);
		ByteArrayRequest request = new ByteArrayRequest(Request.Method.POST,
				url, jsonObject, responseListener(listener, true, dialog, tag),
				responseError(listener, true, dialog, tag));
		addRequest(request, tag);
	}

	/**
	 * 返回对象 带进度条
	 * 
	 * @param url
	 *            接口
	 * @param tag
	 *            上下文
	 * @param classOfT
	 *            类对象
	 * @param params
	 *            post需要传的参数
	 * @param progressTitle
	 *            进度条文字
	 * @param LoadingShow
	 *            true (显示进度) false (不显示进度)
	 * @param listener
	 *            回调
	 */
	public static <T> void post(String url, Object tag, Class<T> classOfT,
			JsonObject jsonObject, String progressTitle, boolean LoadingShow,
			RequestJsonListener<T> listener) {
		DebugLog.i("RequestManager", "url-->" + url);
		DebugLog.i("RequestManager", "jsonObject-->" + jsonObject.toString());
		LoadingFragment dialog = new LoadingFragment();
		if (LoadingShow) {
			dialog.show(((FragmentActivity) tag).getSupportFragmentManager(),
					"Loading");
			dialog.setMsg(progressTitle);
		}
		ByteArrayRequest request = new ByteArrayRequest(Request.Method.POST,
				url, jsonObject, responseListener(listener, classOfT,
						LoadingShow, dialog, tag), responseError(listener,
						LoadingShow, dialog, tag));
		addRequest(request, tag);
	}

	/**
	 * 成功消息监听 返回对象
	 * 
	 * @param l
	 * @return
	 */
	protected static <T> Response.Listener<byte[]> responseListener(
			final RequestJsonListener<T> l, final Class<T> classOfT,
			final boolean flag, final LoadingFragment p, final Object tag) {
		return new Response.Listener<byte[]>() {
			@Override
			public void onResponse(byte[] arg0) {
				String data = null;
				try {
					data = new String(arg0, "UTF-8");
					DebugLog.i("Response.Listener", "tag>" + tag + ">data-->"
							+ data, true);
					l.requestSuccess(tag, JsonUtils.object(data, classOfT));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (JsonSyntaxException e) {
					DebugLog.e("Response.Listener", "tag>" + tag
							+ "-->接口返回非json格式,或者json格式被修改未重新匹配");
					e.printStackTrace();
				}
				if (flag) {
					if (p.getShowsDialog()) {
						p.dismiss();
					}
				}
			}
		};
	}

	/**
	 * 对象返回错误监听
	 * 
	 * @param l
	 *            回调
	 * @param flag
	 *            flag true 带进度条 flase不带进度条
	 * @param p
	 *            进度条的对象
	 * @return
	 */
	protected static <T> Response.ErrorListener responseError(
			final RequestJsonListener<T> l, final boolean flag,
			final LoadingFragment p, final Object tag) {
		return new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError e) {
				l.requestError(tag, e);
				DebugLog.i("Response.ErrorListener", "tag-->" + tag + "e-->"
						+ e.getMessage());
				if (flag) {
					if (p.getShowsDialog()) {
						p.dismiss();
					}
				}
			}
		};
	}

	/**
	 * 成功消息监听 返回String
	 * 
	 * @param l
	 *            String 接口
	 * @param flag
	 *            true 带进度条 flase不带进度条
	 * @param p
	 *            进度条的对象
	 * @return
	 */
	protected static Response.Listener<byte[]> responseListener(
			final RequestListener l, final boolean flag,
			final LoadingFragment p, final Object tag) {
		return new Response.Listener<byte[]>() {
			@Override
			public void onResponse(byte[] arg0) {
				String data = null;
				try {
					data = new String(arg0, "UTF-8");
					DebugLog.i("Response.Listener", "tag>" + tag + ">data-->"
							+ data, true);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				l.requestSuccess(tag, data);
				if (flag) {
					if (p.getShowsDialog()) {
						p.dismiss();
					}
				}
			}
		};
	}

	/**
	 * String 返回错误监听
	 * 
	 * @param l
	 *            String 接口
	 * @param flag
	 *            true 带进度条 flase不带进度条
	 * @param p
	 *            进度条的对象
	 * @return
	 */
	protected static Response.ErrorListener responseError(
			final RequestListener l, final boolean flag,
			final LoadingFragment p, final Object tag) {
		return new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError e) {
				l.requestError(tag, e);
				DebugLog.i("Response.ErrorListener", "tag-->" + tag + "e-->"
						+ e.getMessage());
				if (flag) {
					if (p.getShowsDialog()) {
						p.dismiss();
					}
				}
			}
		};
	}

	public static void addRequest(Request<?> request, Object tag) {
		if (tag != null) {
			request.setTag(tag);
		}
		mRequestQueue.add(request);
	}

	/**
	 * 当主页面调用协议 在结束该页面调用此方法
	 * 
	 * @param tag
	 */
	public static void cancelAll(Object tag) {
		mRequestQueue.cancelAll(tag);
	}

	/**
	 * 返回String
	 * 
	 * @param url
	 *            接口
	 * @param tag
	 *            上下文
	 * @param params
	 *            post需要传的参数
	 * @param listener
	 *            回调
	 */
	public static void post(String url, Object tag, String str,
			RequestListener listener) {
		DebugLog.i("RequestManager", "url-->" + url);
		DebugLog.i("RequestManager", "jsonObject-->" + str.toString());
		ByteArrayRequest request = new ByteArrayRequest(url,
				Request.Method.POST, str, responseListener(listener, false,
						null, tag), responseError(listener, false, null, tag));
		addRequest(request, tag);
	}
}
