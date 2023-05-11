package com.hibernate;

import java.util.Random;

//import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class AppHQL1 {

	public static void main(String[] args) {
		//System.out.println("Hello World!!");
		
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentHQL.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Random r = new Random();
		
		session.beginTransaction();
//		for(int i=1; i <=10; i++) {
//			StudentHQL stu = new StudentHQL();
//			stu.setRollno(i);
//			stu.setName("Name"+ i);
//			stu.setMarks(r.nextInt(50));
//			session.save(stu);			
//		}

		//Query q = session.createQuery("from StudentHQL");
		Query q = session.createQuery("from StudentHQL where rollno=3");
//		List<StudentHQL> sl= q.getResultList();
//		for(StudentHQL s: sl) {
//			System.out.println(s);
//		}
		
		StudentHQL shql = (StudentHQL)q.uniqueResult();
		System.out.println(shql);
		
		
		
		session.getTransaction().commit();
		
		

	}

}
