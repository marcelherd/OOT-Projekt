package com.marcelherd.oot.persistence.entity;

import java.io.Serializable;

/**
 * TODO javadoc
 * 
 * @author Marcel Herd
 */
public abstract class Entity implements Serializable {
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
