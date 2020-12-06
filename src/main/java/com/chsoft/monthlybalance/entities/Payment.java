package com.chsoft.monthlybalance.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="payment_generator")
	@SequenceGenerator(name = "payment_generator",sequenceName = "payment_seq", allocationSize = 1)
	private long paymentId;
	private String place;
	private double value;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur payer;
	
	public Payment() {
	}
	
	public Payment(String place, double value, Date date) {
		super();
		this.place = place;
		this.value = value;
		this.date= date;
	}
	
	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Utilisateur getPayer() {
		return payer;
	}
	public void setPayer(Utilisateur payer) {
		this.payer = payer;
	}
}
