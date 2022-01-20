package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Класс описывает работу сортировки с помощью создания компаратора на основании анонимного класса
 * @author Alexey Novoselov
 * @version 1.0
 */
public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getSize() - right.getSize();
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);

        ArrayList<Integer> list = new ArrayList<Integer>() {
            @Override
            public boolean add(Integer o) {
                System.out.println("Add a new element to list: " + o);
                return super.add(o);
            }
        };
        list.add(100500);

        Comparator<Attachment> comparatorName = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment first, Attachment second) {
                return first.getName().compareTo(second.getName());
            }
        };
        attachments.sort(comparatorName);
        System.out.println(attachments);
    }
}
