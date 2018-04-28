package com.lxapp.appsession.ehchache;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import net.sf.ehcache.search.Results;

public class EhcacheUtil {
	

    private static final String path = "/ehcache.xml";  
   
  
    private CacheManager manager;  
  
    private static EhcacheUtil ehCache;  
  
    public  EhcacheUtil(String path) {  
    	URL url = getClass().getResource(path);  
        manager = CacheManager.create(url);  
    }  
  
    public static EhcacheUtil getInstance() {  
        if (ehCache== null) {  
            ehCache= new EhcacheUtil(path);  
        }  
        return ehCache; 
    }  
  
    public void put(String cacheName, String key, Object value) {  
        Cache cache = manager.getCache(cacheName);  
        Element element = new Element(key, value);  
        cache.put(element);  
    }  
    
    public void put(String cacheName, String key, Object value,boolean toDisk) {  
        Cache cache = manager.getCache(cacheName);  
        Element element = new Element(key, value);  
        cache.put(element);  
        if(toDisk)cache.flush();
    }
  
    public Object get(String cacheName, String key) {  
        Cache cache = manager.getCache(cacheName);  
        Element element = cache.get(key);  
        return element == null ? null : element.getObjectValue();  
    }  
  
    public Cache get(String cacheName) {  
        return manager.getCache(cacheName);  
    }  
    
    
    public List<Object> find(String cacheName,String attr,String kw) {
    	 Cache cache = manager.getCache(cacheName);  
    	 Attribute<String> kwAttr = cache.getSearchAttribute(attr); 
    	 Query query = cache.createQuery();  
    	  query.addCriteria(kwAttr.eq(kw));
    	  Results results = query.execute();  
    	//获取Results中包含的所有的Result对象  
    	List<Result> resultList = results.all(); 
    	List<Object> retList = new ArrayList<>();
    	for (Result result : resultList) {
    		retList.add(result.getValue());
		}
    	
    	return retList;

	}
  
    public void remove(String cacheName, String key) {  
        Cache cache = manager.getCache(cacheName);  
        cache.remove(key);  
    }  
    
    public void removeAll(String cacheName) {  
        Cache cache = manager.getCache(cacheName);  
        cache.removeAll();  
    }  
  
	
	
}
