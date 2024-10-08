package com.sample.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.spring.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	//crud자동생성
}
