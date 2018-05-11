package com.lxapp.appsession;

import java.util.Timer;
import java.util.TimerTask;

public class AppSessionManager {
	
	
	private AppSessionReception appSessionReception;
	
	private AppSessionDao appSessionDao;
	
	private AppSessionGenerate appSessionGenerate;
	
	Timer timer;
	
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
	
	
	public AppSession getSessionByAlias(String alias) {

		return appSessionDao.getByAlias(alias);

	}
	
	
	
	
	private AppSession createAppSession() {
		 
		AppSession appSession = appSessionGenerate.generate();
		appSessionReception.setSessionId(appSession.getId());
		appSessionDao.save(appSession);
		return appSession;

	}
	

	
	public void deleteAppsession(AppSession appSession) {
		appSessionReception.setSessionId(null);
		appSession.setIsvalid(false);
		appSessionDao.delete(appSession);

	}
	
	protected void setLife(AppSession appSession,int life) {
		
		appSessionDao.setLife(appSession, life);
	}
	
	public void updateAppsession(AppSession appSession) {
		
		appSessionDao.update(appSession.getId(), appSession);
	}
	
	
	
	public void refSession(AppSession appSession) {
		appSessionDao.refLife(appSession);

	}
	
	public void startLifeService() {
		if(timer!=null)return;
		
		System.out.println("====appSession服务启动====");
		
		timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {  
            public void run() {  
                appSessionDao.gc();
            }  
        }, 10000, 60000); 
		
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
	
	
}
