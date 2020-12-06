package com.chsoft.monthlybalance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chsoft.monthlybalance.dao.GroupUserRepository;
import com.chsoft.monthlybalance.entities.GroupUser;

@Controller
@RequestMapping("/groups")
public class GroupUserController {

	@Autowired
	GroupUserRepository groupUserRepo;
	
	@GetMapping("/new")
	public String displayGroupUser(Model model) {
		GroupUser groupUser = new GroupUser();
		model.addAttribute("groupUser", groupUser);
		return "groups/new-group_user";
	}
	
	@GetMapping
	public String getLstGroupUser(Model model) {
		List<GroupUser> lstGroupUser = groupUserRepo.findAll();
		model.addAttribute("lstGroupUser", lstGroupUser);
		return "groups/list-group_user";
	}
	
	@PostMapping("/save")
	public String saveGroupUser(GroupUser groupUser, Model model) {
		groupUserRepo.save(groupUser);
		return "redirect:/groups/new";
	}
}
