package com.hana.delivery.db.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.hana.delivery.db.model.composite.BouquetComponentKey;

import lombok.Data;

@Data
@Entity
@Table(name="bouquet_component")
public class BouquetComponent {
	
	@EmbeddedId
	private BouquetComponentKey id;
	
	@ManyToOne
	@MapsId("bouquet_id")
	@JoinColumn(name="buquet_id")
	private Bouquet bouquet;
	
	@ManyToOne
	@MapsId("bouquet_garni_id")
	@JoinColumn(name="bouquet_garni_id")
	private BouquetGarni bouquetGarni;
	
	@Column(name="quality") @ColumnDefault("0")
	private double quality = 0;

	@Column(name="cost") @ColumnDefault("0")
	private double cost = 0;
	
	@Column(name="remark")
	private String remark;
}
