package com.huawei.vodafone.bean;

import java.io.Serializable;

public class Plans implements Serializable   {

	private String number;

	private String money;
	private String min;
	private String text;

	public Plans(String number, String money, String min, String text) {
		super();
		this.number = number;
		this.money = money;
		this.min = min;
		this.text = text;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Plans() {
		super();
		// TODO Auto-generated constructor stub
	}

}