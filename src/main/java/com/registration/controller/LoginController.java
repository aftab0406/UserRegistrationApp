package com.registration.controller;
/**
 * This controller class is used for handle login form to perform login activity. 
 * @author	Aftab Alam
 * @version	1.0
 * @since	Jan2-2020
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.registration.constant.AppConstant;
import com.registration.model.Login;
import com.registration.service.UserRegistrationService;

/**
 * This controller class is used for handle all request which is coming from login form page.
 * to DB related operation. 
 * @author	Aftab Alam
 * @version	1.0
 * @since	Jan1-2020
 */
@Controller
public class LoginController {

	@Autowired
	private UserRegistrationService userRegService;
	
	/**
	 * This controller method is used to load login form and bind login model class to login form.
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/")
	public String LoadUnlockRegistrationForm(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return AppConstant.LOGIN_FORM;
	}
	
	/**
	 * This controller method is used to handle Sign in request.
	 * @param login
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/Signin", method= RequestMethod.POST)
	public String handelSignInRequest(Login login,Model model) {
		boolean loginFlag;
		loginFlag = userRegService.validateLogin(login);
		if(loginFlag) {
			return AppConstant.DASH_BOARD;
		}else {
			model.addAttribute("failureMsg",AppConstant.LOGIN_FORM_FAILURE_MSG);
			return AppConstant.LOGIN_FORM;
		}
	}
}
