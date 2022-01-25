package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int rsl = add(
                () -> {
                    int total = 0;
                    for (int i : number) {
                        total += i;
                    }
                    return total;
                }
        );
        System.out.println(rsl);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
