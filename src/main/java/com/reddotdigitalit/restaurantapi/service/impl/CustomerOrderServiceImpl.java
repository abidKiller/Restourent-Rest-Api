package com.reddotdigitalit.restaurantapi.service.impl;


import com.reddotdigitalit.restaurantapi.dto.CustomerOrderRequestDto;
import com.reddotdigitalit.restaurantapi.dto.CustomerOrderResponseDto;
import com.reddotdigitalit.restaurantapi.dto.FoodItemDto;
import com.reddotdigitalit.restaurantapi.entity.Customer;
import com.reddotdigitalit.restaurantapi.entity.CustomerOrder;
import com.reddotdigitalit.restaurantapi.entity.CustomerOrderDetail;
import com.reddotdigitalit.restaurantapi.entity.FoodItem;
import com.reddotdigitalit.restaurantapi.repository.CustomerOrderDetailRepository;
import com.reddotdigitalit.restaurantapi.repository.CustomerOrderRepository;
import com.reddotdigitalit.restaurantapi.service.CustomerOrderDetailService;
import com.reddotdigitalit.restaurantapi.service.CustomerOrderService;
import com.reddotdigitalit.restaurantapi.service.CustomerService;
import com.reddotdigitalit.restaurantapi.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {



    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private FoodItemService foodItemService;

    @Autowired
    private CustomerOrderDetailService customerOrderDetailService;

    @Autowired
    private CustomerService customerService;


    @Autowired
    private CustomerOrderDetailRepository customerOrderDetailRepository;
    @Override
    public CustomerOrderResponseDto addCustomerOrder(CustomerOrderRequestDto customerOrderRequestDto) {

        List<List<Long>> foodItemIdsWithQuantities=customerOrderRequestDto.getFoodItemIdsWithQuantities();

        String customerMessage=customerOrderRequestDto.getCustomerMessage();
        Long totalPrice=0L;

        Long customerId= customerOrderRequestDto.getCustomerID();

        Customer customer= customerService.convertToEntity( customerService.getCustomer(customerId));
        CustomerOrder customerOrder=new CustomerOrder();
        customerOrder.setCustomer(customer);
        customerOrder.setCustomerMessage(customerOrderRequestDto.getCustomerMessage());

        customerOrder=customerOrderRepository.save(customerOrder);

        List<FoodItemDto> foodItemDtos=new ArrayList<>();
        for(List<Long> foodItemIdWithQuantity : foodItemIdsWithQuantities ){
            Long foodItemId= foodItemIdWithQuantity.get(0);
            Long orderQuantity = foodItemIdWithQuantity.get(1);

           // Set<FoodItem> foodItems=new HashSet<>();
            System.out.println(foodItemId+" " +orderQuantity);
            if(foodItemService.validateQuantity(foodItemId, orderQuantity)){
                FoodItem foodItem= foodItemService.getFoodItem(foodItemId);
                CustomerOrderDetail customerOrderDetail=new CustomerOrderDetail();

                foodItemDtos.add(foodItemService.convertToDto(foodItem));
                totalPrice+=orderQuantity*foodItem.getPrice();

                customerOrderDetail.setFoodItem(foodItem);
                customerOrderDetail.setQuantity(orderQuantity);
                customerOrderDetail.setCustomerOrder(customerOrder);
                customerOrderDetailRepository.save(customerOrderDetail);
               // customerOrderDetail.se
                //customerOrderDetails.add(customerOrderDetail);
            }
        }

        customerOrder.setTotalPrice(totalPrice);

        customerOrder=customerOrderRepository.save(customerOrder);
        CustomerOrderResponseDto customerOrderResponseDto=new CustomerOrderResponseDto();
        customerOrderResponseDto.setId(customerOrder.getId());
        customerOrderResponseDto.setFoodItems(foodItemDtos);
        customerOrderResponseDto.setTotalPrice(totalPrice);


        return customerOrderResponseDto;
      //  return con;
    }

    @Override
    public List<CustomerOrderResponseDto> getAllCustomerOrders() {
        return null;
    }

    @Override
    public List<CustomerOrderResponseDto> getAllCustomerOrdersByCustomerId(Long id) {

//        public class CustomerOrderResponseDto {
//            private Long id;
//            private Long totalPrice;
//            private List<FoodItem> foodItems;
//
//        }

        List<CustomerOrder> customerOrders=customerOrderRepository.findAllByCustomerId(id);
        List<CustomerOrderResponseDto> customerOrderResponseDtos=new ArrayList<>();

        if(customerOrders==null){
            return null;

        }

        for(CustomerOrder customerOrder:customerOrders){
            CustomerOrderResponseDto customerOrderResponseDto=new CustomerOrderResponseDto();
            customerOrderResponseDto.setId(customerOrder.getId());
            customerOrderResponseDto.setTotalPrice(customerOrder.getTotalPrice());

            List<FoodItemDto> foodItemDtos=new ArrayList<>();
            List<CustomerOrderDetail> customerOrderDetails=customerOrderDetailService.getCustomerOrderDetailByCustomerOrderId(customerOrder.getId());


            for(CustomerOrderDetail customerOrderDetail: customerOrderDetails){
               FoodItemDto foodItemDto = foodItemService.convertToDto(customerOrderDetail.getFoodItem());

               foodItemDtos.add(foodItemDto);
            }

            customerOrderResponseDto.setFoodItems(foodItemDtos);
            customerOrderResponseDtos.add(customerOrderResponseDto);

        }

        //return null;
        return customerOrderResponseDtos;
    }

}
