package com.sample.spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.spring.api.request.CreateAndEditFoodRequest;
import com.sample.spring.model.FoodEntity;
import com.sample.spring.sevice.FoodService;

@RestController
public class FoodApi {
	
	@Autowired
	private FoodService foodService;

	@GetMapping("/foods")
	public String getFoods() {
		return "getFoods";
	}
	
	@GetMapping("/food/{foodId}")
	public String viewFood(
			@PathVariable("foodId") Long foodId
			) {
		return "viewFood / " + foodId;
	}
	
	
	// #################
	
	@PostMapping("/food")
	public FoodEntity postFood(
			@RequestBody CreateAndEditFoodRequest request
			) {
		return foodService.createFood(request);
//		return "postFood / name: " + request.getName() + ", address : " + request.getAddress() + ", 메뉴[0]" + request.getMenus().get(1).getName();
	}
	
	@PutMapping("/food/{foodId}")
	public void editFood(
			@PathVariable("foodId") Long foodId,
			@RequestBody CreateAndEditFoodRequest request
			) {
		
		foodService.editFood(foodId, request);
		
//		return "editFood" + foodId + ", name: " + request.getName() + ", address : " + request.getAddress();
	}
	
	
	// #################
	
	@DeleteMapping("/food/{foodId}")
	public void deleteFood(
			@PathVariable("foodId") Long foodId
			) {
		
		foodService.deleteFood(foodId);
	}
	
}
