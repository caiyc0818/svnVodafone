package com.huawei.vodafone.bean;

import java.util.ArrayList;

/**
 * 
 * 
 * @function
 * @author Weich
 * @version 1.0, 2015年8月28日 下午2:48:09
 */
public class AllPersonalInfo {

	private String select;

	private ArrayList<PersonalInfo> personalInfos;

	private String listsize;

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public ArrayList<PersonalInfo> getPersonalInfos() {
		return personalInfos;
	}

	public void setPersonalInfos(ArrayList<PersonalInfo> personalInfos) {
		this.personalInfos = personalInfos;
	}

	public String getListsize() {
		return listsize;
	}

	public void setListsize(String listsize) {
		this.listsize = listsize;
	}

}
