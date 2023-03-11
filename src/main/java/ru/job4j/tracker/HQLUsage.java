package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class HQLUsage {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (SessionFactory sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sf.openSession();
            List<Item> list = findAll(session);
            for (Item item : list) {
                System.out.println(item);
            }
            unique(session);
            findById(3, session);
            update(session, 2);
            delete(session, 3);
            insert(session, new Item("name"));
            session.close();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static List<Item> findAll(Session session) {
        return session.createQuery("FROM Item", Item.class).list();
    }

    public static void unique(Session session) {
        Query<Item> query = session.createQuery(
                "from Item as i where i.id = 3", Item.class);
        System.out.println(query.uniqueResult());
    }

    public static void findById(Integer id, Session session) {
        Query<Item> query = session.createQuery(
                "from Item as i where i.id = :fId", Item.class);
        query.setParameter("fId", id);
        System.out.println(query.uniqueResult());
    }

    public static void update(Session session, int id) {
        try {
            session.beginTransaction();
            session.createQuery(
                    "Update Item Set name = :fName where id = :fId")
                    .setParameter("fName", "new name")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void delete(Session session, int id) {
        try {
            session.beginTransaction();
            session.createQuery(
                            "DELETE Item WHERE id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void insert(Session session, Item item) {
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
}
