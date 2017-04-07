package com.huawei.vodafone.util;

import java.util.ArrayList;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.huawei.vodafone.bean.FreeUnitItem;
import com.huawei.vodafone.bean.FreeUnitItemDetail;

/**
 * json管理
 * 
 * @author Administrator
 * 
 */
public class JsonUtils {
	private static Gson gson = new Gson();

	public static <T> T object(String json, Class<T> classOfT) {
		return gson.fromJson(json, classOfT);
	}

	public static <T> String toJson(Class<T> param) {
		return gson.toJson(param);
	}

	public static <T> String toJson(T param) {
		return gson.toJson(param);
	}

	public static <T> JsonObject toJsonObject(T param) {
		return new JsonParser().parse(gson.toJson(param)).getAsJsonObject();
	}

	public static <T> JsonArray toJsonArray(T param) {
		return new JsonParser().parse(gson.toJson(param)).getAsJsonArray();
	}

	public static String xml2JSON(String xml) {
		try {
			JSONObject obj = XML.toJSONObject(xml);
			return obj.toString();
		} catch (JSONException e) {
			System.err.println("xml->json失败" + e.getLocalizedMessage());
			return "";
		}
	}

	/**
	 * 将json格式转换成map对象
	 * 
	 * @param jsonStr
	 * @return
	 */
	public static Map<?, ?> jsonToMap(String jsonStr) {
		Map<?, ?> objMap = null;
		if (gson != null) {
			java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<Map<?, ?>>() {
			}.getType();
			objMap = gson.fromJson(jsonStr, type);
		}
		return objMap;
	}

	public static Object getJsonValue(String jsonStr, String key) {
		Object rulsObj = null;
		Map<?, ?> rulsMap = jsonToMap(jsonStr);
		if (rulsMap != null && rulsMap.size() > 0) {
			rulsObj = rulsMap.get(key);
		}
		return rulsObj;
	}

	public static String getHeadCode(String json) {
		try {
			JSONObject jb = new JSONObject(json);
			return jb.getJSONObject("header").getString("resultCode");
		} catch (JSONException e) {
		} catch (NumberFormatException e) {
		} catch (JsonSyntaxException e) {
		}
		return "-1";
	}

	public static String getHeadMessage(String json) {
		try {
			JSONObject jb = new JSONObject(json);
			return jb.getJSONObject("header").getString("resultMessage");
		} catch (JSONException e) {
		} catch (NumberFormatException e) {
		} catch (JsonSyntaxException e) {
		}
		return "";
	}

	public static <T> T getBodyObject(String json, Class<T> classOfT) {
		try {
			JSONObject jb = new JSONObject(json);
			String result = jb.getString("body");
			return gson.fromJson(result, classOfT);
		} catch (JSONException e) {
		} catch (NumberFormatException e) {
		} catch (JsonSyntaxException e) {
		}
		return null;
	}

	public static <T> ArrayList<T> getBodyArray(String json, Class<T> classOfT) {
		try {
			JSONObject jb = new JSONObject(json);
			JSONArray result = jb.getJSONArray("body");

			ArrayList<T> classoftarray = new ArrayList<T>();
			for (int i = 0; i < result.length(); i++) {
				classoftarray.add(gson.fromJson(result.getJSONObject(i)
						.toString(), classOfT));
			}
			return classoftarray;
		} catch (JSONException e) {
		} catch (NumberFormatException e) {
		} catch (JsonSyntaxException e) {
		}
		return null;
	}

	public static <T> ArrayList<T> getArray(String json, Class<T> classOfT) {
		try {
			JSONArray result = new JSONArray(json);
			ArrayList<T> classoftarray = new ArrayList<T>();
			for (int i = 0; i < result.length(); i++) {
				classoftarray.add(gson.fromJson(result.getJSONObject(i)
						.toString(), classOfT));
			}
			return classoftarray;
		} catch (JSONException e) {
		} catch (NumberFormatException e) {
		} catch (JsonSyntaxException e) {
		}
		return null;
	}

	public static int setNullInt(JSONObject jsonObject, String key) {
		try {
			return jsonObject.getInt(key);
		} catch (Exception e) {
			return -1;
		}
	}

	public static String setNullStr(JSONObject jsonObject, String key) {
		try {
			return jsonObject.getString(key);
		} catch (Exception e) {
			return "";
		}
	}

	public static ArrayList<FreeUnitItem> getFreeUnitItem(String json) {
		try {
			JSONObject myjson = new JSONObject(xml2JSON(json));
			myjson = myjson.getJSONObject("soapenv:Envelope")
					.getJSONObject("soapenv:Body")
					.getJSONObject("bbs:QueryFreeUnitResultMsg");
			JSONArray array = myjson.getJSONObject("QueryFreeUnitResult")
					.getJSONArray("bbs:FreeUnitItem");
			array = new JSONArray(array.toString().replace("bbs:", ""));

			ArrayList<FreeUnitItem> FreeUnitItem = JsonUtils.getArray(
					array.toString(), FreeUnitItem.class);
			for (int i = 0; i < array.length(); i++) {
				String FreeUnitItemDetail = array.getJSONObject(i).getString(
						"FreeUnitItemDetail");
				if (FreeUnitItemDetail.charAt(0) == '{') {
					FreeUnitItemDetail item = JsonUtils.object(
							FreeUnitItemDetail, FreeUnitItemDetail.class);
					if (item != null) {
						FreeUnitItem.get(i).setFreeUnitItemDetailItem(item);
					}
				} else {
					ArrayList<FreeUnitItemDetail> myarray = JsonUtils.getArray(
							FreeUnitItemDetail, FreeUnitItemDetail.class);
					if (myarray != null && myarray.size() > 0) {
						FreeUnitItem.get(i).setFreeUnitItemDetailArray(myarray);
					}
				}
			}
			return FreeUnitItem;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}
