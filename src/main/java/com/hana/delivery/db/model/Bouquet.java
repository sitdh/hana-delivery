package com.hana.delivery.db.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
@Entity
@Table(name="bouquet")
public class Bouquet {

	@Id
	@GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="cost", nullable=false)
	@Min(0)
	private double cost = 0;
	
	@Column(name="price", nullable=false)
	@Min(0)
	private double price = 0;
	
	@Column(name="remain", nullable=false)
	@Min(0)
	private Integer remain = 0;
	
	@Column(name="stock", nullable=false)
	@Min(0)
	private Integer stock = 0;
	
	@OneToMany(mappedBy="bouquet")
	private Set<BouquetComponent> component;
	
}
