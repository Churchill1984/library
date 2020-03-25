package com.eng.it.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.eng.it.model.Professor;

public class ProfessorDao {

	private EntityManager entityManager;
	
	

	public Professor findById(Long id) {
		return entityManager.find(Professor.class, id);
	}

	public void insert(Professor professor) {
		entityManager.getTransaction().begin();
		entityManager.persist(professor);
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