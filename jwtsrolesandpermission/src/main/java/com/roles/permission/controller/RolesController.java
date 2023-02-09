package com.roles.permission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roles.permission.entity.Roles;
import com.roles.permission.service.RolesService;

@RestController
@PreAuthorize("hasAuthority('ADMINONlY')")
@RequestMapping("/roles")
public class RolesController {

	@Autowired
	private RolesService roleServiceImpl;

	@GetMapping()
	public List<Roles> findAllusers() {
		return roleServiceImpl.findAllRoles();
	}

	@GetMapping("/{id}")
	public Roles userById(@PathVariable int id) {
		return roleServiceImpl.findRolerById(id);
	}

	@PostMapping("/rolesassigned")
	public String Addroles(@RequestParam(value = "userId") int userId, @RequestParam(value = "roleId") int roleId) {
		roleServiceImpl.addroles(userId, roleId);
		return "Role Assined";

	}

	@PostMapping()
	public String addUser(@RequestBody Roles roles) {
		roleServiceImpl.addRole(roles);
		return "Roles Added";
	}

	@PutMapping("/{id}")
	public String updateUser(@PathVariable int id, @RequestBody Roles roles) {
		roleServiceImpl.updateRole(id, roles);
		return "roles Updated";
	}

	@DeleteMapping()
	public String deleteUser(@PathVariable int id) {
		roleServiceImpl.deleteRole(id);
		return "roles  Deleted";
	}
}
