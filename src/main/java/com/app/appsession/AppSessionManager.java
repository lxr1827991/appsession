package com.app.appsession;

public class AppSessionManager {
	
	
	AppSessionReception appSessionReception;
	
	AppSessionDao appSessionDao;
	
	AppSessionGenerate appSessionGenerate;
	

	public AppSession getSession() {
		 
		if(appSessionReception==null)
			throw new IllegalArgumentException("appSessionReception is null");
		
		String sessionid = appSessionReception.getSessionId();
		
		return getSession(sessionid);

	}
	
	public AppSession getSession(String sessionid) {
		 
		AppSession session = appSessionDao.getSession(sessionid);
		
		if(session==null)return createAppSession();
		
		return session;

	}
	
	
	
	private AppSession createAppSession() {
		 
		AppSession appSession = appSessionGenerate.generate();
		appSessionReception.setSessionId(appSession.getId());
		appSessionDao.save(appSession);
		return appSession;

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
		
		AppSessionDao appSessionDao = new AppSessionDao();
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
