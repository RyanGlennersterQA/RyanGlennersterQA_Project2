package com.qa.CarPark.Controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.CarPark.Domain.CarPark;
import com.qa.CarPark.service.CarParkService;

@RestController
@CrossOrigin
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
	

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Boolean> removeCar(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.remove(id));
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CarPark> updateCar(@PathVariable Long id, @RequestBody CarPark newCar) {
		return new ResponseEntity<CarPark>(this.service.update(id, newCar), HttpStatus.ACCEPTED);
	}
		

}
