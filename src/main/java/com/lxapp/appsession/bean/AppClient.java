package com.lxapp.appsession.bean;

public class AppClient {
	
	//ÕËºÅÃÜÂë
	public static final int AUTH_TYPE_PWD = 1;
	//×Ô¶¯µÇÂ¼
	public static final int AUTH_TYPE_AUTO = 2;
	
	String id;
	
	String account;
	
	String pwd;
	
	String token;
	
	Integer authType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getAuthType() {
		return authType;
	}

	public void setAuthType(Integer authType) {
		this.authType = authType;
	}

	
	
}
