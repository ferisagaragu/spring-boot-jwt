package org.neurobrain.tlozbotw.controller;

import java.util.Map;

import org.neurobrain.tlozbotw.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
	public ResponseEntity<?> update(
		@PathVariable("id") Long id,
		@RequestBody Map<String, Object> req
	) {
		return userService.update(id, req);
	}

	@PutMapping("/blocked/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> blocked(
		@PathVariable("id") Long id,
		@RequestBody Map<String, Object> req
	) {
		return userService.blocked(id, req);
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> delete(
		@PathVariable("id") Long id
	) {
		return userService.delete(id);
	}

}
