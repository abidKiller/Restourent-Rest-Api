package com.reddotdigitalit.restaurantapi.repository;

import com.reddotdigitalit.restaurantapi.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Long> {

    public List<CustomerOrder> findAllByCustomerId(Long id);

}
