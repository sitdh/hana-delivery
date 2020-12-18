package com.hana.delivery.db.model;

import java.math.BigInteger;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.Type;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Entity @Builder
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
  @Builder.Default private int stock = 0;

  @Column(name = "remain", precision = 5)
  @Min(0)
  @Getter @Setter
  @Builder.Default private int remain = 0;

  @Column(name = "margin_rate", precision = 4, scale = 2)
  @Getter @Setter
  @Builder.Default private double marginRate = 1;

  @Column(name = "management_cost", precision = 4, scale = 2)
  @Getter @Setter
  @Builder.Default private double managementCost = 0;

  @Column(name = "discount", precision = 1, scale = 5)
  @Min(0) @Max(1)
  @Getter @Setter
  @Builder.Default private double discount = 0;

  @Getter @Setter
  @ManyToOne(fetch = FetchType.LAZY)
  private Bouquet bouquet;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = true)
  private Collection<ProductOrderLine> productOrderLines;
  
  @Column(name = "price", updatable = false, precision = 5, scale = 2)
  @Builder.Default private double price = 0;
  
  @Tolerate
  public Product() {}

  public double getPrice()
  {
    return (this.bouquet.getCost() + this.getManagementCost()) 
    		* this.getMarginRate()
        * (1 - this.getDiscount());
  }
  
  @PrePersist
  private void prePersist() {
  	this.price = this.getPrice();
  	if (this.getProductName().length() == 0) {
  		this.setProductName(this.getBouquet().getName());
  	}
  }
  
  @PreUpdate
  private void preUpdate() {
  	this.price = this.getPrice();
  	if (this.getProductName().length() == 0) {
  		this.setProductName(this.getBouquet().getName());
  	}
  }

}
