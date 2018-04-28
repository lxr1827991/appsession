package com.lxapp.appsession;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.lxapp.appsession.bean.AppClient;
import com.lxapp.appsession.utils.AppSessionUtils;

public class AppSession  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 20180428;

	
	
	String id;
	
	String	alias;
	
	
	boolean isvalid = true;
	
	boolean forever = false;
	
	AppClient appClient;
	
	Map<String, Object> attrs = new HashMap<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	public void putAttr(String key,Object val) {
		attrs.put(key, val);

	}
	
	
	public Object getAttr(String key) {
		return attrs.get(key);

	}
	
	public AppClient getAppClient() {
		return appClient;
	}

	public void setAppClient(AppClient appClient) {
		this.appClient = appClient;
	}

	public void invalidat() {
		
		AppSessionUtils.appSessionManager.deleteAppsession(this);
		isvalid = false;
	}
	
	public void setForever() {
		AppSessionUtils.appSessionManager.setForever(this);
		forever=true;
	}
	
	public boolean isForever() {
		return forever;
	}
	
	
	
	
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public String toString() {
		return "AppSession [id=" + id + "]";
	}
	
	
	
}
