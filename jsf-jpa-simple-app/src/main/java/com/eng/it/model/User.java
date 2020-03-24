package com.eng.it.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false)
	private long id;
	@Column(name = "USER_NAME", unique = true, nullable = false)
	private String username;
	@Column(name = "PASSWORD", unique = true, nullable = false)
	private String password;
	@Column(name = "E_MAIL", unique = true)
	private String eMail;
	@Column(name = "CREATE_DATE", updatable = false, nullable = false)
	private LocalDate createDate = LocalDate.now();
	@Column(name = "EDIT_DATE", nullable = true)
	private LocalDate editDate;
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
	private Person person;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getEditDate() {
		return editDate;
	}

	public void setEditDate(LocalDate editDate) {
		this.editDate = editDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
