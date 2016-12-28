package com.tangyu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tangyu.service.MailService;

@Controller
public class MailController {
	
	@Autowired
	private MailService mailService;

	@RequestMapping(value = "mail")
	@ResponseBody
	public String sensMail() {
		mailService.sengMail();
		return "发送成功！";
	}
}
