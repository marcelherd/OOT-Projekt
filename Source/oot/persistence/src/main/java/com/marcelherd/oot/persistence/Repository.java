package com.marcelherd.oot.persistence;

import java.io.Serializable;
import java.util.List;

import com.marcelherd.oot.persistence.model.Entity;

/**
 * TODO javadoc
 * 
 * @param <T>
 * @param <ID>
 * 
 * @author Marcel Herd
 */
public interface Repository<T extends Entity, ID extends Serializable> {
	
	void save(T entity);
	
	void save(Iterable<T> entities);
	
	T findOne(ID primaryKey);
	
	List<T> findAll();
	
	List<T> findAll(Iterable<ID> ids);
	
	Long count();
	
	void delete(ID id);
	
	void delete(T entity);
	
	void delete(Iterable<T> entities);

}
