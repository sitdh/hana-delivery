package com.hana.delivery.db.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hana.delivery.db.model.ArtifactComponent;

public interface ArtifactComponentRepository extends JpaRepository<ArtifactComponent, BigInteger> {
}
