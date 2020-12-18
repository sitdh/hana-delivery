package com.hana.delivery.db.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hana.delivery.db.model.ArtifactComponent;
import com.hana.delivery.db.repository.ArtifactComponentRepository;

import lombok.Getter;

@Service
public class ArtifactComponentService implements EntityService<ArtifactComponent> {

	@Autowired @Getter
	private ArtifactComponentRepository artifactComponentRepository;
	
	public Collection<ArtifactComponent> list() {
		return this.getArtifactComponentRepository().findAll();
	}

	@Override
	@Transactional
	public ArtifactComponent insert(ArtifactComponent entity) {
		return this.artifactComponentRepository.save(entity);
	}
}
