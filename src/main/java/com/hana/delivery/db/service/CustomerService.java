package com.hana.delivery.db.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hana.delivery.db.model.Customer;
import com.hana.delivery.db.repository.CustomerRepository;

import lombok.Getter;

@Service
public class CustomerService implements EntityService<Customer> {
	
	@Autowired @Getter
	protected CustomerRepository customerRepository;

	@Override
	public Collection<Customer> list() {
		return this.customerRepository.findAll();
	}

	@Override
	public Customer insert(Customer entity) {
		return this.customerRepository.save(entity);
	}

}
