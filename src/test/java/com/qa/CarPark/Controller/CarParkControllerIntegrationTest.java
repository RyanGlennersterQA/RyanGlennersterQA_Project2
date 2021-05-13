package com.qa.CarPark.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.CarPark.Domain.CarPark;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema.sql", "classpath:data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class CarParkControllerIntegrationTest {
	
	@Autowired
	private MockMvc MockMvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		CarPark car = new CarPark ("Mercedes", "GLA", "2021-05-11", "2021-05-12");
		
		String carAsJSON = this.mapper.writeValueAsString(car);
		
		RequestBuilder mockRequest = post("/create").contentType(MediaType.APPLICATION_JSON).content(carAsJSON);
		
		CarPark savedCar = new CarPark(2L, "Mercedes", "GLA", "2021-05-11", "2021-05-12");
		
		String savedCarAsJSON = this.mapper.writeValueAsString(savedCar);
		
		ResultMatcher matchStatus = status().isCreated();
		
		ResultMatcher matchBody = content().json(savedCarAsJSON);
		
		this.MockMvc.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
		
	}
	
	@Test
	void testGetAll() throws Exception {
		CarPark savedCar = new CarPark(1L, "Mercedes", "GLA", "2021-05-11", "2021-05-12");
		
		List<CarPark> cars = List.of(savedCar);
		RequestBuilder mockRequest = get("/getAll");
		
		
		String savedCarAsJSON = this.mapper.writeValueAsString(cars);
		
		ResultMatcher matchBody = content().json(savedCarAsJSON);
		ResultMatcher matchStatus = status().isOk();
		this.MockMvc.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
		
	}
	
	@Test
	void testRemove() throws Exception {
		RequestBuilder mockRequest = delete("/remove/1");
		
		ResultMatcher matchBody = content().string("true");
		ResultMatcher matchStatus = status().isOk();
		
		this.MockMvc.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
		//status & content.
	}
	
	@Test
	void testUpdate() throws Exception {
		
		CarPark update = new CarPark("Mercedes", "GLC", "2021-05-13", "2021-05-14");
		String updateAsJSON = this.mapper.writeValueAsString(update);
		
		RequestBuilder mockRequest = put("/update/1").contentType(MediaType.APPLICATION_JSON).content(updateAsJSON);
		
		CarPark updatedCar = new CarPark(1L, "Mercedes", "GLC", "2021-05-13", "2021-05-14");
		String updatedCarAsJSON = this.mapper.writeValueAsString(updatedCar);
		
		ResultMatcher matchBody = content().json(updatedCarAsJSON);
		ResultMatcher matchStatus = status().isAccepted();
		
		this.MockMvc.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
		
		
		
	}
	
	
	

}
