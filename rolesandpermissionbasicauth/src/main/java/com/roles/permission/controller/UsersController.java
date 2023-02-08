package com.roles.permission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roles.permission.entity.Users;
import com.roles.permission.serviceimpl.UsersServiceImpl;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UsersServiceImpl impl;

	@PreAuthorize("hasAuthority('entry')")
	@GetMapping()
	public List<Users> findAllusers() {
		return impl.findAllUsers();
	}

	@GetMapping("/{id}")
	public Users userById(@PathVariable int id) {
		return impl.findUserById(id);
	}

	@PostMapping()
	public String addUser(@RequestBody Users user) {
		impl.addUser(user);
		return "Users Added";
	}

	@PutMapping("/{id}")
	public String updateUser(@PathVariable int id, @RequestBody Users user) {
		impl.updateUser(id, user);
		return "Users Updated";
	}

	@DeleteMapping()
	public String deleteUser(@PathVariable int id) {
		impl.deleteUser(id);
		return "Users  Deleted";
	}
}
