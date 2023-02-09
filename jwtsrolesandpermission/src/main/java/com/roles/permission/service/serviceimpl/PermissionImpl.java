package com.roles.permission.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roles.permission.entity.Permission;
import com.roles.permission.repo.PermissionRepo;
import com.roles.permission.service.PermissionService;

@Service
public class PermissionImpl implements PermissionService {

	@Autowired
	private PermissionRepo repo;

	@Override
	public List<Permission> findAllPermission() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Permission findPermissionrById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow();
	}

	@Override
	public Permission addPermission(Permission permission) {
		// TODO Auto-generated method stub
		Permission permission2 = new Permission();
		permission2.setPermissionname(permission.getPermissionName());
		return repo.save(permission2);

	}

	@Override
	public Permission updatePermission(int id, Permission permission) {
		// TODO Auto-generated method stub
		Permission permission2 = repo.findById(id).orElseThrow();
		permission2.setPermissionname(permission.getPermissionName());
		return repo.save(permission2);
	}

	@Override
	public void deletePermission(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);

	}

}
