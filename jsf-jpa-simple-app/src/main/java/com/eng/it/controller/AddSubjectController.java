package com.eng.it.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.eng.it.dao.SubjectDao;
import com.eng.it.model.Subject;

@Named
@RequestScoped
public class AddSubjectController {

	@Inject
	private EntityManager entityManager;

	private SubjectDao subjectDao;

	private Subject subject;

	private String console;

	@PostConstruct
	public void init() {
		subjectDao = new SubjectDao();
		subjectDao.setEntityManager(entityManager);
		subject = new Subject();
	}

	public String addSubject() {
		if (console.equals("Da")) {
			subject.setActive(true);
		}
		subjectDao.insert(subject);		
		return "/subject.xhtml?faces-redirect=true";
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

}
