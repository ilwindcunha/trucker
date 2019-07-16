package com.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.entity.Vehicles;


@Repository
public class VehicleRepositoryImpl {
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public Vehicles create(Vehicles vhc){
		entityManager.persist(vhc);
		return vhc;
	}
	
	public Vehicles update(Vehicles vhc){
		return entityManager.merge(vhc);
	}
	
	public void delete(Vehicles vhc){
		entityManager.remove(vhc);
	}
}
