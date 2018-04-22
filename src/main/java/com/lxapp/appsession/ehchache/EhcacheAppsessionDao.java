package com.lxapp.appsession.ehchache;

import com.lxapp.appsession.AppSession;
import com.lxapp.appsession.AppSessionDao;
import com.lxapp.appsession.exception.AppSessionException;

public class EhcacheAppsessionDao implements AppSessionDao{
	
	String tempCache = "appSession";
	String foreverCache = "appSessionForever";
	
	public AppSession getSession(String sessionid) {
		Object obj = EhcacheUtil.getInstance().get(foreverCache,sessionid);
		
		if(obj==null)obj = EhcacheUtil.getInstance().get(tempCache,sessionid);
		
		if(obj==null)return null;
		
		if(obj instanceof AppSession)return (AppSession)obj;
		
		throw new AppSessionException("ehcache 缓存的类型错�?");
		
		
	}
	
	
	public void save(AppSession appSession) {
		if(appSession.isForever()) {
			EhcacheUtil.getInstance().put(foreverCache, appSession.getId(), appSession,true);
		}
		
		else EhcacheUtil.getInstance().put(tempCache, appSession.getId(), appSession);
	}


	@Override
	public void delete(AppSession appSession) {
		EhcacheUtil.getInstance().remove(foreverCache, appSession.getId());
		EhcacheUtil.getInstance().remove(tempCache, appSession.getId());
		
	}


	@Override
	public void setForever(AppSession appSession) {
		EhcacheUtil.getInstance().remove(tempCache, appSession.getId());
		EhcacheUtil.getInstance().put(foreverCache, appSession.getId(), appSession,true);
		
	}


	@Override
	public void update(String sessionid, AppSession appSession) {
		
		if(appSession.isForever())EhcacheUtil.getInstance().put(foreverCache, appSession.getId(), appSession);
		else 
		EhcacheUtil.getInstance().put(tempCache, appSession.getId(), appSession);
		
	}
	
}
