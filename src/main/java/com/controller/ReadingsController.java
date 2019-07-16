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

import com.entity.Readings;
import com.service.ReadingService;

@RestController
@RequestMapping(value = "/readings")
public class ReadingsController {

	@Autowired
	ReadingService service;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@CrossOrigin
	public List<Readings> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@CrossOrigin
	public Readings findOne(@PathVariable("id") String vim) {
		return service.findOne(vim);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@CrossOrigin
	public Readings create(@RequestBody Readings rd) {
		System.out.println("Inside controller");
		return service.create(rd);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@CrossOrigin
	public List <Readings> update(@RequestBody List <Readings>  readings) {
		for(Readings reading : readings){
			service.update(reading.getVin(), reading);
		}
		return readings;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	@CrossOrigin
	public void delete(@PathVariable("id") String vimId) {
		service.delete(vimId);
	}

}
