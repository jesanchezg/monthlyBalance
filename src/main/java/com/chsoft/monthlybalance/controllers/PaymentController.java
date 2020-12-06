package com.chsoft.monthlybalance.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chsoft.monthlybalance.dao.PaymentRepository;
import com.chsoft.monthlybalance.entities.Payment;

@Controller
@RequestMapping("/payments")
public class PaymentController {

	//Field injection
	@Autowired
	PaymentRepository paymentRepo;
	
	//Setter Injection
//	PaymentRepository paymentRepo;
//	
//	@Autowired
//	public void setPaymentRepo(PaymentRepository paymentRepo) {
//		this.paymentRepo = paymentRepo;
//	}
	
//	//Constructor injection
//	PaymentController(PaymentRepository paymentRepo){
//		this.paymentRepo = paymentRepo;
//	}
	
	@GetMapping("/new")
	public String displayPaymentForm(Model model) {
		Payment aPayment = new Payment();
		model.addAttribute("payment",aPayment);
		return "payments/new-payment";
	}

	@PostMapping("/save")
	public String createPayment(Payment payment, Model model) {
		System.out.println("payment.getDate()=> "+payment.getDate());
		System.out.println("payment.getPlace()=> "+payment.getPlace());
		if(payment.getDate() == null) {
			payment.setDate(new Date());
		}
		// this method should handle saving to the database
		if(paymentRepo.save(payment) != null) {
			System.out.println("Payment saved");
		}
		//use to prevent duplicate submissions.
		return "redirect:/payments/new";
	}
	
	@GetMapping
	public String getLstPayment(Model model) {
		List<Payment> lstPayments = paymentRepo.findAll();
		model.addAttribute("payments", lstPayments);
		return "payments/list-payments";
	}
}
