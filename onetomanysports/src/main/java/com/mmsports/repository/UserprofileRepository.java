package com.mmsports.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mmsports.bean.Userprofile;




@Repository
public interface UserprofileRepository extends JpaRepository<Userprofile, Long>{

	List<Userprofile> findBySportsId(Long sportsId);
	

	
	



	
 

}