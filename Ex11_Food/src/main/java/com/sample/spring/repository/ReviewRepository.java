package com.sample.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.spring.model.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

}
