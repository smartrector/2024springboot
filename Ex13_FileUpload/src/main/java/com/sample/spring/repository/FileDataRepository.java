package com.sample.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.spring.domain.FileEntity;

public interface FileDataRepository extends JpaRepository<FileEntity, Long> {

}
