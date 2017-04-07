package com.huawei.vodafone.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 用户信息
 * 
 * @function
 * @author caihelin
 * @version 1.0 2015年5月13日 14:08:01
 * 
 */
public class User 
{	
	private String userId;
	
	private String number;
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	private String nickname;
	

}
