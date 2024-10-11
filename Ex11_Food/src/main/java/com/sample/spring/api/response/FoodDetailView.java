package com.sample.spring.api.response;

import java.time.ZonedDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodDetailView {
	private Long id;
	private String name;
	private String address;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
	private List<Menu> menus;
	
	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Menu{
		private Long foodId;
		private String name;
		private Integer price;
		private ZonedDateTime createdAt;
		private ZonedDateTime updatedAt;
	}
}
