package com.eng.it.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.eng.it.dao.UserDao;
import com.eng.it.model.User;


@Named
@RequestScoped
public class UserLoginView {

	@Inject
	private EntityManager em;

	@Inject
	UserDao userDAO;

	User user = new User();

	public String send() {
		userDAO.setEm(em);
		user = userDAO.getUser(user.getNameUser(), user.getPassword());
		
		System.out.println("user.getLastAccess() "+user.getLastAccess());
		
		if (user == null) {
			user = new User();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "User not found!", " Login Error!"));
			return null;
		} else {
			return "/main";
		}

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
