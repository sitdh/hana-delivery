package com.hana.delivery.db.model;

import java.math.BigInteger;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
  @Column(name = "id")
  private BigInteger id;

  @Column(nullable = false, length = 100)
  private String productName;

  @Column(nullable = false)
  @Type(type = "text")
  private String description;

  @Column(name = "stock", precision = 5)
  @Min(0)
  private int stock = 0;

  @Column(name = "remain", precision = 5)
  @Min(0)
  private int remain = 0;

  @Column(name = "margin", precision = 10, scale = 2)
  private double margin;

  @Column(name = "discount", precision = 1, scale = 5)
  @Min(0) @Max(1)
  private double discount = 0;

  @OneToMany
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Collection<Bouquet> bouquets;

  @Column(name = "product_cost", updatable = false, precision = 10, scale = 2)
  public double productCost()
  {
    return this.bouquets.stream().map(b -> b.getCost()).reduce(0, Decimal::sum);
  }

  @Column(name = "product_price", updatable = false, precision = 10, scale = 2)
  public double productPrice()
  {
    return 0;
  }
}
