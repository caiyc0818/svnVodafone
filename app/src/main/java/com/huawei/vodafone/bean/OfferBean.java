package com.huawei.vodafone.bean;

import java.io.Serializable;

public class OfferBean  implements Serializable{
	private int offerId;
	private String offerName;
	private String type;
	private int price;
	private String CurrentAmount;
	private String InitialAmount;
	private String EffectiveTime;
	private String ExpireTime;
	private int tag;

	public int getOfferId() {
		return offerId;
	}


	public OfferBean(int offerId, String offerName, String type, int price, String currentAmount, String initialAmount,
			String effectiveTime, String expireTime, int tag) {
		super();
		this.offerId = offerId;
		this.offerName = offerName;
		this.type = type;
		this.price = price;
		CurrentAmount = currentAmount;
		InitialAmount = initialAmount;
		EffectiveTime = effectiveTime;
		ExpireTime = expireTime;
		this.tag = tag;
	}


	public String getType() {
		return type;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCurrentAmount() {
		return CurrentAmount;
	}

	public void setCurrentAmount(String currentAmount) {
		CurrentAmount = currentAmount;
	}

	public String getInitialAmount() {
		return InitialAmount;
	}

	public void setInitialAmount(String initialAmount) {
		InitialAmount = initialAmount;
	}

	public String getEffectiveTime() {
		return EffectiveTime;
	}

	public void setEffectiveTime(String effectiveTime) {
		EffectiveTime = effectiveTime;
	}

	public String getExpireTime() {
		return ExpireTime;
	}

	public void setExpireTime(String expireTime) {
		ExpireTime = expireTime;
	}


	public OfferBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}
