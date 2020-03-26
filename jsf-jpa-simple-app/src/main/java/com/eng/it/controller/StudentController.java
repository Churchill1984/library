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

import com.eng.it.dao.StudentDAO;
import com.eng.it.model.Student;

@Named
@RequestScoped
public class StudentController {

	 @Inject
	    private EntityManager entityManager;
	 
	    private StudentDAO studentDAO;

	    private List<Student> students;
	    
	    private Student student;
	    @PostConstruct
	    public void init() {
	        studentDAO = new StudentDAO();
	        studentDAO.setEntityManager(entityManager);
	        students = studentDAO.getAllStudents();
	        student = new Student();
	    }

	    public String addStudent() {
	    	studentDAO.insert(student);
	    	return "student.xhtml?faces-redirect=true";
	    }
	    
	    public String redirectToAddStudent() {
	        return "addStudent";
	    }
	    
	    public String deleteStudent(Student student) {
	        studentDAO.delete(student);
	        students.remove(student);
	        return "student.xhtml?faces-redirect=true";
	    }
	    
	  //for update
	    public void onRowEdit(RowEditEvent<Student> event) {
	        studentDAO.update(event.getObject());
	        FacesMessage msg = new FacesMessage("Student Updated");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	    
	    public void onRowCancel(RowEditEvent<Student> event) {
	        FacesMessage msg = new FacesMessage("Update Cancelled");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	    
	     //for delete
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
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

		public Student getStudent() {
			return student;
		}

		public void setNewStudent(Student student) {
			this.student = student;
		}
	
}
