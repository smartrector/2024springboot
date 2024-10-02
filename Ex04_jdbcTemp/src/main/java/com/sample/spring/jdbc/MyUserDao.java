package com.sample.spring.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyUserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<MyUserDto> list(){
		String query = "select * from myuser";
		List<MyUserDto> list = jdbcTemplate.query(query, 
				new BeanPropertyRowMapper<>(MyUserDto.class)
				);
		
		
		return list;
	}
}
