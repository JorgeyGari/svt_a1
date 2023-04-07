import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateAndTime {

    /**
     * Method 19: Check if a year is a leap year
     *
     * @param year year to check
     * @return true if the year is a leap year, false otherwise
     * @throws IllegalArgumentException if the year is less than 1582
     */
    public static boolean isLeapYear(int year) {
        if (year <= 1582) {
            throw new IllegalArgumentException("Year must be greater than 1582, the first year in the Gregorian calendar");
        }
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }

    /**
     * Method 20: Number of days between two dates
     *
     * @param date1 first date
     * @param date2 second date
     * @return the number of days between the first and the second date
     * @throws IllegalArgumentException if any date is null
     * @throws IllegalArgumentException if the second date is prior to the first one
     * @throws DateTimeException if a date is invalid (day or month are not in the correct range)
     */
    public static long numberDays(LocalDate date1, LocalDate date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }
        if (date2.isBefore(date1)) {
            throw new IllegalArgumentException("The second date cannot be before the first one");
        }
        try {
            return ChronoUnit.DAYS.between(date1, date2);
        } catch (DateTimeException e) {
            throw new DateTimeException("Dates cannot have negative values" + e.getMessage());
        }
    }

    /**
     * Method 21: Check if a date falls on a weekend
     *
     * @param date date to check
     * @return true if the date falls in a weekend, false otherwise
     * @throws IllegalArgumentException if the date is prior to October 15th, 1582
     * @throws IllegalArgumentException if the date is null
     * @throws DateTimeException if the date is invalid (day or month are not in the correct range)
     */

    public static boolean checkWeekend(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        if (date.isBefore(LocalDate.of(1582, 10, 15))) {
            throw new IllegalArgumentException("Date must be within the use of the Gregorian calendar");
        }
        try {
            DayOfWeek day = date.getDayOfWeek();
            return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
        } catch (DateTimeException e) {
            throw new DateTimeException("Invalid date");
        }
    }
}