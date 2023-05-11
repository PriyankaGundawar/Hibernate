package com.hibernate;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class AppStuLap {

	public static void main(String[] args) {
					
		Laptop l = new Laptop();
		l.setLid(101);
		l.setLname("Dell");
		
		Studenth s = new Studenth();
		s.setRollno(1);
		s.setName("priya");		
		//s.setLaptop(l);
		s.getLaptop().add(l);
		
		l.getStudent().add(s);
		

		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Laptop.class).addAnnotatedClass(Studenth.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx=session.beginTransaction();
		session.save(s);
		session.save(l);
		tx.commit();
		
		

	}

}
