package com.sample.spring.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDto {
	private Long tno;
	private String title;
	private String writer;
	private boolean complete;
	private LocalDate dueDate;
}
