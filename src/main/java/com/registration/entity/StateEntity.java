package com.registration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * This state class is used to mapp with DB state master table
 * @author	Aftab Alam
 * @version	1.0
 * @since	Dec27-2019
 */

@Entity
@Table(name = "STATE_MASTER")
@Data
public class StateEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="STATE_ID",length=5)
	private Integer stateId;
	
	@Column(name="STATE_NAME",length=30)
	private String stateName;
	
	@Column(name="COUNTRY_ID",length=5)
	private Integer countryId;
}
