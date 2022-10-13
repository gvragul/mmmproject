package com.spring.security.UserLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.UserLogin.model.Role;

 
 

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}