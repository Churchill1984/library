package com.eng.it.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
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

	@PostConstruct
	public void init() {
		subjectDao = new SubjectDao();
		subjectDao.setEntityManager(entityManager);
		subjectsList = subjectDao.getAllSubjects();
	}

	public String addSubject() {
		return "addSubject";
	}

	public List<Subject> getSubjectsList() {
		return subjectsList;
	}

	public void setSubjectsList(List<Subject> subjectsList) {
		this.subjectsList = subjectsList;
	}

}
