package com.hana.delivery.db.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name="bouquet_garni")
public class BouquetGarni {
	
	@Id 
	@GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name", nullable=false)
	@NotBlank
	private String name;
	
	@Column(name="quality", columnDefinition="DEFAULT 0")
	@Min(0)
	private int quality;
	
	@Column(name="cost_per_unit")
	@Min(0)
	private double cost;
	
	@Column(name="garni_type", nullable=false, columnDefinition="DEFAULT 'flower'")
	private String garniType;
	
	@Column(name="created_at", columnDefinition="TIMESTAMP")
	private LocalDateTime createdAt;
	
	@Column(name="updated_at", columnDefinition="TIMESTAMP")
	private LocalDateTime updatedAt;
	
	@Column(name="deleted_at", columnDefinition="TIMESTAMP")
	private LocalDateTime deletedAt;
	
}
