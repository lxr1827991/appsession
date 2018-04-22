package com.lxapp.appsession;

public interface AppSessionDao {
	
	public AppSession getSession(String sessionid);
	
	
	public void save(AppSession appSession);
	
	public void update(String sessionid,AppSession appSession);
	
	
	void delete(AppSession appSession);
	/**
	 * 设置session不过期
	 */
	void setForever(AppSession appSession);
	
}
