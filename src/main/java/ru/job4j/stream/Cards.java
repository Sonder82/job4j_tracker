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
                .flatMap(s -> Stream.of(Values.values())
                .map(v -> new Cards(s, v)))
                        .forEach(System.out::println);
    }
}
