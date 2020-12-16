package com.hana.delivery.db.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
@Table
@Entity(name = "artifact_component")
public class ArtifactComponent {

  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
  @Column(name = "id")
  private BigInteger id;

  @Column(name = "number")
  @Min(0)
  private int number = 0;

  @Column(name = "cost")
  @Min(0)
  private float cost = 0;

  @ManyToOne
  private Artifact artifact;

  @ManyToOne
  private Bouquet bouquet;

} 