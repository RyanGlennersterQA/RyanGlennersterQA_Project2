package com.qa.CarPark.Domain;


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
	private String arrivalDate;
	private String leavingDate;
	
		public CarPark() {}



	public CarPark(String make, String model, String arrivalDate, String leavingDate) {
		this.make = make;
		this.model = model;
		this.arrivalDate = arrivalDate;
		this.leavingDate = leavingDate;
	}


	public CarPark(long id, String make, String model, String arrivalDate, String leavingDate) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.arrivalDate = arrivalDate;
		this.leavingDate = leavingDate;
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


	public String getArrivalDate() {
		return arrivalDate;
	}


	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}


	public String getLeavingDate() {
		return leavingDate;
	}


	public void setLeavingDate(String leavingDate) {
		this.leavingDate = leavingDate;
	}


	@Override
	public String toString() {
		return "CarPark [id=" + id + ", make=" + make + ", model=" + model + ", arrivalDate=" + arrivalDate
				+ ", leavingDate=" + leavingDate + "]";
	}
	
	
	
	

}
