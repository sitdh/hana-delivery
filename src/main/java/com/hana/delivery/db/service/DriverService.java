package com.hana.delivery.db.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.hana.delivery.db.model.Driver;
import com.hana.delivery.db.repository.DriverRepository;

public class DriverService implements EntityService<Driver> {
	
	@Autowired
	private DriverRepository driverRepository;

	@Override
	public Collection<Driver> list() {
		return this.driverRepository.findAll();
	}

	@Override
	public Driver insert(Driver entity) {
		return this.driverRepository.save(entity);
	}

}
