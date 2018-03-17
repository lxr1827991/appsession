package com.app.appsession;

import java.util.UUID;

public class AppSessionGenerate {

	public AppSession generate() {
		AppSession appSession = new AppSession();
		appSession.setId(UUID.randomUUID().toString());
		return appSession;

	}
	
}
