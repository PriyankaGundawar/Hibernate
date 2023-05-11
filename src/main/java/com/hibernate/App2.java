package com.hibernate;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App2 {

	public static void main(String[] args) {
		//System.out.println("Hello World!!");
		
		//Aliens al = new Aliens(); //this one will also work
		Aliens al = null; //no need to create the object. 
				
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Aliens.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx=session.beginTransaction();
		//session.save(al);
		al = (Aliens) session.get(Aliens.class, 103);
		tx.commit();
		System.out.println(al);
		
		
		

	}

}
