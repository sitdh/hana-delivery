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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
@Entity
@Table(name="artifact")
public class Artifact {
	
	@Id 
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	@Column(name = "id")
	private BigInteger id;
	
	@Column(name = "cost", precision = 5, scale = 2, nullable = false)
	@Min(0)
	private double cost = 0;
	
	@Column(name = "type", nullable = false)
	private String type = "flower";
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "stock", precision = 3)
	@Min(0) @Max(99999)
	private int stock = 0;
	
	@OneToMany
	@JoinColumn(name = "artifact_id", referencedColumnName = "id")
	private Collection<ArtifactComponent> artifactComponents;

}
