package com.hana.delivery.db.repository;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hana.delivery.db.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, BigInteger> {
	
	@Query(value = "SELECT p FROM Product p")
	public Collection<Product> findAllProducts(Sort sort);
}
