import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import java.util.Random;

public class CalculatorTest {

    /* Method 01 */
    @Test
    public void method01Test1() {
        Random rand = new Random();
        //testing with integers
        float f_randomA = rand.nextFloat()*(32768-65536); //In this way, we have the range [-32768, 32768]
        float f_randomB = rand.nextFloat()*(32768-65536);
        float expected = f_randomA + f_randomB;
        Assertions.assertEquals(expected, Calculator.addNumbers(f_randomA, f_randomB), 1000000);

    }

    @ParameterizedTest(name = "Checking if {0} + {1} = {2}")
    @MethodSource("NumbersSum")
    public void method01TestCases(float a, float b, float expected) {
        Assertions.assertEquals(expected, Calculator.addNumbers(a, b));
    }

    public static Stream<Arguments> NumbersSum() {
        return Stream.of(
                Arguments.arguments(2, 1, 3),
                Arguments.arguments(1, -2, -1),
                Arguments.arguments(1, Float.MAX_VALUE, Float.MAX_VALUE)
        );
    }
    /* Method 02 */
    @ParameterizedTest(name = "Checking if {0} + {1} = {2}")
    @MethodSource("positiveNumbers")
    public void method02Test(int a, int b, int expected) {
        Assertions.assertEquals(expected, Calculator.addPositiveNumbers(a, b));
    }

    @Test
    public void method02TestException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Calculator.addPositiveNumbers(-1, 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Calculator.addPositiveNumbers(1, -1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Calculator.addPositiveNumbers(-1, -1));
    }

    public static Stream<Arguments> positiveNumbers() {
        return Stream.of(
                Arguments.arguments(2, 1, 3),
                Arguments.arguments(1, 2, 3),
                Arguments.arguments(0, 0, 0),
                Arguments.arguments(0, 1, 1),
                Arguments.arguments(1, 0, 1),
                Arguments.arguments(1, 1, 2)
        );
    }

    /* Method 03 */
    public static Stream<Arguments> NumbersDivision() {
        return Stream.of(
                Arguments.arguments(1, 1, 1),
                Arguments.arguments(5, 5, 1),
                Arguments.arguments(8, 4, 2),
                Arguments.arguments(10, 4, 2.5f),
                Arguments.arguments(6, -2, -3),
                Arguments.arguments(0, 3, 0),
                Arguments.arguments(4, 0, Float.NaN)
        );
    }

    @ParameterizedTest(name = "Checking if {0} / {1} = {2}")
    @MethodSource("NumbersDivision")
    public void method03Test(int a, int b, float expected) {
        Assertions.assertEquals(expected, Calculator.divideNumbers(a, b));
    }

    /* Method 04 */
    public static Stream<Arguments> NumbersSquareRoot() {
        return Stream.of(
                Arguments.arguments(0, 0),
                Arguments.arguments(1, 1),
                Arguments.arguments(9, 3),
                Arguments.arguments(81, 9),
                Arguments.arguments(2, 1.4142135623730951),
                Arguments.arguments(0.25, 0.5),
                Arguments.arguments(0.01, 0.1),
                Arguments.arguments(100, 10),
                Arguments.arguments(-4, Double.NaN),
                Arguments.arguments(-9, Double.NaN),
                Arguments.arguments(-0, 0));
    }

    @ParameterizedTest(name = "Checking if the square root of {0} is {1}")
    @MethodSource("NumbersSquareRoot")
    public void method04Test(double a, double expected) {
        Assertions.assertEquals(expected, Calculator.squareRoot(a));
    }

    /* Method 05 */
    public static Stream<Arguments> NumbersList() {
        return Stream.of(
                Arguments.arguments(Arrays.asList(2f), 2f),
                Arguments.arguments(Arrays.asList(4f, 8f), 6f),
                Arguments.arguments(Arrays.asList(6f, 6f), 6f),
                Arguments.arguments(Arrays.asList(23.1f, 34.2f, 45.3f), 34.2f),
                Arguments.arguments(Arrays.asList(8f, 9.3f, 2.6f), 6.63f),
                Arguments.arguments(Arrays.asList(0f, 10f), 5f),
                Arguments.arguments(Arrays.asList(5f, -5f), 0f)
        );
    }

    @ParameterizedTest(name = "Checking the average of a list of numbers")
    @MethodSource("NumbersList")
    public void method05Test(List<Float> numbers, float expected) {
        float actual = Calculator.listAverage(numbers);
        Assertions.assertEquals(expected, actual, 0.01f);
    }

    /* Method 06 */
    public static Stream<Arguments> NumbersBinary() {
        return Stream.of(
                Arguments.arguments(0, "0"),
                Arguments.arguments(1, "1"),
                Arguments.arguments(2, "10"),
                Arguments.arguments(3, "11"),
                Arguments.arguments(16, "10000"),
                Arguments.arguments(17, "10001"),
                Arguments.arguments(31, "11111"),
                Arguments.arguments(32, "100000"),
                Arguments.arguments(-1, "11111111111111111111111111111111"),
                Arguments.arguments(-32, "11111111111111111111111111100000"));
    }

    @ParameterizedTest(name = "Checking the binary representation of {0}")
    @MethodSource("NumbersBinary")
    public void method06Test(int a, String expected) {
        Assertions.assertEquals(expected, Calculator.toBinary(a));
    }
}