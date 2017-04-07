package com.huawei.vodafone.bean;

import java.util.List;

public class PlansBean {

	private List<PlansItem> itemList;

	public List<PlansItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<PlansItem> itemList) {
		this.itemList = itemList;
	}

	public PlansBean(List<PlansItem> itemList) {
		super();
		this.itemList = itemList;
	}

	public PlansBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}