package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class HmbTracker implements Store, AutoCloseable {

    /**
     * В поле создаем объект {@link StandardServiceRegistry}.
     * Метод configure читает файл hibernate.cfg.xml и выполняет инициализация пула и кешей
     */
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    /**
     * В поле создаем объект {@link SessionFactory}.
     * SessionFactory - это объект конфигуратор. Он создается один раз на все приложение.
     * В нем происходит создания пулов, загрузка кешей, проверка моделей.
     */
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
                throw e;
            }
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            var query = session.createQuery(
                            "UPDATE Item SET name = :fName, created = :fCreated WHERE id = :fId");
                    query.setParameter("fName", item.getName());
                    query.setParameter("fCreated", item.getCreated());
                    query.setParameter("fId", id);
                    result = query.executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
                throw e;
            }
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            var query = session.createQuery(
                    "DELETE Item WHERE id = :fId");
            query.setParameter("fId", id);
            result = query.executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
                throw e;
            }
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        List<Item> itemList = new ArrayList<>();
        try {
            session.beginTransaction();
            Query<Item> query = session.createQuery(
                    "FROM Item ORDER BY id", Item.class);
            itemList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
                throw e;
            }
        } finally {
            session.close();
        }
        return itemList;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        List<Item> itemList = new ArrayList<>();
        try {
            session.beginTransaction();
            Query<Item> query = session.createQuery(
                    "FROM Item WHERE name = :fName", Item.class);
            query.setParameter("fName", key);
            itemList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
                throw e;
            }
        } finally {
            session.close();
        }
        return itemList;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        var item = new Item();
        try {
            session.beginTransaction();
            var query = session.createQuery(
                    "FROM Item WHERE id = :fId", Item.class);
            query.setParameter("fId", id);
            item = query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
                throw e;
            }
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
