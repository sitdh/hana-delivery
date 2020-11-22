package com.hana.delivery.db.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product_variant")
public class ProductVariant {
	
	@Id
	@GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
	private Integer id;
	
	@Column(name="product", nullable=false)
	private BouquetProduct productBouquet;
	
	@Column(name="colour", nullable=false)
	private String colour;
	
	@Column(name="weight", nullable=false)
	private double weight;
	
	@Column(name="cost", nullable=false)
	private double cost = 0;
	
	@Column(name="image", nullable=false)
	private String image;

	@ManyToOne
	@JoinColumn(name="product_id", nullable=false)
	private Collection<BouquetProduct> bouquets;
}
