package com.hana.delivery.db.model.composite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Embeddable
public class BouquetComponentKey implements Serializable {

	@Transient
	private static final long serialVersionUID = 4746895878497419499L;
	
	@Column(name="component_id")
	private Integer componentId;
	
	@Column(name="bouquet_id")
	private Integer bouquetId;

}
