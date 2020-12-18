package com.hana.delivery.db.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hana.delivery.db.model.ProductOrderLine;
import com.hana.delivery.db.repository.ProductOrderLineRepository;

import lombok.Getter;

@Service
public class ProductOrderLineService implements EntityService<ProductOrderLine> {
	
	@Autowired @Getter
	protected ProductOrderLineRepository productOrderLineRepository;

	@Override
	public Collection<ProductOrderLine> list() {
		return this.productOrderLineRepository.findAll();
	}

	@Override
	public ProductOrderLine insert(ProductOrderLine entity) {
		return this.productOrderLineRepository.save(entity);
	}

}
