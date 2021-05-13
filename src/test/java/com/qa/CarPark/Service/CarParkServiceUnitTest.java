package com.qa.CarPark.Service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.CarPark.service.CarParkService;
import com.qa.CarPark.Domain.CarPark;
import com.qa.CarPark.repo.CarParkRepo;

@SpringBootTest
public class CarParkServiceUnitTest {

	@Autowired
	private CarParkService service;
	
	@MockBean
	private CarParkRepo repo;
	
	@Test
	void testCreate() {
		CarPark car = new CarPark("Mercedes", "GLA", "2021-05-11", "2021-05-12");
		CarPark savedCar = new CarPark(1L, "Mercedes", "GLA", "2021-05-11", "2021-05-12");
		
		Mockito.when(this.repo.save(car)).thenReturn(savedCar);
		
		assertThat(this.service.create(car)).isEqualTo(savedCar);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(car);
		
	}
	
	@Test
	void testGetAll() {
		List<CarPark> list = this.service.getAll();
		list.add(new CarPark(1L, "Mercedes", "GLA", "2021-05-11", "2021-05-12"));
		
		assertThat(list).size().isGreaterThan(0);
		
		Mockito.when(this.repo.findAll()).thenReturn(list);
		
		assertThat(this.service.getAll().isEmpty()).isFalse();
		
		Mockito.verify(this.repo, Mockito.atLeastOnce()).findAll();
}
	
	@Test
	void testUpdate() {
		CarPark car = new CarPark(1L, "Mercedes", "GLA", "2021-05-11", "2021-05-12");
		
		Mockito.when(this.repo.findById(car.getId())).thenReturn(Optional.of(car));
		Mockito.when(this.repo.save(car)).thenReturn(car);
		
		assertThat(this.service.update(car.getId(), car)).isEqualTo(car);
		
		Mockito.verify(this.repo, Mockito.atLeastOnce()).findById(car.getId());
		Mockito.verify(this.repo, Mockito.atLeastOnce()).save(car);
	}
	
	@Test
	void testDelete() {
		this.repo.deleteById(1L);
		assertThat(this.repo.existsById(1L)).isFalse();
	}
	
}
