package com.hibernate;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="Aliens_tableCache")
//@Cacheable
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class AliensSLCache {
	@Id
	private int aid;
	private String aname;
	@Column(name="alien_color")
	private String acolor;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
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
