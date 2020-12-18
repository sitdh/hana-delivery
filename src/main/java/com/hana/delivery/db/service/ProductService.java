package com.hana.delivery.db.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hana.delivery.db.model.Product;
import com.hana.delivery.db.repository.ProductRepository;

import lombok.Getter;

@Service
public class ProductService implements EntityService<Product> {
	
	@Autowired @Getter
	private ProductRepository productRepository;

	@Override
	public Collection<Product> list() {
		return this.getProductRepository().findAll();
	}

	@Override @Transactional
	public Product insert(Product entity) {
		return this.getProductRepository().save(entity);
	}

}
