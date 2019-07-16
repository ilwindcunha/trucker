package com.service;

import java.util.List;

import com.entity.Readings;

public interface ReadingService {
	 List<Readings> findAll();

	 Readings findOne(String id);

	 Readings create(Readings rd);

	 Readings update(String id, Readings rd);

	 void delete(String id);
}
