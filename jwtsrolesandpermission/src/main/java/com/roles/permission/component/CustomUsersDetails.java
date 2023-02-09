package com.roles.permission.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.roles.permission.entity.Users;
import com.roles.permission.repo.UsersRepo;

@Service
public class CustomUsersDetails implements UserDetailsService {
	@Autowired
	private UsersRepo usersRepo; 

	@Override
	public CustomService loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user1= usersRepo.findByUsername(username);
		if(user1==null)
		{
			throw new UsernameNotFoundException("404 not found");
		}
		return new CustomService(user1);
	}

}
