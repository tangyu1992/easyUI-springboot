package com.tangyu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tangyu.service.UserService;

@Controller
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "";
	}
	@RequestMapping(value="new",method = RequestMethod.GET)
	public String newPage() {
		return "/user/new";
	}
}
