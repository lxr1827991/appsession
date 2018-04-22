package com.lxapp.appsession;

import com.lxapp.appsession.utils.AppSessionUtils;

public class AppSessionReception {

	
	private ThreadLocal<String> threadSession = new ThreadLocal<>();
	
	public String getSessionId() {
		
		return threadSession.get();

	}
	
	
	public void setSessionId(String sessionid) {
		
		threadSession.set(sessionid);

	}
	
	
	public void requestStart() {
		AppSessionUtils.cleanMemorySession();
	}
	
	 public void requestFinish() {
		
		 AppSessionUtils.updateAppsession();

	}
	
	
}
