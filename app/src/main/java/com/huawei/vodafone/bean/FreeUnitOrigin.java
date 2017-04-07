package com.huawei.vodafone.bean;

import java.io.Serializable;

public class FreeUnitOrigin implements Serializable{

	private String OriginType;

	private OfferingKey OfferingKey;

	public String getOriginType() {
		return OriginType;
	}

	public void setOriginType(String originType) {
		OriginType = originType;
	}

	public OfferingKey getOfferingKey() {
		return OfferingKey;
	}

	public void setOfferingKey(OfferingKey offeringKey) {
		OfferingKey = offeringKey;
	}

}