package com.reddotdigitalit.restaurantapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public class FoodItemDto {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String foodItemName;
    @JsonProperty
    private long price;
    @JsonIgnore
    private String privateInfo;
}
