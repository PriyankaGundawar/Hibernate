package com.hibernate;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class AppObjectlifeCycle {

	public static void main(String[] args) {
		//System.out.println("Hello World!!");
		

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(LaptopObjectLC.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();		
		session.beginTransaction();
		
		LaptopObjectLC obj = new LaptopObjectLC(); //when we create object it will be in New state.
		obj.setLid(3); //when we try to set the values it will be in transient state
		obj.setName("HP");
		obj.setPrice(400);		
		
		session.save(obj); //when we save the object it will be in persistent state
		//obj.setPrice(250); // if we are trying to change the value it is still in persistent state. this value will be updated in DB.
		
		session.getTransaction().commit();
		session.detach(obj); //the object will be detached state. after which whatever we change the values it will not be saved in DB. used only for processing.
		obj.setPrice(350);
		
		

	}

}
