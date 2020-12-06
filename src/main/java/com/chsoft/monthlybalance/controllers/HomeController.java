package com.chsoft.monthlybalance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chsoft.monthlybalance.dao.PaymentRepository;
import com.chsoft.monthlybalance.dao.UserRepository;
import com.chsoft.monthlybalance.dto.UserSumByGroup;
import com.chsoft.monthlybalance.entities.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {

	@Value("${version}")
	private String ver;
	
	@Autowired
	PaymentRepository paymRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		model.addAttribute("versionNumber", ver);
		
		List<Payment> lstPaymt = paymRepo.findAll();
		model.addAttribute("payments", lstPaymt);
		
		//Get Number of payments by User
//		List<UserPayment> usersPaymentsCount = userRepo.userPayments();
//		model.addAttribute("userListPaymentCount", usersPaymentsCount);
//		ObjectMapper objectMapper = new ObjectMapper();
//		String jsonUsrGrpLstSumPymt = objectMapper.writeValueAsString(usersPaymentsCount);
		
		//Get Sum of payments by User per month
		List<UserSumByGroup> usersGroupSumPaymnt = userRepo.userGroupSumPaymt();
		model.addAttribute("userGroupListSumPaymt", usersGroupSumPaymnt);
		if(usersGroupSumPaymnt != null && usersGroupSumPaymnt.size()>0)
			System.out.println("usersGroupSumPaymnt=> "+usersGroupSumPaymnt.get(0).getSumOfValues());
		//Lets convert usersGroupPaymntSum object into a json structure for use in javascript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonUsrGrpLstSumPymt = objectMapper.writeValueAsString(usersGroupSumPaymnt);
		System.out.println("jsonUsrGrpLstSumPymt=> "+jsonUsrGrpLstSumPymt);
		model.addAttribute("userPymtSumToChart", jsonUsrGrpLstSumPymt);
		
		return "main/home";
	}
}
