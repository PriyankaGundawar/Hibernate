package com.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class AppELGet {

	public static void main(String[] args) {
		//System.out.println("Hello World!!");
		
				
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(PersonEL.class).addAnnotatedClass(LapEL.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		PersonEL pel = session.get(PersonEL.class, 1);
		System.out.println(pel.getPname());
		
//		Collection<LapEL> lap = pel.getLap(); //if we dont write this code it will only print person details not laptop details. that means it is LAZY.
//		
//		for(LapEL l : lap) {
//			System.out.println(l);
//		}
	

		session.getTransaction().commit();
					

	}

}
