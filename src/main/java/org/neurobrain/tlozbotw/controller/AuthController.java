package org.neurobrain.tlozbotw.controller;

import java.util.Map;

import org.neurobrain.tlozbotw.service.interfaces.IAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {
      
	@Autowired
	private IAuthService authService;

	@Value("classpath:/static/index.html")
	private Resource index;
    
	@PostMapping("/signup")
	public ResponseEntity<?> signup(
		@RequestBody Map<String, Object> req
	) {	
		return authService.signup(req);
	}
    
    
	@PostMapping("/signin")
	public ResponseEntity<?> signin(
		@RequestBody Map<String, Object> req
	) {
		return authService.signin(req);
	}

}
