package com.huawei.vodafone.bean;

public class ConsumeAndQuota {

	private String Id;

	private String name;

	private Measure usedValue;

	private Measure leftValue;

	private Measure totalValue;

	private Measure dailyValue;

	private UtcDate expiryDate;

	private UtcDate startDate;

	private String offerInstId;

	private String offerId;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Measure getUsedValue() {
		return usedValue;
	}

	public void setUsedValue(Measure usedValue) {
		this.usedValue = usedValue;
	}

	public Measure getLeftValue() {
		return leftValue;
	}

	public void setLeftValue(Measure leftValue) {
		this.leftValue = leftValue;
	}

	public Measure getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Measure totalValue) {
		this.totalValue = totalValue;
	}

	public Measure getDailyValue() {
		return dailyValue;
	}

	public void setDailyValue(Measure dailyValue) {
		this.dailyValue = dailyValue;
	}

	public UtcDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(UtcDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public UtcDate getStartDate() {
		return startDate;
	}

	public void setStartDate(UtcDate startDate) {
		this.startDate = startDate;
	}

	public String getOfferInstId() {
		return offerInstId;
	}

	public void setOfferInstId(String offerInstId) {
		this.offerInstId = offerInstId;
	}

	public String getOfferId() {
		return offerId;
	}

	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

}