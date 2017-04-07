package com.huawei.vodafone.bean;

import java.io.Serializable;

public class OfferingKey implements Serializable{

	private String PurchaseSeq;

	private String OfferingID;

	public String getPurchaseSeq() {
		return PurchaseSeq;
	}

	public void setPurchaseSeq(String purchaseSeq) {
		PurchaseSeq = purchaseSeq;
	}

	public String getOfferingID() {
		return OfferingID;
	}

	public void setOfferingID(String offeringID) {
		OfferingID = offeringID;
	}

}