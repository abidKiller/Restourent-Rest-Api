package com.reddotdigitalit.restaurantapi.service;

import com.reddotdigitalit.restaurantapi.entity.CustomerOrderDetail;

import java.util.List;

public interface CustomerOrderDetailService {

    CustomerOrderDetail addCustomerOrderDetail(CustomerOrderDetail customerOrderDetail);

    List<CustomerOrderDetail> getCustomerOrderDetailByCustomerOrderId(Long id);
}
