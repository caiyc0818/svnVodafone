package com.huawei.vodafone.db;
public class JokeMsg {
	private String idd;
	private String type;
	private String code;
	private String content;

	public JokeMsg() {
		super();
	}

	public JokeMsg(String idd, String type, String code,String content) {
		super();
		this.idd = idd;
		this.type = type;
		this.code = code;
		this.content = content;
	}

	public String getIdd() {
		return idd;
	}

	public void setIdd(String idd) {
		this.idd = idd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "JokeMsg [idd=" + idd + ", type=" + type + ", code=" + code + ", content=" + content + "]";
	}

	
}
