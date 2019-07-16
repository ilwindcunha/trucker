package com.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.entity.Tires;

@Repository
public class TiresInterfaceImpl {
	@PersistenceContext
	private EntityManager entityManager;

	public Tires create(Tires vhc) {
		entityManager.persist(vhc);
		return vhc;
	}

	public Tires update(Tires vhc) {
		return entityManager.merge(vhc);
	}

	public void delete(Tires vhc) {
		entityManager.remove(vhc);
	}
}
