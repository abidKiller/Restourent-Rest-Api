package com.reddotdigitalit.restaurantapi.repository;

import com.reddotdigitalit.restaurantapi.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem,Long> {
}
