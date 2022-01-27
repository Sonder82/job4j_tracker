package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MathFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Function<Double, Double> func = x -> 2 * x + 1;
        List<Double> result = MathFunction.diapason(5, 8, func);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Function<Double, Double> func = x -> 2 * (x * x) + 3 * x + (-5);
        List<Double> result = MathFunction.diapason(5, 8, func);
        List<Double> expected = Arrays.asList(60D, 85D, 114D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        Function<Double, Double> func = x -> Math.pow(2, x);
        List<Double> result = MathFunction.diapason(5, 8, func);
        List<Double> expected = Arrays.asList(32D, 64D, 128D);
        assertThat(result, is(expected));
    }
}