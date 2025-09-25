package com.faik.Controller;

import com.faik.dto.DtoCustomer;

public interface ICustomerController {
	public DtoCustomer findDtoCustomerById(Long id);
}
