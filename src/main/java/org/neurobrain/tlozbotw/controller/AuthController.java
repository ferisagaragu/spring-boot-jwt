package org.neurobrain.tlozbotw.controller;

import java.util.Map;

import org.neurobrain.tlozbotw.service.interfaces.IAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {
      
	@Autowired
	private IAuthService authService;

    
	/**
	 	@apiGroup Auth
		@apiVersion 0.0.1
		@apiDescription Servicio para registrar un nuevo usuario
		@api {post} auth/signup/ signup
		@apiPermission none

		@apiParamExample {json} Request-Body:
			{
				"name": "your user name",
				"lastName": "your last name",
				"phoneNumber": "your phone number",
				"imageUrl": "your account photo",
				"userName": "your user name",
				"email": "your email"
			}

		@apiSuccessExample {json} HTTP/1.1 200 OK
			{
				"timestamp": "2020-01-03T04:05:37.126+0000",
				"status": 200,
				"message": "your success message"
			}

		@apiErrorExample {json} HTTP/1.1 400 Bad Request
			{
				"timestamp": "2020-01-03T16:42:13.727+0000",
				"status": 400,
				"error": "Bad Request",
				"message": "your problem message",
				"trace": "your trace catch",
				"path": "/user/firstSignup/:id"
			}

		@apiErrorExample {json} HTTP/1.1 500 Internal Server Error
			{
				"timestamp": "2020-01-03T17:37:02.348+0000",
				"status": 500,
				"error": "Internal Server Error",
				"message": "your error message",
				"trace": "your trace catch",
				"path": "/user/firstSignup/:id"
			}
	*/
	@PostMapping("/signup")
	public ResponseEntity<?> signup(
		@RequestBody Map<String, Object> req
	) {	
		return authService.signup(req);
	}
    
	/**
	 	@apiGroup Auth
		@apiVersion 0.0.1
		@apiDescription Servicio para iniciar sesión
		@api {post} auth/signin signin
		@apiPermission none

		@apiParamExample {json} Request-Body:
			{
				"userName": "email | user name | phone number",
				"password": "your password"
			}

		@apiSuccessExample {json} HTTP/1.1 200 OK
			{
				"timestamp": "2020-01-03T20:21:07.712+0000",
				"status": 200,
				"data": {
					"id": identify id,
					"type": "Bearer",
					"token": "your token",
					"name": "your name",
					"lastName": "your last name",
					"phoneNumber": "your phone number",
					"imageUrl": "your account photo",
					"userName": "your user name",
					"email": "your email",
					"firstSession": true | false,
					"roles": [
						"your roles"
					]
				}
			}

		@apiErrorExample {json} HTTP/1.1 400 Bad Request
			{
				"timestamp": "2020-01-03T16:42:13.727+0000",
				"status": 400,
				"error": "Bad Request",
				"message": "your problem message",
				"trace": "your trace catch",
				"path": "/auth/signin"
			}

		@apiErrorExample {json} HTTP/1.1 500 Internal Server Error
			{
				"timestamp": "2020-01-03T17:37:02.348+0000",
				"status": 500,
				"error": "Internal Server Error",
				"message": "your error message",
				"trace": "your trace catch",
				"path": "/auth/signin"
			}
	*/
	@PostMapping("/signin")
	public ResponseEntity<?> signin(
		@RequestBody Map<String, Object> req
	) {
		return authService.signin(req);
	}

}
