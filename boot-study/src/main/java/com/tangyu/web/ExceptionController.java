package com.tangyu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/error")
public class ExceptionController {
	@RequestMapping(method = RequestMethod.GET)
	public String errot() {
		return "";
	}
}
