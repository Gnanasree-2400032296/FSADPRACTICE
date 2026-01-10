package com.klu.client;
import java.util.*;
import org.hibernate.*;
import com.klu.util.HibernateUtil;
public class HQLQueries {
	public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        // Sort by price ascending
        session.createQuery("from Product p order by p.price asc")
               .list()
               .forEach(System.out::println);

        // Sort by price descending
        session.createQuery("from Product p order by p.price desc")
               .list()
               .forEach(System.out::println);

        // Sort by quantity highest
        session.createQuery("from Product p order by p.quantity desc")
               .list()
               .forEach(System.out::println);

        // Pagination
        Query q1 = session.createQuery("from Product");
        q1.setFirstResult(0);
        q1.setMaxResults(3);
        q1.list().forEach(System.out::println);

        Query q2 = session.createQuery("from Product");
        q2.setFirstResult(3);
        q2.setMaxResults(3);
        q2.list().forEach(System.out::println);

        // Aggregates
        Long total = (Long) session
                .createQuery("select count(p) from Product p")
                .uniqueResult();
        System.out.println("Total Products: " + total);

        Long available = (Long) session
                .createQuery("select count(p) from Product p where p.quantity > 0")
                .uniqueResult();
        System.out.println("Available Products: " + available);

        Object[] minMax = (Object[]) session
                .createQuery("select min(p.price), max(p.price) from Product p")
                .uniqueResult();
        System.out.println("Min Price: " + minMax[0]);
        System.out.println("Max Price: " + minMax[1]);

        // Group By
        List<Object[]> group = session
                .createQuery("select p.description, count(p) from Product p group by p.description")
                .list();
        for (Object[] obj : group) {
            System.out.println(obj[0] + " : " + obj[1]);
        }

        // WHERE + LIKE
        session.createQuery("from Product p where p.name like 'L%'")
               .list()
               .forEach(System.out::println);

        session.createQuery("from Product p where p.price between 1000 and 10000")
               .list()
               .forEach(System.out::println);

        session.close();
    }
}
