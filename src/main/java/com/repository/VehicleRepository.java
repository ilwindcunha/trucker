package com.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.entity.Vehicles;

public interface VehicleRepository extends CrudRepository<Vehicles, String> {
    Optional<Vehicles> findByVin(String vin);
}
