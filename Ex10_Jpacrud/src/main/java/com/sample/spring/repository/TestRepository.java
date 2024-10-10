package com.sample.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.spring.entity.TestEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {

}
