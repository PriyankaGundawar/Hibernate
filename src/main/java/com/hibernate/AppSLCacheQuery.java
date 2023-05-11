package com.hibernate;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class AppSLCacheQuery {

	public static void main(String[] args) {
		
		AliensSLCache ac =null;
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(AliensSLCache.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session1 = sf.openSession();
		
		session1.beginTransaction();
		Query q1=session1.createQuery("from AliensSLCache where aid=101");	
		//q1.setCacheable(true);
		ac = (AliensSLCache)q1.uniqueResult();
		System.out.println(ac);
		
		session1.getTransaction().commit();
		session1.close();
		
		Session session2 = sf.openSession();		
		session2.beginTransaction();
		Query q2 = session2.createQuery("from AliensSLCache where aid=101");		
		ac = (AliensSLCache) q2.uniqueResult();
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
