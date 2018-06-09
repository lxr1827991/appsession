package com.lxapp.appsession;

import java.util.UUID;

import com.lxapp.appsession.bean.DefAppsession;

public class AppSessionGenerate {

	public AppSession generate() {
		AppSession appSession = new DefAppsession();
		appSession.setId(UUID.randomUUID().toString());
		return appSession;

	}
	
}
