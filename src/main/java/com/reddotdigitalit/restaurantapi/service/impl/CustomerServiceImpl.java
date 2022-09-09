package com.reddotdigitalit.restaurantapi.service.impl;

import com.reddotdigitalit.restaurantapi.dto.CustomerDto;
import com.reddotdigitalit.restaurantapi.entity.Customer;
import com.reddotdigitalit.restaurantapi.repository.CustomerRepository;
import com.reddotdigitalit.restaurantapi.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer convertToEntity(CustomerDto customerDto){
        return modelMapper.map(customerDto,Customer.class);
    }

    @Override
    public CustomerDto convertToDto(Customer customer){
        return modelMapper.map(customer,CustomerDto.class);
    }

    @Override
    public Customer addCustomer(CustomerDto customerDto) {

        Customer customer= convertToEntity(customerDto);

        customer=customerRepository.save(customer);

        return customer;

    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        return customerRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomer(Long id) {
        Optional<Customer> customer=customerRepository.findById(id);
        return convertToDto(customer.get());
    }

}
