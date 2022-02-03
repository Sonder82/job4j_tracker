package ru.job4j.stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Класс описывает  фильтрацию студентов по проходному баллу
 *
 * @author Aleksey Novoselov
 * @version 1.0
 */
public class StudentLevel {
    /**
     * Получить список студентов проходящих по баллам.
     * @param students передается начальный список студентов.
     * @param bound проходной балл.
     * @return возвращает отсортированный список по проходному баллу от большего к меньшему
     */
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted((left, right) -> Integer.compare(right.getScore(), left.getScore()))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}
