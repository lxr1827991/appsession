package com.lxapp.appsession;

public class AppSessionReception {

	
	private ThreadLocal<String> threadSession = new ThreadLocal<>();
	
	public String getSessionId() {
		
		return threadSession.get();

	}
	
	
	public void setSessionId(String sessionid) {
		
		threadSession.set(sessionid);

	}
	
	
	
	
	
}
