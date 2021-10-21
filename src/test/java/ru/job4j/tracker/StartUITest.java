package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replacedName = "New Item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replacedName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ReplaceAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. === Edit item ===" + ln
                        + "1. ===Exit===" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. === Edit item ===" + ln
                        + "1. ===Exit===" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(one.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ShowAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. === Show all items ===" + ln
                        + "1. ===Exit===" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. === Show all items ===" + ln
                        + "1. ===Exit===" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. === Find item by id ===" + ln
                        + "1. ===Exit===" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. === Find item by id ===" + ln
                        + "1. ===Exit===" + ln
                        + "=== Exit Program ===" + ln
        ));

    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ShowAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. === Show all items ===" + ln
                        + "1. ===Exit===" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. === Show all items ===" + ln
                        + "1. ===Exit===" + ln
                        + "=== Exit Program ===" + ln
        ));
    }
}
