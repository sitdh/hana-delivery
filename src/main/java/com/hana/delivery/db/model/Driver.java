package com.hana.delivery.db.model;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
@Table
@Entity(name = "driver")
public class Driver {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private BigInteger id;
	
	@Column(name = "driver_license", nullable = false)
	private String driverLicense;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "address", nullable = true)
	private String address;
	
	@Basic
	@Column(name = "license_expired", nullable = true)
	private Date licenseExpired;
	
	@Basic
	@Column(name = "registered_at", nullable = true)
	private Date registredAt;
	
	@Basic
	@Column(name = "created_at", nullable = true)
	private Date createdAt;
	
	@Basic
	@Column(name = "updated_at", nullable = true)
	private Date updatedAt;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "driver_id", referencedColumnName = "id", nullable = true)
	private Collection<OrderDelivery> delivers;
	
	@Tolerate
	public Driver() {}
	
	@PrePersist
	protected void prePersist() {
		this.licenseExpired = new Date();
		this.registredAt = new Date();
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	@PreUpdate
	protected void preUpdate() {
		this.updatedAt = new Date();
	}

}
