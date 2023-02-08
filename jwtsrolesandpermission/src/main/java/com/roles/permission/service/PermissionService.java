package com.roles.permission.service;

import java.util.List;

import com.roles.permission.entity.Permission;

public interface PermissionService {
	List<Permission> findAllPermission();

	Permission findPermissionrById(int id);

	Permission addPermission(Permission permission);

	Permission updatePermission(int id, Permission permission);

	void deletePermission(int id);
}
