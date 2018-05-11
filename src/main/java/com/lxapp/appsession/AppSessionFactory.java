package com.lxapp.appsession;

import com.lxapp.appsession.ehchache.EhcacheAppsessionDao;
import com.lxapp.appsession.utils.AppSessionUtils;

public class AppSessionFactory {

	
	public static AppSessionManager createAppSessionManager(AppSessionReception appSessionReception) {
		
		 return createAppSessionManager(appSessionReception,new EhcacheAppsessionDao());
	}
	
	public static AppSessionManager createAppSessionManager(AppSessionReception appSessionReception,AppSessionDao appSessionDao) {
		 return createAppSessionManager(appSessionReception,appSessionDao,false);
	}
	
	
	public static AppSessionManager createAppSessionManager(AppSessionReception appSessionReception,AppSessionDao appSessionDao,boolean maintain) {
		 AppSessionManager appSessionManager;
		 appSessionManager = new AppSessionManager();
		 appSessionManager.setAppSessionDao(appSessionDao);
		 appSessionManager.setAppSessionGenerate(new AppSessionGenerate());
		 appSessionManager.setAppSessionReception(appSessionReception);
		 AppSessionUtils.appSessionManager = appSessionManager;
		 if(maintain)
		 appSessionManager.startLifeService();
		 return appSessionManager;
	}
	
}
