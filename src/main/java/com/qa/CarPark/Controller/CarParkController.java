package com.qa.CarPark.Controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.CarPark.Domain.CarPark;
import com.qa.CarPark.service.CarParkService;

public class CarParkController {
	
	private CarParkService service;
	
	public CarParkController(CarParkService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<CarPark> createBooking(@RequestBody CarPark car) {
		return new ResponseEntity<CarPark>(this.service.create(car),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CarPark>> getCars() {
		return ResponseEntity.ok(this.service.getAll());
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<CarPark> getCharacterById(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.getById(id));
	}
	
	@DeleteMapping("/remove/{id}")
	public CarPark removeCar(@PathVariable Long id) {
		this.service.remove(id);
		return this.service.getById(id);
	}
	
	@GetMapping("/findByMake")
	public CarPark findByMake(@PathParam("make") String make) {
		for (CarPark car : this.service.getAll()) {
			System.out.println(car.getMake());
		}
		System.out.println(make);
		return null;
	}
	
	

}
