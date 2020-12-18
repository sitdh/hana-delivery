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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
  @Column(name = "id")
  @Getter @Setter
  private BigInteger id;

  @Column(nullable = false, length = 100)
  @Getter @Setter
  private String productName;

  @Column(nullable = false)
  @Type(type = "text")
  @Getter @Setter
  private String description;

  @Column(name = "stock", precision = 5)
  @Min(0)
  @Getter @Setter
  private int stock = 0;

  @Column(name = "remain", precision = 5)
  @Min(0)
  @Getter @Setter
  private int remain = 0;

  @Column(name = "margin_rate", precision = 4, scale = 2)
  @Getter @Setter
  private double marginRate = 1;

  @Column(name = "management_cost", precision = 4, scale = 2)
  @Getter @Setter
  private double managementCost = 1;

  @Column(name = "discount", precision = 1, scale = 5)
  @Min(0) @Max(1)
  @Getter @Setter
  private double discount = 1;

  @OneToMany
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Collection<Bouquet> bouquets;

  @OneToMany
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Collection<ProductOrderLine> productOrderLines;
  
  @Column(name = "price", updatable = false, precision = 10, scale = 2)
  private double price;

  public double getPrice()
  {
    return this.bouquets
    		.stream()
    		.mapToDouble(Bouquet::getCost)
    		.sum() 
    		* this.getMarginRate()
        * this.getDiscount()
        * this.getManagementCost();
  }

}
