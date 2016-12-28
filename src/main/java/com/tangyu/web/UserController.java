package com.tangyu.web;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tangyu.model.User;
import com.tangyu.service.CodeService;
import com.tangyu.service.UserService;
import com.tangyu.utils.AjaxJson;
import com.tangyu.utils.DateUtils;
import com.tangyu.utils.SecurityUtils;

@Controller
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private CodeService codeService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {

		return "/user/index";
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String newPage() {
		return "/adminLte/register";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveNew(User user,  HttpSession session) {
		String key="",code="";
		AjaxJson json = new AjaxJson();
		if (codeService.authCode("test", key, code) != 0) {
			json.setMsg("验证码错误，请重试！");
			json.setSuccess(false);
			return json;
		}
		if (user != null && StringUtils.isNotBlank(user.getEmail()) && StringUtils.isNotBlank(user.getEmail())
				&& StringUtils.isNotBlank(user.getEmail())) {
			final Date creDate = DateUtils.getCurrentDate();
			user.setPassword(SecurityUtils.getMD5(user.getPassword()));
			user.setCreatedAt(creDate);
			user.setUpdatedAt(creDate);
			user.setStatus(1);
			userService.insert(user);
			if (user.getId() == null) {
				json.setSuccess(false);
				json.setMsg("注册失败！");
			}else{
				session.setAttribute("currentUser", user);
			}
		} else {
			json.setSuccess(false);
			json.setMsg("注册失败！参数错误！！");
		}
		return json;
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.POST)
	public String show(@PathVariable Long userId, Model model) {
		User user = userService.queryById(userId);
		model.addAttribute("user", user);
		return "/user/show";
	}
}
