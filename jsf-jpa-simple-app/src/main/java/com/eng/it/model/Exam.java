package com.eng.it.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exam")
public class Exam implements Serializable {

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
	@Column(name = "EXAM_DATE", nullable = false)
	private LocalDate examDate;
	@Column(name = "STATUS", nullable = false)
	private boolean status = false;
	@ManyToMany
	@JoinTable(name = "exam_subject", joinColumns = @JoinColumn(name = "EXAM_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "SUBJECT_ID", referencedColumnName = "ID"))
	private List<Subject> listOfSubjects;

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

	public LocalDate getExamDate() {
		return examDate;
	}

	public void setExamDate(LocalDate examDate) {
		this.examDate = examDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Subject> getListOfSubjects() {
		return listOfSubjects;
	}

	public void setListOfSubjects(List<Subject> listOfSubjects) {
		this.listOfSubjects = listOfSubjects;
	}

}
