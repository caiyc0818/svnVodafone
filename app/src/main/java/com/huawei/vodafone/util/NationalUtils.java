package com.huawei.vodafone.util;

import java.util.ArrayList;

import com.huawei.vodafone.bean.DiyUtils2;
import com.huawei.vodafone.bean.DiyUtils2.BodyBean.OfferListBean;

public class NationalUtils {
	private static ArrayList<OfferListBean> list = new ArrayList<>();

	public static void setNationalUtil(DiyUtils2 diyUtils2) {
		list = (ArrayList<OfferListBean>) diyUtils2.getBody().getOfferList();
	}
	public static String getOfferName(String id) {
		switch (Integer.parseInt(id)) {
		case  12011:
			return  "€2 Starbucks coupon";
		case  120002:
			return  "Free 5M Internet Add-on";
		case  120098:
			return  "Free 1G Data Add-on for Point Redeem";
		case  12013:
			return  "1G Internet Add-on";
		case  12014:
			return  "2G Internet Add-on";
		default:
			break;
		}
		for (int i = 0; i < list.size(); i++) {
			if (id.equals(list.get(i).getOfferId())) {
				return list.get(i).getOfferName();
			}
		}
		return "";
	}

	public static int getPrice(String id) {
		for (int i = 0; i < list.size(); i++) {
			if (id.equals(list.get(i).getOfferId())) {
				return list.get(i).getPeriodicFee().getCurrencyValue();
			}
		}
		return 0;
	}
}
