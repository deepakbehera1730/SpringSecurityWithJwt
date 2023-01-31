package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.component.JwtServiceDetail;
import com.jwt.config.JwtResponse;
import com.jwt.config.JwtUtil;
import com.jwt.entity.Users;

@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	
	@Autowired
	private JwtServiceDetail userDetailsService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createUserToken(@RequestBody Users authenticationRequest)throws Exception{
	//testing System.out.println("test1"); 
	authenticate(authenticationRequest.getUsername(),authenticationRequest.getPassword());
	//testing operation System.out.println("test2");
	  final UserDetails userDetails=userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
	 final String token=jwtTokenUtil.generateToken(userDetails);
	  return ResponseEntity.ok(new JwtResponse(token));
		
		
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("user blocked",e);
		}catch (BadCredentialsException e) {
			throw new Exception("invalid credentials",e);
		}
		
	}

}
