import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import java.util.Random;

public class CalculatorTest {
    @Test
    public void method01Test1(){
        Random rand = new Random();
        //testing with integers
        int int_randomA = rand.nextInt(65536)-32768; //In this way, we have the range [-32768, 32768]
        int int_randomB = rand.nextInt(65536)-32768;
        int expected = int_randomA+int_randomB;
        //Add also tests with other types, floats, doubles
        Assertions.assertEquals(expected, Calculator.addNumbers(int_randomA, int_randomB));

    }
    @ParameterizedTest(name = "Checking if {0} + {1} = {2}")
    @MethodSource("NumbersSum")
    public void method01Test2(int a, int b, int expected){
        Assertions.assertEquals(expected, Calculator.addNumbers(a, b));
    }

    @ParameterizedTest(name = "Checking if {0} + {1} = {2}")
    @MethodSource("positiveNumbers")
    public void method02Test(int a, int b, int expected){
        Assertions.assertEquals(expected, Calculator.addPositiveNumbers(a, b));
    }
    public static Stream<Arguments> NumbersSum() {
        return Stream.of(
                Arguments.arguments(2, 1, 3),
                Arguments.arguments(1, -2, -1),
                Arguments.arguments(0,Integer.MAX_VALUE, Integer.MAX_VALUE)
        );
    }

    public static Stream<Arguments> positiveNumbers(){
        return Stream.of(
                Arguments.arguments(2, 1, 3),
                Arguments.arguments(1, 2, 3),
                Arguments.arguments(0, 0, 0),
                Arguments.arguments(0, 1, 1),
                Arguments.arguments(1, 0, 1)
        );
    }
}