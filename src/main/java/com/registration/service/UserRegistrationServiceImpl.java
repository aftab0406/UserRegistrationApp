package com.registration.service;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.constant.AppConstant;
import com.registration.entity.UserRegistrationEntity;
import com.registration.model.Login;
import com.registration.model.UnlockAccount;
import com.registration.model.UserRegistration;
import com.registration.repository.UserRegistrationRepository;
import com.registration.utility.EmailUtils;

/**
 * This service class is implementation of service interface, gives support to controller class 
 * to DB related operation. 
 * @author	Aftab Alam
 * @version	1.0
 * @since	Jan2-2020
 */
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	private static final String ALPHA_NUMERIC_STRING = AppConstant.ALPH_NUMERIC_STRING_VALUE;

	@Autowired
	private UserRegistrationRepository userRegRepo;

	@Autowired
	private EmailUtils emailUtils;

	/**
	 * This service method is used to insert user registration details in DB Table.
	 * @param userRegistration
	 * @return boolean value
	 */
	@Override
	public boolean insertUserDetails(UserRegistration userReg) {
		boolean insertFlag = false;
		UserRegistrationEntity userRegEntity = new UserRegistrationEntity();
		BeanUtils.copyProperties(userReg, userRegEntity);
		userRegEntity.setPassword(tempPwd(8));
		userRegEntity.setActiveState(AppConstant.ACTIVE_STATE_LOCKED);
		userRegEntity = userRegRepo.save(userRegEntity);
		if (userRegEntity.getRegId() > 0) {
			try {
				useMailService(userRegEntity,AppConstant.REG_MAIL_BODY);
				insertFlag = true;
			} catch (Exception e) {
				insertFlag = false;
			}
		}
		return insertFlag;
	}

	/**
	 * This service method is used for mail service.
	 * @param userRegEntity
	 * @throws Exception
	 */
	@Override
	public void useMailService(UserRegistrationEntity userRegEntity,String body) throws Exception {
		String emailBody = readEmailFromTextFile(userRegEntity,body);
		emailUtils.sendMimeEmail(userRegEntity.getEmail(), AppConstant.MAIL_SUBJECT, emailBody);
	}

	/**
	 * This service method is used for read email body from text file.
	 * @param userRegEntity
	 * @return
	 * @throws Exception
	 */
	@Override
	public String readEmailFromTextFile(UserRegistrationEntity userRegEntity,String body) throws Exception {
		//String fileName = AppConstant.MAIL_BODY;
		StringBuilder sb = new StringBuilder();
		FileReader reader = new FileReader(body);
		BufferedReader br = new BufferedReader(reader);
		String line = br.readLine();
		while (line != null) {
			if (line.contains("${firstName} ${lastName}")) {
				line = line.replace("${firstName} ${lastName}", userRegEntity.getFirstName()+" "+userRegEntity.getLastName());
			} else if (line.contains("${tempPwd}")) {
				line = line.replace("${tempPwd}", userRegEntity.getPassword());
			} else if (line.contains("${email}")) {
				line = line.replace("${email}", userRegEntity.getEmail());
			}
			sb.append(line);
			line = br.readLine();
		}
		br.close();
		return String.valueOf(sb);
	}

	/**
	 * This service method is used for generate random alpha numeric password for user.
	 * @param count
	 * @return
	 */

	@Override
	public String tempPwd(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	/**
	 * This service method is used for validate password while password update.
	 * @param unlockAccount
	 * @return
	 */
	@Override
	public boolean updatePasswordValidation(UnlockAccount unlockAccount) {
		boolean unlockFlag = false;
		UserRegistrationEntity userRegEntity = new UserRegistrationEntity();
		BeanUtils.copyProperties(unlockAccount, userRegEntity);
		userRegEntity = userRegRepo.findByEmailAndPassword(userRegEntity.getEmail(), userRegEntity.getPassword());
		if(userRegEntity != null) {
			if(userRegEntity.getRegId()>0 && AppConstant.ACTIVE_STATE_LOCKED.equals(userRegEntity.getActiveState())) {
				userRegEntity.setPassword(unlockAccount.getNewPassword());
				userRegEntity.setActiveState(AppConstant.ACTIVE_STATE_UNLOCKED);
				unlockFlag = unlockAccount(userRegEntity);
				return unlockFlag;
			} else {
				return unlockFlag;
			}
		}else {
			return unlockFlag;
		}
	}
	
	/**
	 * This service method is used for unlock user account during password updation.
	 * @param userRegEntity
	 * @return
	 */
	@Override
	public boolean unlockAccount(UserRegistrationEntity userRegEntity) {
		boolean unlockFlag = false;
		UserRegistrationEntity entity = new UserRegistrationEntity();
		entity = userRegRepo.save(userRegEntity);
		if(entity.getRegId()>0) {
			unlockFlag = true;
		}
		return unlockFlag;
	}
	
	/**
	 * This method is user for validate password during login process.
	 * @param login
	 * @return
	 */
	@Override
	public boolean validateLogin(Login login) {
		boolean loginFlag = false;
		UserRegistrationEntity userRegEntity = new UserRegistrationEntity();
		userRegEntity = userRegRepo.findByEmailAndPassword(login.getEmail(), login.getPassword());
		if(userRegEntity != null) {
			if(userRegEntity.getRegId()>0 && AppConstant.ACTIVE_STATE_UNLOCKED.equals(userRegEntity.getActiveState())) {
				loginFlag = true;
				return loginFlag;
			}else {
				return loginFlag;
			}
		}else {
			return loginFlag;
		}
	}
	
	@Override
	public String ForgotPwd(String email)throws Exception {
		String forgotMsg = null;
		UserRegistrationEntity userRegEntity = new UserRegistrationEntity();
		userRegEntity = userRegRepo.findByEmail(email);
		if(userRegEntity !=null) {
			if(AppConstant.ACTIVE_STATE_UNLOCKED.equals(userRegEntity.getActiveState())) {
				useMailService(userRegEntity,AppConstant.FORGOT_MAIL_BODY);
				forgotMsg = "password sent to gmail";
			} else {
				forgotMsg = "Your Account is locked";
			}
		}else {
			forgotMsg = "Invalid Email!!! Try Another.";
		}
		return forgotMsg;
	}

	@Override
	public boolean validateEmail(String email) {
		UserRegistrationEntity entity = userRegRepo.findByEmail(email);
		if(entity==null)
			return true;
		return false;
	}
}
