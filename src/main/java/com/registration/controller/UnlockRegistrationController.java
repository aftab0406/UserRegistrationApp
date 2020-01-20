package com.registration.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.registration.constant.AppConstant;
import com.registration.model.UnlockAccount;
import com.registration.service.UserRegistrationService;

/**
 * This controller class is used for handle all request which is coming from unloack account page. 
 *
 * @author	Aftab Alam
 * @version	1.0
 * @since	Jan2-2020
 */
@Controller
public class UnlockRegistrationController {

	@Autowired
	private UserRegistrationService userRegService;
	
	/**
	 * This controller method is used for load change password and unlock account page.
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ChangePassword", method = RequestMethod.GET)
	public String LoadUnlockRegistrationForm(HttpServletRequest request, Model model) {
		UnlockAccount unlockAccount = new UnlockAccount();
		String email = request.getParameter("email");
		unlockAccount.setEmail(email);
		model.addAttribute("unlockAccount", unlockAccount);
		return AppConstant.UNLOCK_ACCOUNT_FORM;
	}
	
	/**
	 * This controller method is used for handle request and perform update account operation.
	 * @param unlockAccount
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/UpdatePassword", method= RequestMethod.POST)
	public String handelSignInRequest(UnlockAccount unlockAccount,Model model) {
		boolean unlockFlag;
		unlockFlag = userRegService.updatePasswordValidation(unlockAccount);
		if(unlockFlag) {
			model.addAttribute("successMsg", AppConstant.UNLOCK_ACCOUNT_SUCCESS_MSG);
			model.addAttribute("UnlockFlag", unlockFlag);
		}else {
			model.addAttribute("failureMsg", AppConstant.UNLOCK_ACCOUNT_FAILURE_MSG);
			model.addAttribute("UnlockFlag", unlockFlag);
		}
		return AppConstant.UNLOCK_ACCOUNT_FORM;
	}
}
