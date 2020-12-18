package com.hana.delivery.db.service;

import java.util.Collection;

public interface EntityService<T> {

	public Collection<T> list();
	
	public T insert(T entity);
}
