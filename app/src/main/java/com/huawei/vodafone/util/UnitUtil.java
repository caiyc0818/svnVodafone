package com.huawei.vodafone.util;

import java.util.List;

import com.huawei.vodafone.bean.BalanceInfo;
import com.huawei.vodafone.bean.FreeUnitItem;
import com.huawei.vodafone.bean.Measure;

/**
 * 单位帮助类
 * 
 */
public class UnitUtil {

	/**
	 * 余额
	 */
	public static String getBalance(List<BalanceInfo> list) {
		return getBalance(list, true);
	}

	/**
	 * 余额
	 */
	public static String getBalance(List<BalanceInfo> list, boolean sign) {
		double money = 0;
		for (BalanceInfo item : list) {
			int unit = Integer.valueOf(item.getBalance().getCurrencyUnit());
			money = money + item.getBalance().getCurrencyValue()
					* Math.pow(10, -unit);
		}
		if (sign) {
			String signIcon = "€";
			if (list != null && list.size() > 0) {
				signIcon = getSign(list.get(0).getBalance().getCurrencyType());
			}
			return signIcon + "JianGe"
					+ StringUtils.formatDecimalFloat(money, 2);
		}
		return StringUtils.formatDecimalFloat(money, 2);
	}

	/**
	 * 余额
	 */
	public static String getSign(String sign) {
		String signIcon = "€";
		switch (sign) {
		case "EUR":
			signIcon = "€";
			break;
		case "USD":
			signIcon = "$";
			break;
		default:
			break;
		}
		return signIcon;
	}

	/**
	 * unit为需要展示的单位，空的话默认展示当前单位
	 */
	public static double getValue(Measure measure, String unit) {
		double gap = 0;
		if (StringUtils.isEmpty(unit)) {
			return measure.getMeasureValue();
		}
		switch (measure.getMeasureType()) {
		case "Dataflow":
			gap = 1024;
			break;
		case "Number":
			gap = 10;
			break;
		case "TimeLength":
			gap = 60;
			break;
		case "Ratio":
			gap = 10;
			break;
		default:
			break;
		}

		return measure.getMeasureValue()
				* Math.pow(gap, measureUnit(measure.getMeasureUnit())
						- measureUnit(unit));
	}

	/**
	 * 以最小单位为刻度
	 */
	public static int measureUnit(String Unit) {
		int num = 1;
		switch (Unit) {
		case "Byte":
		case "Second":
		case "One":
		case "ExtremeRatio":
			num = 1;
			break;
		case "KB":
		case "Minute":
		case "Minutes":
		case "Permillage":
			num = 2;
			break;
		case "MB":
		case "Hundred":
		case "Hour":
		case "Percent":
			num = 3;
			break;
		case "GB":
		case "Thousand":
			num = 4;
			break;
		default:
			break;
		}
		return num;
	}

	public static double getValueTotal(FreeUnitItem unitItem, String unit) {
		return getValueTwo(Integer.valueOf(unitItem.getTotalInitialAmount()),
				unit, unitItem.getMeasureUnitName());
	}

	public static double getValueUnused(FreeUnitItem unitItem, String unit) {
		return getValueTwo(Integer.valueOf(unitItem.getTotalUnusedAmount()),
				unit, unitItem.getMeasureUnitName());
	}

	public static double getValueTwo(int amount, String unit, String oldunit) {
		double gap = 0;
		if (StringUtils.isEmpty(unit)) {
			return amount;
		}
		switch (unit) {
		case "Byte":
		case "KB":
		case "MB":
		case "GB":
			gap = 1024;
			break;
		case "Second":
		case "Minute":
		case "Hour":
			gap = 60;
			break;
		default:
			break;
		}

		return amount * Math.pow(gap, measureUnit(oldunit) - measureUnit(unit));
	}
}
