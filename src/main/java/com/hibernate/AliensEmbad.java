package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Aliens_Embadtable")
public class AliensEmbad {
	@Id
	private int aid;
	private AlienNames aname;
	private String acolor;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}

	public AlienNames getAname() {
		return aname;
	}
	public void setAname(AlienNames aname) {
		this.aname = aname;
	}
	public String getAcolor() {
		return acolor;
	}
	public void setAcolor(String acolor) {
		this.acolor = acolor;
	}
	@Override
	public String toString() {
		return "Aliens [aid=" + aid + ", aname=" + aname + ", acolor=" + acolor + "]";
	}
	
	

}
