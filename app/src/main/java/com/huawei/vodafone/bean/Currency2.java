package com.huawei.vodafone.bean;

import java.io.Serializable;

public class Currency2 implements Serializable{

	private String currencyType;

	private int currencyValue;

	private String currencyUnit;

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public int getCurrencyValue() {
		return currencyValue;
	}

	public void setCurrencyValue(int currencyValue) {
		this.currencyValue = currencyValue;
	}

	public String getCurrencyUnit() {
		return currencyUnit;
	}

	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}

}