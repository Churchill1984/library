package com.eng.it.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.MoveEvent;
import org.primefaces.event.RowEditEvent;

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
		professor = new Professor();
	}

	public String addProfessor() {
		professorDao.insert(professor);
		return "professor.xhtml?faces-redirect=true";
	}

	public String deleteProfessor(Professor professor) {
		professorDao.delete(professor);
		professors.remove(professor);
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
	
    //for update
	public void onRowEdit(RowEditEvent<Professor> event) {
		professorDao.update(event.getObject());
		FacesMessage msg = new FacesMessage("Professor Updated");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Professor> event) {
		FacesMessage msg = new FacesMessage("Update Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	 //for delete

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
