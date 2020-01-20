package com.registration.constant;

/**
 * This interface holds various string literals for various classes. 
 * @author	Aftab Alam
 * @version	1.0
 * @since	Jan2-2020
 */
public interface AppConstant {

	/**
	 * User Registration Controller constants
	 */
	public static final String USER_REGISTRATION_FORM = "UserRegistrationForm";
	public static final String USER_REGISTRATION_SUCCESS_MSG = "User Registration Saved Sucessfully.";
	public static final String USER_REGISTRATION_FAILURE_MSG = "User Registration Saved Sucessfully.";
	public static final String USER_REGISTRATION_REDIARECT = "redirect:/dpSolution";
	
	/**
	 * Unlock Registration Controller constants
	 */
	public static final String UNLOCK_ACCOUNT_FORM = "UnlockAccountForm";
	public static final String UNLOCK_ACCOUNT_SUCCESS_MSG = "Your Password has changed and account is unlocked.";
	public static final String UNLOCK_ACCOUNT_FAILURE_MSG = "Account Activation Problem!! Check Your Password.";
	
	/**
	 * Login Form Controller
	 */
	public static final String LOGIN_FORM = "LoginForm";
	public static final String LOGIN_FORM_FAILURE_MSG = "Login Failed";
	
	/**
	 * forgot password controller
	 */
	public static final String FORGOT_PASSWORD = "ForgotPasswordForm";
	
	/**
	 * Dash Board Form
	 */
	public static final String DASH_BOARD = "DashBoard";
	
	/**
	 * User Registration Service constants
	 */
	public static final String ALPH_NUMERIC_STRING_VALUE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	public static final String MAIL_SUBJECT = "Unlock Account";
	public static final String ACTIVE_STATE_LOCKED = "Locked";
	public static final String ACTIVE_STATE_UNLOCKED = "UnLocked";
	
	/**
	 * mail body constants
	 */
	public static final String REG_MAIL_BODY = "EmailBody.txt";
	public static final String FORGOT_MAIL_BODY = "ForgotEmailBody.txt";
}
