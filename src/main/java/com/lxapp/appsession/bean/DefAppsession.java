package com.lxapp.appsession.bean;

import java.util.HashMap;
import java.util.Map;

import com.lxapp.appsession.AppSession;

public class DefAppsession extends AppSession{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8487453807035928541L;
	
	Map<String, String> attrs = new HashMap<>();
	
	@Override
	public void putAttr(String key, String val) {
		attrs.put(key, val);
		
	}

	@Override
	public String getAttr(String key) {
		
		return attrs.get(key);
	}

}
