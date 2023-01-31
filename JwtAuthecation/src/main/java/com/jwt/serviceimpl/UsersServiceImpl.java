package com.jwt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.entity.Users;
import com.jwt.repo.UsersRepo;
import com.jwt.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersRepo repo;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Users postData(Users users) {
		
		// TODO Auto-generated method stub
		Users user1=new Users();
		user1.setUsername(users.getUsername());
		String sc=users.getPassword();
		String passwordencoder=passwordEncoder.encode(sc);
		user1.setPassword(passwordencoder);
	return 	repo.save(user1);
		
	 
	}

}
