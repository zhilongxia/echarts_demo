package com.zjjf.analysis.controller.login;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/analysis/authority")
public class AuthorityController {

	private final static String LOGIN_URL = "/login/index";

	private final static String MAIN_URL = "/main";

	@RequestMapping(value = "/scmsLoginPage.do")
	public String gotoLoginPage(HttpServletRequest request) throws IOException {

		return LOGIN_URL;
	}

	@RequestMapping(value = "/scmsMainPage.do")
	public String index(HttpServletRequest request, Model model) {

		HashMap<String, Object> logInVoMap = new HashMap<String, Object>();

		logInVoMap.put("userId", "test");
		logInVoMap.put("userName", "test");
		logInVoMap.put("userNickName", "111111");
		model.addAttribute("logInVo", logInVoMap);
		return MAIN_URL;
	}

	@RequestMapping(value = "/toMainPage.do", method = RequestMethod.GET)
	public String toMain() {
		try {
			return "index/index";
		} catch (Exception e) {
			// TODO ¥ÌŒÛ“≥
			return "";

		}
	}

}
