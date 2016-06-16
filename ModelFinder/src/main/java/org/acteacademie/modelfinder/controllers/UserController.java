package org.acteacademie.modelfinder.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.acteacademie.modelfinder.domain.StringResponse;
import org.acteacademie.modelfinder.domain.User;
import org.acteacademie.modelfinder.services.AuthorizationService;
import org.acteacademie.modelfinder.services.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

@RestController
public class UserController {

	@Resource
	AuthorizationService authorizationService;
	
	@Resource
	UserService userService;
	
	@RequestMapping("/user")
	@CrossOrigin
	public StringResponse user(HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("USER");
		StringResponse response = new StringResponse(user.getRole());
		
		return response;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<User> loginSubmit(@RequestBody User user, HttpServletRequest request, Authentication auth) {
		if (isAuthorized(user)) {
			User authenticatedUser = this.userService.getUserByMail(user.getMail());
			authenticatedUser.setPassword(null);
			
			HttpSession session = request.getSession();
			session.setAttribute("USER", authenticatedUser);
			
			return ResponseEntity.ok(authenticatedUser);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(null);
		}
	}

	private boolean isAuthorized(User userToCheck) {

		User user = this.userService.getUserByMail(userToCheck.getMail());
		if(user != null){
			String encodedPassword = Hashing.sha1().hashString(userToCheck.getPassword(), Charsets.UTF_8 ).toString();
			if(user.getPassword().equals(encodedPassword)){
				return true;
			}
		}
		return false;
	}
}
