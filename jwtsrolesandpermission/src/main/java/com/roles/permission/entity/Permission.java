package com.roles.permission.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String permissionName;
	
	@ManyToMany(mappedBy = "permission")
	private List<Roles> roles;
	

	public Permission(int id, String permissionname) {
		super();
		this.id = id;
		this.permissionName = permissionname;
	}

	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionname(String permissionname) {
		this.permissionName = permissionname;
	}

}
