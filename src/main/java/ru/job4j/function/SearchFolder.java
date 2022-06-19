package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Класс описывает совместную работу шаблона проектирования стратегия
 * в сочетании с функциональными интерфейсами
 * @author Alexey Novoselov
 * @version 1.0
 */

public class SearchFolder {
    /**
     * Метод выполняет поиск элементов с помощью фильтра
     * @param list список элементов коллекции
     * @param pred функциональный интерфейс Predicate
     * @return возвращает коллекцию элементов после фильтра
     */

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder f : list) {
           if (pred.test(f)) {
               rsl.add(f);
           }
        }
        return rsl;
    }
}
