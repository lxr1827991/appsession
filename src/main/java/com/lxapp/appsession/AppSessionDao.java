package com.lxapp.appsession;

public interface AppSessionDao {
	
	public AppSession getSession(String sessionid);
	
	public void save(AppSession appSession);
	
	public void update(String sessionid,AppSession appSession);
	
	
	void delete(AppSession appSession);
	/**
	 * 设置session 生命周期
	 */
	void setLife(AppSession appSession,int life);
	
	public AppSession getByAlias(String alias);
	
	void refLife(AppSession session);
	
	void gc();
	
}
