package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", value=" + value +
                '}';
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit1 -> Stream.of(Value.values())
                .map(value1 -> new Card(suit1, value1)))
                .forEach(System.out::println);
    }
}
