package com.roles.permission.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roles.permission.entity.Roles;

@Repository
public interface RolesRepo extends JpaRepository<Roles,Integer> {

}
