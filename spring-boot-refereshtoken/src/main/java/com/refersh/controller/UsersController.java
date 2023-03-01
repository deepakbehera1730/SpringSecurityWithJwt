package com.refersh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refersh.entity.Users;

import com.refersh.service.UsersService;
import com.refersh.utils.ApiUrls;

@RestController
@RequestMapping(ApiUrls.USER)
public class UsersController {
	@Autowired
	private UsersService service;

	@GetMapping()
	public List<Users> getAllUsers() {
		return service.getAll();
	}
	@GetMapping("/{id}")
	public Users getById(@PathVariable int id) {
		return service.findById(id);
	}
	@PutMapping("/{id}")
	public String updateUsers(@RequestBody Users users, @PathVariable int id) throws Exception {
		service.putData(users, id);
		return "Updated User";
	}

	@DeleteMapping("/{id}")
	public String deleteUsers(@PathVariable int id) {
		service.deleteById(id);
		return "Delete Users";
	}
}
