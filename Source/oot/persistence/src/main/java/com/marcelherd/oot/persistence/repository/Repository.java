package com.marcelherd.oot.persistence.repository;

import java.io.Serializable;
import java.util.List;

import com.marcelherd.oot.persistence.entity.Entity;

/**
 * TODO javadoc
 * 
 * @param <T>
 * @param <ID>
 * 
 * @author Marcel Herd
 */
public interface Repository<T extends Entity, ID extends Serializable> {

	T findOne(ID primaryKey);

	List<T> findAll();

	List<T> findAll(Iterable<ID> ids);

	Long count();

}
