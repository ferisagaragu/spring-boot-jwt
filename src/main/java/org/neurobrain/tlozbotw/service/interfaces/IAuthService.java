package org.neurobrain.tlozbotw.service.interfaces;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

public interface IAuthService {
	
	public ResponseEntity<?> signup(Map<String, Object> req) throws ResponseStatusException;
	public ResponseEntity<?> signin(Map<String, Object> req) throws ResponseStatusException;
	
}
