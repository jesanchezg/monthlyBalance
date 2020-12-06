package com.chsoft.monthlybalance.dao;


import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.chsoft.monthlybalance.entities.GroupUser;
import com.chsoft.monthlybalance.entities.Payment;
import com.chsoft.monthlybalance.entities.Utilisateur;

//@ContextConfiguration(classes=MonthlyBalanceApplication.class)  //H2 Syntax
//@DataJpaTest //H2 Syntax
@SpringBootTest
@RunWith(SpringRunner.class)
//@SqlGroup({
//	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts= {"classpath:schema.sql", "classpath:data.sql"}), 
//	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts= "classpath:drop.sql")
//}) //With @SpringBootTest you don't need @SqlGroup. But data.sql is not loading.
public class MonthlyBalanceIntegrationTest {

	@Autowired
	GroupUserRepository groupUserRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PaymentRepository paymRepo;
	
	@Test
	public void ifNewGroupUserSaved_thenSuccess() {
		GroupUser groupUser = new GroupUser("new Groupsssss");
		groupUserRepo.save(groupUser);
		List<GroupUser> lstGrUsr = groupUserRepo.findAll();
		System.out.println("lstGrUsr.get(0).getName()=> "+lstGrUsr.get(0).getName());
		assertEquals(1,groupUserRepo.findAll().size());
		
		Utilisateur user = new Utilisateur("New guy!", 55, false, "male", "guy@guy.com");
		user = userRepo.save(user);
		System.out.println("user.getUtilisateurId()=> " + user.getUtilisateurId());
		List<Utilisateur> lstUser = userRepo.findAll();
		assertEquals(1,userRepo.findAll().size());
		
		Payment paymnt = new Payment("Centrales", 150, new Date());
		paymnt = paymRepo.save(paymnt);
		paymnt.setPayer(user);
		paymRepo.save(paymnt);
		assertEquals(1,paymRepo.findAll().size());
	}
	
//	@Test
//	public void ifNewUtilisateurSaved_ThenSuccess() {
//		Utilisateur user = new Utilisateur("New guy!", 55, false, "male", "guy@guy.com");
//		userRepo.save(user);
//		List<Utilisateur> lstUser = userRepo.findAll();
//		assertEquals(4,userRepo.findAll().size());
//	}
}
