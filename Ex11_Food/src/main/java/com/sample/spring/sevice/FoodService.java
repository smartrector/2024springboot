package com.sample.spring.sevice;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.spring.api.request.CreateAndEditFoodRequest;
import com.sample.spring.model.FoodEntity;
import com.sample.spring.repository.FoodRepository;
import com.sample.spring.repository.MenuRepository;

@Service
public class FoodService {
	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private MenuRepository menuRepository;

	public FoodEntity createFood(
			CreateAndEditFoodRequest request
			) {
		FoodEntity food = FoodEntity.builder()
				.name(request.getName())
				.address(request.getAddress())
				.createdAt(ZonedDateTime.now())
				.updatedAt(ZonedDateTime.now())
				.build();
		
		foodRepository.save(food);
		
		return food;
	}

	public void editFood() {

	}

	public void deleteFood() {

	}
}
