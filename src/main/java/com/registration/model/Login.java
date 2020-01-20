package com.registration.model;

import java.io.Serializable;

import lombok.Data;

/**
 * This login class is used to map with login form data
 * 
 * @author	Aftab Alam
 * @version	1.0
 * @since	Dec27-2019
 */
@Data
public class Login implements Serializable {

	private String email;
	private String Password;
}
