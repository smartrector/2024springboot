package com.sample.spring.api.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAndEditFoodRequest {
	private String name;
	private String address;
	private List<CreateAndEditFoodRequestMenu> menus;
}
