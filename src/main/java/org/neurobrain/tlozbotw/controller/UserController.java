package org.neurobrain.tlozbotw.controller;

import java.util.Map;

import org.neurobrain.tlozbotw.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	/**
	 	@apiGroup User
		@apiVersion 0.0.1
		@apiDescription Servicio para iniciar sesión por primera vez
		@api {post} user/firstSignin/:id firstSignin
		@apiPermission {user} {admin}

		@apiParam {number} Id Identificador único

		@apiParamExample {json} Request-Body:
			{
	 			"password": "your password"
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
				"path": "/user/firstSignin/:id"
			}

		@apiErrorExample {json} HTTP/1.1 401 Unauthorized
			{
				"timestamp": "2020-01-03T04:17:06.006+0000",
				"status": 401,
				"error": "Unauthorized",
				"message": "Full authentication is required to access this resource",
				"path": "/user/firstSignin/:id"
			}

		@apiErrorExample {json} HTTP/1.1 500 Internal Server Error
			{
				"timestamp": "2020-01-03T17:37:02.348+0000",
				"status": 500,
				"error": "Internal Server Error",
				"message": "your error message",
				"trace": "your trace catch",
				"path": "/user/firstSignin/:id"
			}
	*/
	@PostMapping("/firstSignin/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?> firstSignin(
		@PathVariable("id") Long id,
		@RequestBody Map<String, Object> req
	) {
		return userService.firstSignin(id, req);
	}

	/**
		@apiGroup User
		@apiVersion 0.0.1
		@apiDescription Servicio para actualizar un usuario
		@api {put} user/update/:id update
		@apiPermission {user} {admin}

		@apiParam {number} Id Identificador único

		@apiParamExample {json} Request-Body:
			{
				"name": "your name",
				"lastName": "your last name",
				"phoneNumber": "your phone number",
				"imageUrl": "your account photo",
				"userName": "your user name"
			}

		@apiSuccessExample {json} HTTP/1.1 200 OK
			{
				"timestamp": "2020-01-03T18:03:54.033+0000",
				"status": 200,
				"message": "your success message",
				"data": {
					"id": identify id,
					"name": "your name",
					"lastName": "your last name",
					"phoneNumber": "your phone number",
					"imageUrl": "your account photo",
					"userName": "your user name",
					"email": "your email",
					"roles": [
						"your roles"
					]
				}
			}

		@apiErrorExample {json} HTTP/1.1 400 Bad Request
			{
				"timestamp": "2020-01-03T18:13:58.035+0000",
				"status": 400,
				"error": "Bad Request",
				"message": "your problem message",
				"trace": "your trace catch",
				"path": "/user/update/:id"
			}

		@apiErrorExample {json} HTTP/1.1 401 Unauthorized
			{
				"timestamp": "2020-01-03T04:17:06.006+0000",
				"status": 401,
				"error": "Unauthorized",
				"message": "Full authentication is required to access this resource",
				"path": "/user/update/:id"
			}

		@apiErrorExample {json} HTTP/1.1 500 Internal Server Error
			{
				"timestamp": "2020-01-03T17:37:02.348+0000",
				"status": 500,
				"error": "Internal Server Error",
				"message": "your error message",
				"trace": "your trace catch",
				"path": "/user/update/:id"
			}
	*/
	@PutMapping("/update/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?> update(
		@PathVariable("id") Long id,
		@RequestBody Map<String, Object> req
	) {
		return userService.update(id, req);
	}

	/**
		@apiGroup User
		@apiVersion 0.0.1
		@apiDescription Servicio para bloquear y desbloquear un usuario
		@api {put} user/blocked/:id blocked
		@apiPermission {admin}

		@apiParam {number} Id Identificador único

		@apiParamExample {json} Request-Body:
			{
				"blocked": true | false
			}

		@apiSuccessExample {json} HTTP/1.1 200 OK
			{
				"timestamp": "2020-01-03T18:35:29.813+0000",
				"status": 200,
				"message": "your success message"
			}

		@apiErrorExample {json} HTTP/1.1 400 Bad Request
			{
				"timestamp": "2020-01-03T18:13:58.035+0000",
				"status": 400,
				"error": "Bad Request",
				"message": "your problem message",
				"trace": "your trace catch",
				"path": "/user/blocked/:id"
			}

		@apiErrorExample {json} HTTP/1.1 401 Unauthorized
			{
				"timestamp": "2020-01-03T04:17:06.006+0000",
				"status": 401,
				"error": "Unauthorized",
				"message": "Full authentication is required to access this resource",
				"path": "/user/blocked/:id"
			}

		@apiErrorExample {json} HTTP/1.1 500 Internal Server Error
			{
				"timestamp": "2020-01-03T17:37:02.348+0000",
				"status": 500,
				"error": "Internal Server Error",
				"message": "your error message",
				"trace": "your trace catch",
				"path": "/user/blocked/:id"
			}
	*/
	@PutMapping("/blocked/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> blocked(
		@PathVariable("id") Long id,
		@RequestBody Map<String, Object> req
	) {
		return userService.blocked(id, req);
	}

	/**
		@apiGroup User
		@apiVersion 0.0.1
		@apiDescription Servicio para eliminar un usuario (eliminación lógica)
		@api {delete} user/delete/:id delete
		@apiPermission {admin}

		@apiParam {number} Id Identificador único

		@apiSuccessExample {json} HTTP/1.1 200 OK
			{
				"timestamp": "2020-01-03T18:41:46.305+0000",
				"status": 200,
				"message": "your success message"
			}

		@apiErrorExample {json} HTTP/1.1 400 Bad Request
			{
				"timestamp": "2020-01-03T18:13:58.035+0000",
				"status": 400,
				"error": "Bad Request",
				"message": "your problem message",
				"trace": "your trace catch",
				"path": "/user/delete/:id"
			}

		@apiErrorExample {json} HTTP/1.1 401 Unauthorized
			{
				"timestamp": "2020-01-03T04:17:06.006+0000",
				"status": 401,
				"error": "Unauthorized",
				"message": "Full authentication is required to access this resource",
				"path": "/user/delete/:id"
			}

		@apiErrorExample {json} HTTP/1.1 500 Internal Server Error
			{
				"timestamp": "2020-01-03T17:37:02.348+0000",
				"status": 500,
				"error": "Internal Server Error",
				"message": "your error message",
				"trace": "your trace catch",
				"path": "/user/delete/:id"
			}
	*/
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> delete(
		@PathVariable("id") Long id
	) {
		return userService.delete(id);
	}

}
