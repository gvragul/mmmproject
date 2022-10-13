package com.mmsports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mmsports.bean.sports;



@Repository

public interface SportsRepository extends JpaRepository<sports,Long> {
	
	

}
