package com.chsoft.monthlybalance.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chsoft.monthlybalance.domain.User;

@Controller
public class HomeControllerFirstReview {

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("formData", new User());
		return "index";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String processFormData(User user, RedirectAttributes attr) {
		//Insert data submited in the form to the database
		attr.addFlashAttribute("user",user);
		System.out.println(user.getAge());
		System.out.println(user.getFullName());
		return "redirect:/display";
	}
	
	@RequestMapping(value="/display", method=RequestMethod.GET)
	public String displayFormData(User user) {
		System.out.println(user.getAge());
		System.out.println(user.getFullName());
		return "result";
	}
}
