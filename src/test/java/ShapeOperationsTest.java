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

    /* Method 16 */
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
        Assertions.assertEquals(expected, ShapeOperations.perimeterCircle(radius), 0.01f);
    }

    @Test
    public void method16TestExceptions() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeOperations.perimeterCircle(0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeOperations.perimeterCircle(-2));
    }

    /* Method 17 */
    public static Stream<Arguments> Triangles() {
        return Stream.of(
                Arguments.arguments(1, 2, 3, "scalene"),
                Arguments.arguments(2, 2, 4, "isosceles"),
                Arguments.arguments(4, 3, 4, "isosceles"),
                Arguments.arguments(6, 1, 1, "isosceles"),
                Arguments.arguments(3, 3, 3, "equilateral"),
                Arguments.arguments(4.3f, 5, 4.2f, "scalene"),
                Arguments.arguments(7.9f, 8, 7.9f, "isosceles"),
                Arguments.arguments(4.1f, 4.1f, 4.1f, "equilateral")
        );
    }

    @ParameterizedTest(name = "Checking the type of triangle")
    @MethodSource("Triangles")
    public void method17Test(float sidea, float sideb, float sidec, String expected) {
        Assertions.assertEquals(expected, ShapeOperations.typeTriangle(sidea, sideb, sidec));
    }

    @Test
    public void method17TestExceptionsZeros() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeOperations.typeTriangle(0, 0, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeOperations.typeTriangle(0, 1, 2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeOperations.typeTriangle(1, 0, 3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeOperations.typeTriangle(2, 1, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeOperations.typeTriangle(0, 0, 5));
    }
    @Test
    public void method17TestExceptionsNegatives() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeOperations.typeTriangle(-7, 3, 4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeOperations.typeTriangle(3, -1, 3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeOperations.typeTriangle(2, 8, -2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeOperations.typeTriangle(-9, 2, -1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ShapeOperations.typeTriangle(-1, -1, -1));
    }

    //method18
    public static Stream<Arguments> DistancesArgs() {
        return Stream.of(
                Arguments.arguments(new ShapeOperations.Point(1,1),new ShapeOperations.Point(0,3), 2.2360679), //negative slope
                Arguments.arguments(new ShapeOperations.Point(0,3),new ShapeOperations.Point(0,5.25f), 2.25), //same vertical plane -> difference of the y-coordinates
                Arguments.arguments(new ShapeOperations.Point(0,3),new ShapeOperations.Point(0,3), 0), //same point
                Arguments.arguments(new ShapeOperations.Point(1,4),new ShapeOperations.Point(4,1), 4.2426406) //positive slope
                );
    }
    @ParameterizedTest(name = "Computing the distance between points")
    @MethodSource("DistancesArgs")
    void testDistanceBetweenPoints(ShapeOperations.Point p1, ShapeOperations.Point p2, double expected) {
        double actual = ShapeOperations.distanceBetweenPoints(p1, p2);
        Assertions.assertEquals(expected, actual, 0.0001);
    }
}
