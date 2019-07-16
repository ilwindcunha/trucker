package com.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.entity.Priority;

@Repository
public class PriorityRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public Priority create(Priority vhc){
		entityManager.persist(vhc);
		return vhc;
	}
	
	public Priority update(Priority vhc){
		return entityManager.merge(vhc);
	}
	
	public void delete(Priority vhc){
		entityManager.remove(vhc);
	}
}
