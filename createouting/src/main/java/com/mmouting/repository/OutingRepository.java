package com.mmouting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mmouting.bean.outing;

@Repository

public interface OutingRepository extends JpaRepository<outing,Long> {
	
	

}
