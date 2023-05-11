package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Laptop {
	
	@Id
	private int lid;
	private String lname;
	
//	@ManyToOne
//	private Studenth student;
	
	@ManyToMany
	private List<Studenth> student = new ArrayList<Studenth>();
	
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
//	public Studenth getStudent() {
//		return student;
//	}
//	public void setStudent(Studenth student) {
//		this.student = student;
//	}
	public List<Studenth> getStudent() {
		return student;
	}
	public void setStudent(List<Studenth> student) {
		this.student = student;
	}
	

	
	

}
