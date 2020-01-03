package org.neurobrain.tlozbotw.service.interfaces;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

public interface IAuthService {
	ResponseEntity<?> signup(Map<String, Object> req) throws ResponseStatusException;
	ResponseEntity<?> signin(Map<String, Object> req) throws ResponseStatusException;
	ResponseEntity<?> recoverPassword(Map<String, Object> req) throws ResponseStatusException;
	ResponseEntity<?> changePassword(Map<String, Object> req) throws ResponseStatusException;
}
