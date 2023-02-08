package com.roles.permission.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.roles.permission.entity.Users;
import com.roles.permission.repo.UsersRepo;
import com.roles.permission.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepo repo;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public List<Users> findAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Users findUserById(int id) {

		return repo.findById(id).orElseThrow();
	}

	@Override
	public Users addUser(Users user) {
		// TODO Auto-generated method stub
		Users user2 = new Users();
		user2.setUsername(user.getUsername());
		String pass = user.getPaswword();
		String enc = passwordEncoder.encode(pass);
		user2.setPaswword(enc);
		user2.setRoles(new ArrayList<>(user.getRoles()));
		return repo.save(user2);
	}

	@Override
	public Users updateUser(int id, Users user) {
		Users user2 = repo.findById(id).orElseThrow();
		user2.setUsername(user.getUsername());
		String password = user.getPaswword();
	String encyrptPassword = passwordEncoder.encode(password);
		user2.setPaswword(encyrptPassword);
		user2.setRoles(new ArrayList<>(user.getRoles()));
		return repo.save(user2);
	}

	@Override
	public void deleteUser(int id) {

		repo.deleteById(id);
	}

}
