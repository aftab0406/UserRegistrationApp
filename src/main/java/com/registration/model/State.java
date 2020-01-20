package com.registration.model;

import java.io.Serializable;

import lombok.Data;

/**
 * This state class is used to mapp with form data
 * @author	Aftab Alam
 * @version	1.0
 * @since	Dec27-2019
 */
@Data
public class State implements Serializable {

	private Integer stateId;
	private String stateName;
	private Integer countryId;
}
