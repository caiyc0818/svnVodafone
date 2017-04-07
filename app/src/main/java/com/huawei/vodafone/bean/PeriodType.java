package com.huawei.vodafone.bean;

public class PeriodType {

	private String type;

	private Integer length;

	private UtcDate startDate;

	private UtcDate endDate;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public UtcDate getStartDate() {
		return startDate;
	}

	public void setStartDate(UtcDate startDate) {
		this.startDate = startDate;
	}

	public UtcDate getEndDate() {
		return endDate;
	}

	public void setEndDate(UtcDate endDate) {
		this.endDate = endDate;
	}

}