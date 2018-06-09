package com.lxapp.appsession.redis;

import com.lxapp.appsession.AppSession;
import com.lxapp.appsession.AppSessionDao;

public abstract class RedisDao implements AppSessionDao{

	static String sidPre = "apps.";
	static String aliasPre = "apps.alias.";
	
	public abstract RedisAppsession getRedisAppsession(String sessionid);
	
	public abstract String get(String key);
	 
	public abstract void set(String key,String val);
	
	
	public AppSession getSession(String sessionid) {
		
		RedisAppsession appsession = getRedisAppsession(sidPre+sessionid);
		
		return appsession;
		
	}
	
	public AppSession getByAlias(String alias) {
		
		String sid = get(aliasPre+alias);
		if(sid==null)return null;
		RedisAppsession appsession = getRedisAppsession(sidPre+sid);
		
		return appsession;
		
	}
	
	
	public void save(AppSession appSession) {
		
		
	}


	@Override
	public void delete(AppSession appSession) {
	
	}


	@Override
	public void setLife(AppSession appSession,int life) {
	
		
	}


	@Override
	public void update(String sessionid, AppSession appSession) {
		
	
		
	}

	@Override
	public void refLife(AppSession session) {
		
		
	}

	@Override
	public void gc() {
		
		
	}
	
	
	
	
}
