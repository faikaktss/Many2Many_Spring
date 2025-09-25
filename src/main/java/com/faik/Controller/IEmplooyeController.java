package com.faik.Controller;

import java.util.List;

import com.faik.Entites.Emplooye;
import com.faik.dto.DtoEmplooye;

public interface IEmplooyeController {
	public List<DtoEmplooye> findAllEmplooye();
}
