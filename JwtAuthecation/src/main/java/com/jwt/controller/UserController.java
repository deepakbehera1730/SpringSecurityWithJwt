package com.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.component.JwtServiceDetail;
import com.jwt.config.JwtResponse;
import com.jwt.config.JwtUtil;
import com.jwt.entity.Users;
import com.jwt.serviceimpl.UsersServiceImpl;

@RestController
public class UserController {
	@Autowired
	private UsersServiceImpl impl;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private JwtServiceDetail userDetailsService;

	@GetMapping("/getall")
	public List<Users> getAllUsers() {
		return impl.getAll();
	}

	@GetMapping("getbyid/{id}")
	public Users getById(@PathVariable int id) {
		return impl.findById(id);
	}

	@PostMapping("/addusers")
	public String addUsers(@RequestBody Users users) {
		impl.postData(users);
		return "Users Added";

	}

	@PutMapping("updateusers/{id}")
	public String updateUsers(@RequestBody Users users, @PathVariable int id) {
		impl.putData(users, id);
		return "Updated User";
	}

	@DeleteMapping("deleteUsers/{id}")
	public String deleteUsers(@PathVariable int id) {
		impl.deleteById(id);
		return "Delete Users";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createUserToken(@RequestBody Users authenticationRequest) throws Exception {

		impl.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));

	}

}
