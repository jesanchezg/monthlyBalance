package com.chsoft.monthlybalance.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chsoft.monthlybalance.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
	
	@Override
	public List<Payment> findAll();
}
