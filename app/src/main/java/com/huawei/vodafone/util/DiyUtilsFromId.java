package com.huawei.vodafone.util;

import com.huawei.vodafone.bean.DiyUtils2;

public class DiyUtilsFromId {

	private static DiyUtils2.BodyBean.DiyItemListBean DataDiyItemListBean = new DiyUtils2.BodyBean.DiyItemListBean();
	private static DiyUtils2.BodyBean.DiyItemListBean UnitDiyItemListBean = new DiyUtils2.BodyBean.DiyItemListBean();
	private static DiyUtils2.BodyBean.DiyItemListBean VoiceDiyItemListBean = new DiyUtils2.BodyBean.DiyItemListBean();

	public static void setDiyUtil2(DiyUtils2 diyUtils2) {
		for (int i = 0; i < diyUtils2.getBody().getDiyItemList().size(); i++) {
			if ("C_DATA_LEVEL".equals(diyUtils2.getBody().getDiyItemList().get(i).getItemTypeId())) {
				DataDiyItemListBean = diyUtils2.getBody().getDiyItemList().get(i);
			}
			if ("C_SMS_LEVEL".equals(diyUtils2.getBody().getDiyItemList().get(i).getItemTypeId())) {
				UnitDiyItemListBean = diyUtils2.getBody().getDiyItemList().get(i);
			}
			if ("C_VOICE_LEVEL".equals(diyUtils2.getBody().getDiyItemList().get(i).getItemTypeId())) {
				VoiceDiyItemListBean = diyUtils2.getBody().getDiyItemList().get(i);
			}
		}
	}

	public static boolean isNull() {
		if (DataDiyItemListBean.getItemTypeId() == null || UnitDiyItemListBean.getItemTypeId() == null
				|| VoiceDiyItemListBean.getItemTypeId() == null) {
			return true;
		}
		return false;
	}

	public static int getDataId(int value) {
		int newValue = value / 1024;
		int id = 0;
		for (int i = 0; i < DataDiyItemListBean.getLevelList().size(); i++) {
			if (newValue == DataDiyItemListBean.getLevelList().get(i).getLevelQuota().getMeasureValue()) {
				id = Integer.parseInt(DataDiyItemListBean.getLevelList().get(i).getLevelId());
			}
		}
		return id;
	}

	public static int getVoiceId(int value) {
		int id = 0;
		for (int i = 0; i < VoiceDiyItemListBean.getLevelList().size(); i++) {
			if (value == VoiceDiyItemListBean.getLevelList().get(i).getLevelQuota().getMeasureValue()) {
				id = Integer.parseInt(VoiceDiyItemListBean.getLevelList().get(i).getLevelId());
			}
		}
		return id;

	}

	public static int getSmsId(int value) {
		int id = 0;
		for (int i = 0; i < UnitDiyItemListBean.getLevelList().size(); i++) {
			if (value == UnitDiyItemListBean.getLevelList().get(i).getLevelQuota().getMeasureValue()) {
				id = Integer.parseInt(UnitDiyItemListBean.getLevelList().get(i).getLevelId());
			}
		}
		return id;

	}

	public static long getDataMoney(int value) {
		int newValue = value / 1024;
		long money = 0;
		for (int i = 0; i < DataDiyItemListBean.getLevelList().size(); i++) {
			if (newValue == DataDiyItemListBean.getLevelList().get(i).getLevelQuota().getMeasureValue()) {
				money = DataDiyItemListBean.getLevelList().get(i).getLevelPrice().getCurrencyValue();
			}
		}
		return money;
	}

	public static long getVoiceMoney(int value) {
		long money = 0;
		for (int i = 0; i < VoiceDiyItemListBean.getLevelList().size(); i++) {
			if (value == VoiceDiyItemListBean.getLevelList().get(i).getLevelQuota().getMeasureValue()) {
				money = VoiceDiyItemListBean.getLevelList().get(i).getLevelPrice().getCurrencyValue();
			}
		}
		return money;

	}

	public static long getSmsMoney(int value) {
		long money = 0;
		for (int i = 0; i < UnitDiyItemListBean.getLevelList().size(); i++) {
			if (value == UnitDiyItemListBean.getLevelList().get(i).getLevelQuota().getMeasureValue()) {
				money = UnitDiyItemListBean.getLevelList().get(i).getLevelPrice().getCurrencyValue();
			}
		}
		return money;

	}

	// public static double getDataMoney(int value) {
	// int newValue = value / 1024;
	// int money = 0;
	// for (int i = 0; i < DataDiyItemListBean.getLevelList().size(); i++) {
	// if (newValue ==
	// DataDiyItemListBean.getLevelList().get(i).getLevelQuota().getMeasureValue())
	// {
	// money =
	// DataDiyItemListBean.getLevelList().get(i).getLevelPrice().getCurrencyValue();
	// }
	// }
	// double double1 = (double) (money * 0.0001);
	// return double1;
	// }
	//
	// public static Double getVoiceMoney(int value) {
	// int money = 0;
	// for (int i = 0; i < VoiceDiyItemListBean.getLevelList().size(); i++) {
	// if (value ==
	// VoiceDiyItemListBean.getLevelList().get(i).getLevelQuota().getMeasureValue())
	// {
	// money =
	// VoiceDiyItemListBean.getLevelList().get(i).getLevelPrice().getCurrencyValue();
	// }
	// }
	// double double1 = (double) (money * 0.0001);
	// return double1;
	//
	// }
	//
	// public static Double getSmsMoney(int value) {
	// int money = 0;
	// for (int i = 0; i < UnitDiyItemListBean.getLevelList().size(); i++) {
	// if (value ==
	// UnitDiyItemListBean.getLevelList().get(i).getLevelQuota().getMeasureValue())
	// {
	// money =
	// UnitDiyItemListBean.getLevelList().get(i).getLevelPrice().getCurrencyValue();
	// }
	// }
	// double double1 = (double) (money * 0.0001);
	// return double1;
	//
	// }

}
