package com.chsoft.monthlybalance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.chsoft.monthlybalance.dto.UserPayment;
import com.chsoft.monthlybalance.dto.UserSumByGroup;
import com.chsoft.monthlybalance.entities.Utilisateur;

public interface UserRepository extends CrudRepository<Utilisateur, Long>{
	
	@Override
	public List<Utilisateur> findAll();
	
	//get quantity of payment done by user 
	@Query(nativeQuery=true, value="SELECT usr.FULL_NAME as fullName, COUNT(pym.utilisateur_id) as paymentCount " + 
			"FROM UTILISATEUR usr left join payment pym ON usr.utilisateur_id = pym.utilisateur_id " + 
			"GROUP BY usr.FULL_NAME ORDER BY 2 DESC")
	public List<UserPayment> userPayments();
	
	//get sum of values of each user in a group by month and year
	@Query(nativeQuery=true, value="SELECT usr.FULL_NAME as fullName, SUM(VALUE) as sumOfValues " + 
			"FROM PAYMENT pym " + 
			"left join UTILISATEUR usr ON usr.utilisateur_id = pym.utilisateur_id " + 
			" WHERE " + 
			"MONTH(pym.date) = MONTH(CURRENT_DATE) " + 
			"AND YEAR(pym.date) = YEAR(CURRENT_DATE) " + 
//			"AND pym.utilisateur_id IN (1,5) " +//For local
			"AND pym.utilisateur_id IN (1,2) " +//For AWS
			"AND usr.group_users_id = 1" +//TODO add group parameter in session by spring security.
			//For test porposes
//			"AND pym.utilisateur_id IN (select utilisateur_id from utilisateur where full_name = 'New guy!') " +
			"GROUP BY pym.utilisateur_id, usr.FULL_NAME;")
	public List<UserSumByGroup> userGroupSumPaymt();
}
