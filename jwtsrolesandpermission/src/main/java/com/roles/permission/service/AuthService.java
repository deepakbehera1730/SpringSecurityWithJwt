package com.roles.permission.service;

import org.springframework.stereotype.Service;

import com.roles.permission.entity.Users;


public interface AuthService {

	public Users registration(Users users);

	public void authenticate(String username, String paswword) throws Exception;

	

}
