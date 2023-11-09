package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * Math.pow(x, 2) + 3 * x + 4);
        List<Double> expected = Arrays.asList(69D, 94D, 123D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenIndicativeFunctionThenIndicativeResult() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 9, x -> Math.pow(4, x));
        List<Double> expected = Arrays.asList(4D, 16D, 64D, 256D, 1024D, 4096D, 16384D, 65536D);
        assertThat(result).containsAll(expected);
    }
}