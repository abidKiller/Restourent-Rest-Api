package com.reddotdigitalit.restaurantapi.controller;

import com.reddotdigitalit.restaurantapi.dto.FoodItemDto;
import com.reddotdigitalit.restaurantapi.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping(value = "/foodItem/all")
    public List<FoodItemDto> getAllFoodItems(){
        //foodItemService.findAll().stream().forEach(System.out::println);
        return foodItemService.getAllFoodItems();
    }
}
