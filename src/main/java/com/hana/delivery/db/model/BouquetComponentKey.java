package com.hana.delivery.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class BouquetComponentKey implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4746895878497419499L;
	
	@Column(name="bouquet_garni_id")
	private Integer bouquetGarniId;
	
	@Column(name="bouquet_id")
	private Integer bouquetId;

}
