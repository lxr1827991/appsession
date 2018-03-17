package com.app.appsession;

import com.app.appsession.exception.AppSessionException;
import com.app.appsession.utils.EhcacheUtil;

public class AppSessionDao {

	String cacheName = "appSession";
	
	public AppSession getSession(String sessionid) {
		Object obj = EhcacheUtil.getInstance().get(cacheName,sessionid);

		if(obj==null)return null;
		
		if(obj instanceof AppSession)return (AppSession)obj;
		
		throw new AppSessionException("ehcache 缓存的类型错误");
		
		
	}
	
	
	public void save(AppSession appSession) {
		EhcacheUtil.getInstance().put(cacheName, appSession.getId(), appSession);
	}
	
}
