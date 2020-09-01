package com.adam.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ControllerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isShowFormSelect = true;
	private boolean isShowListStudent = false;
	private boolean isShowListClass = false;
	private boolean isCreateStudent = false;

	/*
	 * @PostConstruct public void init() { isShowFormSelect = true; isShowListClass
	 * = false; isShowListStudent = false; isCreateStudent = false; }
	 */

	public void showStudents() {
		isShowFormSelect = false;
		isShowListClass = false;
		isCreateStudent = false;

		isShowListStudent = true;
	}

	public void showClasses() {
		isShowFormSelect = false;
		isShowListStudent = false;
		isCreateStudent = false;

		isShowListClass = true;
	}

	public void backToSelect() {
		isShowListStudent = false;
		isShowListClass = false;
		isCreateStudent = false;

		isShowFormSelect = true;

	}

	public void showFormCreate() {
		this.isShowFormSelect = false;
		this.isShowListStudent = true;
		this.isCreateStudent = true;
	}

	public boolean isShowFormSelect() {
		return isShowFormSelect;
	}

	public void setShowFormSelect(boolean isShowFormSelect) {
		this.isShowFormSelect = isShowFormSelect;
	}

	public boolean isShowListStudent() {
		return isShowListStudent;
	}

	public void setShowListStudent(boolean isShowListStudent) {
		this.isShowListStudent = isShowListStudent;
	}

	public boolean isShowListClass() {
		return isShowListClass;
	}

	public void setShowListClass(boolean isShowListClass) {
		this.isShowListClass = isShowListClass;
	}

	public boolean isCreateStudent() {
		return isCreateStudent;
	}

	public void setCreateStudent(boolean isCreateStudent) {
		this.isCreateStudent = isCreateStudent;
	}

}
