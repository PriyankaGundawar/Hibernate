package com.hibernate;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class AppGetvsLoad {

	public static void main(String[] args) {
		//System.out.println("Hello World!!");
		

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(LaptopObjectLC.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();		
		session.beginTransaction();
		
//		LaptopObjectLC obj = session.get(LaptopObjectLC.class, 7); //this will fire the query against db.
//		System.out.println(obj);  
//		System.out.println(obj.getName());  //thows null pinter exception as 7 is not there in DB.
//		
		
//		LaptopObjectLC obj = session.load(LaptopObjectLC.class, 1); //proxy object. it will not not fire a query to db untill we use the object
//		System.out.println(obj);  //this statement will fire the query against db as we are using the object
//		
		LaptopObjectLC obj = session.load(LaptopObjectLC.class, 7);
		System.out.println(obj);  //throws object not found exception
		
		session.getTransaction().commit();

		

	}

}

//get() will not throw an exception when the value is not there in db which we are trying to fetch. it will give null object.
//when we try to use the(sysout(obj.getName()), it will throe nullpointer exception.


//Load() will throw an object not found exception when the value is not there in db which we are trying to fetch. 
