package com.huawei.vodafone.bean;

public class DiyLevelItem {
	private String levelId;
	private Currency2 levelPrice;
	private Measure levelQuota;
	private String levelStatus;
	private String leveldefault;
	private String sequence;
	public String getLevelId() {
		return levelId;
	}
	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}
	public Currency2 getLevelPrice() {
		return levelPrice;
	}
	public void setLevelPrice(Currency2 levelPrice) {
		this.levelPrice = levelPrice;
	}
	public Measure getLevelQuota() {
		return levelQuota;
	}
	public void setLevelQuota(Measure levelQuota) {
		this.levelQuota = levelQuota;
	}
	public String getLevelStatus() {
		return levelStatus;
	}
	public void setLevelStatus(String levelStatus) {
		this.levelStatus = levelStatus;
	}
	public String getLeveldefault() {
		return leveldefault;
	}
	public void setLeveldefault(String leveldefault) {
		this.leveldefault = leveldefault;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public DiyLevelItem(String levelId, Currency2 levelPrice, Measure levelQuota, String levelStatus,
			String leveldefault, String sequence) {
		super();
		this.levelId = levelId;
		this.levelPrice = levelPrice;
		this.levelQuota = levelQuota;
		this.levelStatus = levelStatus;
		this.leveldefault = leveldefault;
		this.sequence = sequence;
	}
	public DiyLevelItem() {
		super();
		// TODO Auto-generated constructor stub
	}

}