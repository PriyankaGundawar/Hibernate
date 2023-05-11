package com.hibernate;

import java.util.List;
import java.util.Random;

//import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class AppHQL2 {

	public static void main(String[] args) {
		//System.out.println("Hello World!!");
		
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentHQL.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Random r = new Random();
		
		session.beginTransaction();

		//Query q = session.createQuery("select rollno, Name, marks from StudentHQL where rollno=3");
		Query q = session.createQuery("select rollno, Name, marks from StudentHQL ");
		
		List<StudentHQL> ls = q.getResultList();
//		Object[] os = (Object[])q.uniqueResult(); //printing array of objects to print values of rollno, name, marks
		List<Object[]> los = (List<Object[]>)q.list(); //list of objects
		
//		for(Object o : os) {
//		System.out.println(o);
//		
//		}
		
		for(Object[] oa : los) {
			System.out.println(oa[0]+ ":" +oa[1]+ ":" +oa[2]);
		}
		
		session.getTransaction().commit();
		
		

	}

}
