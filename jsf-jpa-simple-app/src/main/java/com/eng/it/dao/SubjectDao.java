package com.eng.it.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.eng.it.model.Subject;

public class SubjectDao {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void insert(Subject subject) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(subject);
		entityManager.getTransaction().commit();

	}

	public List<Subject> getAllSubjects() {
		return entityManager.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
	}

}
