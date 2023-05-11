package com.hibernate;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class AppSLCache {

	public static void main(String[] args) {
		
		AliensSLCache ac =null;
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(AliensSLCache.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session1 = sf.openSession();		
		session1.beginTransaction();
		
		ac = (AliensSLCache) session1.get(AliensSLCache.class, 101);
		System.out.println(ac);
		session1.getTransaction().commit();
		session1.close();
		
//		ac = (AliensCache) session1.get(AliensCache.class, 101);
//		System.out.println(ac);
		
		Session session2 = sf.openSession();		
		session2.beginTransaction();
		
		ac = (AliensSLCache) session2.get(AliensSLCache.class, 101);
		System.out.println(ac);
		
		session2.getTransaction().commit();
		session2.close();
		
		

	}

}

//if we try to query/get same statement twice then it wont fire same query twice. it will fire only once gives results twice.
//getting same results inspite of calling same statement, in DB it will fire only once due to it will cache the results. its called first level cache.
//first level cache is default in hibernate
//first level cache only works for same session.

//if we try to query/get same statement twice in two diff sessions it will fire same query twice.
