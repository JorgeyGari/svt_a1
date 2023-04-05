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

    public static Stream<Arguments> Circles() {
        return Stream.of(
                Arguments.arguments(2f, 12.57f),
                Arguments.arguments(5f, 31.42f),
                Arguments.arguments(1f, 6.28f),
                Arguments.arguments(3.6f, 22.62f),
                Arguments.arguments(0.4f, 2.51f)
        );
    }

    @ParameterizedTest(name = "Checking the perimeter of a circle")
    @MethodSource("Circles")
    public void method16Test(float radius, float expected) {
        Assertions.assertEquals(expected, ShapeOperations.perimeterCircle(radius), 0.001f);
    }

    @Test
    public void method16TestExceptions() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeOperations.perimeterCircle(0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeOperations.perimeterCircle(-2));
    }
}
