package com.eng.it.model;


import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -4737182271966335658L;

	@Id
	@Column(name="ID")
	@GeneratedValue
	 private long id;
	 
	 @Column(name = "FIRST_NAME", nullable = false, length = 30)
	 String firstName;
	 
	 @Column(name = "LAST_NAME", nullable = false, length = 30)
	 String lastName;
	 
	 @Column(name = "E_MAIL", nullable = false, length = 30)
	 String email;
	 
	 @Column(name = "SCORE", nullable = false)
	 int score;

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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	 
	@Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", espb=" + score + "]";
    }
}
