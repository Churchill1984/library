package com.eng.it.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.eng.it.model.Professor;

public class ProfessorDao {

	private EntityManager entityManager;

	public void insert(Professor professor) {
		entityManager.getTransaction().begin();
		entityManager.persist(professor);
		entityManager.getTransaction().commit();
	}

	public void update(Professor professor) {
		entityManager.getTransaction().begin();
		entityManager.merge(professor);
		entityManager.getTransaction().commit();
	}

	public void delete(Professor professor) {
		entityManager.getTransaction().begin();
		entityManager.remove(professor);
		entityManager.getTransaction().commit();
	}
	
	public List<Professor> getAllProfessors() {
		return entityManager.createQuery("select p from Professor p", Professor.class).getResultList();

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
