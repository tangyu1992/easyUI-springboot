package com.tangyu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tangyu.model.User;
import com.tangyu.service.UserService;

@Controller
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		
		return "/user/index";
	}

	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String newPage() {
		return "/user/new";
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String saveNew() {
		return "redirect:/users";
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.POST)
	public String show(@PathVariable Long userId, Model model) {
		User user = userService.queryById(userId);
		model.addAttribute("user", user);
		return "/user/show";
	}
}
