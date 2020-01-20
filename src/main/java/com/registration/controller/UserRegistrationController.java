package com.registration.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.registration.constant.AppConstant;
import com.registration.model.UserRegistration;
import com.registration.service.UserRegistrationService;

/**
 * This controller class is used to register new user.
 * 
 * @author	Aftab Alam
 * @version	1.0
 * @since	Dec27-2019
 */

@Controller
public class UserRegistrationController {

	@Autowired
	private UserRegistrationService userRegService;
	
	/**
	 * this controller method is used to load user registration form.
	 * @param model
	 * @return (LVN: UserRegistration form)
	 */
	@RequestMapping("/UserRegistration")
	public String displayUserRegistrationForm(Model model) {
		UserRegistration userRegistration = new UserRegistration();
		model.addAttribute("userRegistration", userRegistration);
		
		return AppConstant.USER_REGISTRATION_FORM;
	}
	
	/**
	 * This controller method is used for handle/process user registration operation.
	 * @param userReg
	 * @param redAttrib
	 * @return
	 */
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	public String saveUserDetails(UserRegistration userReg, RedirectAttributes redAttrib) {
		boolean regFlag = false;
		regFlag = userRegService.insertUserDetails(userReg);
		if(regFlag)
			redAttrib.addFlashAttribute("successMsg", AppConstant.USER_REGISTRATION_SUCCESS_MSG);
			//redAttrib.addAttribute("successMsg", AppConstant.USER_REGISTRATION_SUCCESS_MSG);
		else
			redAttrib.addFlashAttribute("failureMsg", AppConstant.USER_REGISTRATION_FAILURE_MSG);
			//redAttrib.addAttribute("failureMsg", AppConstant.USER_REGISTRATION_FAILURE_MSG);
			
		return AppConstant.USER_REGISTRATION_REDIARECT;
	}
	
	/**
	 * This controller method is used for solve double posting problem on user registration.
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/dpSolution", method = RequestMethod.GET)
	public String doublePostingSolution(Model model) {
		UserRegistration userRegistration = new UserRegistration();
		model.addAttribute("userRegistration", userRegistration);
		
		return AppConstant.USER_REGISTRATION_FORM;
	}
	
	/**
	 * --
	 * @param req
	 * @return
	 */
	
	@GetMapping("/findDupEmail")
	public @ResponseBody String validateDuplicateEmail(HttpServletRequest req) {
		String email=req.getParameter("email");
		boolean flag=userRegService.validateEmail(email);
		if(flag)
			return "Unique";
		return "Duplicate";
	}
}
