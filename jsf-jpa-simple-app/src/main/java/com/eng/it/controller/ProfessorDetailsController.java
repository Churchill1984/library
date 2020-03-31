package com.eng.it.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.eng.it.model.Professor;

@Named
@SessionScoped
public class ProfessorDetailsController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7625628828359157405L;

	@Inject
	private ProfessorController professorController;

	private Professor selectedProfessor;

	@PostConstruct
	public void init() {		
		selectedProfessor = new Professor();
		selectedProfessor = professorController.getProfessor();	
	}

	public Professor getSelectedProfessor() {
		return selectedProfessor;
	}

	public void setSelectedProfessor(Professor selectedProfessor) {
		this.selectedProfessor = selectedProfessor;
	}

}
