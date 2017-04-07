package com.huawei.vodafone.bean;

public class BookingInfo {

	private UtcDate createTime;

	private String bookingType;

	private String salesChannelId;

	private String offerId;

	private String offerName;

	private String offeringInstStatus;

	private String offerType;

	public UtcDate getCreateTime() {
		return createTime;
	}

	public void setCreateTime(UtcDate createTime) {
		this.createTime = createTime;
	}

	public String getBookingType() {
		return bookingType;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	public String getSalesChannelId() {
		return salesChannelId;
	}

	public void setSalesChannelId(String salesChannelId) {
		this.salesChannelId = salesChannelId;
	}

	public String getOfferId() {
		return offerId;
	}

	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getOfferingInstStatus() {
		return offeringInstStatus;
	}

	public void setOfferingInstStatus(String offeringInstStatus) {
		this.offeringInstStatus = offeringInstStatus;
	}

	public String getOfferType() {
		return offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

}