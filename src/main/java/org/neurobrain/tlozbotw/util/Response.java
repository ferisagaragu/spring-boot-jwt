package org.neurobrain.tlozbotw.util;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class Response {

	public ResponseEntity<?> ok(String message, Object data) {
		return response(message, data, HttpStatus.OK);
	}

	public ResponseEntity<?> ok(String message) {
		return response(message, null, HttpStatus.OK);
	}

	public ResponseEntity<?> ok(Object data) {
		return response(null, data, HttpStatus.OK);
	}


	public ResponseEntity<?> created(String message, Object data) {
		return response(message, data, HttpStatus.CREATED);
	}
	
	public ResponseEntity<?> created(String message) {
		return response(message, null, HttpStatus.CREATED);
	}
	
	public ResponseEntity<?> created(Object data) {
		return response(null, data, HttpStatus.CREATED);
	}


	private ResponseEntity<Object> response(String message, Object data, HttpStatus status) {
		Map<String, Object> resp = new LinkedHashMap<>();
		resp.put("timestamp", new Date());
		resp.put("status", status.value());

		if (message != null) {
			resp.put("message", message);
		}

		if (data != null) {
			resp.put("data", data);
		}

		return new ResponseEntity<Object> (
			resp,
			status
		);
	}

}
