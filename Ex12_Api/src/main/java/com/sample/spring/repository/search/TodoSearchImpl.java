package com.sample.spring.repository.search;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.jpa.JPQLQuery;
import com.sample.spring.dto.PageRequestDto;
import com.sample.spring.model.QTodoEntity;
import com.sample.spring.model.TodoEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch{

	public TodoSearchImpl() {
		super(TodoEntity.class);
	}

	@Override
	public Page<TodoEntity> search1(PageRequestDto pageRequestDto) {
		log.info("search1#######################");
		
		QTodoEntity todoEntity = QTodoEntity.todoEntity;
		JPQLQuery<TodoEntity> query = from(todoEntity);
		
//		query.where(todoEntity.title.contains("test"));
		
		Pageable pageable = PageRequest.of(pageRequestDto.getPage()-1, pageRequestDto.getSize(),Sort.by("tno").descending());
		query.offset(pageable.getOffset());
		query.limit(pageable.getPageSize());
		query.orderBy(todoEntity.tno.desc());
		List<TodoEntity> list =  query.fetch();
		long total =  query.fetchCount();
		
		return new PageImpl<>(list,pageable,total);

	}


	
}
