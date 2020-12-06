package com.chsoft.monthlybalance.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chsoft.monthlybalance.entities.GroupUser;

public interface GroupUserRepository extends CrudRepository<GroupUser, Long> {

	@Override
	public List<GroupUser> findAll();
}
