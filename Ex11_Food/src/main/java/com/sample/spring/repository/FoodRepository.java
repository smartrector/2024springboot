package com.sample.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.spring.model.FoodEntity;

public interface FoodRepository extends JpaRepository<FoodEntity, Long> {

}
