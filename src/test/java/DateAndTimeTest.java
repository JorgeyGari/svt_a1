import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.DateTimeException;
import java.time.LocalDate;
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

    /* Method 20 */
    public static Stream<Arguments> DatesDays() {
        return Stream.of(
                Arguments.arguments(LocalDate.of(2022, 6, 2), LocalDate.of(2022, 8, 4), 63),
                Arguments.arguments(LocalDate.of(2022, 9, 19), LocalDate.of(2023, 1, 19), 122),
                Arguments.arguments(LocalDate.of(2022, 6, 2), LocalDate.of(2023, 6, 2), 365),
                Arguments.arguments(LocalDate.of(2023, 5, 1), LocalDate.of(2023, 5, 1), 0),
                Arguments.arguments(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 2), 1),
                Arguments.arguments(LocalDate.of(0, 1, 1), LocalDate.of(0, 2, 1), 31),
                Arguments.arguments(LocalDate.of(-1, 12, 31), LocalDate.of(0, 1, 2), 2)
        );
    }

    @ParameterizedTest(name = "Checking number of days")
    @MethodSource("DatesDays")
    public void method20Test(LocalDate date1, LocalDate date2, long expected) {
        Assertions.assertEquals(expected, DateAndTime.numberDays(date1, date2));
    }

    @Test
    public void method20TestExceptionsNegatives() {
        Assertions.assertThrows(DateTimeException.class, () -> DateAndTime.numberDays(LocalDate.of(2023, -1, 1), LocalDate.of(2023, 1, 2)));
        Assertions.assertThrows(DateTimeException.class, () -> DateAndTime.numberDays(LocalDate.of(2023, 1, -1), LocalDate.of(2023, 1, 2)));
        Assertions.assertThrows(DateTimeException.class, () -> DateAndTime.numberDays(LocalDate.of(2023, 1, 1), LocalDate.of(2023, -1, 2)));
        Assertions.assertThrows(DateTimeException.class, () -> DateAndTime.numberDays(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, -2)));
        Assertions.assertThrows(DateTimeException.class, () -> DateAndTime.numberDays(LocalDate.of(0, 0, 3), LocalDate.of(8, 4, 2)));
        Assertions.assertThrows(DateTimeException.class, () -> DateAndTime.numberDays(LocalDate.of(0, 9, 0), LocalDate.of(8, 4, 2)));

    }

    @Test
    public void method20TestExceptionsOrder() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.numberDays(LocalDate.of(2023, 4, 3), LocalDate.of(2023, 4, 2)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.numberDays(LocalDate.of(2023, 4, 3), LocalDate.of(2023, 2, 2)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.numberDays(LocalDate.of(2023, 4, 3), LocalDate.of(2022, 4, 2)));
    }

    @Test
    public void method20TestExceptionsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.numberDays(null, LocalDate.of(2023, 4, 2)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.numberDays(LocalDate.of(2022, 4, 3), null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.numberDays(null, null));
    }

    /* Method 21 */
    public static Stream<Arguments> Weekends() {
        return Stream.of(
                Arguments.arguments(LocalDate.of(2023, 5, 1), false),
                Arguments.arguments(LocalDate.of(2023, 2, 14), false),
                Arguments.arguments(LocalDate.of(2022, 3, 9), false),
                Arguments.arguments(LocalDate.of(2022, 6, 2), false),
                Arguments.arguments(LocalDate.of(2023, 8, 4), false),
                Arguments.arguments(LocalDate.of(2023, 1, 21), true),
                Arguments.arguments(LocalDate.of(2022, 8, 28), true),
                Arguments.arguments(LocalDate.of(1582, 10, 15), false),
                Arguments.arguments(LocalDate.of(1582, 10, 16), true)
        );
    }

    @ParameterizedTest(name = "Checking if a date falls on weekend")
    @MethodSource("Weekends")
    public void method21Test(LocalDate date, boolean expected) {
        Assertions.assertEquals(expected, DateAndTime.checkWeekend(date));
    }

    @Test
    public void method21TestExceptionsYear() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.checkWeekend(LocalDate.of(1581, 12, 31)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.checkWeekend(LocalDate.of(1582, 10, 14)));
    }

    @Test
    public void method21TestExceptionsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.checkWeekend(null));
    }

    @Test
    public void method21TestExceptionsInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.checkWeekend(LocalDate.of(2020, 0, 3)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.checkWeekend(LocalDate.of(2020, 12, 0)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.checkWeekend(LocalDate.of(2022, -3, 8)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.checkWeekend(LocalDate.of(2021, 12, -3)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.checkWeekend(LocalDate.of(2021, 2, 29)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.checkWeekend(LocalDate.of(2022, 11, 31)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> DateAndTime.checkWeekend(LocalDate.of(2023, 13, 12)));
    }
}
