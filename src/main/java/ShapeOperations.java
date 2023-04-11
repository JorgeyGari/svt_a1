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
    public static double perimeterCircle(float radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        return 2 * Math.PI * radius;
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
        if (sidea <= 0 || sideb <= 0 || sidec <= 0) {
            throw new IllegalArgumentException("All sides must be positive");
        }
        if (sidea == sideb && sidea == sidec) {
            return "equilateral";
        }
        if (sidea == sideb || sidea == sidec || sideb == sidec) {
            return "isosceles";
        }
        return "scalene";
    }

    /**
     * method 18
     */
    public static class Point {
        private final float x, y;
        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }
        public float getX() {
            return x;
        }
        public float getY() {
            return y;
        }
    }
    public static double distanceBetweenPoints(Point p1, Point p2) {
        double deltaX = p2.getX() - p1.getX();
        double deltaY = p2.getY() - p1.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);

    }

}
