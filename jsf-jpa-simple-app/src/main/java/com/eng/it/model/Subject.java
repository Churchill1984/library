package com.eng.it.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3884122431790982769L;

	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "NAME", nullable = false, unique = true)
	private String name;

	@Column(name = "ESPB", nullable = false, unique = true)
	private int espb;

	@Column(name = "ACTIVE")
	private boolean active = true;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
