package com.roles.permission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roles.permission.entity.Users;
import com.roles.permission.service.UsersService;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UsersService usersService;;

	@PreAuthorize("hasAuthority('ADMINONlY')")
	@GetMapping()
	public List<Users> findAllusers() {
		return usersService.findAllUsers();
	}

	@PreAuthorize("hasAuthority('ADMINONlY')")
	@GetMapping("/{id}")
	public Users userById(@PathVariable int id) {
		return usersService.findUserById(id);
	}
//
//	@PostMapping()
//	public String addUser(@RequestBody Users user) {
//		impl.addUser(user);
//		return "Users Added";
//	}

	@PutMapping("/{id}")
	public String updateUser(@PathVariable int id, @RequestBody Users user) {
		usersService.updateUser(id, user);
		return "Users Updated";
	}
	@PreAuthorize("hasAuthority('ADMINONlY')")
	@DeleteMapping()
	public String deleteUser(@PathVariable int id) {
		usersService.deleteUser(id);
		return "Users  Deleted";
	}
}
