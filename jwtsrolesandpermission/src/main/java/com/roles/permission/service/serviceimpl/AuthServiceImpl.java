package com.roles.permission.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.roles.permission.entity.Users;
import com.roles.permission.repo.UsersRepo;
import com.roles.permission.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private AuthenticationManager manager;
	@Autowired
	private UsersRepo repo;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Users registration(Users users) {
		Users user2 = new Users();
		user2.setUsername(users.getUsername());
		String pass = users.getPassword();
		String enc = passwordEncoder.encode(pass);
		user2.setPassword(enc);
		return repo.save(user2);
	}

	@Override
	public void authenticate(String username, String paswword) throws Exception {
		try {

			manager.authenticate(new UsernamePasswordAuthenticationToken(username, paswword));

		} catch (DisabledException e) {
			throw new Exception("user blocked", e);
		} catch (BadCredentialsException e) {
			throw new Exception("invalid credentials", e);
		}

	}

}
