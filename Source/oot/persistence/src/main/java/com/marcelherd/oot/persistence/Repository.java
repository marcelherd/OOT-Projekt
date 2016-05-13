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
	
	default void save(Iterable<T> entities) {
		for (T entity : entities) {
			save(entity);
		}
	}
	
	T findOne(ID primaryKey);
	
	List<T> findAll();
	
	List<T> findAll(Iterable<ID> ids);
	
	Long count();
	
	void delete(ID id);
	
	void delete(T entity);
	
	default void delete(Iterable<T> entities) {
		for (T entity : entities) {
			delete(entity);
		}
	}

}
