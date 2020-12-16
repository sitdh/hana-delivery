package com.hana.delivery.db.model;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;

import lombok.Data;

@Data
@Table
@Entity(name = "product_order")
public class ProductOrder implements PreUpdateEventListener, PreInsertEventListener {

  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
  private BigInteger id;

  @Basic
  @Column(name = "created_at", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  @Basic
  @Column(name = "updated_at", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

  @Column(name = "cart_price", nullable = false, updatable = false, precision = 10, scale = 2)
  public double getCartPrice()
  {
    return 0;
  }

  public boolean onPreInsert(PreInsertEvent event)
  {

    return true;
  }
  
  public boolean onPreUpdate(PreUpdateEvent event)
  {
    this.updatedAt = new Date();

    return true;
  }
}
