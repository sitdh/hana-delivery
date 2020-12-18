package com.hana.delivery.db.model;

import java.math.BigInteger;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.Builder;
import lombok.Data;

@Data @Builder
@Table
@Entity(name = "bouquet")
public class Bouquet {

  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
  private BigInteger id;

  @Column(name = "name", length = 100, nullable = false)
  private String name;

  @Column(name = "cost", precision = 5, scale = 2) 
  @Min(0)
  @Builder.Default private double cost = 0;

  @Column(name = "image_location", length = 200, nullable = false)
  private String imageLocation;

  @OneToMany
	@JoinColumn(name = "bouquet_id", referencedColumnName = "id")
  private Collection<ArtifactComponent> artifactComponents;
  
  public double getCost() {
  	return this.getArtifactComponents().stream()
  			.mapToDouble(ArtifactComponent::getCost)
  			.sum();
  }

}
