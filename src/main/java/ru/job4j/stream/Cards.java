package ru.job4j.stream;


import java.util.stream.Stream;

public class Cards {
    private Suits suits;
    private  Values values;

    public Cards(Suits suits, Values values) {
        this.suits = suits;
        this.values = values;
    }

    @Override
    public String toString() {
        return "DoubleLoop{"
                + "suits=" + suits
                + ", values=" + values
                + '}';
    }

    public static void main(String[] args) {
        Stream.of(Suits.values())
                .flatMap(suits1 -> Stream.of(Values.values())
                .map(values1 -> new Cards(suits1, values1)))
                        .forEach(System.out::println);
    }
}
