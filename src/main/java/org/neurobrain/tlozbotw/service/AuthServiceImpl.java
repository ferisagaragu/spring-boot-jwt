package org.neurobrain.tlozbotw.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.neurobrain.tlozbotw.dao.IRoleDAO;
import org.neurobrain.tlozbotw.dao.IUserDAO;
import org.neurobrain.tlozbotw.entity.Role;
import org.neurobrain.tlozbotw.entity.User;
import org.neurobrain.tlozbotw.exception.BadRequestException;
import org.neurobrain.tlozbotw.exception.UnauthorizedException;
import org.neurobrain.tlozbotw.response.AuthResp;
import org.neurobrain.tlozbotw.security.JwtProvider;
import org.neurobrain.tlozbotw.security.UserPrinciple;
import org.neurobrain.tlozbotw.service.interfaces.IAuthService;
import org.neurobrain.tlozbotw.util.Mail;
import org.neurobrain.tlozbotw.util.Request;
import org.neurobrain.tlozbotw.util.Resource;
import org.neurobrain.tlozbotw.util.Text;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthServiceImpl implements IAuthService, UserDetailsService {

	@Autowired
	private AuthenticationManager authenticationManager;
	 
	@Autowired
	private JwtProvider jwtProvider;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private Mail mail;
	
	@Autowired
	private AuthResp response;
	
	@Autowired
	private Request request;
	
	@Autowired
	private IUserDAO userDao;
	
	@Autowired
	private IRoleDAO roleDao;
 
	@Value("${app.auth.user-no-exist}")
	private String userNoExist;
	
	@Value("${app.auth.user-no-password}")
	private String userNoPassowrd;
	
	@Value("${app.auth.user-exist}")
	private String userExist;
	
	@Value("${app.auth.user-created}")
	private String userCreated;
	
	@Value("${app.auth.mail-exist}")
	private String mailExist;
	
	@Value("${app.auth.phone-number-exist}")
	private String phoneNumberExist;
	
	@Value("${app.auth.mail-subject}")
	private String mailSubject;
	
	@Value("${app.auth.mail-message}")
	private String mailMessage;
	
	@Value("${app.auth.mail-sub-message}")
	private String mailSubMessage;
	
	@Value("${app.auth.mail-app-name}")
	private String mailAppName;
			
	@Value("${app.auth.mail-app-description}")
	private String mailAppDescription;
	
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName)
		throws UsernameNotFoundException {
      
		User user = userDao.findByUserName(userName).orElseThrow(() ->
			new UsernameNotFoundException(userNoExist)
		);
			
		return UserPrinciple.build(user);
	}
	
    
	@Override
	@Transactional
	public ResponseEntity<?> signup(Map<String, Object> req) 
		throws ResponseStatusException {
		
		existUser(req);
		
		String password = Text.uniqueString();
		User user = new User(
			request.getString(req, "name"), 
			request.getString(req, "lastName"),
			request.getString(req, "phoneNumber"),
			request.getString(req, "imageUrl"),
			request.getString(req, "userName"),
			request.getString(req, "email"),
			encoder.encode(password),
			true
		);
		
		List<Role> roles = new ArrayList<>();
		roles.add(roleDao.findById(1l).orElse(null));
		user.setRoles(roles);
		User userOut = userDao.save(user);
		
		mail.send(
			mailSubject, 
			Resource.passworTemplate(
				userOut.getName(), 
				mailMessage, 
				mailSubMessage, 
				password, 
				mailAppName, 
				mailAppDescription
			), 
			userOut.getEmail()
		);
		
		return response.signupResp(userOut, userCreated);
	}


	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> signin(Map<String, Object> req) 
		throws ResponseStatusException {
		
		String userName = request.getString(req, "userName");
		User user = searchUserName(userName);
		String jwt;
		
		try {
			Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
					user.getUserName(),
					request.getString(req, "password")
				)
			);
	 
			SecurityContextHolder.getContext().setAuthentication(authentication);
			jwt = jwtProvider.generateJwtToken(authentication);
		} catch (Exception e) {
			throw new UnauthorizedException(userNoPassowrd);
		}
		
		return response.signinResp(jwt, user);
	}
	
	
	private void existUser(Map<String, Object> req) 
	    throws ResponseStatusException {
		
		User userName = userDao.findByUserName(
			request.getString(req, "userName")
		).orElse(null);
		if (userName != null) {
			throw new BadRequestException(userExist);
		}
		
		User userEmail = userDao.findByEmail(
			request.getString(req, "email")
		).orElse(null);
		if (userEmail != null) {
			throw new BadRequestException(mailExist);
		}
		
		User userPhone = userDao.findByPhoneNumber(
			request.getString(req, "phoneNumber")
		).orElse(null);
		if (userPhone != null) {
			throw new BadRequestException(phoneNumberExist);
		}
	}
	
	
	private User searchUserName(String userName) {
		User user = userDao.findByUserName(userName).orElse(null);
		
		if (user == null) {
			user = userDao.findByEmail(userName).orElse(null);
			if (user == null) {
				user = userDao.findByPhoneNumber(userName).orElseThrow(() ->
					new UnauthorizedException(userNoExist)
				);
			}
		}
		
		return user;
	}
}
