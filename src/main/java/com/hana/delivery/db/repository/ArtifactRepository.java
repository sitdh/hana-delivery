package com.hana.delivery.db.repository;

import java.math.BigInteger;

import com.hana.delivery.db.model.Artifact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, BigInteger>  {
}
