package com.tangyu.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tangyu.utils.HttpUtils;

@Controller
public class HomeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String test(Model model, HttpServletRequest request) {
		String localIp = HttpUtils.getRequestIp(request);
		logger.info("get request from {}", localIp);
		model.addAttribute("ip", localIp);
		return "index";
	}
}
