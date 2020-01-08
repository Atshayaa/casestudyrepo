package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/")
	public ModelAndView welcomePage() {
		return new ModelAndView("welcomePage");
	}

	@RequestMapping(value = { "/success" }, method = RequestMethod.GET)
	public ModelAndView SuccessPage(HttpServletRequest req) {
		return new ModelAndView("success");
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error_value,
			@RequestParam(value = "logout", required = false) String logout_value) {
		ModelAndView model = new ModelAndView();
		if (error_value != null) {
			model.addObject("error", "Invalid Credentials provided.");
			//model.setViewName("loginPage");
			return model;
		} else if (logout_value != null) {
			model.addObject("message", "Logged out successfully.");
			model.setViewName("loginPage");
			return model;
		} else if (logout_value == null && error_value == null) {
			return new ModelAndView("loginPage");
		}

		return new ModelAndView("success");
	}
}
