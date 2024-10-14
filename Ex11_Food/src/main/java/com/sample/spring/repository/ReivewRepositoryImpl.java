package com.sample.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sample.spring.model.ReviewEntity;

@Repository
public class ReivewRepositoryImpl implements ReviewRepositoryCustom {
	
	@Autowired
	private JPAQueryFactory queryFactory;
	
	@Override
	public Slice<ReviewEntity> findSliceByFoodId(Long foodId, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
