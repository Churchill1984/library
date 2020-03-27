package com.eng.it.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.event.RowEditEvent;

import com.eng.it.dao.SubjectDao;
import com.eng.it.model.Subject;

@Named
@RequestScoped
public class SubjectController {

	private static final String ADD_SUBJECT = "addSubject";

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
		return ADD_SUBJECT;
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

	public void onRowEdit(RowEditEvent<Subject> event) {
		subjectDao.update(event.getObject());

		FacesMessage msg = new FacesMessage("Subject Edited");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String onRowDelite(Subject subject) {
		subjectDao.delite(subject);
		subjectsList.remove(subject);

		FacesMessage msg = new FacesMessage("Subject deleted");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		return "/subject.xhtml?faces-redirect=true";
	}

	public void onRowCancel() {
		FacesMessage msg = new FacesMessage("Subject Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	// for delete
	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
