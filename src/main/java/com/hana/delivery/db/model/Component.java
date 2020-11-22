package com.hana.delivery.db.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
@Entity
@Table(name="component")
public class Component {
	
	@Id 
	@GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
	@Column(name="id")
	private BigInteger id;
	
	@Column(name="cost", precision=5, scale=2, nullable=false)
	@Min(0)
	private double cost = 0;
	
	@Column(name="type", nullable=false)
	private String type = "flower";
	
	@Column(name="name", nullable=false, length=100)
	private String name;
	
	@Column(name="stock", precision=3)
	@Min(0) @Max(999)
	private int stock = 0;
	
}
