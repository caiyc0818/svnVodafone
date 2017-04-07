package com.huawei.vodafone.net;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.google.gson.JsonObject;
import com.huawei.vodafone.bean.Beacon;
import com.huawei.vodafone.bean.ChoosediyLevelValue;
import com.huawei.vodafone.bean.DiyValue;
import com.huawei.vodafone.bean.Measure;
import com.huawei.vodafone.bean.OfferInstValue;
import com.huawei.vodafone.bean.OfferValue;
import com.huawei.vodafone.bean.ParameterValue;
import com.huawei.vodafone.bean.PeriodType;
import com.huawei.vodafone.bean.QueryPayment;
import com.huawei.vodafone.bean.QueryUsage;
import com.huawei.vodafone.bean.SimpleProperty;
import com.huawei.vodafone.bean.UserInfo;
import com.huawei.vodafone.bean.UtcDate;
import com.huawei.vodafone.util.DateUtil;
import com.huawei.vodafone.util.JsonUtils;

/**
 * post请求json
 * 
 * @author weich
 * @version V1.0 创建时间：2015-09-07 上午10:52:36
 */
public class RequestJSon {
	private static String channelId = "9c0lf9xb5CgIyK+4ODA9ruf9iZwjeyQmN9pEZZRzqV5iPw2FvFeMAqJK8YNpSC1D4AXNsPY=";

	/************************* 公共请求头 ******************************/

	private static JsonObject getHeader() {
		JsonObject Header = new JsonObject();
		Header.addProperty("loginToken", "1513132123132");// 保留字段
		Header.addProperty("loginID", "asdasdasd");// 保留字段
		// Currently, only the JSON format is supported
		Header.addProperty("format", "json");
		Header.addProperty("channelId", channelId);
		Header.addProperty("channelType", "UCM");// 在沃达丰中该值是“UCM”,但它是可配置的。
		// API protocol version. The current value is 1.0.
		Header.addProperty("version", "1.0");
		// The value in Vodafone project is “101” but it can be configurated.
		Header.addProperty("beId", "101");
		// The value in Vodafone project is “101” but it can be configurated.
		Header.addProperty("beCode", "101");
		// Example: 2015-01-25 20:23:30
		Header.addProperty("timestamp",
				DateUtil.ConverToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		Header.addProperty("locale", "2002");// 用于多种语言。该值在沃达丰中是“2002”(英国人),2022是德国人。
		Header.addProperty("serialId", UUID.randomUUID().toString());
		// 37c95be8-9170-4f7b-8a6c-ef0ec19ba251, 每个接口调用期间唯一的序列ID生成。
		return Header;
	}

	public static JsonObject getJson(JsonObject Body) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("header", getHeader());
		jsonObject.add("body", Body);
		return jsonObject;
	}

	/************************* 公共请求头 ******************************/

	/**
	 * 14查询可订阅的订单和DIY ranks
	 */
	public static JsonObject OffersAndDIYRanks() {
		JsonObject json = new JsonObject();
		json.addProperty("msisdn", UserInfo.getUserMobile());
		json.addProperty("offerType", "A");
		json.addProperty("salesChannelId", "1001");
		return getJson(json);
	}

	/**
	 * 1更新用户信息
	 */
	public static JsonObject UpdateSubInfo() {
		JsonObject json = new JsonObject();
		json.addProperty("msisdn", UserInfo.getUserMobile());
		List<SimpleProperty> list = new ArrayList<SimpleProperty>();
		SimpleProperty item1 = new SimpleProperty();
		item1.setCode("C_HANDSET_OS_TYPE");
		item1.setValue("Android");
		SimpleProperty item2 = new SimpleProperty();
		item2.setCode("C_HANDSET_BRAND");
		item2.setValue("HuaweiMate8");
		SimpleProperty item3 = new SimpleProperty();
		item3.setCode("C_HANDSET_NETWORK");
		item3.setValue("LTE");
		SimpleProperty item4 = new SimpleProperty();
		item4.setCode("C_APP_ACTIVE_USAGE");
		item4.setValue("1");
		list.add(item1);
		list.add(item2);
		list.add(item3);
		list.add(item4);
		json.add("propertyList", JsonUtils.toJsonArray(list));
		return getJson(json);
	}

	/**
	 * 5订阅订单
	 */
	public static JsonObject Optionaloffering(String dataId, String unitId, String costId, boolean isdiy) {
		JsonObject json = new JsonObject();
		json.addProperty("msisdn", UserInfo.getUserMobile());
		json.addProperty("salesChannelId", "1001");
		List<OfferValue> list = new ArrayList<OfferValue>();
		OfferValue item1 = new OfferValue();

		List<ParameterValue> instParameterValueList = new ArrayList<ParameterValue>();
		ParameterValue ParameterItem1 = new ParameterValue();
		ParameterItem1.setParameterId(dataId);
		ParameterItem1.setParameterCode("C_DATA_LEVEL");
		ParameterItem1.setParameterValue(dataId);
		ParameterItem1.setParameterActionType("A");

		ParameterValue ParameterItem2 = new ParameterValue();
		ParameterItem2.setParameterId(unitId);
		ParameterItem2.setParameterCode("C_VOICE_LEVEL");
		ParameterItem2.setParameterValue(unitId);
		ParameterItem2.setParameterActionType("A");

		ParameterValue ParameterItem3 = new ParameterValue();
		ParameterItem3.setParameterId(costId);
		ParameterItem3.setParameterCode("C_SMS_LEVEL");
		ParameterItem3.setParameterValue(costId);
		ParameterItem3.setParameterActionType("A");
		instParameterValueList.add(ParameterItem1);
		instParameterValueList.add(ParameterItem2);
		instParameterValueList.add(ParameterItem3);

		if (isdiy) {
			item1.setInstParameterValueList(instParameterValueList);
			item1.setOfferId("10102");
		} else {
			item1.setOfferId(dataId);
		}

		item1.setOrderNumber(1);
		list.add(item1);
		json.add("offerList", JsonUtils.toJsonArray(list));
		return getJson(json);
	}

	/**
	 * 6修改订单
	 */
	public static JsonObject modify(String dataId, String unitId, String costId, String OfferInstId, String OfferId) {
		JsonObject json = new JsonObject();
		json.addProperty("msisdn", UserInfo.getUserMobile());
		json.addProperty("salesChannelId", "1001");
		List<OfferInstValue> list = new ArrayList<OfferInstValue>();
		OfferInstValue item1 = new OfferInstValue();
		item1.setOfferId(OfferId);
		item1.setOfferInstId(OfferInstId);
		List<ParameterValue> instParameterValueList = new ArrayList<ParameterValue>();
		ParameterValue ParameterItem1 = new ParameterValue();
		ParameterItem1.setParameterCode("C_DATA_LEVEL");
		ParameterItem1.setParameterValue(dataId);
		ParameterItem1.setParameterActionType("M");

		ParameterValue ParameterItem2 = new ParameterValue();
		ParameterItem2.setParameterValue(unitId);
		ParameterItem2.setParameterCode("C_VOICE_LEVEL");
		ParameterItem2.setParameterActionType("M");

		ParameterValue ParameterItem3 = new ParameterValue();
		ParameterItem3.setParameterId(costId);
		ParameterItem3.setParameterCode("C_SMS_LEVEL");
		ParameterItem3.setParameterValue(costId);
		ParameterItem3.setParameterActionType("M");

		instParameterValueList.add(ParameterItem1);
		instParameterValueList.add(ParameterItem2);
		instParameterValueList.add(ParameterItem3);
		item1.setInstParameterValueList(instParameterValueList);
		list.add(item1);
		json.add("offerInstList", JsonUtils.toJsonArray(list));
		return getJson(json);
	}

	/**
	 * 7退订订单
	 */
	public static JsonObject removeOptional(String offerId, String OfferInstId) {
		JsonObject json = new JsonObject();
		json.addProperty("msisdn", UserInfo.getUserMobile());
		List<OfferInstValue> list = new ArrayList<OfferInstValue>();
		OfferInstValue item1 = new OfferInstValue();
		item1.setOfferInstId(OfferInstId);
		item1.setOfferId(offerId);
		list.add(item1);
		json.add("offerInstList", JsonUtils.toJsonArray(list));
		return getJson(json);
	}

	/**
	 * 2查询订单有效期
	 */
	public static JsonObject OfferingRentCycle() {
		JsonObject json = new JsonObject();
		json.addProperty("msisdn", UserInfo.getUserMobile());
		List<OfferInstValue> list = new ArrayList<OfferInstValue>();
		OfferInstValue item1 = new OfferInstValue();
		item1.setOfferInstId("101991010007014");
		item1.setOfferId("10102");
		// list.add(item1);
		json.add("offerInstList", JsonUtils.toJsonArray(list));
		return getJson(json);
	}

	/**
	 * 15查询用户历史订购记录
	 */
	public static JsonObject BookingHistory() {
		JsonObject json = new JsonObject();
		json.addProperty("msisdn", UserInfo.getUserMobile());
		UtcDate startDate = new UtcDate();
		startDate.setUtcDate(DateUtil.getPreNMonthDay(6));
		UtcDate endDate = new UtcDate();
		endDate.setUtcDate(DateUtil.ConverToString(new Date(), "yyyy-MM-dd"));
		json.add("startDate", JsonUtils.toJsonObject(startDate));
		json.add("endDate", JsonUtils.toJsonObject(endDate));
		return getJson(json);
	}

	/**
	 * 3通过手机号查询余额 查询已订阅的订单
	 */
	public static JsonObject ReferInfo(String type) {
		JsonObject json = new JsonObject();
		json.addProperty("msisdn", UserInfo.getUserMobile());
		json.addProperty("offerType", type);
		return getJson(json);
	}

	/**
	 * 8,13通过手机号查询余额 查询已订阅的订单
	 */
	public static JsonObject ReferInfo() {
		JsonObject json = new JsonObject();
		json.addProperty("msisdn", UserInfo.getUserMobile());
		return getJson(json);
	}

	/**
	 * 4查询DIY套餐根据价格排序
	 */
	public static JsonObject DiyPrice() {
		JsonObject json = new JsonObject();
		json.addProperty("msisdn", UserInfo.getUserMobile());
		json.addProperty("offerID", "10102");

		List<ChoosediyLevelValue> list = new ArrayList<ChoosediyLevelValue>();
		ChoosediyLevelValue item1 = new ChoosediyLevelValue();
		item1.setItemId("C_VOICE_LEVEL");
		item1.setLevelId("2");
		ChoosediyLevelValue item2 = new ChoosediyLevelValue();
		item2.setItemId("C_SMS_LEVEL");
		item2.setLevelId("1");
		ChoosediyLevelValue item3 = new ChoosediyLevelValue();
		item3.setItemId("C_DATA_LEVEL");
		item3.setLevelId("2");
		ChoosediyLevelValue item4 = new ChoosediyLevelValue();
		item4.setItemId("C_UNIT_LEVEL");
		item4.setLevelId("3");
		// list.add(item1);
		// list.add(item2);
		// list.add(item3);
		// list.add(item4);
		json.add("levelList", JsonUtils.toJsonArray(list));
		return getJson(json);
	}

	/**
	 * 9查询收费CDRs, 10查询月消费记录
	 */
	public static JsonObject CDRs() {
		JsonObject json = new JsonObject();
		json.addProperty("msisdn", UserInfo.getUserMobile());
		UtcDate startDate = new UtcDate();
		startDate.setUtcDate("2016-07-20");
		UtcDate endDate = new UtcDate();
		endDate.setUtcDate("2016-08-05");
		json.add("startDate", JsonUtils.toJsonObject(startDate));
		json.add("endDate", JsonUtils.toJsonObject(endDate));
		json.addProperty("totalCDRNum", 0);
		json.addProperty("beginRowNum", 0);
		json.addProperty("fetchRowNum", 10);
		return getJson(json);
	}

	/**
	 * 11查询月消费记录
	 */
	public static JsonObject Payment() {
		JsonObject json = new JsonObject();
		json.addProperty("msisdn", UserInfo.getUserMobile());
		List<QueryPayment> list = new ArrayList<QueryPayment>();
		QueryPayment item1 = new QueryPayment();
		item1.setPaymentType("0");
		QueryPayment item2 = new QueryPayment();
		item2.setPaymentType("1");
		QueryPayment item3 = new QueryPayment();
		item3.setPaymentType("2");
		QueryPayment item4 = new QueryPayment();
		item4.setPaymentType("3");
		QueryPayment item5 = new QueryPayment();
		item5.setPaymentType("4");
		list.add(item1);
		list.add(item2);
		list.add(item3);
		list.add(item4);
		list.add(item5);
		json.add("queryPaymentList", JsonUtils.toJsonArray(list));
		return getJson(json);
	}

	/**
	 * 12查询手机业务使用历史
	 */
	public static JsonObject Usage() {
		JsonObject json = new JsonObject();
		json.addProperty("msisdn", UserInfo.getUserMobile());
		List<QueryUsage> list = new ArrayList<QueryUsage>();
		QueryUsage item1 = new QueryUsage();
		item1.setUsageType("0");
		PeriodType periodType1 = new PeriodType();
		periodType1.setType("2");
		periodType1.setLength(3);
		item1.setPeriodType(periodType1);
		QueryUsage item2 = new QueryUsage();
		item2.setUsageType("1");
		PeriodType periodType2 = new PeriodType();
		periodType2.setType("2");
		item2.setPeriodType(periodType2);
		periodType2.setLength(3);
		item2.setPeriodType(periodType2);
		list.add(item1);
		list.add(item2);
		json.add("queryUsageList", JsonUtils.toJsonArray(list));
		return getJson(json);
	}

	/**
	 * 16查询可订阅的订单和DIY ranks
	 */
	public static JsonObject rankCombinationAndPrice() {
		JsonObject json = new JsonObject();
		json.addProperty("msisdn", UserInfo.getUserMobile());
		json.addProperty("offerID", "10102");
		return getJson(json);
	}

	/**
	 * 17查询可订阅的订单和DIY ranks
	 */
	public static JsonObject reportUserLocation() {
		JsonObject json = new JsonObject();
		json.addProperty("msisdn", UserInfo.getUserMobile());
		List<Beacon> list = new ArrayList<Beacon>();
		Beacon beacon1 = new Beacon();
		beacon1.setId(6);
		beacon1.setMajor(1000);
		beacon1.setMinor(1);
		beacon1.setName("Earth");
		beacon1.setUuid("E58171D9-8398-4453-A991-5593682DDB56");
		list.add(beacon1);
		Beacon beacon2 = new Beacon();
		beacon2.setId(7);
		beacon2.setMajor(1001);
		beacon2.setMinor(1);
		beacon2.setName("Earth2");
		beacon2.setUuid("E58171D9-8398-4453-A991-5593682DDB56");
		list.add(beacon2);
		json.add("beaconsList", JsonUtils.toJsonArray(list));
		return getJson(json);
	}

	/**
	 * 18查询推荐订单
	 */
	public static JsonObject queryPromotionOffer() {
		JsonObject json = new JsonObject();
		json.addProperty("msisdn", UserInfo.getUserMobile());
		json.addProperty("offertype", "D");
		json.addProperty("offerID", "10102");
		List<DiyValue> list = new ArrayList<DiyValue>();
		DiyValue diyValue = new DiyValue();
		diyValue.setItemId("C_DATA_LEVEL");
		Measure measure = new Measure();
		measure.setMeasureType("Dataflow");
		measure.setMeasureUnit("MB");
		measure.setMeasureValue(300);
		diyValue.setLevelValue(measure);
		list.add(diyValue);

		DiyValue diyValue1 = new DiyValue();
		diyValue1.setItemId("C_UNIT_LEVEL");
		Measure measure1 = new Measure();
		measure1.setMeasureType("Number");
		measure1.setMeasureUnit("One");
		measure1.setMeasureValue(300);
		diyValue1.setLevelValue(measure1);
		list.add(diyValue1);
		json.add("levelList", JsonUtils.toJsonArray(list));

		List<ParameterValue> list1 = new ArrayList<ParameterValue>();
		ParameterValue parameterValue = new ParameterValue();
		parameterValue.setParameterId("1");
		parameterValue.setParameterCode("C_PROMOTION_DISC");
		parameterValue.setParameterValue("300");
		list1.add(parameterValue);

		ParameterValue parameterValue1 = new ParameterValue();
		parameterValue1.setParameterId("2");
		parameterValue1.setParameterCode("C_PROMOTION_DISC_EXP_DATETIME");
		parameterValue1.setParameterValue("2016-07-30 23:59:59");
		list1.add(parameterValue1);
		json.add("promotionOffer", JsonUtils.toJsonArray(list1));
		return getJson(json);
	}

	public static String recharge(String mobile, int ammout) {
		StringBuilder poststring = new StringBuilder();
		poststring
				.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ars=\"http://www.huawei.com/bme/cbsinterface/arservices\" xmlns:cbs=\"http://www.huawei.com/bme/cbsinterface/cbscommon\" xmlns:arc=\"http://cbs.huawei.com/ar/wsservice/arcommon\">");
		poststring.append("<soapenv:Header/>");
		poststring.append("<soapenv:Body>");
		poststring.append("<ars:RechargeRequestMsg>");
		poststring.append("<RequestHeader>");

		poststring.append("<cbs:Version>1</cbs:Version>");
		poststring.append("<cbs:BusinessCode>1</cbs:BusinessCode>");
		poststring.append("<cbs:MessageSeq>" + UUID.randomUUID()
				+ "</cbs:MessageSeq>");
		poststring.append("<cbs:OwnershipInfo>");
		poststring.append("<cbs:BEID>101</cbs:BEID>");
		poststring.append("</cbs:OwnershipInfo>");

		poststring.append("<cbs:AccessSecurity>");
		poststring.append("<cbs:LoginSystemCode>102</cbs:LoginSystemCode>");
		poststring
				.append("<cbs:Password>xyYSFeOUi5DagegPuCQmUQ==</cbs:Password>");
		poststring.append("<cbs:RemoteIP>127.0.0.1</cbs:RemoteIP>");
		poststring.append("</cbs:AccessSecurity>");

		poststring.append("<cbs:OperatorInfo>");
		poststring.append("<cbs:OperatorID>102</cbs:OperatorID>");
		poststring.append("</cbs:OperatorInfo>");
		poststring.append("<cbs:AccessMode>3</cbs:AccessMode>");

		poststring.append("<cbs:TimeFormat>");
		poststring.append("<cbs:TimeType>1</cbs:TimeType>");
		poststring.append("<cbs:TimeZoneID>1</cbs:TimeZoneID>");
		poststring.append("</cbs:TimeFormat>");

		poststring.append("</RequestHeader>");

		poststring.append("<RechargeRequest>");
		poststring.append("<ars:RechargeType>1</ars:RechargeType>");
		poststring.append("<ars:RechargeChannelID>11</ars:RechargeChannelID>");
		poststring.append("<ars:RechargeObj>");
		poststring.append("<ars:AcctAccessCode>");

		poststring.append("<arc:PrimaryIdentity>" + mobile
				+ "</arc:PrimaryIdentity>");

		poststring.append("</ars:AcctAccessCode>");
		poststring.append("</ars:RechargeObj>");
		poststring.append("<ars:RechargeInfo>");
		poststring.append("<ars:CashPayment>");

		poststring.append("<ars:Amount>" + ammout + "</ars:Amount>");

		poststring.append("</ars:CashPayment>");
		poststring.append("</ars:RechargeInfo>");

		poststring.append("<ars:CurrencyID>1049</ars:CurrencyID>");
		poststring.append("</RechargeRequest>");

		poststring.append("</ars:RechargeRequestMsg>");
		poststring.append("</soapenv:Body>");
		poststring.append("</soapenv:Envelope>");
		return poststring.toString();
	}

	/**
	 * 首页免费资源查询
	 */
	public static String QueryFreeUnit() {
		StringBuilder poststring = new StringBuilder();
		poststring
				.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:bbs=\"http://www.huawei.com/bme/cbsinterface/bbservices\" xmlns:cbs=\"http://www.huawei.com/bme/cbsinterface/cbscommon\" xmlns:bbc=\"http://www.huawei.com/bme/cbsinterface/bbcommon\">");
		poststring.append("<soapenv:Header/>");
		poststring.append("<soapenv:Body>");
		poststring.append("<bbs:QueryFreeUnitRequestMsg>");
		poststring.append("<RequestHeader>");

		poststring.append("<cbs:Version>1</cbs:Version>");
		// poststring.append("<cbs:BusinessCode>1</cbs:BusinessCode>");
		poststring.append("<cbs:MessageSeq>" + UUID.randomUUID()
				+ "</cbs:MessageSeq>");
		poststring.append("<cbs:OwnershipInfo>");
		poststring.append("<cbs:BEID>101</cbs:BEID>");
		poststring.append("</cbs:OwnershipInfo>");

		poststring.append("<cbs:AccessSecurity>");
		poststring.append("<cbs:LoginSystemCode>102</cbs:LoginSystemCode>");
		poststring
				.append("<cbs:Password>xyYSFeOUi5DagegPuCQmUQ==</cbs:Password>");
		poststring.append("<cbs:RemoteIP>127.0.0.1</cbs:RemoteIP>");
		poststring.append("</cbs:AccessSecurity>");

		poststring.append("<cbs:OperatorInfo>");
		poststring.append("<cbs:OperatorID>101</cbs:OperatorID>");
		poststring.append("</cbs:OperatorInfo>");
		// poststring.append("<cbs:AccessMode>3</cbs:AccessMode>");
		poststring.append("<cbs:MsgLanguageCode>2002</cbs:MsgLanguageCode>");

		poststring.append("<cbs:TimeFormat>");
		poststring.append("<cbs:TimeType>1</cbs:TimeType>");
		poststring.append("<cbs:TimeZoneID>101</cbs:TimeZoneID>");
		poststring.append("</cbs:TimeFormat>");

		poststring.append("</RequestHeader>");
		poststring.append("<QueryFreeUnitRequest>");
		poststring.append("<bbs:QueryObj>");
		poststring.append("<bbs:SubAccessCode>");
		poststring.append("<bbc:PrimaryIdentity>" + UserInfo.getUserMobile()
				+ "</bbc:PrimaryIdentity>");
		poststring.append("</bbs:SubAccessCode>");
		poststring.append("</bbs:QueryObj>");
		poststring.append("</QueryFreeUnitRequest>");
		poststring.append("</bbs:QueryFreeUnitRequestMsg>");
		poststring.append("</soapenv:Body>");
		poststring.append("</soapenv:Envelope>");
		return poststring.toString();
	}

	/**
	 * 用户订购信息查询
	 */
	public static String QueryCustomerInfo() {
		StringBuilder poststring = new StringBuilder();
		poststring
				.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:bcs=\"http://www.huawei.com/bme/cbsinterface/bcservices\" xmlns:cbs=\"http://www.huawei.com/bme/cbsinterface/cbscommon\" xmlns:bcc=\"http://www.huawei.com/bme/cbsinterface/bccommon\">");
		poststring.append("<soapenv:Header/>");
		poststring.append("<soapenv:Body>");
		poststring.append("<bcs:QueryCustomerInfoRequestMsg>");
		poststring.append("<RequestHeader>");

		poststring.append("<cbs:Version>1</cbs:Version>");
		// poststring.append("<cbs:BusinessCode>1</cbs:BusinessCode>");
		poststring.append("<cbs:MessageSeq>" + UUID.randomUUID()
				+ "</cbs:MessageSeq>");
		poststring.append("<cbs:OwnershipInfo>");
		poststring.append("<cbs:BEID>101</cbs:BEID>");
		poststring.append("</cbs:OwnershipInfo>");

		poststring.append("<cbs:AccessSecurity>");
		poststring.append("<cbs:LoginSystemCode>102</cbs:LoginSystemCode>");
		poststring
				.append("<cbs:Password>xyYSFeOUi5DagegPuCQmUQ==</cbs:Password>");
		poststring.append("<cbs:RemoteIP>127.0.0.1</cbs:RemoteIP>");
		poststring.append("</cbs:AccessSecurity>");

		poststring.append("<cbs:OperatorInfo>");
		poststring.append("<cbs:OperatorID>101</cbs:OperatorID>");
		poststring.append("</cbs:OperatorInfo>");
		// poststring.append("<cbs:AccessMode>3</cbs:AccessMode>");
		poststring.append("<cbs:MsgLanguageCode>2002</cbs:MsgLanguageCode>");

		poststring.append("<cbs:TimeFormat>");
		poststring.append("<cbs:TimeType>2</cbs:TimeType>");
		poststring.append("<cbs:TimeZoneID>101</cbs:TimeZoneID>");
		poststring.append("</cbs:TimeFormat>");

		poststring.append("</RequestHeader>");
		poststring.append("<QueryCustomerInfoRequest>");
		poststring.append("<bcs:QueryObj>");
		poststring.append("<bcs:SubAccessCode>");
		poststring.append("<bcc:PrimaryIdentity>" + UserInfo.getUserMobile()
				+ "</bcc:PrimaryIdentity>");
		poststring.append("</bcs:SubAccessCode>");
		poststring.append("</bcs:QueryObj>");
		poststring.append("</QueryCustomerInfoRequest>");
		poststring.append("</bcs:QueryCustomerInfoRequestMsg>");
		poststring.append("</soapenv:Body>");
		poststring.append("</soapenv:Envelope>");
		return poststring.toString();
	}
}
