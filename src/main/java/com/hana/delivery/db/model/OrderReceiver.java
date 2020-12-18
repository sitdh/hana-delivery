package com.hana.delivery.db.model;

import java.math.BigInteger;

import lombok.experimental.Tolerate;

public class OrderReceiver {
	
	private BigInteger id;
	
	private String name;
	
	private String address;
	
	@Tolerate
	public OrderReceiver() {}

}
