package com.roles.permission.service;

import java.util.List;

import com.roles.permission.entity.Roles;

public interface RolesService {
	List<Roles> findAllRoles();

	Roles findRolerById(int id);

	Roles addRole(Roles role);

	Roles updateRole(int id, Roles role);

	void deleteRole(int id);

	void addroles(int userId, int roleId);
}
