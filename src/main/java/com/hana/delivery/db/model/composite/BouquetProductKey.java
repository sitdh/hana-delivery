package com.hana.delivery.db.model.composite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Embeddable
public class BouquetProductKey implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 2125051115164346270L;

	@Column(name="bouquet_id")
	private Integer bouquetId;
	
	@Column(name="product_variant_id")
	private Integer productVariantId;
}
