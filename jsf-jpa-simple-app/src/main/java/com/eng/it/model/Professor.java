package com.eng.it.model;

import java.io.Serializable;
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
@Table(name = "professor")
public class Professor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6922395658493307035L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@Column(name = "FIRST_NAME", nullable = false, length = 30)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false, length = 30)
	private String lastName;

	@Column(name = "E_MAIL", nullable = false, length = 30)
	private String email;

	@ManyToMany
	@JoinTable(name = "professor_subject",
	joinColumns = @JoinColumn(name = "PROFESSOR_ID",referencedColumnName="ID"),
	inverseJoinColumns = @JoinColumn(name = "SUBJECT_ID",referencedColumnName="ID"))
	private List<Subject> listOfSubjects;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Subject> getListOfSubjects() {
		return listOfSubjects;
	}

	public void setListOfSubjects(List<Subject> listOfSubjects) {
		this.listOfSubjects = listOfSubjects;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

}
