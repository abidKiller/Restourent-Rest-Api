package com.reddotdigitalit.restaurantapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.util.Pair;


import java.util.List;

@Data
public class CustomerOrderRequestDto {

    @JsonProperty
    private Long customerID;
    @JsonProperty
    private String customerMessage;
    @JsonProperty
    private List<List<Long>> foodItemIdsWithQuantities;

}
