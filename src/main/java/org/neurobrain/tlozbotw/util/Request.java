package org.neurobrain.tlozbotw.util;

import java.util.List;
import java.util.Map;

import org.neurobrain.tlozbotw.exception.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class Request {

	public Long getLong(Object req, String key) {
		Object reqOut = ((Map<?, ?>) req).get(key);
		
		if (reqOut != null) {
			return Long.valueOf(reqOut.toString()); 
		}

		throw new BadRequestException(key + " field not found");
	}
	
	
	public String getString(Object req, String key) {
		Object reqOut = ((Map<?, ?>) req).get(key);
		
		if (reqOut != null) {
			return reqOut.toString();
		}

		throw new BadRequestException(key + " field not found");
	}
	
	
	public boolean getBoolean(Object req, String key) {
		Object reqOut = ((Map<?, ?>) req).get(key);
		
		if (reqOut != null) {
				return reqOut.toString().equals("true");
		}

		throw new BadRequestException(key + " field not found");
	}
	
	
	public List<?> getList(Object req, String key) {
		Object reqOut = ((Map<?, ?>) req).get(key);
		
		if (reqOut != null) {
			return (List<?>) reqOut;
		}

		throw new BadRequestException(key  + " field not found");
	}
	
}
