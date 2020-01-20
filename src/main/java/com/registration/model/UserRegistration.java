package com.registration.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * This class is used to mapping with form page.
 * 
 * @author	Aftab Alam
 * @version	1.0
 * @since	Dec27-2019
 */

@Data
public class UserRegistration implements Serializable {

	private String firstName;
	private String lastName;
	private String email;
	private Long phNo;
	private Date dob;
	private String gender;
	private String country;
	private String state;
	private String city;
	private String password;
	private String activeState;
	
}
