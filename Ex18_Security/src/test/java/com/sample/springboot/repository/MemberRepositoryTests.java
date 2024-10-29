package com.sample.springboot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sample.springboot.domain.Member;
import com.sample.springboot.domain.MemberRole;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManagerBuilder authenticationManagerBuilder;
	
//	@Test
//	public void testInsertMember() {
//		
//		for(int i=0;i<10;i++) {
//		Member member = Member.builder()
//				.email("user" + i + "@aaa.com")
//				.pw(passwordEncoder.encode("1111"))
//				.nickname("user" + i)
//				.build();
//		
//		member.addRole(MemberRole.USER);
//		if(i>5) {
//			member.addRole(MemberRole.MEMEBER);
//		}
//		if(i>8) {
//			member.addRole(MemberRole.ADMIN);
//		}
//		memberRepository.save(member);
//		}
//		
//	}
	@Test
	public void testRead() {
		String email = "user9@aaa.com";
		Member member = memberRepository.getWithRole(email);
		
		log.info("#########################");
		log.info(member);
		log.info(member.getMemberRoleList());
	}
	
	
	
	
}
