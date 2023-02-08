package com.roles.permission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roles.permission.entity.Permission;
import com.roles.permission.serviceimpl.PermissionImpl;

@RestController
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private PermissionImpl permissionImpl;

	@GetMapping()
	public List<Permission> findAllusers() {
		return permissionImpl.findAllPermission();
	}

	@GetMapping("/{id}")
	public Permission userById(@PathVariable int id) {
		return permissionImpl.findPermissionrById(id);
	}

	@PostMapping()
	public String addUser(@RequestBody Permission permission) {
		permissionImpl.addPermission(permission);
		return "Permission Added";
	}

	@PutMapping("/{id}")
	public String updateUser(@PathVariable int id, @RequestBody Permission permission) {
		permissionImpl.updatePermission(id, permission);
		return "Permission Updated";
	}

	@DeleteMapping()
	public String deleteUser(@PathVariable int id) {
		permissionImpl.deletePermission(id);
		return "permission  Deleted";
	}
}
