package com.chsoft.monthlybalance.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="utilisateur_generator")
	@SequenceGenerator(name = "utilisateur_generator",sequenceName = "utilisateur_seq", allocationSize = 1)
	private long utilisateurId;
	private String fullName;
	private int age;
	private boolean employed;
	private String gender;
	private String email;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinColumn(name = "group_users_id")
	private GroupUser groupUsersId;
	
	@OneToMany(mappedBy = "payer")
	private List<Payment> payments;
	
	public Utilisateur() {
		
	}
	
	public Utilisateur(String fullName, int age, boolean employed, String gender, String email) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.employed = employed;
		this.gender = gender;
		this.email = email;
	}
	
	public long getUtilisateurId() {
		return utilisateurId;
	}
	public void setUtilisateurId(long utilisateurId) {
		this.utilisateurId = utilisateurId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isEmployed() {
		return employed;
	}
	public void setEmployed(boolean employed) {
		this.employed = employed;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public GroupUser getGroupUsersId() {
		return groupUsersId;
	}

	public void setGroupUsersId(GroupUser groupUsersId) {
		this.groupUsersId = groupUsersId;
	}
}
