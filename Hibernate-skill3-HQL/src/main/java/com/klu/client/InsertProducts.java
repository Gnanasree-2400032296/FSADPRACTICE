package com.klu.client;
import org.hibernate.*;
import com.klu.model.Product;
import com.klu.util.HibernateUtil;
public class InsertProducts {
	public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Product("Laptop", "Electronics", 55000, 10));
        session.save(new Product("Mouse", "Electronics", 500, 50));
        session.save(new Product("Keyboard", "Electronics", 1200, 30));
        session.save(new Product("Chair", "Furniture", 3000, 15));
        session.save(new Product("Table", "Furniture", 7000, 5));
        session.save(new Product("Pen", "Stationery", 20, 100));

        tx.commit();
        session.close();

        System.out.println("Products Inserted Successfully");
    }
}
