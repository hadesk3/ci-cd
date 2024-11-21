package com.tutorial.employeemanagmentbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.employeemanagmentbackend.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	Boolean existsByEmail(String email);	
}
