package com.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.entity.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {

}
