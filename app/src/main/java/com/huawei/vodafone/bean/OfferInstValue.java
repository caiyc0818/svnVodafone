package com.huawei.vodafone.bean;

import java.util.List;

public class OfferInstValue {
	private String offerInstId;

	private UtcDateTime effectiveDate;

	private UtcDateTime expireDate;

	private UtcDateTime orderDate;

	private String offerId;

	private String offerCode;

	private String offerName;

	private String offerDesc;

	private String offerType;

	private String addOnSubcategory;

	private String tryFlag;

	private String alertFlag;

	private Currency onceFee;

	private Currency periodicFee;

	private String iconUrl;

	private String maxNumber;

	private List<ParameterValue> instParameterValueList;

	private List<ParameterValue> offeringPropSpec;

	private String offeringInstStatus;

	private String recurringOffer;

	private String campaignId;

	private String responseId;

	public String getOfferInstId() {
		return offerInstId;
	}

	public void setOfferInstId(String offerInstId) {
		this.offerInstId = offerInstId;
	}

	public UtcDateTime getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(UtcDateTime effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public UtcDateTime getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(UtcDateTime expireDate) {
		this.expireDate = expireDate;
	}

	public UtcDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(UtcDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getOfferId() {
		return offerId;
	}

	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	public String getOfferCode() {
		return offerCode;
	}

	public void setOfferCode(String offerCode) {
		this.offerCode = offerCode;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getOfferDesc() {
		return offerDesc;
	}

	public void setOfferDesc(String offerDesc) {
		this.offerDesc = offerDesc;
	}

	public String getOfferType() {
		return offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public String getAddOnSubcategory() {
		return addOnSubcategory;
	}

	public void setAddOnSubcategory(String addOnSubcategory) {
		this.addOnSubcategory = addOnSubcategory;
	}

	public String getTryFlag() {
		return tryFlag;
	}

	public void setTryFlag(String tryFlag) {
		this.tryFlag = tryFlag;
	}

	public String getAlertFlag() {
		return alertFlag;
	}

	public void setAlertFlag(String alertFlag) {
		this.alertFlag = alertFlag;
	}

	public Currency getOnceFee() {
		return onceFee;
	}

	public void setOnceFee(Currency onceFee) {
		this.onceFee = onceFee;
	}

	public Currency getPeriodicFee() {
		return periodicFee;
	}

	public void setPeriodicFee(Currency periodicFee) {
		this.periodicFee = periodicFee;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(String maxNumber) {
		this.maxNumber = maxNumber;
	}

	public List<ParameterValue> getInstParameterValueList() {
		return instParameterValueList;
	}

	public void setInstParameterValueList(
			List<ParameterValue> instParameterValueList) {
		this.instParameterValueList = instParameterValueList;
	}

	public List<ParameterValue> getOfferingPropSpec() {
		return offeringPropSpec;
	}

	public void setOfferingPropSpec(List<ParameterValue> offeringPropSpec) {
		this.offeringPropSpec = offeringPropSpec;
	}

	public String getOfferingInstStatus() {
		return offeringInstStatus;
	}

	public void setOfferingInstStatus(String offeringInstStatus) {
		this.offeringInstStatus = offeringInstStatus;
	}

	public String getRecurringOffer() {
		return recurringOffer;
	}

	public void setRecurringOffer(String recurringOffer) {
		this.recurringOffer = recurringOffer;
	}

	public String getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

}