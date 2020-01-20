package com.registration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * This country class is used to mapp with DB country master table 
 * 
 * @author	Aftab Alam
 * @version	1.0
 * @since	Dec27-2019
 */

@Entity
@Table(name = "COUNTRY_MASTER")
@Data
public class CountryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="COUNTRY_ID",length=5)
	private Integer countryId;
	
	@Column(name="COUNTRY_NAME",length=30)
	private String countryName;
}
