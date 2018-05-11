package com.lxapp.appsession.utils;

import com.lxapp.appsession.AppSession;
import com.lxapp.appsession.AppSessionManager;

public class AppSessionUtils {
	
	private static ThreadLocal<AppSession> threadSession = new ThreadLocal<>();
	
	public static AppSessionManager appSessionManager;
	
	public static AppSession getSession() {
		return getSession(true);

	}
	
	public static AppSession getSession(boolean iscreate) {
		AppSession session = threadSession.get();
		if(session!=null)return session;
		AppSession appSession = appSessionManager.getSession(iscreate);
		threadSession.set(appSession);
		return appSession;
	}
	
	
	
	public static AppSession getSessionByAlias(String alias) {
		
		return appSessionManager.getSessionByAlias(alias);

	}
	
	public static void refSession(AppSession appSession) {
		appSessionManager.refSession(appSession);
	}
	
	
	public static void updateAppsession() {
		AppSession session = threadSession.get();
		if(session!=null)
		appSessionManager.updateAppsession(session);
	}
	
	
	public static void invalidatSession(AppSession appSession) {
		
		AppSession thisSession = AppSessionUtils.getSession(false);
		if(thisSession!=null&&thisSession.getId().equals(appSession.getId())) {
			threadSession.set(null);
		}
		
		AppSessionUtils.appSessionManager.deleteAppsession(appSession);
	}
	
	
	
	public static void cleanMemorySession() {
		threadSession.set(null);
	}
	
}
