import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ShapeOperationsTest {
    /* Method 15 */
    public static Stream<Arguments> Rectangles() {
        return Stream.of(
                Arguments.arguments(1, 1, 1),
                Arguments.arguments(2, 2, 4),
                Arguments.arguments(3, 4, 12),
                Arguments.arguments(4.22, 5.33, 22.4926),
                Arguments.arguments(0.5, 0.1, 0.05));
    }

    @ParameterizedTest(name = "Area of rectangle with length {0} and width {1}")
    @MethodSource("Rectangles")
    public void method15Test(double length, double width, double expected) {
        Assertions.assertEquals(expected, ShapeOperations.areaOfRectangle(length, width));
    }

    @Test
    public void method15TestException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeOperations.areaOfRectangle(0, 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeOperations.areaOfRectangle(1, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeOperations.areaOfRectangle(0, -2));
    }
}
