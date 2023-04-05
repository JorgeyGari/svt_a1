import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DateAndTimeTest {
    /* Method 19 */
    public static Stream<Arguments> leapYears() {
        return Stream.of(
                Arguments.arguments(2000, true),
                Arguments.arguments(2001, false),
                Arguments.arguments(2002, false),
                Arguments.arguments(2003, false),
                Arguments.arguments(2004, true),
                Arguments.arguments(1583, false),
                Arguments.arguments(1584, true));
    }

    @ParameterizedTest(name = "Checking if {0} is a leap year")
    @MethodSource("leapYears")
    public void method19Test(int year, boolean expected) {
        Assertions.assertEquals(expected, DateAndTime.isLeapYear(year));
    }

    @Test
    public void method19TestException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.isLeapYear(1582));
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.isLeapYear(0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.isLeapYear(-1));
    }
}
