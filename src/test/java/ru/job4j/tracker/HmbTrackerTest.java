package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.*;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class HmbTrackerTest {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @After
    public void wipeTable() {
        Session session = sf.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.createQuery(
                    "DELETE FROM Item").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HmbTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenReplaceItemThenGetNewItem() throws Exception {
        try (var tracker = new HmbTracker()) {
            Item item = new Item("test1");
            tracker.add(item);
            int id = item.getId();
            Item itemNew = new Item("test2");
            tracker.replace(id, itemNew);
            List<Item> result = tracker.findByName(itemNew.getName());
            assertThat(result.get(0).getName()).contains("test2");
        }
    }

    @Test
    public void whenDeleteItem() throws Exception {
        try (var tracker = new HmbTracker()) {
            Item item = new Item("test1");
            tracker.add(item);
            int id = item.getId();
            tracker.delete(id);
            assertThat(tracker.findById(id)).isNull();
        }
    }

    @Test
    public void whenFindAllThenCheckSize() throws Exception {
        try (var tracker = new HmbTracker()) {
            Item first = new Item("test1");
            Item second = new Item("test2");
            tracker.add(first);
            tracker.add(second);
            assertThat(tracker.findAll()).hasSize(2);
        }
    }

    @Test
    public void whenFindByNameThenGetItem() {
        try (var tracker = new HmbTracker()) {
            Item first = new Item("test1");
            Item second = new Item("test2");
            tracker.add(first);
            tracker.add(second);
            assertThat(tracker.findByName("test1")).containsExactly(first);
        }
    }

    @Test
    public void whenFindByIdThenGetIt() {
        try (var tracker = new HmbTracker()) {
            Item first = new Item("test1");
            Item second = new Item("test2");
            tracker.add(first);
            tracker.add(second);
            assertThat(tracker.findById(first.getId())).isEqualTo(first);
        }
    }
}