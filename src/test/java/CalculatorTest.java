import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import java.util.Random;

public class CalculatorTest {

    @Test
    public void method01Test1() {
        Random rand = new Random();
        //testing with integers
        int int_randomA = rand.nextInt(65536) - 32768; //In this way, we have the range [-32768, 32768]
        int int_randomB = rand.nextInt(65536) - 32768;
        int expected = int_randomA + int_randomB;
        //Add also tests with other types, floats, doubles
        Assertions.assertEquals(expected, Calculator.addNumbers(int_randomA, int_randomB));

    }

    @ParameterizedTest(name = "Checking if {0} + {1} = {2}")
    @MethodSource("NumbersSum")
    public void method01Test2(int a, int b, int expected) {
        Assertions.assertEquals(expected, Calculator.addNumbers(a, b));
    }

    @ParameterizedTest(name = "Checking if {0} + {1} = {2}")

    @MethodSource("positiveNumbers")
    public void method02Test(int a, int b, int expected) {
        Assertions.assertEquals(expected, Calculator.addPositiveNumbers(a, b));
    }

    public static Stream<Arguments> NumbersSum() {
        return Stream.of(
                Arguments.arguments(2, 1, 3),
                Arguments.arguments(1, -2, -1),
                Arguments.arguments(0, Integer.MAX_VALUE, Integer.MAX_VALUE)
        );
    }

    /* Method 02 */
    // Check if the method throws an exception when negative numbers are passed
    @Test
    public void method02checkNegativeException() {
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
                Arguments.arguments(100, 10),
                Arguments.arguments(2, 1.4142135f),
                Arguments.arguments(3, 1.7320508f),
                Arguments.arguments(-4, Float.NaN),
                Arguments.arguments(-9, Float.NaN),
                Arguments.arguments(-0, 0));
    }

    @ParameterizedTest(name = "Checking if the square root of {0} is {1}")
    @MethodSource("NumbersSquareRoot")
    public void method04Test(int a, float expected) {
        Assertions.assertEquals(expected, Calculator.squareRoot(a));
    }
}