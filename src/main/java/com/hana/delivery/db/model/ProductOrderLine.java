package com.hana.delivery.db.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;


import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data @Builder
@Table
@Entity(name = "product_order_line")
public class ProductOrderLine {

  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
  @Column(name = "id")
  private BigInteger id;

  @Column(name = "quantity", nullable = false)
  @Min(0)
  @Builder.Default private int quantity = 0;

  @ManyToOne
  private Product product;
  
  @ManyToOne
  private ProductOrder productOrder;
  
  @Column(name = "price", precision = 10, scale = 2, updatable = false)
  @Builder.Default private double price = 0;
  
  @Basic
  @Column(name = "created_at")
  private Date createdAt;
  
  @Basic
  @Column(name = "updated_at")
  private Date updatedAt;
  

  @Tolerate
  public ProductOrderLine() {}

  public double getPrice() {
    return this.getProduct().getPrice() * this.getQuantity();
  }

  
  @PrePersist
  public void prePersist() {
  	this.price = this.getPrice();
  	this.createdAt = new Date();
  	this.updatedAt = new Date();
  }

  @PreUpdate
  public void preUpdate() {
  	this.price = this.getPrice();
  	this.updatedAt = new Date();
  }
}
