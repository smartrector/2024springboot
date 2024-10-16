package com.sample.spring.repository;



import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sample.spring.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

	@EntityGraph(attributePaths = ("memberRoleList"))
	@Query("select m from Member m where m.email = :email")
	Member getWithRole(@Param("email") String email);
}
