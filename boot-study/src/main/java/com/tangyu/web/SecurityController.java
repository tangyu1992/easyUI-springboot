package com.tangyu.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tangyu.model.User;
import com.tangyu.service.CodeService;
import com.tangyu.service.UserService;
import com.tangyu.utils.AjaxJson;

@Controller
public class SecurityController {
	@Autowired
	private UserService userService;
	@Autowired
	private CodeService codeService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "login")
	public String login() {
		return "adminLte/login";
	}

	@RequestMapping(value = "auth")
	@ResponseBody
	public AjaxJson auth(User user, String key, String code, HttpSession session) {
		logger.info("user:{}", user);
		final AjaxJson json = new AjaxJson();
		logger.info("code:{},key:{}", code, key);
		if (codeService.authCode("test", key, code) != 0) {

			json.setMsg("验证码错误，请重试！");
			json.setSuccess(false);
			return json;
		}
		final User loginUser = userService.login(user);
		if (loginUser == null) {
			json.setMsg("账号或密码错误，请重试！");
			json.setSuccess(false);
		} else if (loginUser.getStatus() == 0) {
			json.setMsg("账号已注销！");
			json.setSuccess(false);
		} else {
			session.setAttribute("currentUser", loginUser);
		}
		return json;
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
