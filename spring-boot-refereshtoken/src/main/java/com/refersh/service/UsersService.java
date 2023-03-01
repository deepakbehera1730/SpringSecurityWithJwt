package com.refersh.service;

import java.util.List;

import com.refersh.entity.Users;

public interface UsersService {
	public List<Users> getAll();

	public Users postData(Users users);

	public Users findById(int id);

	public Users putData(Users users, int id);

	public void deleteById(int id);
}
