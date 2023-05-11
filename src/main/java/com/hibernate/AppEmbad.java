package com.hibernate;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class AppEmbad {

	public static void main(String[] args) {
		//System.out.println("Hello World!!");
		
		AlienNames an = new AlienNames();
		an.setFname("priya");
		an.setLname("Dikonda");
		an.setMname("Ram");
		
		AliensEmbad ale = new AliensEmbad();
	
		ale.setAid(103);
		ale.setAname(an);
		ale.setAcolor("light green");
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(AliensEmbad.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx=session.beginTransaction();
		session.save(ale);
		tx.commit();
		
		

	}

}
