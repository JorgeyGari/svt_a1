public class ShapeOperations {
    /**
     * Method 15: Area of a rectangle
     *
     * @param length length of the rectangle
     * @param width  width of the rectangle
     * @return the area of the rectangle
     * @throws IllegalArgumentException if length or width are not positive
     */
    public static double areaOfRectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be positive");
        }
        return length * width;
    }

    /**
     * Method 16: Perimeter of a circle
     *
     * @param radius radius of circle
     * @return the perimeter of the circle
     * @throws IllegalArgumentException if radius is not positive
     */
    public static float perimeterCircle(float radius) {
        return Float.NaN;
    }

    /**
     * Method 17: Type of triangle
     *
     * @param sidea side a of the triangle
     * @param sideb side b of the triangle
     * @param sidec side c of the triangle
     * @return the type of the triangle
     * @throws IllegalArgumentException if any side is not positive
     */
    public static String typeTriangle(float sidea, float sideb, float sidec) {
        return null;
    }
}
