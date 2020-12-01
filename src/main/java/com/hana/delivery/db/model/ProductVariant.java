package com.hana.delivery.db.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.hana.delivery.db.model.composite.BCVComponentKey;

import lombok.Data;

@Data
@Entity
@Table(name="product_variant")
public class ProductVariant {
//	
//	@EmbeddedId
//	private BCVComponentKey id; 
	
	@Column(name="colour", nullable=false)
	private String colour;
	
	@Column(name="weight", nullable=false)
	private double weight;
	
	@Column(name="cost", nullable=false)
	private double cost = 0;
	
	@Column(name="image", nullable=false)
	private String image;

//	@ManyToOne
//	@JoinColumn(name="product_id", nullable=false)
//	private Collection<Bouquet> bouquets;
	
//	@ManyToOne
//	@MapsId("bouquet_component_id")
//	@JoinColumn(name="bouquet_component_id")
//	private BouquetComponent bouquetComponent;
//	
//	@ManyToOne
//	@MapsId("product_id")
//	@JoinColumn(name="product_id")
//	private Product product;
}
