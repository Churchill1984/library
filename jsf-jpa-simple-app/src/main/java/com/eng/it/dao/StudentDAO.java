package com.eng.it.dao;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.Query;

 

import com.eng.it.model.Student;

public class StudentDAO {

	 private EntityManager entityManager;

	    public Student findById(Long id) {
	        return entityManager.find(Student.class, id);
	    }

	    public void insert(Student student) {
	        entityManager.getTransaction().begin();
	        entityManager.persist(student);
	        entityManager.getTransaction().commit();
	    }

	    public void update(Student student) {
	        entityManager.getTransaction().begin();
	        entityManager.merge(student);
	        entityManager.getTransaction().commit();
	    }
	 
	    public void delete(Student student) {
	        entityManager.getTransaction().begin();
	        entityManager.remove(student);
	        entityManager.getTransaction().commit();
	    }
	    public List<Student> getAllStudents() {
	         return entityManager.createQuery("select s from Student s", Student.class).getResultList();
	        
	    }

	    public EntityManager getEntityManager() {
	        return entityManager;
	    }

	    public void setEntityManager(EntityManager entityManager) {
	        this.entityManager = entityManager;
	    }
}
