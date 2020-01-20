package com.registration.model;

import java.io.Serializable;

import lombok.Data;

/**
 * This class is used to map with  unlock account form data
 * 
 * @author	Aftab Alam
 * @version	1.0
 * @since	Dec27-2019
 */
@Data
public class UnlockAccount implements Serializable {

	private String email;
	private String Password;
	private String newPassword;
	private String confirmPassword;
}
