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
}
