package com.lxapp.appsession;

import com.lxapp.appsession.ehchache.EhcacheAppsessionDao;
import com.lxapp.appsession.utils.AppSessionUtils;

public class AppSessionFactory {

	
	public static AppSessionManager createAppSessionManager(AppSessionReception appSessionReception) {
		 AppSessionManager appSessionManager;
		 appSessionManager = new AppSessionManager();
		 appSessionManager.setAppSessionDao(new EhcacheAppsessionDao());
		 appSessionManager.setAppSessionGenerate(new AppSessionGenerate());
		 appSessionManager.setAppSessionReception(appSessionReception);
		 AppSessionUtils.appSessionManager = appSessionManager;
		 return appSessionManager;
	}
	
	
}
