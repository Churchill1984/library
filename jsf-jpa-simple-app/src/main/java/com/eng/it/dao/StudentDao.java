package com.eng.it.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.eng.it.model.Student;

public class StudentDao {
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void insert(Student student) {
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
	}

	public Student getStudentByUserAndPass(String userName, String password) {
		String query = "SELECT s from Student s WHERE s.userName = :name and s.password = :password";

		if (em != null) {
			try {
				return (Student) em.createQuery(query, Student.class).setParameter("name", userName)
						.setParameter("password", password).getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
		} else {
			return null;
		}
	}
}
