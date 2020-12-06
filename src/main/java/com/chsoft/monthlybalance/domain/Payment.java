package com.chsoft.monthlybalance.domain;

public class Payment {
	private long id;
	private String place;
	private double value;
	
	public Payment() {
		
	}
	
	public Payment(int id, String place, double value) {
		super();
		this.id = id;
		this.place = place;
		this.value = value;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}	
}
