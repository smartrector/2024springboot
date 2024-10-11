package com.sample.spring.api.response;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodView {
	private Long id;
	private String name;
	private String address;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
}
