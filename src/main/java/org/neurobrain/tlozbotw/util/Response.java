package org.neurobrain.tlozbotw.util;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class Response {

	public ResponseEntity<?> created(String message, Object data) {
		try {
			Map<String, Object> resp = new LinkedHashMap<>();
			resp.put("timestamp", new Date());
			resp.put("status", 201);
			resp.put("message", message);
			
			if (data != null) {
				resp.put("data", data); 
			}
			
			return new ResponseEntity<Object> (
				resp, 
				HttpStatus.CREATED
			);
		} catch (ResponseStatusException e) {
			Map<String, Object> rep = new HashMap<>();
			rep.put("error", e.getMessage());
			e.printStackTrace();
			
			return new ResponseEntity<Map<String, Object>>(
				rep, 
				HttpStatus.BAD_REQUEST
			);
		}
	}
	
	public ResponseEntity<?> created(String message) {
		try {
			Map<String, Object> resp = new LinkedHashMap<>();
			resp.put("timestamp", new Date());
			resp.put("status", 201);
			resp.put("message", message);
			
			return new ResponseEntity<Object> (
				resp, 
				HttpStatus.CREATED
			);
		} catch (ResponseStatusException e) {
			Map<String, Object> rep = new HashMap<>();
			rep.put("error", e.getMessage());
			e.printStackTrace();
			
			return new ResponseEntity<Map<String, Object>>(
				rep, 
				HttpStatus.BAD_REQUEST
			);
		}
	}
	
	public ResponseEntity<?> created(Object data) {
		try{
			Map<String, Object> resp = new LinkedHashMap<>();
			resp.put("timestamp", new Date());
			resp.put("status", 201);	
			
			if (data != null) {
				resp.put("data", data); 
			}
			
			return new ResponseEntity<Object> (
				resp, 
				HttpStatus.CREATED
			);
		} catch (ResponseStatusException e) {
			Map<String, Object> rep = new HashMap<>();
			rep.put("error", e.getMessage());
			e.printStackTrace();
			
			return new ResponseEntity<Map<String, Object>>(
				rep, 
				HttpStatus.BAD_REQUEST
			);
		}
	}
	
	
	public ResponseEntity<?> ok(String message, Object data) {
		try {
			Map<String, Object> resp = new LinkedHashMap<>();
			resp.put("timestamp", new Date());
			resp.put("status", 200);
			resp.put("message", message);
			
			if (data != null) {
				resp.put("data", data); 
			}
			
			return new ResponseEntity<Object> (
				resp, 
				HttpStatus.OK
			);
		} catch (ResponseStatusException e) {
			Map<String, Object> rep = new HashMap<>();
			rep.put("error", e.getMessage());
			e.printStackTrace();
			
			return new ResponseEntity<Map<String, Object>>(
				rep, 
				HttpStatus.BAD_REQUEST
			);
		}
	}
	
	public ResponseEntity<?> ok(String message) {
		try {	
			Map<String, Object> resp = new LinkedHashMap<>();
			resp.put("timestamp", new Date());
			resp.put("status", 200);
			resp.put("message", message);	
			
			return new ResponseEntity<Object> (
				resp, 
				HttpStatus.OK
			);
		} catch (ResponseStatusException e) {
			Map<String, Object> rep = new HashMap<>();
			rep.put("error", e.getMessage());
			e.printStackTrace();
			
			return new ResponseEntity<Map<String, Object>>(
				rep, 
				HttpStatus.BAD_REQUEST
			);
		}
	}
	
	public ResponseEntity<?> ok(Object data) {
		try {
			Map<String, Object> resp = new LinkedHashMap<>();
			resp.put("timestamp", new Date());
			resp.put("status", 200);	
			
			if (data != null) {
				resp.put("data", data); 
			}
			
			return new ResponseEntity<Object> (
				resp, 
				HttpStatus.OK
			);
		} catch (Exception e) {
			Map<String, Object> rep = new HashMap<>();
			rep.put("error", e.getMessage());
			e.printStackTrace();
			
			return new ResponseEntity<Map<String, Object>>(
				rep, 
				HttpStatus.BAD_REQUEST
			);
		}
	}
	
}
