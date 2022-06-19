package ru.job4j.function;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Класс описывает совместную работу шаблона проектирования стратегия
 * в сочетании с функциональными интерфейсами
 * @author Alexey Novoselov
 * @version 1.0
 */

public class StrategyUsage {
    /**
     * Метод выполняет проверки со строками
     * @param pred функциональный интерфейс Predicate
     * @param s строка для которой выполняется проверка
     * @return возвращает результат проверки строки
     */
    public boolean check(Predicate<String> pred, String s) {
        return pred.test(s);
    }

    /**
     * Метод выполняет преобразование строк
     * @param fun функциональный интерфейс Function
     * @param s строка с которой выполняется преобразование
     * @return возвращает результат преобразования
     */
    public String transform(Function<String, String> fun, String s) {
        return fun.apply(s);
    }

    public static void main(String[] args) {
        StrategyUsage usage = new StrategyUsage();
        System.out.println("Результат работы: "
                + usage.check(str -> str.isEmpty(), ""));
        System.out.println("Результат работы: "
                + usage.check(str -> str.startsWith("Fun"), "Functional interface"));
        System.out.println("Результат работы: "
                + usage.check(str -> str.contains("rn"), "Surname Name"));
        System.out.println(
                "Строка после преобразования: "
                        + usage.transform(str -> str.toUpperCase(), "aBCdEfghKLmnpRstU"));
        System.out.println(
                "Строка после преобразования: " + usage.transform(
                        str -> str.concat("работает корректно."), "Строка после преобразования: "));
        System.out.println(
        "Строка после преобразования: "
                + usage.transform(str -> str.trim(), "    aBC dEfghK Lmnp RstU        "));
    }
}
