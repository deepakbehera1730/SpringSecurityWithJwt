package com.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.entity.Users;
import com.jwt.serviceimpl.UsersServiceImpl;

@RestController
public class UserController {
@Autowired
private UsersServiceImpl impl;

@GetMapping("/getall")
public List<Users> getAllUsers()
{
	return impl.getAll();
}

@PostMapping("/addusers")
public String addUsers(@RequestBody Users users)
{
	impl.postData(users);
	return "Users Added";
	
}

}
