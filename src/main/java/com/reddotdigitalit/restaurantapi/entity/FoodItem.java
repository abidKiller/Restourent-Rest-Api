package com.reddotdigitalit.restaurantapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "food_item")

public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String privateInfo;
    private String foodItemName;
    private Long price;
    @Column(updatable = true)
    private Long availableQuantity;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "foodItem",fetch = FetchType.LAZY)
    private List<CustomerOrderDetail> customerOrders=new ArrayList<>();

}
