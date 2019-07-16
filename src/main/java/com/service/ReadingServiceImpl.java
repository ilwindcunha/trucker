package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Priority;
import com.entity.PriorityTypes;
import com.entity.Readings;
import com.entity.Vehicles;
import com.exception.BadRequestException;
import com.exception.ResourceNotFoundException;
import com.repository.PriorityRepository;
import com.repository.ReadingRepository;
import com.repository.VehicleRepository;


@Service
public class ReadingServiceImpl implements ReadingService{
	@Autowired
	ReadingRepository repository;
	@Autowired
	VehicleRepository vRepository;
	@Autowired
	PriorityRepository pRepository;
	
	@Transactional(readOnly = true)
	public List<Readings> findAll() {
		return (List<Readings>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Readings findOne(String id) {
		Optional<Readings> vhc = repository.findByVin(id);
        
        if(!vhc.isPresent()){
        	throw new ResourceNotFoundException("Vehicle with id "+ id +"doesnt exist");
        }
        return vhc.get();
	}

	@Transactional
	public Readings create(Readings rd) {
		Optional<Readings> existing = repository.findByVin(rd.getVin());
        /*if (existing.isPresent()) {
            throw new BadRequestException("Vehicle with Vin " + rd.getVin()+ " already exists.");
        }*/
        //get the vin data
        Optional<Vehicles> vdata = vRepository.findByVin(rd.getVin());
        //check for conditions
        Vehicles data = vdata.get();
        double tenPercent = data.getMaxFuelVolume()*0.1;
        if(data.getRedlineRpm() < rd.getEngineRpm()){
        	pRepository.create(new Priority(rd.getVin(), PriorityTypes.HIGH));
        }else if(rd.getFuel() < tenPercent){
        	pRepository.create(new Priority(rd.getVin(), PriorityTypes.MEDIUM));
        }else if(rd.check()){
        	pRepository.create(new Priority(rd.getVin(), PriorityTypes.LOW));
        }else if(rd.isCheckEngineLightOn() || rd.isEngineCooolantLow()){
        	pRepository.create(new Priority(rd.getVin(), PriorityTypes.LOW));
        }
        return repository.save(rd);
	}

	@Transactional
	public Readings update(String id, Readings rd) {

		 Optional<Readings> existing = repository.findByVin(id);
	        return repository.save(rd);
	}

	@Transactional
	public void delete(String id) {
		Optional<Readings> existing = repository.findByVin(id);
        if (!existing.isPresent()) {
            throw new ResourceNotFoundException("Vehicle with id " + id + " doesn't exist.");
        }
        repository.delete(existing.get());
	}

}
