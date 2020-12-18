package com.hana.delivery.db.model;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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

@Builder
@Data
@Table
@Entity(name = "payment_information")
public class PaymentInformation {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private BigInteger id;
	
	// Credit card, Transfer, Cash
	@Column(name = "payment_channel")
	private String paymentChannel;
	
	@OneToMany
	@JoinColumn(name = "product_order_id", referencedColumnName = "id", nullable = true)
	private Collection<ProductOrder> productOrder;
	
	@Column(name = "payment_status")
	private String paymentStatus;
	
	@Basic
	@Column(name = "transaction_timestamp")
	private Date transactionTimestamp;
	
	@Basic
	@Column(name = "created_at")
	private Date createdAt;
	
	@Basic
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Tolerate
	public PaymentInformation() {}
	
	@PrePersist
	private void prePersist() {
		this.transactionTimestamp = (null == this.transactionTimestamp)
				? this.transactionTimestamp 
				: new Date() ;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	@PreUpdate
	private void preUpdate() {
		this.updatedAt = new Date();
	}

}
