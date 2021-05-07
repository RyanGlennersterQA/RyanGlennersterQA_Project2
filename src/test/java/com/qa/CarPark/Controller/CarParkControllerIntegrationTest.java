package com.qa.CarPark.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.CarPark.Domain.CarPark;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CarParkControllerIntegrationTest {
	
	@Autowired
	private MockMvc MockMvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		CarPark car = new CarPark ("Mercedes", "GLA", 05/06/2021, 05/07/2021);
		
		String carAsJSON = this.mapper.writeValueAsString(car);
		
		RequestBuilder mockRequest = post("/create").contentType(MediaType.APPLICATION_JSON).content(carAsJSON);
		
		CarPark savedCar = new CarPark(1L, "Mercedes", "GLA", 05/06/2021, 05/07/2021);
		
		String savedCarAsJSON = this.mapper.writeValueAsString(savedCar);
		
		ResultMatcher matchStatus = status().isCreated();
		
		ResultMatcher matchBody = content().json(savedCarAsJSON);
		
		this.MockMvc.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
		
		
	}
	

}
