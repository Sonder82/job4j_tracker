package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Транспортные средства");

    }

    @Override
    public void passenger(int count) {
        System.out.println("Количество пассажиров: " + count);

    }

    @Override
    public double toFuel(double fuel) {
        double price = 50;
        return fuel * price;
    }
}
