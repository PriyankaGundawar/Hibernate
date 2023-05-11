package com.hibernate;

import java.util.List;
import java.util.Random;

//import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class AppHQL3 {

	public static void main(String[] args) {
		//System.out.println("Hello World!!");
		
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentHQL.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Random r = new Random();
		int a = 6;
		
		session.beginTransaction();

		//Query q = session.createQuery("select sum(marks) from StudentHQL ");
		Query q = session.createQuery("select sum(marks) from StudentHQL where rollno>:a");
		q.setParameter("a", a);
		//Object stu = (Object)q.uniqueResult();
		Integer stu = (Integer)q.uniqueResult(); //as we are returning integer value(object also will work).
        System.out.println(stu);
		
		session.getTransaction().commit();
		
		

	}

}
