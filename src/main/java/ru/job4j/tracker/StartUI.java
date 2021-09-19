package ru.job4j.tracker;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        LocalDateTime currentDateTimeFormat = item.getCreated();
        String result = currentDateTimeFormat.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + result);
    }
}
