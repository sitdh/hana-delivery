package com.hana.delivery.db.service;

import java.util.Collection;

import javax.transaction.Transactional;

import com.hana.delivery.db.model.Artifact;
import com.hana.delivery.db.repository.ArtifactRepository;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtifactService implements EntityService<Artifact> {

  @Autowired @Getter
  private ArtifactRepository artifactRepository;

  public Collection<Artifact> list() {
    return this.artifactRepository.findAll();
  }

  @Transactional
  public Artifact insert(Artifact artifact) {
    return this.artifactRepository.save(artifact);
  }
}
