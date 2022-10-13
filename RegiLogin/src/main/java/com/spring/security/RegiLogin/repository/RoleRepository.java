package com.spring.security.RegiLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.RegiLogin.model.Role;

 
 

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}