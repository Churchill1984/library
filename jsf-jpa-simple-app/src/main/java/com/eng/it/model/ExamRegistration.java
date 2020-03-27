package com.eng.it.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exam_registration")
public class ExamRegistration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4913792469853069389L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private long id;
	@Column(name = "NAME", nullable = false, unique = true)
	private String name;
	@Column(name = "REGISTRATION_FROM", nullable = false)
	private LocalDate registrationFrom;
	@Column(name = "REGISTRATION_TO", nullable = false)
	private LocalDate registrationTo;
	@Column(name = "EXAM_FROM", nullable = false)
	private LocalDate examFrom;
	@Column(name = "EXAM_TO", nullable = false)
	private LocalDate examTo;

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

	public LocalDate getRegistrationFrom() {
		return registrationFrom;
	}

	public void setRegistrationFrom(LocalDate registrationFrom) {
		this.registrationFrom = registrationFrom;
	}

	public LocalDate getRegistrationTo() {
		return registrationTo;
	}

	public void setRegistrationTo(LocalDate registrationTo) {
		this.registrationTo = registrationTo;
	}

	public LocalDate getExamFrom() {
		return examFrom;
	}

	public void setExamFrom(LocalDate examFrom) {
		this.examFrom = examFrom;
	}

	public LocalDate getExamTo() {
		return examTo;
	}

	public void setExamTo(LocalDate examTo) {
		this.examTo = examTo;
	}

}
