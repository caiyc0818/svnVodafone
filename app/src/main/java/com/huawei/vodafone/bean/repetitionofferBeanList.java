package com.huawei.vodafone.bean;

import java.io.Serializable;

public class repetitionofferBeanList implements Serializable {
	private int tag;
	private OfferBean offerList;

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public OfferBean getOfferList() {
		return offerList;
	}

	public void setOfferList(OfferBean offerList) {
		this.offerList = offerList;
	}

	public repetitionofferBeanList(int tag, OfferBean offerList) {
		super();
		this.tag = tag;
		this.offerList = offerList;
	}

	public repetitionofferBeanList() {
		super();
		// TODO Auto-generated constructor stub
	}

}
