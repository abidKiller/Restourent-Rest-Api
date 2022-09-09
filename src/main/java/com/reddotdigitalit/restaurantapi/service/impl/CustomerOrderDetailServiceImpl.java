package com.reddotdigitalit.restaurantapi.service.impl;


import com.reddotdigitalit.restaurantapi.entity.Customer;
import com.reddotdigitalit.restaurantapi.entity.CustomerOrderDetail;
import com.reddotdigitalit.restaurantapi.repository.CustomerOrderDetailRepository;
import com.reddotdigitalit.restaurantapi.service.CustomerOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class CustomerOrderDetailServiceImpl implements CustomerOrderDetailService {

    @Autowired
    private CustomerOrderDetailRepository customerOrderDetailRepository;

    @Override
    public CustomerOrderDetail addCustomerOrderDetail(CustomerOrderDetail customerOrderDetail){

        return customerOrderDetailRepository.save(customerOrderDetail);
    }
    @Override
    public List<CustomerOrderDetail> getCustomerOrderDetailByCustomerOrderId(Long id){
       // List<CustomerOrderDetail> customerOrderDetails=customerOrderDetailRepository.findByCustomerOrderId(id);

//        for (int i=0;i<customerOrderDetails.size();i++){
//            CustomerOrderDetail c=customerOrderDetails.get(i);
//            System.out.println(c.getId()+" "+c.getQuantity()+" "+c.getFoodItem());
//        }



        return customerOrderDetailRepository.findByCustomerOrderId(id);
    }
}
