package com.chsoft.monthlybalance.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class GroupUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="group_user_generator")
	@SequenceGenerator(name = "group_user_generator",sequenceName = "group_user_seq", allocationSize = 1)
	public long groupUserId;
	public String name;
	
	@OneToMany(mappedBy = "groupUsersId")
	private List<Utilisateur> utilisateurs;
	
	public GroupUser() {
	}
	
	public GroupUser(String name) {
		super();
		this.name = name;
	}

	public long getGroupUsersId() {
		return groupUserId;
	}

	public void setGroupUsersId(long groupUsersId) {
		this.groupUserId = groupUsersId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Utilisateur> getUsers() {
		return utilisateurs;
	}

	public void setUsers(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

}
