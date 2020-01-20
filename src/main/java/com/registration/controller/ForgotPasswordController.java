package com.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.registration.constant.AppConstant;
import com.registration.model.ForgotPassword;
import com.registration.service.UserRegistrationService;

/**
 * This controller class is used for handle all request which is coming from forgot password form page.
 * and help to send password on email 
 * @author	Aftab Alam
 * @version	1.0
 * @since	Jan1-2020
 */

@Controller
public class ForgotPasswordController {

	@Autowired
	private UserRegistrationService userRegService;

	/**
	 * This controller method is used to load forgot password form and bind login model class
	 * to forgot password form.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ForgotPassword")
	public String LoadUnlockRegistrationForm(Model model) {
		ForgotPassword forgotPwd = new ForgotPassword();
		model.addAttribute("forgotPwd", forgotPwd);
		return AppConstant.FORGOT_PASSWORD;
	}

	/**
	 * This controller method is used to handle Sign in request.
	 * 
	 * @param login
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "ForgotPasswordRequest", method = RequestMethod.POST)
	public String handelSubmitBtn(@ModelAttribute("forgotPwd")ForgotPassword forgotPwd, Model model)throws Exception {
		String forgotMsg = null;
		forgotMsg = userRegService.ForgotPwd(forgotPwd.getEmail());
		model.addAttribute("forgotMsg", forgotMsg);
		return AppConstant.FORGOT_PASSWORD;
	}
}
