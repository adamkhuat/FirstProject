package com.adam.controller;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.adam.model.StudentClass;
import com.adam.repo.ClassRepo;

@Named
@RequestScoped
public class ClassBean {

	ClassRepo classRepo = new ClassRepo();

	public List<StudentClass> getAllClass() {
		return classRepo.getAllStudents();
	}

	public String save(StudentClass sclass) {
		classRepo.save(sclass);
		return "/classes.xhtml?faces-redirect=true";
	}

	public String create() {
		StudentClass studentClass = new StudentClass();
		Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		map.put("newClass", studentClass);
		return "/index.xhtml?faces-redirect=true";
	}

	public String edit(int id) {
		StudentClass studentClass = classRepo.findById(id);
		System.out.println(studentClass);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("classEdit", studentClass);

		return "/edit.xhtml?faces-redirect=true";
	}

	public String update(StudentClass studentClass) {
		classRepo.edit(studentClass);
		return "/index.xhtml?faces-redirect=true";
	}

	public String delete(int id) {
		classRepo.delete(id);
		return "/index.xhtml?faces-redirect=true";
	}

}
