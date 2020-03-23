package com.eng.it.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4791198130484930386L;

	@Id
	@Column(name = "ID", updatable = false, nullable = false)
	private long id;
	@Column(name = "STREET", updatable = true, nullable = false)
	private String street;
	@Column(name = "CITY", updatable = true, nullable = false)
	private String city;
	@Column(name = "COUNTRY", updatable = true, nullable = false)
	private String country;
	@Column(name = "POSTAL_CODE", updatable = true, nullable = false)
	private int postalCode;
	@OneToOne(fetch=FetchType.LAZY, mappedBy="address")
	private Student student;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

}
