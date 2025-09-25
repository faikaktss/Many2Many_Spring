package com.faik.Controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faik.Controller.IEmplooyeController;
import com.faik.Services.IEmplooyeService;
import com.faik.dto.DtoEmplooye;


@RestController
@RequestMapping("rest/api/emplooye")
public class EmplooyeControllerImpl implements IEmplooyeController{

	@Autowired
	private IEmplooyeService emplooyeService;
	
	@GetMapping(path = "/list")
	@Override
	public List<DtoEmplooye> findAllEmplooye() {
		return emplooyeService.findAllEmplooye();
	}

}
