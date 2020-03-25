package com.eng.it.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.eng.it.dao.ProfessorDao;
import com.eng.it.model.Professor;

@Named
@RequestScoped
public class ProfessorController {

	@Inject
	private EntityManager entityManager;
	private Professor professor;
	private ProfessorDao professorDao;
	private List<Professor> professors;

	@PostConstruct
	public void init() {
		professorDao = new ProfessorDao();
		professorDao.setEntityManager(entityManager);
		professors = professorDao.getAllProfessors();
		professor=new Professor();
	}

	public String addProfessor() {
		professorDao.insert(professor);		
		return "professor.xhtml?faces-redirect=true";
	}
	
	public String redirectToAddProfessor() {
		return "addProfessor";
	}

	public ProfessorDao getProfessorDao() {
		return professorDao;
	}

	public void setProfessorDao(ProfessorDao professorDao) {
		this.professorDao = professorDao;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}
