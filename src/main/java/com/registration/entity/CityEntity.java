package com.registration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * This city class is used to map with DB city master table
 * 
 * @author	Aftab Alam
 * @version	1.0
 * @since	Dec27-2019
 */
@Entity
@Table(name = "CITY_MASTER")
@Data
public class CityEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CITY_ID",length=5)
	private Integer cityId;
	
	@Column(name="CITY_NAME",length=30)
	private String cityName;
	
	@Column(name="STATE_ID",length=5)
	private Integer stateId;
}
