package com.hana.delivery.db.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hana.delivery.db.model.Bouquet;
import com.hana.delivery.db.repository.BouquetRepository;

import lombok.Getter;

@Service
public class BouquetService implements EntityService<Bouquet> {
	
	@Autowired @Getter
	private BouquetRepository bouquetRepository;

	@Transactional
	public Bouquet insert(Bouquet bouquet) {
		return this.bouquetRepository.save(bouquet);
	}

	@Override @Transactional
	public Collection<Bouquet> list() {
		return this.bouquetRepository.findAll();
	}
}
