package com.hana.delivery.db.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.Builder;
import lombok.Data;

@Data @Builder
@Table
@Entity(name = "artifact_component")
public class ArtifactComponent {

  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
  @Column(name = "id")
  private BigInteger id;

  @Column(name = "quality")
  @Min(1)
  @Builder.Default private int quality = 1;

  @Column(name = "cost", updatable = false, precision = 10, scale = 2)
  @Min(0)
  @Builder.Default private double cost = 0;

  @ManyToOne(fetch = FetchType.LAZY)
  private Artifact artifact;

  @ManyToOne(fetch = FetchType.LAZY)
  @Builder.Default private Bouquet bouquet = null;

  public double getCost()
  {
    return this.getArtifact().getUnitCost() 
    		* this.getQuality();
  }
  
  @PrePersist
  private void prePersistent() {
  	this.cost = this.getCost();
  }
  
  @PreUpdate
  private void preUpdate() {
  	this.cost = this.getCost();
  }

} 