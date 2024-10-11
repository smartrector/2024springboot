package com.sample.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.spring.model.MenuEntity;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

}
