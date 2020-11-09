package com.hana.delivery.db.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="bouquet_component")
public class BouquetComponent {
	
	@Id
	@Column(name="garni_id")
	private BouquetGarni garniId;
	
	private double quality;
	
	private double cost;
}
