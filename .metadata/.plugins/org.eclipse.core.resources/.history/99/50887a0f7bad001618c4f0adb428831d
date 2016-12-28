package com.tangyu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tangyu.model.User;
import com.tangyu.service.UserService;
import com.tangyu.utils.AjaxJson;

@Controller
public class SecurityController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "login")
	public String login() {
		return "adminLte/fixed";
	}

	@RequestMapping(value = "auth")
	public AjaxJson auth(User user) {
		AjaxJson json = new AjaxJson();
		return json;
	}
}
