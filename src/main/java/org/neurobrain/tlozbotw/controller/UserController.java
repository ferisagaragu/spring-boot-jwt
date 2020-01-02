package org.neurobrain.tlozbotw.controller;

import java.util.Map;

import org.neurobrain.tlozbotw.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping("/firstSignup/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?> firstSignup(
		@PathVariable("id") Long id,
		@RequestBody Map<String, Object> req
	) {
		return userService.firstSignup(id, req);
	}
	
	
	@PutMapping("/update/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?> updateUser(
		@PathVariable("id") Long id,
		@RequestBody Map<String, Object> req
	) {
		return userService.update(id, req);
	}
	
}
