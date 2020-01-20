package com.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.entity.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, Integer> {

}
