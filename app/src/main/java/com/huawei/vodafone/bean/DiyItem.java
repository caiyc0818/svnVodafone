package com.huawei.vodafone.bean;

import java.io.Serializable;
import java.util.List;

public class DiyItem implements Serializable {

	private String diyType;

	private String itemTypeId;

	private String itemTypeName;

	private List<DiyLevelItem> levelList;

	public String getDiyType() {
		return diyType;
	}

	public void setDiyType(String diyType) {
		this.diyType = diyType;
	}

	public String getItemTypeId() {
		return itemTypeId;
	}

	public void setItemTypeId(String itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public String getItemTypeName() {
		return itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}

	public List<DiyLevelItem> getLevelList() {
		return levelList;
	}

	public void setLevelList(List<DiyLevelItem> levelList) {
		this.levelList = levelList;
	}

	public DiyItem(String diyType, String itemTypeId, String itemTypeName, List<DiyLevelItem> levelList) {
		super();
		this.diyType = diyType;
		this.itemTypeId = itemTypeId;
		this.itemTypeName = itemTypeName;
		this.levelList = levelList;
	}

	public DiyItem() {
		super();
		// TODO Auto-generated constructor stub
	}

}