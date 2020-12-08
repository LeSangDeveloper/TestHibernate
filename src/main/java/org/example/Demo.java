package org.example;

import org.example.pojo.Category;
import org.example.pojo.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
//            Query<Category> query = session.createQuery("FROM Category");
//            List<Category> cats = query.list();
//
//            cats.forEach(c -> System.out.println(c.getName()));

            session.getTransaction().begin();
            Category c = session.get(Category.class, 1);

            Product p = new Product();
            p.setName("iPad Pro 2020");
            p.setDescription("Apple, 128GB");
            p.setPrice(new BigDecimal(39));
            p.setCategory(c);

            session.save(p);
            session.getTransaction().commit();
        }
    }
}
