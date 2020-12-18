package com.hana.delivery.db.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hana.delivery.db.model.OrderDelivery;

@Repository
public interface OrderDeliveryRepository extends JpaRepository<OrderDelivery, BigInteger> {

}
