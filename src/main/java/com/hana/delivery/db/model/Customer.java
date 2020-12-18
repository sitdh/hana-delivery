package com.hana.delivery.db.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data @Builder
@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private BigInteger id;
	
	@Column(name = "name", length = 200, nullable = false)
	private String name;
	
	@Column(name = "profile_location", length = 100, nullable = false)
	private String profileLocation;
	
	@Basic
	@Column(name = "created_at")
	private Date createdAt;
	
	@Basic
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Tolerate
	public Customer() {}
	
	@PrePersist
	private void prePersist() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	@PreUpdate
	private void preUpdate() {
		this.updatedAt = new Date();
	}
	
}
