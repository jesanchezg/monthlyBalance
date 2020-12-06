package com.chsoft.monthlybalance.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chsoft.monthlybalance.domain.Payment;

@RestController
@RequestMapping("/user")
public class UserController{
	
	@RequestMapping("/{userId}")
	public String getUser(@PathVariable int userId) {
		return "User: " + userId;
	}
	
	@RequestMapping("/{userId}/payments")
	public String getUserPayments(@PathVariable("userId") int userId, @RequestParam(value = "date", required = false) Date dateOrNull) {
		return "paymets fouds for user: " + userId + " on the date: " + dateOrNull;
	}
	
	@RequestMapping("/{userId}/overPayments")
	public List<String> getUserOverPayments(@PathVariable("userId") int userId, @RequestParam(value = "date", required = false) Date dateOrNull) {
		return Arrays.asList("Jan", "Feb", "Dec", "Oct");
	}
	
	@RequestMapping("/{userId}/duePayments_as_json")
	public List<Payment> getUserDuePaymentsJson(@PathVariable("userId") int userId, @RequestParam(value = "date", required = false) Date dateOrNull) {
		return Arrays.asList(new Payment(1, "Boucherie", 65.22),
				new Payment(2, "Walmart", 165.22),
				new Payment(3, "SuperC", 185.11));
	}
	
	@RequestMapping("/{userId}/duePayment_as_json")
	public Payment getUserDuePaymentJson(@PathVariable("userId") int userId, @RequestParam(value = "date", required = false) Date dateOrNull) {
		return new Payment(1, "Boucherie", 65.22);
	}
	
}