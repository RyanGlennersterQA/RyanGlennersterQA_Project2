package com.qa.CarPark.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.CarPark.Domain.CarPark;

@Repository
public interface CarParkRepo extends JpaRepository<CarPark, Long>{
	
	CarPark findByMake(String make);
	

}
