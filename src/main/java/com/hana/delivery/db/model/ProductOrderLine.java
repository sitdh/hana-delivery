package com.hana.delivery.db.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

@Table
@Entity(name = "product_order_line")
public class ProductOrderLine {

  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
  @Column(name = "id") @Getter @Setter
  private BigInteger id;

  @Column(name = "quantity", nullable = false)
  @Min(0) @Getter @Setter
  private int quantity = 0;

  @ManyToOne @Getter @Setter
  private Product product;
  
  @Column(name = "price", precision = 10, scale = 2, updatable = false)
  private double price;

  public double getPrice()
  {
    return this.getProduct().getPrice() * this.getQuantity();
  }
}
