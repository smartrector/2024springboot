package com.sample.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sample.spring.domain.Member;
import com.sample.spring.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository repo;
	
	public List<Member> selectAll(){
		return repo.findAll(Sort.by(Sort.Direction.DESC,"id"));
	}
	
	public Member insert(Member member) {
		Member returnMember = repo.save(member);
		return returnMember;
	}
	
	public Optional<Member> view(Long id){
		Optional<Member> member = repo.findById(id);
		return member;
	}
}
