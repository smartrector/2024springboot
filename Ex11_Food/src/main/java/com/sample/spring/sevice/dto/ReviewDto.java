package com.sample.spring.sevice.dto;

import java.util.List;

import com.sample.spring.model.ReviewEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

	private Double avgScore;
	private List<ReviewEntity> reviews;
	private ReviewDtoPage page;
	
	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class ReviewDtoPage{
		private Integer offset;
		private Integer limit;
	}
}
