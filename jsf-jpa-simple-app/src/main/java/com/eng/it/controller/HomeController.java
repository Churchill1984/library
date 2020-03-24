package com.eng.it.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class HomeController {

	public String viewStudent() {
		return "/student";
	}
	
	public String viewProfessor() {
		return "/professor";
	}
	
	public String viewSubject() {
		return "/subject";
	}
}
