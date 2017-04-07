package com.huawei.vodafone.bean;

import java.io.Serializable;

public class PlansItemBean implements Serializable {

	private String itemId;
	private String levelId;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public PlansItemBean(String itemId, String levelId) {
		super();
		this.itemId = itemId;
		this.levelId = levelId;
	}

	public PlansItemBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}