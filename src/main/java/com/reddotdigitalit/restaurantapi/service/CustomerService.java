package com.reddotdigitalit.restaurantapi.service;

import com.reddotdigitalit.restaurantapi.dto.CustomerDto;
import com.reddotdigitalit.restaurantapi.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer convertToEntity(CustomerDto customerDto);

    CustomerDto convertToDto(Customer customer);

    public Customer addCustomer(CustomerDto customerDto);
    public List<CustomerDto> getAllCustomer();
    public CustomerDto getCustomer(Long id);
}
