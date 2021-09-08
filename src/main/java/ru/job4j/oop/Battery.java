package ru.job4j.oop;

public class Battery {
    private int load;
    private int request;

    public Battery(int charge, int power) {
        this.load = charge;
        this.request = power;
    }

    public void exchange(Battery another) {
        this.load = this.load - this.request;
        another.load = another.load + another.request;

    }

    public static void main(String[] args) {
        Battery first = new Battery(50,10);
        Battery second = new Battery(10, 10);
        first.exchange(second);
        System.out.println("first : " + first.load + ". second : " + second.load);
    }
}
