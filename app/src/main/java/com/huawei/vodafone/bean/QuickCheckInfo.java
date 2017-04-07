package com.huawei.vodafone.bean;

import java.util.List;

public class QuickCheckInfo {

	private List<OfferInstValue> offerInstList;

	private List<BalanceInfo> balanceInfoList;

	private List<ConsumeAndQuota> comsumeAndQuotaList;

	private List<RentCycleInfo> rentCycleList;

	public List<OfferInstValue> getOfferInstList() {
		return offerInstList;
	}

	public void setOfferInstList(List<OfferInstValue> offerInstList) {
		this.offerInstList = offerInstList;
	}

	public List<BalanceInfo> getBalanceInfoList() {
		return balanceInfoList;
	}

	public void setBalanceInfoList(List<BalanceInfo> balanceInfoList) {
		this.balanceInfoList = balanceInfoList;
	}

	public List<ConsumeAndQuota> getComsumeAndQuotaList() {
		return comsumeAndQuotaList;
	}

	public void setComsumeAndQuotaList(List<ConsumeAndQuota> comsumeAndQuotaList) {
		this.comsumeAndQuotaList = comsumeAndQuotaList;
	}

	public List<RentCycleInfo> getRentCycleList() {
		return rentCycleList;
	}

	public void setRentCycleList(List<RentCycleInfo> rentCycleList) {
		this.rentCycleList = rentCycleList;
	}

}