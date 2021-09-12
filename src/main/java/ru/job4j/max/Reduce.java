package ru.job4j.max;

public class Reduce {
    private int[] array;

    public void to(int[] input) {
        this.array = input;
    }

    public void print() {
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(input);
        reduce.print();
    }
}
