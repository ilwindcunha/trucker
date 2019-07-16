package com.service;

import java.util.List;

import com.entity.Vehicles;

public interface VehicleService {
    List<Vehicles> findAll();

    Vehicles findOne(String id);

    Vehicles create(Vehicles vhc);

    Vehicles update(String id, Vehicles vhc);

    void delete(String id);
}