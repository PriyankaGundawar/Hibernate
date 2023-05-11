package com.hibernate;

import java.util.List;
import java.util.Random;

//import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;



public class AppHQL4 {

	public static void main(String[] args) {
		//System.out.println("Hello World!!");
		
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentHQL.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Random r = new Random();
		
		session.beginTransaction();
		
		NativeQuery query = session.createNativeQuery("select * from StudentHQL where rollno>5");
		query.addEntity(StudentHQL.class);
        List StudentHQL = query.list();
        for(Object s: StudentHQL) {
        	System.out.println(s);
        	
        }

		
		session.getTransaction().commit();
		
		

	}

}
