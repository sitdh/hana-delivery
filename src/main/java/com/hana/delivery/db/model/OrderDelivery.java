package com.hana.delivery.db.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.apache.commons.lang3.RandomStringUtils;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Builder
@Data
@Table
@Entity(name = "order_delivery")
public class OrderDelivery {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private BigInteger id;
	
	@OneToOne
	@JoinColumn(name = "product_order_id", referencedColumnName = "id", nullable = true)
	private ProductOrder productOrder;
	
	@ManyToOne
	private Driver driver;
	
	@Column(name = "tracking_code", nullable = false, length = 10)
	private String trackingCode;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Tolerate
	public OrderDelivery() {}
	
	@PrePersist
	private void prePersist() {
		this.trackingCode = RandomStringUtils.random(10, "ABCDEFGIHJKLMNOPQRSTUVWXYZ1234567890");
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

}
