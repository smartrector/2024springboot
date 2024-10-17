package com.sample.spring.security;




import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sample.spring.domain.Member;
import com.sample.spring.dto.MemberDto;
import com.sample.spring.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService{

	private final MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("---------------------------load user username ---------------------------" + username);
		
		Member member = memberRepository.getWithRole(username);
		
		if(member == null) {
			throw new UsernameNotFoundException("not found");
		}
		
		MemberDto memberDto = new MemberDto(
				member.getEmail(),
				member.getPw(),
				member.getNickname(),
				member.isSocial(),
				member.getMemberRoleList()
					.stream().map(memberRole -> memberRole.name())
					.collect(Collectors.toList()));

		
		log.info(memberDto);
		
		
		return memberDto;
	}

}
