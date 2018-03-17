package com.app.appsession;

public class AppSessionFactory {

	
	public static AppSessionManager createAppSessionManager(AppSessionReception appSessionReception) {
		 AppSessionManager appSessionManager;
		appSessionManager = new AppSessionManager();
		 appSessionManager.setAppSessionDao(new AppSessionDao());
		 appSessionManager.setAppSessionGenerate(new AppSessionGenerate());
		 appSessionManager.setAppSessionReception(appSessionReception);
		 AppSessionUtils.appSessionManager = appSessionManager;
		 return appSessionManager;
	}
	
	
}
