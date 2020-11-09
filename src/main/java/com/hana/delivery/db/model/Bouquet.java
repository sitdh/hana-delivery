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
@Table(name="bouquet")
public class Bouquet {

	@Id
	@GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	private String name;
	
	private double cost;
	
	private double price;
	
	private Integer quality;
	
	private Integer stock;
	
	private List<BouquetComponent> flowers;
	
	private List<BouquetComponent> accessory;
}
