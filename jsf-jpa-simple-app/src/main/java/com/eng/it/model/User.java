package com.eng.it.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "User")
public class User {

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "userName", nullable = false, unique = true)
	private String nameUser;

	@Column(name = "password", nullable = false, unique = true)
	private String password;

	@Column(name = "lastAccess", unique = true)
	@Temporal(TemporalType.DATE)
	private Date lastAccess;

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, lastAccess, nameUser, password);
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Neke izmene, za probu");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id && Objects.equals(lastAccess, other.lastAccess)
				&& Objects.equals(nameUser, other.nameUser) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", nameUser=");
		builder.append(nameUser);
		builder.append(", password=");
		builder.append(password);
		builder.append(", lastAccess=");
		builder.append(lastAccess);
		builder.append("]");
		return builder.toString();
	}

}
