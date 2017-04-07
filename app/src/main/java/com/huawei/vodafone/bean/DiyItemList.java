package com.huawei.vodafone.bean;

import java.io.Serializable;
import java.util.List;

public class DiyItemList implements Serializable {

	private List<DiyItem> diyItemList;
	private Currency2 fee;
	private List<OfferListBean> offerList;
	public List<DiyItem> getDiyItemList() {
		return diyItemList;
	}
	public void setDiyItemList(List<DiyItem> diyItemList) {
		this.diyItemList = diyItemList;
	}
	public Currency2 getFee() {
		return fee;
	}
	public void setFee(Currency2 fee) {
		this.fee = fee;
	}
	public List<OfferListBean> getOfferList() {
		return offerList;
	}
	public void setOfferList(List<OfferListBean> offerList) {
		this.offerList = offerList;
	}
	public DiyItemList(List<DiyItem> diyItemList, Currency2 fee, List<OfferListBean> offerList) {
		super();
		this.diyItemList = diyItemList;
		this.fee = fee;
		this.offerList = offerList;
	}
	public DiyItemList() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}