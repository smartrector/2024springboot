package com.sample.spring.security.filter;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.filter.OncePerRequestFilter;

import com.sample.spring.dto.MemberDto;
import com.sample.spring.util.JWTUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JWTCheckFilter extends OncePerRequestFilter {

	
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String path = request.getRequestURI();
		log.info("###############// check url :" + path);
		
		
		if(path.startsWith("/api/member/")) {
			return true;
		}
		
//		if(path.startsWith("/test")) {
//			return true;
//		}
		
		return false;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
			
			log.info("###############dododoFilter#####################");
			log.info("###############dododoFilter#####################");
			log.info("###############dododoFilter#####################");
			
			
			String authHeaderStr = request.getHeader("Authorization");
			
			String accessToken = authHeaderStr.substring(7);
			
			Map<String, Object> claims =  JWTUtil.validateToken(accessToken);
			
			MemberDto memberDto = new MemberDto(email,pw,nickname,social.booleanValue(),roleNames);
			
			log.info(memberDto);
			
			
	}

}
