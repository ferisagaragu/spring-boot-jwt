package org.neurobrain.tlozbotw.service;

import java.util.Map;

import org.neurobrain.tlozbotw.dao.IUserDAO;
import org.neurobrain.tlozbotw.entity.User;
import org.neurobrain.tlozbotw.exception.BadRequestException;
import org.neurobrain.tlozbotw.response.UserResp;
import org.neurobrain.tlozbotw.service.interfaces.IUserService;
import org.neurobrain.tlozbotw.util.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImp implements IUserService {

	@Autowired
	Request request;
	
	@Autowired
	UserResp response;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private IUserDAO userDao;
	
	@Value("${app.auth.user-no-exist}")
	private String userNoExist;
	
	@Value("${app.auth.user-activated}")
	private String userActivated;
	
	@Value("${app.auth.user-update}")
	private String userUpdated;
	
	@Value("${app.auth.user-exist}")
	private String userExist;
	
	@Value("${app.auth.phone-number-exist}")
	private String phoneNumberExist;

	@Value("${app.auth.user-blocked}")
	private String userBlockedM;

	@Value("${app.auth.user-unlocked}")
	private String userUnlocked;

	@Value("${app.auth.user-deleted}")
	private String userDeleted;

	@Override
	@Transactional
	public ResponseEntity<?> firstSignup(Long id, Map<String, Object> req)
		throws ResponseStatusException {
		
		User user = userDao.findById(id).orElseThrow(() ->
			new BadRequestException(userNoExist)
		);
		
		user.setFirstSession(false);
		user.setPassword(
			encoder.encode(
				request.getString(req, "password")
			)
		);

		userDao.save(user);
		return response.firstSignupResp(userActivated);
	}


	@Override
	@Transactional
	public ResponseEntity<?> update(Long id, Map<String, Object> req) 
		throws ResponseStatusException {
		
		User userUpdate = userDao.findById(id).orElseThrow(() -> 
			new BadRequestException(userNoExist)
		); 
		
		userOrPhoneNumberExist(req);
		
		userUpdate.setUserName(request.getString(req, "userName"));
		userUpdate.setPhoneNumber(request.getString(req, "phoneNumber"));
		userUpdate.setLastName(request.getString(req, "lastName"));
		userUpdate.setImageUrl(request.getString(req, "imageUrl"));
		userUpdate.setName(request.getString(req, "name"));
		userDao.save(userUpdate);
		
		return response.updateUserResp(userUpdated, userUpdate);
	}


	@Override
	public ResponseEntity<?> blocked(Long id, Map<String, Object> req)
		throws ResponseStatusException {

		boolean blocked = request.getBoolean(req, "blocked");
		User userBlocked = userDao.findById(id).orElseThrow(() ->
			new BadRequestException(userNoExist)
		);
		userBlocked.setBlocked(blocked);
		userDao.save(userBlocked);

		if (blocked) {
			return response.blocked(userBlockedM);
		}

		return response.blocked(userUnlocked);
	}

	@Override
	public ResponseEntity<?> delete(Long id) throws ResponseStatusException {
		User userDelete = userDao.findById(id).orElseThrow(() ->
			new BadRequestException(userNoExist)
		);
		userDelete.setDelete(true);
		userDao.save(userDelete);

		return response.delete(userDeleted);
	}


	private void userOrPhoneNumberExist(Map<String, Object> req) {
		User user = userDao.findByUserName(
			request.getString(req, "userName")
		).orElse(null);
		if (user != null) {
			throw new BadRequestException(userExist);
		}
		
		User userPhoneNumber = userDao.findByPhoneNumber(
			request.getString(req, "phoneNumber")
		).orElse(null);
		if (userPhoneNumber != null) {
			throw new BadRequestException(phoneNumberExist);
		}
	}

}
