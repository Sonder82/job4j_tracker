package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    /**
     * Поле хранит в себе очередь клиентов, которые пришли в магазин.
     */
    private final Queue<Customer> queue;

    /**
     * Поле хранит в себе количество доступного к покупке товара.
     */
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    /**
     * Метод должен вернуть имя последнего счастливого обладателя желаемого товара.
     * @return имя клиента из очереди.
     */
    public String getLastHappyCustomer() {

        String result = "";
        for (int i = 0; i < count; i++) {
             result = queue.poll().name();
        }
        return result;
    }

    /**
     * Метод должен вернуть имя первого клиента, которому не повезло и ему не хватило товара.
     * @return имя клиента из очереди.
     */
    public String getLastUpsetCustomer() {

        String result = "";
        for (int i = 0; i < count + 1; i++) {
            result = queue.poll().name();
        }
        return result;
    }
}
