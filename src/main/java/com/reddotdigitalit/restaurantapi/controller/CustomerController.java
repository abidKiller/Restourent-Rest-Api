package com.reddotdigitalit.restaurantapi.controller;

import com.reddotdigitalit.restaurantapi.dto.CustomerDto;
import com.reddotdigitalit.restaurantapi.entity.Customer;
import com.reddotdigitalit.restaurantapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/all")
    public List<CustomerDto> getAllCustomers(){
        return customerService.getAllCustomer();
    }
    @PostMapping("/customer")
    public ResponseEntity addCustomer(@RequestBody CustomerDto customerDto){

        //hello world i'm abid
        //master changed from github
        
        Customer customer=customerService.addCustomer(customerDto);

        URI location=ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        System.out.println(location.toString());
        return ResponseEntity.created(location).build();
    }
    @GetMapping("/customer/{id}")
    public CustomerDto getCustomer(@PathVariable Long id){
        CustomerDto customer=customerService.getCustomer(id);

        return customer;
    }
}
