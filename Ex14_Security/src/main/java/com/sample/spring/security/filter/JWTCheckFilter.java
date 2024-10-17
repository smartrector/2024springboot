package com.sample.spring.security.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.gson.Gson;
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
			
			
			try {
				String accessToken = authHeaderStr.substring(7);
				
				Map<String, Object> claims =  JWTUtil.validateToken(accessToken);
				
				log.info("##############jwt claims : " + claims);
				
				String email = (String)claims.get("email");
				String pw = (String)claims.get("pw");
				String nickname = (String)claims.get("nickname");
				Boolean social = (boolean)claims.get("social");
				List<String> roleNames = (List<String>)claims.get("roleNames");
				
				
				MemberDto memberDto = new MemberDto(email,pw,nickname,social.booleanValue(),roleNames);
				
				log.info(memberDto);
				log.info(memberDto.getAuthorities());
				
				
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberDto, pw,memberDto.getAuthorities());
				
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				
				filterChain.doFilter(request, response);
			} catch (Exception e) {
				
				log.info("JWT check error");
				
				
				
				Gson gson = new Gson();
				
				String jsonStr = gson.toJson(Map.of("error","ERROR_ACCESS_TOKEN"));
				response.setContentType("application/json;charset=utf-8");
				
				PrintWriter printWriter = response.getWriter();
				printWriter.print(jsonStr);
				printWriter.close();
				
			}
			
			
			
	}

}
