package com.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.registration.entity.UserRegistrationEntity;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistrationEntity, Integer> {

	/**
	 * This method declaration is used to check valid credential. 
	 * @param email
	 * @param password
	 * @return
	 */
	@Query("SELECT u FROM UserRegistrationEntity u WHERE u.email= :email AND u.password= :password")
	public UserRegistrationEntity findByEmailAndPassword(@Param("email")String email,@Param("password")String password);
	
	@Query("SELECT u FROM UserRegistrationEntity u WHERE u.email= :email")
	public UserRegistrationEntity findByEmail(String email);
}
