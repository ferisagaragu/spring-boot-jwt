package org.neurobrain.tlozbotw.service.interfaces;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

public interface IUserService {

	public ResponseEntity<?> firstSignup(Map<String, Object> req) throws ResponseStatusException;
	public ResponseEntity<?> update(Long id, Map<String, Object> req) throws ResponseStatusException;
	
}
