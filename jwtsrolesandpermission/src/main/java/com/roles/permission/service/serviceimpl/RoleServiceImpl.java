package com.roles.permission.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roles.permission.entity.Roles;
import com.roles.permission.entity.Users;
import com.roles.permission.repo.RolesRepo;
import com.roles.permission.repo.UsersRepo;
import com.roles.permission.service.RolesService;

@Service
public class RoleServiceImpl implements RolesService {
	@Autowired
	private RolesRepo roles;
	@Autowired
	private UsersRepo usersRepo;

	@Override
	public List<Roles> findAllRoles() {
		// TODO Auto-generated method stub
		return roles.findAll();
	}

	@Override
	public Roles findRolerById(int id) {
		// TODO Auto-generated method stub
		return roles.findById(id).orElseThrow();
	}

	@Override
	public Roles addRole(Roles role) {
		// TODO Auto-generated method stub
		Roles role2 = new Roles();
		role2.setRolesName(role.getRolesName());
		role2.setPermission(new ArrayList<>(role.getPermission()));
		role2.setUser(new ArrayList<>(role.getUser()));
		return roles.save(role2);
	}

	@Override
	public void addroles(int usersId, int roleId) {

		Users user1 = usersRepo.findById(usersId).orElseThrow();
		Roles role1 = roles.findById(roleId).orElseThrow();

		List<Roles> userRole = user1.getRoles();
		userRole.add(role1);
		user1.setRoles(userRole);

		usersRepo.save(user1);

	}

	@Override
	public Roles updateRole(int id, Roles role) {
		Roles role2 = roles.findById(id).orElseThrow();
		role2.setRolesName(role.getRolesName());
		role2.setPermission(new ArrayList<>(role.getPermission()));
		return roles.save(role2);
	}

	@Override
	public void deleteRole(int id) {
		// TODO Auto-generated method stub
		roles.deleteById(id);
	}

}
