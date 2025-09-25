package com.faik.Services.Impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faik.Entites.Address;
import com.faik.Repository.AddressRepository;
import com.faik.Services.IAddressService;
import com.faik.dto.DtoAddress;
import com.faik.dto.DtoCustomer;

@Service
public class AddressServiceImpl implements IAddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public DtoAddress findDtoAddressById(Long id) {
		
		DtoAddress dtoAddress = new DtoAddress();
		
		Optional<Address> optional = addressRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		
		Address address = optional.get();
		BeanUtils.copyProperties(address, dtoAddress);
		
		DtoCustomer dtoCustomer = new DtoCustomer();
		dtoCustomer.setId(address.getCustomer().getId());
		dtoCustomer.setName(address.getCustomer().getName());
		//dtoCustomer.setAddress(dtoAddress);
		
		
		dtoAddress.setDtoCustomer(dtoCustomer);
		return dtoAddress;
	}

}
