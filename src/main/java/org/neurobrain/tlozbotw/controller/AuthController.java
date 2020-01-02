package org.neurobrain.tlozbotw.controller;

import java.util.Map;

import org.neurobrain.tlozbotw.service.interfaces.IAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {
      
    @Autowired
    private IAuthService authService;
 
    
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
