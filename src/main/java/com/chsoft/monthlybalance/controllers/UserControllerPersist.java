package com.chsoft.monthlybalance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chsoft.monthlybalance.dao.PaymentRepository;
import com.chsoft.monthlybalance.dao.UserRepository;
import com.chsoft.monthlybalance.entities.Payment;
import com.chsoft.monthlybalance.entities.Utilisateur;

@Controller
@RequestMapping("/users")
public class UserControllerPersist {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PaymentRepository paymRepo;
	
	@GetMapping("/new")
	public String displayUser(Model model) {
		Utilisateur utilisateur = new Utilisateur();
		List<Payment> lstPaym = paymRepo.findAll();
		model.addAttribute("user", utilisateur);
		model.addAttribute("allPayments",lstPaym);
		return "users/new-user";
	}
	
	@PostMapping("/save")
	public String saveUser(Utilisateur utilisateur, @RequestParam List<Long> payments, Model model) {
		userRepo.save(utilisateur);
		Iterable<Payment> chosenPayments = paymRepo.findAllById(payments);
		
		for(Payment payment : chosenPayments) {
			payment.setPayer(utilisateur);
			paymRepo.save(payment);
		}
		
		return "redirect:/users/new";
	}
	
	@GetMapping
	public String getLstUsers(Model model) {
		List<Utilisateur> lstUsers = userRepo.findAll();
		model.addAttribute("users", lstUsers);
		return "users/list-users";
	}
}
