package com.sample.springboot.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.sample.springboot.security.APILoginFailHandler;
import com.sample.springboot.security.APILoginSuccessHandler;
import com.sample.springboot.security.filter.JWTCheckFilter;
import com.sample.springboot.security.handler.CustomAccessDeniedHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@Configuration
@Log4j2
@ReadingConverter
@RequiredArgsConstructor
@EnableMethodSecurity
public class CustomSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		log.info("---------------------security config---------------------------");

	    http.cors(httpSecurityCorsConfigurer -> {
	      httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource());
	    });

	    http.sessionManagement(sessionConfig ->  sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

	    http.csrf(config -> config.disable());

	    http.formLogin(config -> {
	      config.loginPage("/api/member/login");
	      config.successHandler(new APILoginSuccessHandler());
	      config.failureHandler(new APILoginFailHandler());
	    });

	    http.addFilterBefore(new JWTCheckFilter(), UsernamePasswordAuthenticationFilter.class); //JWT체크 

	    http.exceptionHandling(config -> {
	      config.accessDeniedHandler(new CustomAccessDeniedHandler());
	    });
	    
	    


	    return http.build();
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	//@Bean
//	public CorsConfigurationSource CorsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
////        configuration.setAllowedOrigins(Arrays.asList("*"));
//		 configuration.setAllowedOriginPatterns(Arrays.asList("*"));
//        configuration.setAllowedMethods(Arrays.asList("HEAD","GET","POST","PUT","DELETE","OPTIONS"));
//        configuration.setAllowedHeaders(Arrays.asList("Authorization","Cache-Control","Content-Type"));
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//
//        return source;
//	}
	
	@Bean
	 public CorsConfigurationSource corsConfigurationSource() {

		    CorsConfiguration configuration = new CorsConfiguration();

		    configuration.setAllowedOriginPatterns(Arrays.asList("*"));
		    configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE"));
		    configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
		    configuration.setAllowCredentials(true);

		    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		    source.registerCorsConfiguration("/**", configuration);

		    return source;
		  }
}
