package com.mmouting.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mmouting.bean.Outing;


@Repository
public interface OutingRepository extends JpaRepository<Outing,Integer>{

	void deleteById(long id);

}