package com.eng.it.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.eng.it.dao.UserDao;
import com.eng.it.model.User;

@Named
@RequestScoped
public class UserLoginView {
	
	@Inject
	private EntityManager em;

	UserDao userDAO = new UserDao();

	User user = new User();

	public String send() {

		if (em == null) {
			System.out.println("");
		}
		user = userDAO.getUser(user.getNameUser(), user.getPassword());
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
