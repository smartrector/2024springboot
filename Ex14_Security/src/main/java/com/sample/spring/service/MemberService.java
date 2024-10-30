package com.sample.spring.service;



import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import com.sample.spring.domain.Member;
import com.sample.spring.dto.MemberDto;



@Transactional
public interface MemberService {
	MemberDto getKakaoMember(String accessToken);
	
	default MemberDto entityToDTO(Member member) {

		MemberDto dto = new MemberDto(
	      member.getEmail(), 
	      member.getPw(), 
	      member.getNickname(), 
	      member.isSocial(), 
	      member.getMemberRoleList().stream().map(memberRole -> memberRole.name()).collect(Collectors.toList()));

	    return dto;
	  }
}
