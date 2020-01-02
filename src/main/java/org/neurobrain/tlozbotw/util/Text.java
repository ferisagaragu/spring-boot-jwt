package org.neurobrain.tlozbotw.util;

import java.lang.reflect.Method;
import java.util.Base64;
import java.util.UUID;


public class Text {

	public static String toJSONString(Object obj) {
		try {
			String jsonOut = "{\n";
			Method[] methods = obj.getClass().getMethods();
			
			for (int i = 0; i < methods.length; i++) {
				if (
					methods[i].getName().contains("get") && 
					!methods[i].getName().equals("getClass")
				) {
		    		jsonOut += "  \"" +  
		    	    methods[i].getName().replace("get", "").toLowerCase() + 
		    	    "\":\"" + methods[i].invoke(obj) + "\",\n";
		    	}
			}
	
			jsonOut = jsonOut.substring(0, jsonOut.length() - 2) + "\n}";
			
			return jsonOut;
		} catch (Exception e) {
			return "Problem when converting the class to json string, "
				 + "it is necessary to generate the getter and setter "
				 + "methods in your entity";
		} 
	}
	
	
	public static String uniqueString() {
		String originalInput = UUID.randomUUID().toString().substring(0, 12);
		String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
		return encodedString;
	}
	
}
