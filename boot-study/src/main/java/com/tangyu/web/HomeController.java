package com.tangyu.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tangyu.model.User;
import com.tangyu.service.CodeService;
import com.tangyu.utils.PageCode;

import com.tangyu.utils.HttpUtils;

@Controller
public class HomeController {
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CodeService codeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String portal() {
		return "portal/portal";
	}
	
	@RequestMapping(value = "/index")
	public String index(Model model, HttpServletRequest request) {
		final HttpSession session=request.getSession();
		final User currentUser=(User) session.getAttribute("currentUser");
		final String localIp = HttpUtils.getRequestIp(request);
		logger.info("get request from {}", localIp);
		model.addAttribute("ip", localIp);
		model.addAttribute("currentUser", currentUser);
		return "adminLte/index";
	}

	@RequestMapping(value = "/getCode", method = RequestMethod.GET)
	@ResponseBody
	public PageCode getImg() {
		return codeService.createSession("test");
	}
}
