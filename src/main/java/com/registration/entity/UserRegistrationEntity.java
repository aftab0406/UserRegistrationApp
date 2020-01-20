package com.registration.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * This entity class is used to map with DB table
 * for User Registration table.
 * 
 * @author	Aftab Alam
 * @version	1.0
 * @since	Dec27-2019
 */

@Entity
@Table(name = "USER_REGISTRATION")
@Data
public class UserRegistrationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="REG_ID",length=5)
	private Integer regId;
	
	@Column(name="FIRST_NAME",length=15)
	private String firstName;
	
	@Column(name="LAST_NAME",length=15)
	private String lastName;
	
	@Column(name="EMAIL",length=30)
	private String email;
	
	@Column(name="PH_NO",length=12)
	private Long phNo;
	
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="GENDER",length=7)
	private String gender;
	
	@Column(name="COUNTRY",length=20)
	private String country;
	
	@Column(name="STATE",length=20)
	private String state;
	
	@Column(name="CITY",length=20)
	private String city;
	
	@Column(name="PASSWORD",length=20)
	private String password;
	
	@Column(name="ACTIVE_STATE",length=9)
	private String activeState;
}
