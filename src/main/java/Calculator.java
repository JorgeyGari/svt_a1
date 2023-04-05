import java.util.List;

public class Calculator {
    /**
     * Method 01: Add two numbers
     * @param a first number
     * @param b second number
     * @return the sum of a and b
     */
    public static int addNumbers(int a, int b) {
        System.out.printf("%d + %d", a, b);
        return a + b;
    }

    /**
     * Method 02: Add two positive numbers
     * @param a first number
     * @param b second number
     * @return the sum of a and b
     * @throws IllegalArgumentException if a or b are negative
     */
    public static int addPositiveNumbers(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
        return a + b;
    }

    /**
     * Method 03: Divide two numbers
     * @param a first number
     * @param b second number
     * @return the division of a and b
     * @throws IllegalArgumentException if b is 0
     */
    public static float divideNumbers(int a, int b) {
        if (b == 0) {
            return Float.NaN;
        }
        return (float) a / b;
    }

    /**
     * Method 04: Calculate the square root of a number
     * @param a number
     * @return the square root of 'a' or NaN if 'a' is negative
     */
    public static float squareRoot(int a) {
        return (float) Math.sqrt(a);
    }

    /**
     * Method 05: Calculate the average of a list of numbers
     * @param numbers list of numbers
     * @return the average of the numbers in the list
     */
    public static float listAverage(List<Float> numbers) {
        float sum = 0;
        for (float n : numbers) {
            sum += n;
        }
        System.out.printf("size " + numbers.size() + "\n");
        return sum / numbers.size();
    }

    /**
     * Method 06: Convert a number to binary
     * @param a number
     * @return the binary representation of 'a'
     */
    public static String toBinary(int a) {
        return Integer.toBinaryString(a);
    }
}
