package com.mmsports.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mmsports.bean.Sports;
import com.mmsports.bean.Userprofile;



@Repository

public interface SportsRepository extends JpaRepository<Sports,Long> {


	
	

}
