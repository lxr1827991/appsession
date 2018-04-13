package com.lxapp.appsession;

public class AppSessionUtils {
	
	 static AppSessionManager appSessionManager;
	
	 
	 

	public static AppSession getSession() {
		
		return appSessionManager.getSession();

	}
	
	
	private void initAppSessionReception(AppSessionReception reception) {
		appSessionManager.setAppSessionReception(reception);

	}
	
}
