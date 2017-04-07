package com.huawei.vodafone.bean;

public class RentCycleInfo {

	private String offerID;

	private String offerInstID;

	private UtcDateTime openDay;

	private UtcDateTime endDay;

	public String getOfferID() {
		return offerID;
	}

	public void setOfferID(String offerID) {
		this.offerID = offerID;
	}

	public String getOfferInstID() {
		return offerInstID;
	}

	public void setOfferInstID(String offerInstID) {
		this.offerInstID = offerInstID;
	}

	public UtcDateTime getOpenDay() {
		return openDay;
	}

	public void setOpenDay(UtcDateTime openDay) {
		this.openDay = openDay;
	}

	public UtcDateTime getEndDay() {
		return endDay;
	}

	public void setEndDay(UtcDateTime endDay) {
		this.endDay = endDay;
	}

}