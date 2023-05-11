package com.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LapEL {
	@Id
	private int lid;
	private String lname;
	private int price;
	@ManyToOne(cascade = CascadeType.ALL)
	private PersonEL person;
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public PersonEL getPerson() {
		return person;
	}
	public void setPerson(PersonEL person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "LapEL [lid=" + lid + ", lname=" + lname + ", price=" + price + ", person=" + person + "]";
	}
	
	

}
