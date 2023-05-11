package com.hibernate;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {

	public static void main(String[] args) {
		//System.out.println("Hello World!!");
		
		Aliens al = new Aliens();
//		al.setAid(101);
//		al.setAname("priya");
//		al.setAcolor("blue");
		
		al.setAid(103);
		al.setAname("ram");
		al.setAcolor("light green");
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Aliens.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx=session.beginTransaction();
		session.save(al);
		tx.commit();
		
		

	}

}
