package com.chsoft.monthlybalance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chsoft.monthlybalance.dao.UserRepository;

@Service
public class UserService {

	//field injection
	@Autowired
	UserRepository userRepo;
	
	//Constructor injection
//	UserRepository userRepo;
//	
//	UserService(UserRepository userRepo){
//		super();
//		this.userRepo = userRepo;
//	}
	
	//Setter injection
//	UserRepository userRepo;
//
//	@Autowired
//	public void setUserRepo(UserRepository userRepo) {
//		this.userRepo = userRepo;
//	}
}
