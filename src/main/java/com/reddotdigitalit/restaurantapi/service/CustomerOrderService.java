package com.reddotdigitalit.restaurantapi.service;


import com.reddotdigitalit.restaurantapi.dto.CustomerOrderRequestDto;
import com.reddotdigitalit.restaurantapi.dto.CustomerOrderResponseDto;
import com.reddotdigitalit.restaurantapi.entity.CustomerOrder;

import java.util.List;

public interface CustomerOrderService {

    public CustomerOrderResponseDto addCustomerOrder(CustomerOrderRequestDto customerOrderDto);


    public List<CustomerOrderResponseDto> getAllCustomerOrders();


    public List<CustomerOrderResponseDto> getAllCustomerOrdersByCustomerId(Long id);
}
