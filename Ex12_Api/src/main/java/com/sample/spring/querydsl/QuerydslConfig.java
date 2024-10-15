package com.sample.spring.querydsl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Configuration
public class QuerydslConfig {
	
	@Autowired
	private  EntityManager em;
	
	@Bean
	public JPAQueryFactory queryFactory() {
		return new JPAQueryFactory(em);
	}
}
