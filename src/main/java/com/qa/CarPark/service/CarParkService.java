package com.qa.CarPark.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.CarPark.Domain.CarPark;
import com.qa.CarPark.repo.CarParkRepo;

@Service
public class CarParkService {
	
	
	
	private CarParkRepo repo;
	
	public CarParkService(CarParkRepo repo) {
		this.repo = repo;
	}
	
	
	public CarPark create(CarPark car) {
		return this.repo.save(car);
	}
	
	public List<CarPark> getAll() {
		return this.repo.findAll();
	}
	
	
	public boolean remove(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
	public CarPark update(Long id, CarPark newCar) {
		CarPark car = this.repo.findById(id).orElseThrow();
		
		car.setMake(newCar.getMake());
		car.setModel(newCar.getModel());
		car.setArrivalDate(newCar.getArrivalDate());
		car.setLeavingDate(newCar.getLeavingDate());
		
		return this.repo.save(car);
	}
	

}
