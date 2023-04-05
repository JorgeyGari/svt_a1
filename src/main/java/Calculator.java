public class Calculator {
    public static int addNumbers(int a, int b) {
        System.out.printf("%d + %d", a, b);
        return a + b;
    }

    public static int addPositiveNumbers(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
        return a + b;
    }

    public static float divideNumbers(int a, int b) {
        if (b == 0) {
            return Float.NaN;
        }
        return (float) a / b;
    }

    public static float squareRoot(int a) {
        return (float) Math.sqrt(a);
    }
}
