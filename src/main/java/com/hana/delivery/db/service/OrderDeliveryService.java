package com.hana.delivery.db.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hana.delivery.db.model.OrderDelivery;
import com.hana.delivery.db.repository.OrderDeliveryRepository;

@Service
public class OrderDeliveryService implements EntityService<OrderDelivery> {
	
	@Autowired
	private OrderDeliveryRepository orderDeliverRepository;

	@Override
	public Collection<OrderDelivery> list() {
		return this.orderDeliverRepository.findAll();
	}

	@Override
	public OrderDelivery insert(OrderDelivery entity) {
		return this.orderDeliverRepository.save(entity);
	}

}
