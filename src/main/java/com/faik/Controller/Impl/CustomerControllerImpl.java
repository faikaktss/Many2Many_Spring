package com.faik.Controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faik.Controller.ICustomerController;
import com.faik.Services.ICustomerService;
import com.faik.dto.DtoCustomer;


@RestController
@RequestMapping("/rest/api/customer")
public class CustomerControllerImpl implements ICustomerController{
	
	@Autowired
	private ICustomerService customerService;

	@GetMapping(path = "/list/{id}")
	@Override
	public DtoCustomer findDtoCustomerById(@PathVariable(name = "id") Long id) {
		return customerService.findCustomerById(id);
	}

}
