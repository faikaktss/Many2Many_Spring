package com.faik.Controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faik.Configuration.DataSource;
import com.faik.Configuration.GlobalProperties;
import com.faik.Configuration.Server;

@RestController
@RequestMapping("/rest/api/property")
public class PropertySourceController {
	
	@Autowired
	private GlobalProperties globalProperties;

	@GetMapping("/datasource")
	public String getDataSource() {
		return 	null;
	}
	
	@GetMapping(value = "/getServers")
	public List<Server> getServers(){
		return globalProperties.getServers();
	}
}
