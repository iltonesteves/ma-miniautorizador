package com.api.mauser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.mauser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
