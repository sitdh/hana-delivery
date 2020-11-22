package com.hana.delivery.db.model;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.hana.delivery.db.model.composite.BouquetProductKey;

public class BouquetProduct {
	
	@EmbeddedId
	private BouquetProductKey bouquetProduct;
	
	@ManyToOne
	@MapsId("product_variant_id")
	@JoinColumn(name="product_variant_id")
	private ProductVariant product;
	
	@ManyToOne
	@MapsId("bouquet_id")
	@JoinColumn(name="bouquet_id")
	private Bouquet bouquet;

}
