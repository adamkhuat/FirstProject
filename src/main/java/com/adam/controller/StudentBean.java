package com.adam.controller;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.adam.model.Student;
import com.adam.repo.StudentRepo;

@Named
@RequestScoped
public class StudentBean {

	@Inject
	StudentRepo repo;

	public List<Student> getAllStudent() {
		return repo.getAllStudents();
	}

	public String create() {
		Student student = new Student();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("newStudent", student);
		return "";
	}

	public void save(Student student) {
		repo.save(student);
		System.out.println(student);
	}

	public void edit(int id) {

		for (Student exists : getAllStudent()) {
			exists.setEditable(false);
		}
		Student student = repo.findById(id);
		student.setEditable(true);
		System.out.println(student);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("studentEdit", student);

		System.out.println("Student EDIT " + student);

	}

	public void update(Student student) {
		repo.edit(student);
		cancelEdit(student);
		System.out.println("Student UPDATE " + student);
	}

	public String delete(int id) {
		repo.delete(id);
		return "DELETE";
	}

	public void cancelEdit(Student student) {
		student.setEditable(false);
	}

	public void clearForm(Student student) {
		student.setSname("");
		student.setSpassword("");
	}
}
