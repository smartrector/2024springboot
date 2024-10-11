package com.sample.spring.sevice;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.spring.api.request.CreateAndEditFoodRequest;
import com.sample.spring.api.response.FoodDetailView;
import com.sample.spring.api.response.FoodView;
import com.sample.spring.model.FoodEntity;
import com.sample.spring.model.MenuEntity;
import com.sample.spring.repository.FoodRepository;
import com.sample.spring.repository.MenuRepository;

import jakarta.transaction.Transactional;

@Service
public class FoodService {
	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private MenuRepository menuRepository;

	@Transactional
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
		
		request.getMenus().forEach((menu)->{
			MenuEntity menuEntity = MenuEntity.builder()
					.foodId(food.getId())
					.name(menu.getName())
					.price(menu.getPrice())
					.createdAt(ZonedDateTime.now())
					.updatedAt(ZonedDateTime.now())
					.build();
			menuRepository.save(menuEntity);
		});
		
		return food;
	}

	@Transactional
	public void editFood(
			Long foodId,
			CreateAndEditFoodRequest request
			) {
		FoodEntity food = foodRepository.findById(foodId).orElseThrow(()->new RuntimeException("no food"));
		food.changeNameAndAddress(request.getName(), request.getAddress());
		foodRepository.save(food);
		
		List<MenuEntity> menus = menuRepository.findAllByFoodId(foodId); 
		menuRepository.deleteAll(menus);
		
		request.getMenus().forEach((menu)->{
			MenuEntity menuEntity = MenuEntity.builder()
					.foodId(food.getId())
					.name(menu.getName())
					.price(menu.getPrice())
					.createdAt(ZonedDateTime.now())
					.updatedAt(ZonedDateTime.now())
					.build();
			menuRepository.save(menuEntity);
		});
		
	}

	public void deleteFood(Long foodId) {
		FoodEntity food = foodRepository.findById(foodId).orElseThrow();
		foodRepository.delete(food);
		
		List<MenuEntity> menus = menuRepository.findAllByFoodId(foodId); 
		menuRepository.deleteAll(menus);
		
	}
	public List<FoodView> getAllFoods(){
		List<FoodEntity> foods = foodRepository.findAll();
		
		return foods.stream().map((food)-> FoodView.builder()
				.id(food.getId())
				.name(food.getName())
				.address(food.getAddress())
				.createdAt(food.getCreatedAt())
				.updatedAt(food.getUpdatedAt())
				.build()
				).toList() ;
	}
	public FoodDetailView getFoodDetail(Long foodId) {
		FoodEntity food = foodRepository.findById(foodId).orElseThrow();
		
		List<MenuEntity> menus = menuRepository.findAllByFoodId(foodId);
		
		return FoodDetailView.builder()
				.id(food.getId())
				.name(food.getName())
				.address(food.getAddress())
				.createdAt(food.getCreatedAt())
				.updatedAt(food.getUpdatedAt())
				.menus(menus.stream().map((menu)->
				
						FoodDetailView.Menu.builder()
						.foodId(menu.getFoodId())
						.name(menu.getName())
						.price(menu.getPrice())
						.createdAt(menu.getCreatedAt())
						.updatedAt(menu.getUpdatedAt())
						.build()

						).toList())
				
				.build();
		
	}
	
	
	
	
	
}
