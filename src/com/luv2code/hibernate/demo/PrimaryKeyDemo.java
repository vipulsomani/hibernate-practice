package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		try {
			//create 3 student object
			Student tempStudent1 = new Student("Vipul","Somani","Vip@gmail.com");
			Student tempStudent2 = new Student("Yash","Maheshwari","yash@gmail.com");
			Student tempStudent3 = new Student("Amit","Somani","amit@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			//save the student object
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			//commit transation
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
				factory.close();
			}
		

	}

}
