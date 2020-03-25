package com.eng.it.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.eng.it.dao.SubjectDao;
import com.eng.it.model.Subject;

@Named
@RequestScoped
public class SubjectController {

	@Inject
	private EntityManager entityManager;

	private SubjectDao subjectDao;

	private List<Subject> subjectsList;

	private Subject selectedSubject = null;

	@PostConstruct
	public void init() {
		subjectDao = new SubjectDao();
		subjectDao.setEntityManager(entityManager);
		subjectsList = subjectDao.getAllSubjects();
	}

	public String addSubject() {
		return "addSubject";
	}

	public String updateSubject() {
		return "addSubject";
	}

	public void deleteSubject() {

		if (selectedSubject != null) {
			subjectDao.delete(selectedSubject);
			subjectsList.remove(selectedSubject);

			selectedSubject = null;
		} else {
			FacesMessage msg = new FacesMessage("You need to select subject in table, which you wanna delete...");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public List<Subject> getSubjectsList() {
		return subjectsList;
	}

	public void setSubjectsList(List<Subject> subjectsList) {
		this.subjectsList = subjectsList;
	}

	public Subject getSelectedSubject() {
		return selectedSubject;
	}

	public void setSelectedSubject(Subject selectedSubject) {
		this.selectedSubject = selectedSubject;
	}

}
