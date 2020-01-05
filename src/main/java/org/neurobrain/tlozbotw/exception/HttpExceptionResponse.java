package org.neurobrain.tlozbotw.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class HttpExceptionResponse {

	public ResponseEntity<Object> error(ResponseStatusException e) {
		Map<String, Object> resp = new LinkedHashMap<>();
		resp.put("timestamp", new Date());
		resp.put("status", e.getStatus().value());
		resp.put("error", e.getStatus());
		resp.put("message", e.getReason());

		try {
			Object developMessage = e.getClass().getMethod(
				"getDevelopMessage"
			).invoke(e);

			if (developMessage != null) {
				resp.put("developMessage", developMessage);
			}
		} catch (Exception ex) { }

		return new ResponseEntity<>(
			resp,
			e.getStatus()
		);
	}

}
