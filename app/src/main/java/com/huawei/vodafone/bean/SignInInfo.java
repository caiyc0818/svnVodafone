package com.huawei.vodafone.bean;

public class SignInInfo {

	private int id;

	private String title;

	private String time;

	private int point;

	private int type;

	private int reserved1;

	public SignInInfo(int id, String title, String time, int point, int type,
			int reserved1) {
		super();
		this.id = id;
		this.title = title;
		this.time = time;
		this.point = point;
		this.type = type;
		this.reserved1 = reserved1;
	}

	public SignInInfo(String title, String time, int point, int type,
			int reserved1) {
		super();
		this.title = title;
		this.time = time;
		this.point = point;
		this.type = type;
		this.reserved1 = reserved1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getReserved1() {
		return reserved1;
	}

	public void setReserved1(int reserved1) {
		this.reserved1 = reserved1;
	}

}