package com.app.appsession;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AppSession  implements Serializable{

	String id;
	
	Map<String, Object> attrs = new HashMap<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	public void putAttr(String key,Object val) {
		attrs.put(key, val);

	}
	
	
	public Object getAttr(String key) {
		return attrs.get(key);

	}
	

	public void invalidat() {
		

	}
	
	@Override
	public String toString() {
		return "AppSession [id=" + id + "]";
	}
	
	
	
}
