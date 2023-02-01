package com.jwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.entity.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);

}
