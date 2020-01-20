package com.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Integer> {

}
