package ru.job4j.tracker;

public class CreateActionForGCTask implements UserAction{
    private final Output out;

    public CreateActionForGCTask(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create new Items for GS Task";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Create multiple Items ===");
        int count = input.askInt("How many Items create: ");
        for (int i = 0; i < count; i++) {
            Item item = new Item("Item " + i);
            store.add(item);
            out.println("Добавленная заявка: " + item);
        }
        out.println("Создано " +  count + " заявок");
        return true;
    }
}
