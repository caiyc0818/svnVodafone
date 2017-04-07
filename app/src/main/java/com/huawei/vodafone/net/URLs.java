package com.huawei.vodafone.net;

/**
 * URLs集合
 * 
 * @author hanweipeng
 * @version V1.0 创建时间：2013-12-24 下午5:52:36
 */
public class URLs {
	// 环境
	// private final static String URL_HOST = "https://223.68.139.247:8443";
	private final static String URL_HOST = "http://223.68.139.247:18080";

	/**
	 * 1更新用户信息
	 */
	public final static String UPDATE_SUB_INFO = URL_HOST
			+ "/bes/ucec/v1/update_sub_info";
	/**
	 * 2查询订单有效期
	 */
	public final static String OFFERINST = URL_HOST
			+ "/bes/ucec/v1/rent_cycle_by_offerinst";

	/**
	 * 3通过手机号码查询已订阅的订单明细列表
	 */
	public final static String OFFERINSTLIST = URL_HOST
			+ "/bes/ucec/v1/offerinstlist_by_sub";
	/**
	 * 4查询DIY套餐根据价格排序
	 */
	public final static String DIYPRICE = URL_HOST
			+ "/bes/ucec/v1/diyprice_by_level";

	/**
	 * 5订阅订单
	 */
	public final static String ADDOPTIONAL = URL_HOST
			+ "/bes/ucec/v1/add_optionaloffering";
	/**
	 * 6修改订单
	 */
	public final static String MODIFYOPTIONAL = URL_HOST
			+ "/bes/ucec/v1/modify_optionalofferinginst";
	/**
	 * 7退订订单
	 */
	public final static String REMOVEOPTIONAL = URL_HOST
			+ "/bes/ucec/v1/remove_optionalofferinginst";
	/**
	 * 8通过手机号查询余额
	 */
	public final static String BALANCEINFO = URL_HOST
			+ "/bes/ucec/v1/balanceinfo_by_sub";
	/**
	 * 9查询收费CDRs
	 */
	public final static String CDRSUB = URL_HOST + "/bes/ucec/v1/cdr_by_sub";

	/**
	 * 10通过手机号查询充值记录
	 */
	public final static String RECHARGELOG = URL_HOST
			+ "/bes/ucec/v1/rechargelog";
	/**
	 * 11查询月消费记录
	 */
	public final static String PAYMENTHISTORY = URL_HOST
			+ "/bes/ucec/v1/month_payment_history";

	/**
	 * 12查询手机业务使用历史
	 */
	public final static String USAGE = URL_HOST + "/bes/ucec/v1/usage_history";

	/**
	 * 13快速查看当前的余额、消费、有效期
	 */
	public final static String QUICKCHECK = URL_HOST
			+ "/bes/ucec/v1/quick_check";

	/**
	 * 14查询可订阅的订单和DIY ranks
	 */
	public final static String OFFERS_DIYRANKS = URL_HOST
			+ "/bes/ucec/v1/diy_offerandrank";

	/**
	 * 15查询用户历史订购记录
	 */
	public final static String ALLBOOKINFO = URL_HOST
			+ "/bes/ucec/v1/allbookinginfo_by_sub";

	/**
	 * 16查询所有可能的排列组合,组合是否有折扣,最终的价格
	 */
	public final static String RANK_COMBINATION_AND_PRICE = URL_HOST
			+ "/bes/ucec/v1/queryallDIYRankpriceanddiscount";

	/**
	 * 17发送用户在沃达丰商店的位置
	 */
	public final static String REPORT_USER_LOACTION = URL_HOST
			+ "/bes/ucec/v1/reportUserLocation";

	/**
	 * 18查询推荐订单
	 */
	public final static String QUERY_PROMOTION_OFFER = URL_HOST
			+ "/bes/ucec/v1/querypromotionaloffer";

	/**
	 * 19充值
	 */
	public final static String RECHARGE = "http://223.68.139.247:18085/services/ArServices";

	/**
	 * 20个推
	 */
	// 华为服务器
	public final static String GETUI = "http://218.104.127.194:20151/push/getui/saveMobileInfo.action";
	// 公司服务器
	// public final static String GETUI =
	// "http://58.213.123.141:9900/push/getui/saveMobileInfo.action";

	/**
	 * 21 Querying Free Units首页查询免费资源
	 */
	public final static String QUERYFREEUNIT = "http://223.68.139.247:18085/services/BbServices?wsdl";

	/**
	 * 22 Querying customer info综合资源查询
	 */
	public final static String QUERYCUSTOMERINFO = "http://223.68.139.247:18085/services/BcServices?wsdl";

}
