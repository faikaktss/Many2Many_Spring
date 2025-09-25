package com.faik.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faik.Entites.Emplooye;
import com.faik.Repository.EmplooyeRepository;
import com.faik.Services.IEmplooyeService;
import com.faik.dto.DtoDepartment;
import com.faik.dto.DtoEmplooye;

@Service
public class EmplooyeServiceImpl implements IEmplooyeService{
	@Autowired
	private EmplooyeRepository emplooyeRepository;

	
	@Override
	public List<DtoEmplooye> findAllEmplooye() {
		List<DtoEmplooye> dtoEmplooyesList = new ArrayList<>();
		
		List<Emplooye> emplooyesList = emplooyeRepository.findAll();
		if(!emplooyesList.isEmpty() && emplooyesList != null) {
			for (Emplooye emplooye : emplooyesList) {
				DtoEmplooye dtoEmplooye = new DtoEmplooye();
				BeanUtils.copyProperties(emplooye, dtoEmplooye);
				
				dtoEmplooye.setDepartment(new DtoDepartment(emplooye.getDepartment().getId(),emplooye.getDepartment().getDepartmentName(),null));
				dtoEmplooyesList.add(dtoEmplooye);
			}
		}
		
		return dtoEmplooyesList;
	}

}
