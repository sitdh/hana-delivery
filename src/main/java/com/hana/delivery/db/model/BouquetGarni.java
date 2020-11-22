package com.hana.delivery.db.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

//@Data
//@Entity
//@Table(name="bouquet_garni")
public class BouquetGarni {
	
//	@Id 
//	@GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
//	@Column(name="id")
//	private Integer id;
//	
//	@NotBlank
//	@Column(name="name", nullable=false)
//	private String name;
	
	@Min(0) 
	@Column(name="quality")
	private int quality = 0;
	
//	@Min(0) 
//	@Column(name="cost_per_unit")
//	private double cost = 0;
//	
//	@Column(name="garni_type")
//	private String garniType = "flower";
//	
//	@OneToMany(mappedBy="bouquetGarni")
//	private Set<BouquetComponent> component;
	
}
