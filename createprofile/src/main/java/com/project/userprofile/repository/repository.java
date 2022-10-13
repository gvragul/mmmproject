package com.project.userprofile.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.userprofile.controller.controller;
import com.project.userprofile.model.userprofile;
 
@Repository
public interface repository extends JpaRepository<userprofile, Long>{
	 
}
