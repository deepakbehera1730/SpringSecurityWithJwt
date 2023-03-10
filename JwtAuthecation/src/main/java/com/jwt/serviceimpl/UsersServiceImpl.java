package com.jwt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.entity.Users;
import com.jwt.repo.UsersRepo;
import com.jwt.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersRepo repo;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager manager;

	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Users postData(Users users) {

		// TODO Auto-generated method stub
		Users user1 = new Users();
		user1.setUsername(users.getUsername());
		String sc = users.getPassword();
		String passwordencoder = passwordEncoder.encode(sc);
		user1.setPassword(passwordencoder);
		return repo.save(user1);

	}

	@Override
	public Users findById(int id) {
		Users users = repo.findById(id).orElseThrow();
		return users;

	}

	@Override
	public Users putData(Users users, int id) {
		Users user1 = repo.findById(id).orElseThrow();
		user1.setUsername(users.getUsername());
		String sc = users.getPassword();
		String passwordencoder = passwordEncoder.encode(sc);
		user1.setPassword(passwordencoder);
		return repo.save(users);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	public void authenticate(String username, String password) throws Exception {
		try {
			manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("user blocked", e);
		} catch (BadCredentialsException e) {
			throw new Exception("invalid credentials", e);
		}

	}
}
