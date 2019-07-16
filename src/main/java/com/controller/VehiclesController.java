package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Vehicles;
import com.service.VehicleService;

@RestController
@RequestMapping(value = "/vehicles")
public class VehiclesController {
	@Autowired
	VehicleService service;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@CrossOrigin
	public List<Vehicles> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@CrossOrigin
	public Vehicles findOne(@PathVariable("id") String vim) {
		return service.findOne(vim);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@CrossOrigin
	public Vehicles create(@RequestBody Vehicles vim) {
		return service.create(vim);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@CrossOrigin
	public List <Vehicles> update(@RequestBody List <Vehicles>  vin) {
		for(Vehicles vehicle : vin)
			service.update(vehicle.getVin(), vehicle);
		
		return vin;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	@CrossOrigin
	public void delete(@PathVariable("id") String vimId) {
		service.delete(vimId);
	}
}
