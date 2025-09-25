package com.faik.dto;

import com.faik.Entites.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoEmplooye {
	
	private Long id;
	
	private String emplooyeName;

	private DtoDepartment department;
}
