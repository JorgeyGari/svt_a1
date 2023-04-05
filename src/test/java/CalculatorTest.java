import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTest {
    @ParameterizedTest(name = "Checking if {0} + {1} = {2}")

    @MethodSource("positiveNumbers")
    public void method02Test(int a, int b, int expected){
        Assertions.assertEquals(expected, Calculator.addPositiveNumbers(a, b));
    }

    // Check if the method throws an exception when negative numbers are passed
    @Test
    public void method02checkNegativeException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Calculator.addPositiveNumbers(-1, 1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Calculator.addPositiveNumbers(1, -1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Calculator.addPositiveNumbers(-1, -1);
        });
    }

    public static Stream<Arguments> positiveNumbers(){
        return Stream.of(
                Arguments.arguments(2, 1, 3),
                Arguments.arguments(1, 2, 3),
                Arguments.arguments(0, 0, 0),
                Arguments.arguments(0, 1, 1),
                Arguments.arguments(1, 0, 1),
                Arguments.arguments(1, 1, 2)
        );
    }
}