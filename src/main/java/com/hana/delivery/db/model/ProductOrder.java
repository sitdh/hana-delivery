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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.RandomStringUtils;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data 
@Builder
@Table
@Entity(name = "product_order")
public class ProductOrder {

  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
  private BigInteger id;
  
  @Column(name = "order_key", updatable = false)
  private String orderKey;

  @Basic
  @Column(name = "created_at", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  @Basic
  @Column(name = "updated_at", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

  @OneToMany
  @JoinColumn(name = "product_order_id", referencedColumnName = "id", nullable = true)
  private Collection<ProductOrderLine> productOrderLine;

  @Column(name = "cart_price", nullable = false, updatable = false, precision = 10, scale = 2)
  @Builder.Default protected double cartPrice = 0;
  
  @Column(name = "item_quantity", updatable = false)
  @Builder.Default protected int itemQuantity = 0;
  
  @ManyToOne
  private PaymentInformation paymentInformation;
  
  @OneToOne(mappedBy = "productOrder")
  private OrderDelivery orderDelivery;
  
  @Tolerate
  public ProductOrder() {}

  public double getCartPrice()
  {
    return (this.getProductOrderLine() == null) 
				? 0.0
    		: this.productOrderLine.stream().mapToDouble(ProductOrderLine::getPrice).sum() ;
  }

  @PrePersist
  private void onPreInsert()
  {
  	this.orderKey = RandomStringUtils.random(12, "ABVCDEFGHIJKLMNOPQRSTUVWZ1234567890");
  	this.cartPrice = this.getCartPrice();
  	this.itemQuantity = this.getProductOrderLine() == null
  			? 0
				: this.getProductOrderLine().size() ;
		this.createdAt = new Date();
		this.updatedAt = new Date();
  }
  
  @PreUpdate
  public void onPreUpdate()
  {
    this.updatedAt = new Date();
  	this.cartPrice = this.getCartPrice();
  	this.itemQuantity = this.getProductOrderLine() == null
  			? 0
				: this.getProductOrderLine().size() ;
  	this.updatedAt = new Date();
  }
}
