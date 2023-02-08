package com.roles.permission.service;

import java.util.List;

import com.roles.permission.entity.Users;

public interface UsersService {
	List<Users> findAllUsers();

	Users findUserById(int id);

	Users addUser(Users user);

	Users updateUser(int id, Users user);

	void deleteUser(int id);

}
