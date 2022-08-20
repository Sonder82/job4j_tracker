package ru.job4j.tracker;

public class DeleteActionForGCTask implements UserAction {
    private final Output out;

    public DeleteActionForGCTask(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Items for GS Task";
    }

    @Override
    public boolean execute(Input input, Store store) {
        int counter = 0;
        out.println("=== Delete multiple Items ===");
        int id = input.askInt("Enter start id: ");
        int count = input.askInt("How many Items delete: ");
        for (int i = 0; i < count; i++) {
            if (store.delete(id++)) {
                counter++;
            } else {
                out.println("Ошибка удаления заявки.");
            }
        }
        out.println("Заявок удалено успешно: " + counter);
        return true;
    }
}
