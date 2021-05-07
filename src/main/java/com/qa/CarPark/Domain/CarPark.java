package com.qa.CarPark.Domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarPark {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String make;
	private String model;
	private Date arrivalDate;
	private Date leavingDate;
	
	
	
	
	public CarPark(Long id, String make, String model, Date arrivalDate, Date leavingDate) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.arrivalDate = arrivalDate;
		this.leavingDate = leavingDate;
	}


	public CarPark(String make, String model, Date arrivalDate, Date leavingDate) {
		super();
		this.make = make;
		this.model = model;
		this.arrivalDate = arrivalDate;
		this.leavingDate = leavingDate;
	}
	
	public CarPark() {}


	public CarPark(String string, String string2, int i, int j) {
		// TODO Auto-generated constructor stub
	}


	public CarPark(long id2, String make2, String model2, int i, int j) {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public Date getArrivalDate() {
		return arrivalDate;
	}


	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}


	public Date getLeavingDate() {
		return leavingDate;
	}


	public void setLeavingDate(Date leavingDate) {
		this.leavingDate = leavingDate;
	}
	
	
	
	

}
