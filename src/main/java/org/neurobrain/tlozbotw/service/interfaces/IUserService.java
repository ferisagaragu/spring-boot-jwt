package org.neurobrain.tlozbotw.service.interfaces;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

public interface IUserService {
	ResponseEntity<?> firstSignup(Long id, Map<String, Object> req) throws ResponseStatusException;
	ResponseEntity<?> update(Long id, Map<String, Object> req) throws ResponseStatusException;
	ResponseEntity<?> blocked(Long id, Map<String, Object> req) throws ResponseStatusException;
	ResponseEntity<?> delete(Long id) throws ResponseStatusException;
}
