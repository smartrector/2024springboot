package com.sample.spring.service;

import java.util.LinkedHashMap;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.sample.spring.domain.Member;
import com.sample.spring.domain.MemberRole;
import com.sample.spring.dto.MemberDto;
import com.sample.spring.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberServiceImpl implements MemberService{
	
	private final MemberRepository memberRepository;

	private final PasswordEncoder passwordEncoder;
	
	
	@Override
	public MemberDto getKakaoMember(String accessToken) {
		
		//accessToken을 이용해서 사용자 정보 가져오기
		String nickname = getEmailFromKakaoAccessToken(accessToken);
		
		Optional<Member> result = memberRepository.findById(nickname);
		
		
		if(result.isPresent()) {
			MemberDto memberDto = entityToDTO(result.get());
			
			log.info("existed.............."+memberDto);
			
			return memberDto;
			//return
		}
		
		Member socialMember = makeSocialMember(nickname);
		
		
		memberRepository.save(socialMember);
		MemberDto memberDto = entityToDTO(socialMember);
		
		return memberDto;
	}
	
	private Member makeSocialMember(String nickname) {
		String tempPassword = makeTempPassword();
		log.info("tempPassword: " + tempPassword);
		
		Member member = Member.builder()
				.email(nickname)
				.pw(passwordEncoder.encode(tempPassword))
				.nickname("Social Member")
				.social(true)
				.build();
		
		member.addRole(MemberRole.USER);
		return member;
				
	}

	private String getEmailFromKakaoAccessToken(String accessToken) {
		String kakaoGetUserURL = "https://kapi.kakao.com/v2/user/me";
		
		RestTemplate restTemplate = new RestTemplate();

	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Authorization", "Bearer " + accessToken);
	    headers.add("Content-Type","application/x-www-form-urlencoded");
	    HttpEntity<String> entity = new HttpEntity<>(headers);

	    UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(kakaoGetUserURL).build();

	    ResponseEntity<LinkedHashMap> response = 
	      restTemplate.exchange(
	      uriBuilder.toString(), 
	      HttpMethod.GET, 
	      entity, 
	      LinkedHashMap.class);

	    
	    log.info("response------------------------------------");
	    log.info(response);
	    
	    LinkedHashMap<String, LinkedHashMap> bodyMap = response.getBody();
	    
	    //LinkedHashMap<String,String> kakaoAccount = bodyMap.get("kakao_account"); // email관련
	    LinkedHashMap<String,String> kakaoAccount = bodyMap.get("properties"); 

//	    log.info(bodyMap);
	    log.info("kakoAccount: " + kakaoAccount);
	    
	    String nickname = kakaoAccount.get("nickname");
	    
	    log.info("nickname: " + nickname);
	    //return kakaoAccount.get("email");
	    return nickname;
	}
	
	private String makeTempPassword() {

	    StringBuffer buffer = new StringBuffer();

	    for(int i = 0;  i < 10; i++){
	      buffer.append(  (char) ( (int)(Math.random()*55) + 65  ));
	    }
	    return buffer.toString();
	  }



}