package com.marcelherd.oot.persistence.repository;

import java.io.Serializable;
import java.util.List;

import com.marcelherd.oot.persistence.domain.Entity;

/**
 * This interface defines methods to interact with the given domain types
 * on the database.
 * 
 * @param <T> - the domain type, that the repository manages
 * @param <ID> - the type of the id of the entity, that the repository manages
 * 
 * @author Marcel Herd
 */
public interface Repository<T extends Entity, ID extends Serializable> {
	
	/**
	 * Saves the given entity.
	 * 
	 * @param entity - entity to be saved
	 */
	void save(T entity);

	/**
	 * Retrieves an entity by its id.
	 * 
	 * @param id - ID of the entity to look up
	 * @return the entity with the given id
	 */
	T findOne(ID id);

	/**
	 * Returns all entities.
	 * 
	 * @return all entities
	 */
	List<T> findAll();

	/**
	 * Returns all entities with the given IDs.
	 * 
	 * @param ids - IDs of the entities to look up
	 * @return all entities with the given IDs
	 */
	List<T> findAll(Iterable<ID> ids);

	/**
	 * Returns the number of entities available.
	 * 
	 * @return the number of entities available
	 */
	Long count();

}
