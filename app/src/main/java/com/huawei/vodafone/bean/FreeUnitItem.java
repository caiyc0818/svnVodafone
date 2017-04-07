package com.huawei.vodafone.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class FreeUnitItem implements Serializable{

	private ArrayList<FreeUnitItemDetail> FreeUnitItemDetailArray;

	private FreeUnitItemDetail FreeUnitItemDetailItem;

	private String MeasureUnitName;

	private String TotalUnusedAmount;

	private String FreeUnitTypeName;

	private String TotalInitialAmount;

	private String MeasureUnit;

	private String FreeUnitType;

	public ArrayList<FreeUnitItemDetail> getFreeUnitItemDetailArray() {
		return FreeUnitItemDetailArray;
	}

	public void setFreeUnitItemDetailArray(
			ArrayList<FreeUnitItemDetail> freeUnitItemDetailArray) {
		FreeUnitItemDetailArray = freeUnitItemDetailArray;
	}

	public FreeUnitItemDetail getFreeUnitItemDetailItem() {
		return FreeUnitItemDetailItem;
	}

	public void setFreeUnitItemDetailItem(
			FreeUnitItemDetail freeUnitItemDetailItem) {
		FreeUnitItemDetailItem = freeUnitItemDetailItem;
	}

	public String getMeasureUnitName() {
		return MeasureUnitName;
	}

	public void setMeasureUnitName(String measureUnitName) {
		MeasureUnitName = measureUnitName;
	}

	public String getTotalUnusedAmount() {
		return TotalUnusedAmount;
	}

	public void setTotalUnusedAmount(String totalUnusedAmount) {
		TotalUnusedAmount = totalUnusedAmount;
	}

	public String getFreeUnitTypeName() {
		return FreeUnitTypeName;
	}

	public void setFreeUnitTypeName(String freeUnitTypeName) {
		FreeUnitTypeName = freeUnitTypeName;
	}

	public String getTotalInitialAmount() {
		return TotalInitialAmount;
	}

	public void setTotalInitialAmount(String totalInitialAmount) {
		TotalInitialAmount = totalInitialAmount;
	}

	public String getMeasureUnit() {
		return MeasureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		MeasureUnit = measureUnit;
	}

	public String getFreeUnitType() {
		return FreeUnitType;
	}

	public void setFreeUnitType(String freeUnitType) {
		FreeUnitType = freeUnitType;
	}

}