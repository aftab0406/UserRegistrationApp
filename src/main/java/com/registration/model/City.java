package com.registration.model;

import java.io.Serializable;

import lombok.Data;
/**
 * This city class is used to map with form data
 * 
 * @author	Aftab Alam
 * @version	1.0
 * @since	Dec27-2019
 */

@Data
public class City implements Serializable {

	private Integer cityId;
	private String cityName;
	private Integer stateId;
}
