package com.reddotdigitalit.restaurantapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class CustomerDto {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String customerName;
    @JsonProperty
    private String email;

}
