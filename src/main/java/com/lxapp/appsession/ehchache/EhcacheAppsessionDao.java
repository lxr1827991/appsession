package com.lxapp.appsession.ehchache;

import java.util.List;

import javax.management.Query;

import com.lxapp.appsession.AppSession;
import com.lxapp.appsession.AppSessionDao;
import com.lxapp.appsession.exception.AppSessionException;

public class EhcacheAppsessionDao implements AppSessionDao{
	
	String tempCache = "appSession";
	String foreverCache = "appSessionForever";
	
	String aliasChache = "appSessionAlias";
	
	public AppSession getSession(String sessionid) {
		Object obj = EhcacheUtil.getInstance().get(foreverCache,sessionid);
		
		if(obj==null)obj = EhcacheUtil.getInstance().get(tempCache,sessionid);
		
		if(obj==null)return null;
		
		if(obj instanceof AppSession)return (AppSession)obj;
		
		throw new AppSessionException("ehcache 缓存的类型错�?");
		
		
	}
	
	
	public List<AppSession> findByAlias(String alias) {
		
		return null;

	}
	
	public AppSession getByAlias(String alias) {
		Object obj = EhcacheUtil.getInstance().get(aliasChache,alias);
		
		if(obj==null)return null;
		
		Object sObj =  EhcacheUtil.getInstance().get(foreverCache,obj.toString());
		if(sObj==null)return null;
		
		if(sObj instanceof AppSession)return (AppSession)sObj;
		throw new AppSessionException("ehcache 缓存的类型错误");
	}
	
	
	public void save(AppSession appSession) {
		if(appSession.isForever()) {
			EhcacheUtil.getInstance().put(foreverCache, appSession.getId(), appSession,true);
			if(appSession.getAlias()!=null&&!"".equals(appSession.getAlias()))
			EhcacheUtil.getInstance().put(aliasChache, appSession.getAlias(), appSession.getId());
		}
		
		else EhcacheUtil.getInstance().put(tempCache, appSession.getId(), appSession);
	}


	@Override
	public void delete(AppSession appSession) {
		EhcacheUtil.getInstance().remove(foreverCache, appSession.getId());
		EhcacheUtil.getInstance().remove(tempCache, appSession.getId());
		if(appSession.getAlias()!=null&&!"".equals(appSession.getAlias()))
			EhcacheUtil.getInstance().remove(aliasChache, appSession.getAlias());
	}


	@Override
	public void setForever(AppSession appSession) {
		EhcacheUtil.getInstance().remove(tempCache, appSession.getId());
		save(appSession);
		
	}


	@Override
	public void update(String sessionid, AppSession appSession) {
		
		if(appSession.isForever()) {
			Object obj = EhcacheUtil.getInstance().get(foreverCache, sessionid);
			if(obj!=null) {
				String palias = ((AppSession)obj).getAlias();
				if(palias!=null&&!palias.equals(appSession.getAlias()))
					EhcacheUtil.getInstance().remove(aliasChache, palias);
			}
			if(appSession.getAlias()!=null)
				EhcacheUtil.getInstance().put(aliasChache, appSession.getAlias(), appSession.getId());
			
			
			EhcacheUtil.getInstance().put(foreverCache, appSession.getId(), appSession);
			
		}
		else 
		EhcacheUtil.getInstance().put(tempCache, appSession.getId(), appSession);
		
	}
	
}
