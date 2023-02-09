package com.roles.permission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roles.permission.component.CustomUsersDetails;
import com.roles.permission.config.JwtResponse;
import com.roles.permission.config.JwtUtil;
import com.roles.permission.entity.Users;
import com.roles.permission.service.AuthService;

@RestController
public class AuthController {
	@Autowired
	private AuthService authService;
	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private CustomUsersDetails userDetailsService;

	@PostMapping("/registration")
	public String registraition(@RequestBody Users users) {
		authService.registration(users);
		return "Succesfully register";
	}

	@PostMapping("/login")
	public ResponseEntity<?> createUserToken(@RequestBody Users authenticationRequest) throws Exception {

		authService.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));

	}

}
