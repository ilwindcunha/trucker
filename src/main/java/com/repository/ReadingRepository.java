package com.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.entity.Readings;
import com.entity.Vehicles;

public interface ReadingRepository extends CrudRepository<Readings, String> {
    Optional<Readings> findByVin(String vin);
    
}
