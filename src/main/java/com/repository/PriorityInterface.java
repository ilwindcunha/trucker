package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.entity.Tires;

public interface PriorityInterface extends CrudRepository<Tires, String> {
}