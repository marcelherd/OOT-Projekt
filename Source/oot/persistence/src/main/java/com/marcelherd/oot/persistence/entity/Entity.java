package com.marcelherd.oot.persistence.entity;

import java.io.Serializable;

/**
 * An entity is a persistence domain object.
 * 
 * @author Marcel Herd
 */
public abstract class Entity implements Serializable {

	private static final long serialVersionUID = 617155370226192117L;
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
