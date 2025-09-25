package com.faik.Controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faik.Controller.IAddressController;
import com.faik.Services.IAddressService;
import com.faik.dto.DtoAddress;

@RestController
@RequestMapping("rest/api/address")
public class AddressControllerImpl implements IAddressController{

	@Autowired
	private IAddressService addressService;
	
	@GetMapping(path = "/list/{id}")
	@Override
	public DtoAddress findDtoAddressById(@PathVariable(name="id") Long id) {
		return addressService.findDtoAddressById(id);
	}

}
