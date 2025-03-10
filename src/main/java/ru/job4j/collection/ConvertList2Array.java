package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        System.out.println(groups);
        int[][] array = new int[groups][cells];
        int row = 0, cell = 0;
        for (Integer num : list) {
            array[row][cell++] = num;
            if (cell >= cells) {
                cell = 0;
                row++;
            }
        }
            return array;
        }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] rsl = toArray(list, 3);
        for (int row = 0; row < rsl.length; row++) {
            for (int cell = 0; cell < rsl[row].length; cell++) {
                System.out.println(cell + " ");
            }
            System.out.println();
        }
    }
}
