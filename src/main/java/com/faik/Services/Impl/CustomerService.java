package com.faik.Services.Impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faik.Entites.Address;
import com.faik.Entites.Customer;
import com.faik.Repository.CustomerRepository;
import com.faik.Services.ICustomerService;
import com.faik.dto.DtoAddress;
import com.faik.dto.DtoCustomer;

@Service
public class CustomerService implements ICustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public DtoCustomer findCustomerById(Long id) {
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress dtoAddress = new DtoAddress();
		
		 Optional<Customer> optional =  customerRepository.findById(id);
		 if(optional.isEmpty()) {
			 return null;
		 }
		 Customer customer = optional.get();
		 Address address = optional.get().getAddress();
		 
		 BeanUtils.copyProperties(customer, dtoCustomer);
		 BeanUtils.copyProperties(address, dtoAddress);
		 
		 dtoCustomer.setAddress(dtoAddress);
		 return dtoCustomer;
	}

}
