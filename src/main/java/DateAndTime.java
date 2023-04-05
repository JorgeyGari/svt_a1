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
}
