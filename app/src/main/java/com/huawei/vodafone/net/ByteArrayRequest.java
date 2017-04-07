package com.huawei.vodafone.net;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.JsonObject;

/**
 * 
 * Created by hanweipeng on 2015/3/11.
 */
class ByteArrayRequest extends Request<byte[]> {

	private final Listener<byte[]> mListener;

	/**
	 * 请求参数
	 */
	private String mPostBody = null;

	/**
	 * 请求头
	 */
	// private HashMap<String, String> headers;

	public ByteArrayRequest(int method, String url, JsonObject postBody,
			Listener<byte[]> listener, ErrorListener errorListener) {
		super(method, url, errorListener);
		this.mPostBody = (postBody == null) ? null : postBody.toString();
		this.mListener = listener;
		this.setRetryPolicy(new DefaultRetryPolicy(30 * 1000, 1, 1.0f));// 超时时间
	}

	public ByteArrayRequest(String url, int method, String str,
			Listener<byte[]> listener, ErrorListener errorListener) {
		super(method, url, errorListener);
		this.mPostBody = (str == null) ? null : str.toString();
		this.mListener = listener;
		this.setRetryPolicy(new DefaultRetryPolicy(30 * 1000, 1, 1.0f));// 超时时间
	}

	// @Override
	// public void setRetryPolicy(RetryPolicy retryPolicy)
	// {
	// // TODO Auto-generated method stub
	// super.setRetryPolicy(retryPolicy);
	// }

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		Map<String, String> headers = super.getHeaders();
		if (null == headers || headers.equals(Collections.emptyMap())) {
			headers = new HashMap<String, String>();
		}
		headers.put("Content-Type", "application/json;charset=UTF-8");
		return headers;
	}

	@Override
	public byte[] getBody() throws AuthFailureError {
		try {
			return mPostBody == null ? null : mPostBody.getBytes("UTF-8");
		} catch (UnsupportedEncodingException uee) {
			VolleyLog
					.wtf("Unsupported Encoding while trying to get the bytes of %s using %s",
							mPostBody, "UTF-8");
			return null;
		}
	}

	@Override
	protected Response<byte[]> parseNetworkResponse(NetworkResponse response) {
		return Response.success(response.data,
				HttpHeaderParser.parseCacheHeaders(response));
	}

	@Override
	protected void deliverResponse(byte[] response) {
		this.mListener.onResponse(response);
	}
}