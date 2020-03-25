package com.eng.it.controller;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import com.eng.it.dao.StudentDAO;
import com.eng.it.model.Student;

@Named
@RequestScoped
public class StudentController {

	 @Inject
	    private EntityManager entityManager;
	 
	    private StudentDAO studentDAO;

	    private List<Student> students;
	    
	    private Student newStudent;
	    
	    @PostConstruct
	    public void init() {
	        studentDAO = new StudentDAO();
	        studentDAO.setEntityManager(entityManager);
	        students = studentDAO.getAllStudents();
	        newStudent = new Student();
	    }

	    public String addStudent() {
	    	studentDAO.insert(newStudent);
	    	return "student.xhtml?faces-redirect=true";
	    }
	    
	    public String redirectToAddStudent() {
	        return "addStudent";
	    }
	    
	    public StudentDAO getStudentDao() {
	        return studentDAO;
	    }

	    public void setStudentDAO(StudentDAO studentDao) {
	        this.studentDAO = studentDao;
	    }

	    public List<Student> getStudents() {
	        return students;
	    }

	    public void setStudents(List<Student> students) {
	        this.students = students;
	    }

		public Student getNewStudent() {
			return newStudent;
		}

		public void setNewStudent(Student newStudent) {
			this.newStudent = newStudent;
		}
	
}
