package com.reddotdigitalit.restaurantapi.repository;

import com.reddotdigitalit.restaurantapi.entity.CustomerOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface CustomerOrderDetailRepository extends JpaRepository<CustomerOrderDetail,Long> {
    public List<CustomerOrderDetail> findByCustomerOrderId(Long id);
}
