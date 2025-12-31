package com.klu;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class MainApp {

	public static void main(String[] args) {
		//Load configuration & create sessionfactory 
SessionFactory factory = new Configuration().configure().buildSessionFactory();

//Open session
Session session=factory.openSession();

//begin transactions
Transaction tx=session.beginTransaction();
//Create object 
Student s=new Student("gnana");
//save object
session.save(s);
//Commit
tx.commit();
//close the resources
session.close();
factory.close();
System.out.println("Data have been inserted successfully");
	}

}
