package com.jwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.entity.Users;

public interface UsersRepo extends JpaRepository<Users, Integer> {


	Users findByUsername(String username);

}
