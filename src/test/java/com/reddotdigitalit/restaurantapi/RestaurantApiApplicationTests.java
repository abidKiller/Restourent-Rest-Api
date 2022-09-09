package com.reddotdigitalit.restaurantapi;

import com.reddotdigitalit.restaurantapi.dto.CustomerOrderResponseDto;
import com.reddotdigitalit.restaurantapi.entity.Customer;
import com.reddotdigitalit.restaurantapi.entity.CustomerOrder;
import com.reddotdigitalit.restaurantapi.entity.CustomerOrderDetail;
import com.reddotdigitalit.restaurantapi.entity.FoodItem;
import com.reddotdigitalit.restaurantapi.repository.CustomerOrderDetailRepository;
import com.reddotdigitalit.restaurantapi.repository.CustomerOrderRepository;
import com.reddotdigitalit.restaurantapi.repository.CustomerRepository;
import com.reddotdigitalit.restaurantapi.repository.FoodItemRepository;
import com.reddotdigitalit.restaurantapi.service.CustomerOrderService;
import com.reddotdigitalit.restaurantapi.service.FoodItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.*;

@SpringBootTest
class RestaurantApiApplicationTests {

	@Autowired
	CustomerRepository cr;
	@Test
	void contextLoads() {


	}


	@Autowired
	private  FoodItemRepository foodItemRepository;
	@Autowired
	private  CustomerOrderDetailRepository customerOrderDetailRepository;
	@Autowired
	private  CustomerRepository customerRepository;

	@Autowired
	private CustomerOrderRepository customerOrderRepository;

	@Test
	void testInsertOrder(){
//		Optional<FoodItem> f1= foodItemRepository.findById(1L);
//		Optional<FoodItem> f2= foodItemRepository.findById(2L);
//
//		System.out.println(f1.get().getPrivateInfo());
//		System.out.println(f2.get().getPrivateInfo());
//
//		CustomerOrderDetail customerOrderDetail1=new CustomerOrderDetail();
//		customerOrderDetail1.setFoodItem(f1.get());
//		customerOrderDetail1.setQuantity(5L);
//		customerOrderDetail1.getCustomerOrder();
//
//
//		CustomerOrderDetail customerOrderDetail2=new CustomerOrderDetail();
//		customerOrderDetail2.setFoodItem(f2.get());
//		customerOrderDetail2.setQuantity(4L);
//
//
//		List<CustomerOrderDetail> customerOrderDetails=new ArrayList<>();
//		customerOrderDetails.add(customerOrderDetail1);
//		customerOrderDetails.add(customerOrderDetail2);


		Optional<Customer> customer=customerRepository.findById(1L);
		//CustomerOrder customerOrder =new CustomerOrder(null,"lol",100L,customer.get(), new HashSet<>(customerOrderDetails));

		CustomerOrder customerOrder = new CustomerOrder();

		customerOrder.setId(1L);
		customerOrder.setCustomer(customer.get());
		customerOrder.setCustomerMessage("hahahaha");
		customerOrder.setTotalPrice(100L);

		customerOrderRepository.save(customerOrder);



//
//		customerOrder.setCustomerOrderDetails(new HashSet<>(customerOrderDetails));
//		customerOrder.setTotalPrice(100L);
//		customerOrder.setCustomer(customer.get());
//		customerOrder.setCustomerMessage("lol baje order");
		//customerOrderRepository.save(customerOrder);


	}
	@Test
	void validateQuantity(){//Long id, Long orderQuantity) {

		Optional<FoodItem> f= foodItemRepository.findById(1L);
		//Optional<Customer> c= customerRepository.findById(1L);
     	if(f.get().getAvailableQuantity()<5)
//	 		//return false;
 		  return;
//
 		Long updatedQuantity=f.get().getAvailableQuantity()-5;
		f.get().setAvailableQuantity(updatedQuantity);
		foodItemRepository.save(f.get());

		//return false;
	}
}
