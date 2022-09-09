package com.reddotdigitalit.restaurantapi.service.impl;

import com.reddotdigitalit.restaurantapi.dto.FoodItemDto;
import com.reddotdigitalit.restaurantapi.entity.FoodItem;
import com.reddotdigitalit.restaurantapi.repository.FoodItemRepository;
import com.reddotdigitalit.restaurantapi.service.FoodItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class FoodItemServiceImpl implements FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FoodItemDto convertToDto(FoodItem foodItem){
        return modelMapper.map(foodItem,FoodItemDto.class);
    }

    @Override
    public FoodItem convertToEntity(FoodItemDto foodItemDto){
        return modelMapper.map(foodItemDto,FoodItem.class);
    }

    @Override
    public List<FoodItemDto> getAllFoodItems() {

       //foodItemRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList()).forEach(System.out::println)  ;
        return foodItemRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Boolean validateQuantity(Long id, Long orderQuantity) {
        Optional<FoodItem> foodItem=foodItemRepository.findById(id);

        if(foodItem.isPresent()) {
            if (foodItem.get().getAvailableQuantity() < orderQuantity)
                return false;

            Long updatedQuantity = foodItem.get().getAvailableQuantity() - orderQuantity;
            foodItem.get().setAvailableQuantity(updatedQuantity);
            foodItemRepository.save(foodItem.get());
            return true;
        }
        return false;
    }
    @Override
    public FoodItem getFoodItem(Long id){
       Optional<FoodItem> foodItem=  foodItemRepository.findById(id);

       return  foodItem.get();
    }



}
