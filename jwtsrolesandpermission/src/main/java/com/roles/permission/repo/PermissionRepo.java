package com.roles.permission.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roles.permission.entity.Permission;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, Integer> {

}
