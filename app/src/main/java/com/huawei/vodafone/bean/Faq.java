package com.huawei.vodafone.bean;

import java.util.HashMap;
import java.util.Map;

public class Faq {

	private String title;
	
	
	private Map<String, String> map=new HashMap<String, String>();

	private boolean isShow=false;

	public boolean isShow() {
		return isShow;
	}


	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Map<String, String> getMap() {
		return map;
	}


	public void setMap(Map<String, String> map) {
		this.map = map;
	}


}