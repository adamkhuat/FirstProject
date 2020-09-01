package com.adam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String Sname;

	@Column
	private String Spassword;

	@Transient
	private boolean editable;

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getSpassword() {
		return Spassword;
	}

	public void setSpassword(String spassword) {
		Spassword = spassword;
	}

	@Override
	public String toString() {
		return "Student [Sname=" + Sname + ", Spassword=" + Spassword + "]";
	}

}
