package com.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.entity.Readings;


@Repository
public class ReadingRepositioryImpl {
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public Readings create(Readings vhc){
		entityManager.persist(vhc);
		return vhc;
	}
	
	public Readings update(Readings vhc){
		return entityManager.merge(vhc);
	}
	
	public void delete(Readings vhc){
		entityManager.remove(vhc);
	}
}