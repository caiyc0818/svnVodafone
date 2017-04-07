package com.huawei.vodafone.bean;

import java.util.ArrayList;

public class UsageVolumeList {

	private String dateType;

	private String CDRType;

	private String statisDate;
	
	private String transactionDate;
	
	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public String getCDRType() {
		return CDRType;
	}

	public void setCDRType(String cDRType) {
		CDRType = cDRType;
	}

	public String getStatisDate() {
		return statisDate;
	}

	public void setStatisDate(String statisDate) {
		this.statisDate = statisDate;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}


}