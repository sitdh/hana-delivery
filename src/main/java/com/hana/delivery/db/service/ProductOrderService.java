package com.hana.delivery.db.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hana.delivery.db.model.ProductOrder;
import com.hana.delivery.db.repository.ProductOrderRepository;

import lombok.Getter;

@Service
public class ProductOrderService implements EntityService<ProductOrder> {
	
	@Autowired @Getter
	private ProductOrderRepository productOrderRepository;

	@Override @Transactional
	public Collection<ProductOrder> list() {
		return this.productOrderRepository.findAll();
	}

	@Override
	public ProductOrder insert(ProductOrder entity) {
		return this.getProductOrderRepository().save(entity);
	}
}
