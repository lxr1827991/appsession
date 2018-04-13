package com.lxapp.appsession;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.lxapp.appsession.bean.AppClient;

public class AppSession  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 20180405;

	String id;
	
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
		

	}
	
	@Override
	public String toString() {
		return "AppSession [id=" + id + "]";
	}
	
	
	
}
