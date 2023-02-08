package com.roles.permission.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roles.permission.entity.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);

}