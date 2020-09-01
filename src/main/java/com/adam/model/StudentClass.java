package com.adam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studentClass")
public class StudentClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String className;

	@Column
	private int classSize;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getClassSize() {
		return classSize;
	}

	public void setClassSize(int classSize) {
		this.classSize = classSize;
	}

	@Override
	public String toString() {
		return "StudentClass [Id=" + id + ", className=" + className + ", classSize=" + classSize + "]";
	}

}
