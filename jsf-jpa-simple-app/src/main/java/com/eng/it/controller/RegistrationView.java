package com.eng.it.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.eng.it.dao.StudentDao;
import com.eng.it.model.Student;

@Named
@RequestScoped
public class RegistrationView {

	@Inject
	private EntityManager em;

	StudentDao studentDao = new StudentDao();

	Student student;

	@PostConstruct
	public void init() {
		// In case you're updating an existing entity.
		student = new Student();
		studentDao.setEm(em);
	}

	public String create() {

		try {
			studentDao.insert(student);
			return "/index";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "This email or password already exsist!", " Error!"));
			return null;
		}

	}

	public String registration() {
		return "/registration";
	}

	public String login() {
		student = studentDao.getStudentByUserAndPass(student.getUserName(), student.getPassword());
		if (student == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "This login invalid", " Error!"));
			return null;
		} else {
			return "/main";
		}
	}

	public Student getStudent() {
		return student;
	}

}
