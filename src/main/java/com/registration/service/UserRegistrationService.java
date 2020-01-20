package com.registration.service;

import com.registration.entity.UserRegistrationEntity;
import com.registration.model.Login;
import com.registration.model.UnlockAccount;
import com.registration.model.UserRegistration;

/**
 * This interface provide various service method for user related operation. 
 * @author	Aftab Alam
 * @version	1.0
 * @since	Jan2-2020
 */
public interface UserRegistrationService {

	/**
	 * This service method is used to insert user registration details in DB Table.
	 * @param userRegistration
	 * @return boolean value
	 */
	public boolean insertUserDetails(UserRegistration userRegistration);
	
	/**
	 * This service method is used for mail service.
	 * @param userRegEntity
	 * @throws Exception
	 */
	public void useMailService(UserRegistrationEntity userRegEntity,String body)throws Exception;
	
	/**
	 * This service method is used for read email body from text file.
	 * @param userRegEntity
	 * @return
	 * @throws Exception
	 */
	public String readEmailFromTextFile(UserRegistrationEntity userRegEntity,String body)throws Exception;
	
	/**
	 * This service method is used for generate random alpha numeric password for user.
	 * @param count
	 * @return
	 */
	public String tempPwd(int count);
	
	/**
	 * This service method is used for validate password while password update.
	 * @param unlockAccount
	 * @return
	 */
	public boolean updatePasswordValidation(UnlockAccount unlockAccount);
	
	/**
	 * This service method is used for unlock user account during password updation.
	 * @param userRegEntity
	 * @return
	 */
	public boolean unlockAccount(UserRegistrationEntity userRegEntity);
	
	/**
	 * This method is user for validate password during login process.
	 * @param login
	 * @return
	 */
	public boolean validateLogin(Login login);
	
	
	public String ForgotPwd(String email) throws Exception;
	
	public boolean validateEmail(String email);
}
