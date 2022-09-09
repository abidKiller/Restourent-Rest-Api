package com.reddotdigitalit.restaurantapi.controller;

import com.reddotdigitalit.restaurantapi.dto.CustomerOrderRequestDto;
import com.reddotdigitalit.restaurantapi.dto.CustomerOrderResponseDto;
import com.reddotdigitalit.restaurantapi.entity.CustomerOrder;
import com.reddotdigitalit.restaurantapi.entity.CustomerOrderDetail;
import com.reddotdigitalit.restaurantapi.repository.CustomerOrderRepository;
import com.reddotdigitalit.restaurantapi.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
public class CustomerOrderController {
    @Autowired
    private CustomerOrderService customerOrderService;
    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @GetMapping("/order/all")
    public List<CustomerOrderResponseDto> getAllCustomerOrders(){

        return customerOrderService.getAllCustomerOrders();
    }

    @PostMapping("/order")
    public ResponseEntity<CustomerOrderResponseDto> addCustomerOrder(@RequestBody CustomerOrderRequestDto customerOrderDto){


       // System.out.println(customerOrderDtoi);
       CustomerOrderResponseDto customerOrderResponseDto=customerOrderService.addCustomerOrder(customerOrderDto);


       if(customerOrderDto==null)
           return null;


        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customerOrderResponseDto.getId())
                .toUri();
        System.out.println(location.toString());
        return ResponseEntity.created(location).body(customerOrderResponseDto);
     //   return ResponseEntity.ok(customerOrderResponseDto);
    }

    @GetMapping("/order/{id}")
    public List<CustomerOrderResponseDto> getOrderById(@PathVariable Long id){
        List<CustomerOrderResponseDto> customerOrderResponseDtos=customerOrderService.getAllCustomerOrdersByCustomerId(id);

        for(CustomerOrderResponseDto customerOrderResponseDto:customerOrderResponseDtos){

            System.out.println(customerOrderResponseDto);

        }
       // return customerOrderResponseDtos;
//        if(customerOrderResponseDto==null)
//            return ResponseEntity.notFound().build();
//
//        return ResponseEntity.ok(customerOrderResponseDto);
        return customerOrderResponseDtos;

    }

}
