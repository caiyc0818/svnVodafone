package com.huawei.vodafone.bean;

import java.io.Serializable;

public class FreeUnitItemDetail implements Serializable {

	private String InitialAmount;

	private String RollOverFlag;

	private String ExpireTime;

	private String LastRollOveredTime;

	private String FreeUnitInstanceID;

	private FreeUnitOrigin FreeUnitOrigin;

	private String CurrentAmount;

	private String EffectiveTime;

	public String getInitialAmount() {
		return InitialAmount;
	}

	public void setInitialAmount(String initialAmount) {
		InitialAmount = initialAmount;
	}

	public String getRollOverFlag() {
		return RollOverFlag;
	}

	public void setRollOverFlag(String rollOverFlag) {
		RollOverFlag = rollOverFlag;
	}

	public String getExpireTime() {
		return ExpireTime;
	}

	public void setExpireTime(String expireTime) {
		ExpireTime = expireTime;
	}

	public String getLastRollOveredTime() {
		return LastRollOveredTime;
	}

	public void setLastRollOveredTime(String lastRollOveredTime) {
		LastRollOveredTime = lastRollOveredTime;
	}

	public String getFreeUnitInstanceID() {
		return FreeUnitInstanceID;
	}

	public void setFreeUnitInstanceID(String freeUnitInstanceID) {
		FreeUnitInstanceID = freeUnitInstanceID;
	}

	public FreeUnitOrigin getFreeUnitOrigin() {
		return FreeUnitOrigin;
	}

	public void setFreeUnitOrigin(FreeUnitOrigin freeUnitOrigin) {
		FreeUnitOrigin = freeUnitOrigin;
	}

	public String getCurrentAmount() {
		return CurrentAmount;
	}

	public void setCurrentAmount(String currentAmount) {
		CurrentAmount = currentAmount;
	}

	public String getEffectiveTime() {
		return EffectiveTime;
	}

	public void setEffectiveTime(String effectiveTime) {
		EffectiveTime = effectiveTime;
	}

}