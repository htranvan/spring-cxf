package com.tsp.dao;

public interface IGeneralDao<E, ID> {

	public E get(ID id);
	
	public ID save(E entity);
}
