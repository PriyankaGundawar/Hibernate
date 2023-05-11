package com.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PersonEL {
	
	@Id
	private int pid;
	private String pname;
	
	//@OneToMany(mappedBy="person")
	@OneToMany(mappedBy="person", fetch=FetchType.EAGER)//this is for AppELGet(it is used to fetch the laptop details even we dont print the laptop details)
	private Collection<LapEL> lap = new ArrayList<LapEL>();
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Collection<LapEL> getLap() {
		return lap;
	}
	public void setLap(Collection<LapEL> lap) {
		this.lap = lap;
	}
	@Override
	public String toString() {
		return "PersonEL [pid=" + pid + ", pname=" + pname + "]";
	}
	
	

}
