package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Vehicles;
import com.exception.BadRequestException;
import com.exception.ResourceNotFoundException;
import com.repository.VehicleRepository;

@Service
public class VehicleServiceImp implements VehicleService{
	@Autowired
	VehicleRepository repository;
	
	@Transactional(readOnly = true)
	public List<Vehicles> findAll() {
		return (List<Vehicles>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Vehicles findOne(String id) {
		 Optional<Vehicles> vhc = repository.findByVin(id);
	        
	        if(!vhc.isPresent()){
	        	throw new ResourceNotFoundException("Vehicle with id "+ id +"doesnt exist");
	        }
	        return vhc.get();
	}

	@Transactional
	public Vehicles create(Vehicles vhc) {
		 Optional<Vehicles> existing = repository.findByVin(vhc.getVin());
	        if (existing.isPresent()) {
	            throw new BadRequestException("Vehicle with Vin " + vhc.getVin()+ " already exists.");
	        }
	        return repository.save(vhc);
	}

	@Transactional
	public Vehicles update(String id, Vehicles vhc) {
		 Optional<Vehicles> existing = repository.findByVin(id);
	        /*if (!existing.isPresent()) {
	            throw new ResourceNotFoundException("Vehicle with id " + id + " doesn't exist.");
	        }*/
	        return repository.save(vhc);
	}

	@Transactional
	public void delete(String id) {
		Optional<Vehicles> existing = repository.findByVin(id);
        if (!existing.isPresent()) {
            throw new ResourceNotFoundException("Vehicle with id " + id + " doesn't exist.");
        }
        repository.delete(existing.get());
	}

}
