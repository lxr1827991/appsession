package com.lxapp.appsession;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.lxapp.appsession.bean.AppClient;
import com.lxapp.appsession.utils.AppSessionUtils;

public abstract class AppSession  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 20180428;

	
	String id;
	
	String	alias;
	
	boolean isvalid = true;
	
	int life = 5;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	public abstract void putAttr(String key,String val);
	
	public abstract String getAttr(String key);
	
	

	public void invalidat() {
		
		
		isvalid = false;
	}
	
	public void setLife(int life) {
		this.life = life;
		AppSessionUtils.appSessionManager.setLife(this,life);
		
	}
	
	public int getLife() {
		return life;
	}
	
	public boolean isIsvalid() {
		return isvalid;
	}

	public void setIsvalid(boolean isvalid) {
		this.isvalid = isvalid;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public String toString() {
		return "AppSession [id=" + id + "]";
	}
	
	
	
}
