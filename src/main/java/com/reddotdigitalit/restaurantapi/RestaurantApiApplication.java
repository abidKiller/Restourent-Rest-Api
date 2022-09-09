package com.reddotdigitalit.restaurantapi;

import com.reddotdigitalit.restaurantapi.entity.Customer;
import com.reddotdigitalit.restaurantapi.entity.CustomerOrder;
import com.reddotdigitalit.restaurantapi.entity.CustomerOrderDetail;
import com.reddotdigitalit.restaurantapi.entity.FoodItem;
import com.reddotdigitalit.restaurantapi.repository.CustomerOrderDetailRepository;
import com.reddotdigitalit.restaurantapi.repository.CustomerOrderRepository;
import com.reddotdigitalit.restaurantapi.repository.CustomerRepository;
import com.reddotdigitalit.restaurantapi.repository.FoodItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class RestaurantApiApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(RestaurantApiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		testInsertOrder();
	}
	@Autowired
	private FoodItemRepository foodItemRepository;
	@Autowired
	private CustomerOrderDetailRepository customerOrderDetailRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerOrderRepository customerOrderRepository;


	void testInsertOrder(){


		Optional<Customer> customer=customerRepository.findById(1L);
		Optional<Customer> customer2=customerRepository.findById(2L);

		CustomerOrder customerOrder1 = new CustomerOrder();

		customerOrder1.setCustomer(customer.get());
		customerOrder1.setCustomerMessage("hahahaha");
		customerOrder1.setTotalPrice(100L);

		CustomerOrder customerOrder2 = new CustomerOrder();

		customerOrder2.setCustomer(customer.get());
		customerOrder2.setCustomerMessage("lalalla");
		customerOrder2.setTotalPrice(124L);

		CustomerOrder customerOrder3 = new CustomerOrder();

		customerOrder3.setCustomer(customer2.get());
		customerOrder3.setCustomerMessage("distingdisting");
		customerOrder3.setTotalPrice(12L);

		customerOrder1 =customerOrderRepository.save(customerOrder1);
		customerOrder2=customerOrderRepository.save(customerOrder2);
		customerOrder3=customerOrderRepository.save(customerOrder3);


		Optional<FoodItem> f1= foodItemRepository.findById(1L);
		Optional<FoodItem> f2= foodItemRepository.findById(2L);
		Optional<FoodItem> f3= foodItemRepository.findById(3L);


		CustomerOrderDetail customerOrderDetail1=new CustomerOrderDetail();
		customerOrderDetail1.setFoodItem(f1.get());
		customerOrderDetail1.setQuantity(5L);
		customerOrderDetail1.setCustomerOrder(customerOrder1);


		customerOrderDetail1=customerOrderDetailRepository.save(customerOrderDetail1);

		CustomerOrderDetail customerOrderDetail2=new CustomerOrderDetail();
		customerOrderDetail2.setFoodItem(f2.get());
		customerOrderDetail2.setQuantity(4L);
		customerOrderDetail2.setCustomerOrder(customerOrder1);

		customerOrderDetail2=customerOrderDetailRepository.save(customerOrderDetail2);

		CustomerOrderDetail customerOrderDetail3=new CustomerOrderDetail();
		customerOrderDetail3.setFoodItem(f3.get());
		customerOrderDetail3.setQuantity(12L);
		customerOrderDetail3.setCustomerOrder(customerOrder2);

		customerOrderDetail3=customerOrderDetailRepository.save(customerOrderDetail3);


		CustomerOrderDetail customerOrderDetail4=new CustomerOrderDetail();
		customerOrderDetail4.setFoodItem(f2.get());
		customerOrderDetail4.setQuantity(12L);
		customerOrderDetail4.setCustomerOrder(customerOrder3);

		customerOrderDetail4=customerOrderDetailRepository.save(customerOrderDetail4);

		Optional<FoodItem> f= foodItemRepository.findById(1L);
		//Optional<Customer> c= customerRepository.findById(1L);
		if(f.get().getAvailableQuantity()<24) {
			System.out.println("less than available");
			return;

		}
//
		Long updatedQuantity=f.get().getAvailableQuantity()-24;
		f.get().setAvailableQuantity(updatedQuantity);
		foodItemRepository.save(f.get());

		List<CustomerOrder> customerOrders=customerOrderRepository.findAllByCustomerId(1L);

		for(CustomerOrder customerOrder:customerOrders)
			System.out.println(customerOrder);






	}
}
