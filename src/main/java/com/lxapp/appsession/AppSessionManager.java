package com.lxapp.appsession;

import com.lxapp.appsession.ehchache.EhcacheAppsessionDao;

public class AppSessionManager {
	
	
	private AppSessionReception appSessionReception;
	
	private AppSessionDao appSessionDao;
	
	private AppSessionGenerate appSessionGenerate;
	
	
	public void init() {
		if(appSessionReception==null)
			throw new IllegalArgumentException("appSessionReception is null");
	}
	

	public AppSession getSession() {
		
		return getSession(true);

	}
	
	public AppSession getSession(boolean iscreate) {
		
		String sessionid = appSessionReception.getSessionId();
		
		return getSession(sessionid,iscreate);

	}
	
	private AppSession getSession(String sessionid,boolean iscreate) {
		 
		if((sessionid==null||"".equals(sessionid))&&!iscreate)return null;
		
		AppSession session = appSessionDao.getSession(sessionid);
		
		if(session==null&&iscreate)return createAppSession();
		
		if(session!=null)appSessionReception.setSessionId(session.getId());
		
		return session;

	}
	
	
	
	private AppSession createAppSession() {
		 
		AppSession appSession = appSessionGenerate.generate();
		appSessionReception.setSessionId(appSession.getId());
		appSessionDao.save(appSession);
		return appSession;

	}
	

	
	protected void deleteAppsession(AppSession appSession) {
		appSessionDao.delete(appSession);

	}
	
	protected void setForever(AppSession appSession) {
		appSessionDao.setForever(appSession);

	}
	
	public void updateAppsession(AppSession appSession) {
		
		appSessionDao.update(appSession.getId(), appSession);
		
	}
	

	public AppSessionReception getAppSessionReception() {
		return appSessionReception;
	}


	public void setAppSessionReception(AppSessionReception appSessionReception) {
		this.appSessionReception = appSessionReception;
	}

	public AppSessionDao getAppSessionDao() {
		return appSessionDao;
	}

	public void setAppSessionDao(AppSessionDao appSessionDao) {
		this.appSessionDao = appSessionDao;
	}

	public AppSessionGenerate getAppSessionGenerate() {
		return appSessionGenerate;
	}

	public void setAppSessionGenerate(AppSessionGenerate appSessionGenerate) {
		this.appSessionGenerate = appSessionGenerate;
	}
	
	
	
	public static void main(String[] args) {
		
		AppSessionDao appSessionDao = new EhcacheAppsessionDao();
		AppSession appSession = new AppSession();
		appSession.setId("1234");
		
		appSessionDao.save(appSession);
		AppSession appSession2 = new AppSession();
		appSession2.setId("1");
		appSessionDao.save(appSession2);
		
		appSession2.setId("33");
		appSession.setId("11");
		
		System.err.println(appSession2== appSessionDao.getSession("1"));
		System.err.println(appSession== appSessionDao.getSession("1234"));
		
	}
	
	
}
