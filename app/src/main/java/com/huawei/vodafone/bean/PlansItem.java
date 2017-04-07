package com.huawei.vodafone.bean;

import java.io.Serializable;
import java.util.List;

public class PlansItem implements Serializable {

	private DiscountRate discountRate;
	private Currency2 fee;
	private List<PlansItemBean> levelList;
	public DiscountRate getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(DiscountRate discountRate) {
		this.discountRate = discountRate;
	}
	public Currency2 getFee() {
		return fee;
	}
	public void setFee(Currency2 fee) {
		this.fee = fee;
	}
	public List<PlansItemBean> getLevelList() {
		return levelList;
	}
	public void setLevelList(List<PlansItemBean> levelList) {
		this.levelList = levelList;
	}
	public PlansItem(DiscountRate discountRate, Currency2 fee, List<PlansItemBean> levelList) {
		super();
		this.discountRate = discountRate;
		this.fee = fee;
		this.levelList = levelList;
	}
	public PlansItem() {
		super();
		// TODO Auto-generated constructor stub
	}

}