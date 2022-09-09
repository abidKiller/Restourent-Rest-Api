package com.reddotdigitalit.restaurantapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reddotdigitalit.restaurantapi.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.event.internal.ProxyVisitor;

import java.io.Serializable;
import java.security.PrivateKey;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrderResponseDto implements Serializable {
    private Long id;
    private Long totalPrice;
    private List<FoodItemDto> foodItems;

}
