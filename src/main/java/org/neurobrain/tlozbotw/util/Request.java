package org.neurobrain.tlozbotw.util;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Request {

	public Long getLong(Object req, String key) {
		Object reqOut = ((Map<?, ?>) req).get(key);
		
		if (reqOut != null) {
			return Long.valueOf(reqOut.toString()); 
		}
		
		return 0L;
	}
	
	
	public String getString(Object req, String key) {
		Object reqOut = ((Map<?, ?>) req).get(key);
		
		if (reqOut != null) {
			return reqOut.toString();
		}
		
		return null;
	}
	
	
	public boolean getBoolean(Object req, String key) {
		Object reqOut = ((Map<?, ?>) req).get(key);
		
		if (reqOut != null) {
			if (reqOut.toString().equals("true")) {
				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}
	
	
	public List<?> getList(Object req, String key) {
		Object reqOut = ((Map<?, ?>) req).get(key);
		
		if (reqOut != null) {
			return (List<?>) reqOut;
		}
		
		return null;
	}
	
}
