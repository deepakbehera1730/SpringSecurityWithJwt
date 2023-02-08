package com.roles.permission.component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.roles.permission.entity.Permission;
import com.roles.permission.entity.Roles;
import com.roles.permission.entity.Users;
import com.roles.permission.service.UsersService;

public class CustomService implements UserDetails {

	public CustomService(Users user) {
		super();
		this.user = user;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Roles> roles = user.getRoles();

		System.out.println("$$$$$" + roles.toString());
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        Roles roles1=new Roles();
//        List<Permission> permissions= roles1.getPermission();

		for (Roles role : roles) {
			System.out.println(role.getRolesName());
			authorities.add(new SimpleGrantedAuthority("ROLE_"+ role.getRolesName()));
			System.out.println(authorities);

			for (Permission permission : role.getPermission()) {
				System.out.println("sds");
				authorities.add(new SimpleGrantedAuthority(permission.getPermissionname()));
				System.out.println(authorities);
			}
		}

		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPaswword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
