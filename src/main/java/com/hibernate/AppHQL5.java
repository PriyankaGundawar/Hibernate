package com.hibernate;

import java.util.List;
import java.util.Map;
import java.util.Random;

//import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.ResultTransformer;

public class AppHQL5 {

	public static void main(String[] args) {
		// System.out.println("Hello World!!");

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentHQL.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Random r = new Random();

		session.beginTransaction();

//		NativeQuery query = session.createNativeQuery("select name, marks from StudentHQL h where h.rollno>5", 
//					Object[].class);
		
NativeQuery query = (NativeQuery) session.createNativeQuery("select rollno, Name, marks from StudentHQL h where h.rollno=5")
.setTupleTransformer(new AliasToBeanResultTransformer(StudentHQL.class)).getSingleResult();

		List<StudentHQL> student = query.list();

//		List students = query.setTupleTransformer((tuples, aliases) -> {
//			StudentHQL student = new StudentHQL();
//			student.setRollno((int) tuples[0]);
//			student.setName((String) tuples[1]);
//			student.setMarks((int) tuples[2]);
//
//			return student;
//		}).getResultList();

		for (Object s : student) {
			System.out.println(s);

		}

		session.getTransaction().commit();

	}

}
