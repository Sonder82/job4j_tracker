package ru.job4j.tracker;

import java.util.Scanner;

 public class StartUI {
     public void init(Scanner scanner, Tracker tracker) {
         boolean run = true;
         while (run) {
             showMenu();
             System.out.print("Select: ");
             int select = Integer.parseInt(scanner.nextLine());
             if (select != 6) {
                 System.out.println("Пользователь выбрал: " + select);
             } else {
                 run = false;
             }
         }
     }
     private void showMenu() {
         String[] menu = {
                 "Add new Item", "Show all items", "Edit item",
                 "Delete item", "Find item by id", "Find items by name",
                 "Exit Program"
         };
         System.out.println("Menu:");
         for (int index = 0; index < menu.length; index++) {
             System.out.println(index + "." + menu[index]);

         }

     }

     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         Tracker tracker = new Tracker();
         new StartUI().init(scanner,tracker);

     }
}
