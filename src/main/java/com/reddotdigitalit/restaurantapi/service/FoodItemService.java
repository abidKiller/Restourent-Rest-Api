package com.reddotdigitalit.restaurantapi.service;

import com.reddotdigitalit.restaurantapi.dto.FoodItemDto;
import com.reddotdigitalit.restaurantapi.entity.FoodItem;

import java.util.List;

public interface FoodItemService {

    FoodItemDto convertToDto(FoodItem foodItem);

    FoodItem convertToEntity(FoodItemDto foodItemDto);

    public List<FoodItemDto> getAllFoodItems();


    Boolean validateQuantity(Long id, Long orderQuantity);


    FoodItem getFoodItem(Long id);
}
