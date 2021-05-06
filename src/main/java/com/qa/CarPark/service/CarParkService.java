package com.qa.CarPark.service;

import java.util.List;
import java.util.Optional;

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
	
	public CarPark getById(Long id) {
		Optional<CarPark> optionalCar = this.repo.findById(id);
		return optionalCar.get();
	}
	
	public boolean remove(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
	
	public CarPark update(Long id, CarPark newCar) {
		Optional<CarPark> car = this.repo.findById(id);
		CarPark existingCar = car.get();
		
		existingCar.setMake(newCar.getMake());
		existingCar.setModel(newCar.getModel());
		existingCar.setArrivalDate(newCar.getArrivalDate());
		existingCar.setLeavingDate(newCar.getLeavingDate());
		
		return this.repo.saveAndFlush(existingCar);
	}
	

}
