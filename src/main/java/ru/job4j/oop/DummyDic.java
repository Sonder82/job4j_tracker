package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return eng;
    }

    public static void main(String[] args) {
        DummyDic word = new DummyDic();
        String input = word.engToRus("zzz");
        System.out.println("Неизвестное слово. " + input);
    }
}
