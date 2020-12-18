package com.hana.delivery.db.model;

import java.math.BigInteger;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Builder @Data
@Entity
@Table(name="artifact")
public class Artifact {
	
	@Id 
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	@Column(name = "id")
	private BigInteger id;
	
	@Column(name = "unit_cost", precision = 5, scale = 2, nullable = false)
	@Min(0) 
	@Builder.Default private double unitCost = 0;
	
	@Column(name = "type", nullable = false)
	@Builder.Default private String type = "flower";
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "stock", precision = 3)
	@Min(0) @Max(99999)
	@Builder.Default private int stock = 0;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "artifact_id", referencedColumnName = "id", nullable = true)
	private Collection<ArtifactComponent> artifactComponents;
	
	@Tolerate
	public Artifact() {}

}
