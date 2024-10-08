package com.sample.spring;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.spring.domain.Member;
import com.sample.spring.repository.MemberRepository;

@SpringBootTest
public class MemberTests {

	@Autowired
	private MemberRepository repo;
	
	@Test
	public void testinsert() {
		for(int i=1;i<=100;i++) {
			
			Member member = Member.builder()
					.name("test" + i)
					.email("han" + i + "@test.com")
					.createDate(LocalDate.now())
					.build();
			repo.save(member);
		}
	}
}
