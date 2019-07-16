package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.entity.Tires;


public interface TiresInterface extends CrudRepository<Tires, String> {
}