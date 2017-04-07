package com.huawei.vodafone.bean;

import java.io.Serializable;

public class DiscountRate implements Serializable{
private String measureType;
private String measureUnit;
private String measureValue;
public String getMeasureType() {
	return measureType;
}
public void setMeasureType(String measureType) {
	this.measureType = measureType;
}
public String getMeasureUnit() {
	return measureUnit;
}
public void setMeasureUnit(String measureUnit) {
	this.measureUnit = measureUnit;
}
public String getMeasureValue() {
	return measureValue;
}
public void setMeasureValue(String measureValue) {
	this.measureValue = measureValue;
}
public DiscountRate(String measureType, String measureUnit, String measureValue) {
	super();
	this.measureType = measureType;
	this.measureUnit = measureUnit;
	this.measureValue = measureValue;
}
public DiscountRate() {
	super();
	// TODO Auto-generated constructor stub
}




}