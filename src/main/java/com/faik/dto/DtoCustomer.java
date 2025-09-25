package com.faik.dto;

import lombok.Data;

@Data
public class DtoCustomer {
	
	private Long id;
	
	private String name;
	
	private DtoAddress address;
}
