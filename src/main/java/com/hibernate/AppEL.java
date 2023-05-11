package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class AppEL {

	public static void main(String[] args) {
		//System.out.println("Hello World!!");
		
		PersonEL pel1 = new PersonEL();
		pel1.setPid(1);
		pel1.setPname("priya");
		
		PersonEL pel2 = new PersonEL();
		pel2.setPid(2);
		pel2.setPname("Ram");
		
		PersonEL pel3 = new PersonEL();
		pel3.setPid(3);
		pel3.setPname("Sai");
		
		List<LapEL> alap = new ArrayList<LapEL>();
		
		LapEL lap1 = new LapEL();
		lap1.setLid(101);
		lap1.setLname("Dell");
		lap1.setPrice(100);
		lap1.setPerson(pel1);
		
		LapEL lap2 = new LapEL();
		lap2.setLid(102);
		lap2.setLname("Apple");
		lap2.setPrice(200);
		lap2.setPerson(pel2);
		
		LapEL lap3 = new LapEL();
		lap3.setLid(103);
		lap3.setLname("HP");
		lap3.setPrice(300);
		lap3.setPerson(pel3);
		
		LapEL lap4 = new LapEL();
		lap4.setLid(104);
		lap4.setLname("Samsung");
		lap4.setPrice(400);
		lap4.setPerson(pel3);
		
		LapEL lap5 = new LapEL();
		lap5.setLid(105);
		lap5.setLname("Mac");
		lap5.setPrice(500);
		lap5.setPerson(pel1);
		
		alap.add(lap1);	
		alap.add(lap2);	
		alap.add(lap3);	
		alap.add(lap4);	
		alap.add(lap5);	
		
//		pel.setLap(alap);

		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(PersonEL.class).addAnnotatedClass(LapEL.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
//		Transaction tx=session.beginTransaction();
//		session.save(pel1);
		//tx.commit();
		
//		Transaction tx=session.beginTransaction();
//		session.save(lap1);
//		tx.commit();
//		tx=session.beginTransaction();
//		session.save(lap2);
//		tx.commit();
//		tx=session.beginTransaction();
//		session.save(lap3);
//		tx.commit();
//		tx=session.beginTransaction();
//		session.save(lap4);
//		tx.commit();
//		tx=session.beginTransaction();
//		session.save(lap5);
//		tx.commit();
		
		

	}

}
