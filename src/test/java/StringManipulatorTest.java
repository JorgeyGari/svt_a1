import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StringManipulatorTest {
    /* Method 07 */
    public static Stream<Arguments> StringsToReverse() {
        return Stream.of(
                Arguments.arguments("Hello", "olleH"),
                Arguments.arguments("World", "dlroW"),
                Arguments.arguments("Java", "avaJ"),
                Arguments.arguments("racecar", "racecar"),
                Arguments.arguments("taco cat", "tac ocat"),
                Arguments.arguments("123456789", "987654321"),
                Arguments.arguments("UC3M", "M3CU"),
                Arguments.arguments(" ", " "),
                Arguments.arguments("", ""),
                Arguments.arguments("a", "a")
        );
    }
    @ParameterizedTest(name = "Reversing \"{0}\"")
    @MethodSource("StringsToReverse")
    public void method07Test(String input, String expected) {
        Assertions.assertEquals(expected, StringManipulator.reverseString(input));
    }

    /* Method 08 */
    public static Stream<Arguments> StringsVowels() {
        return Stream.of(
                Arguments.arguments("Hello, world!", 3),
                Arguments.arguments("Java", 2),
                Arguments.arguments("AEIOU", 5),
                Arguments.arguments("the elephant", 4),
                Arguments.arguments("bcd", 0),
                Arguments.arguments("AaEeIiOoUuAAeeIIooUUaaEEiiOOuu", 30),
                Arguments.arguments("", 0));
    }
    @ParameterizedTest(name = "Counting vowels in \"{0}\"")
    @MethodSource("StringsVowels")
    public void method08Test(String input, int expected) {
        Assertions.assertEquals(StringManipulator.countVowels(input), expected);
    }

    /* Method 09 */
    public static Stream<Arguments> StringsWords() {
        return Stream.of(
                Arguments.arguments("hello world", 2),
                Arguments.arguments("this is a test", 4),
                Arguments.arguments(" now there is a space", 5),
                Arguments.arguments("space at the end of the string ", 7),
                Arguments.arguments(" ", 0),
                Arguments.arguments("", 0),
                Arguments.arguments("   hi    you  ", 2)
        );
    }

    @ParameterizedTest(name = "Checking the number of words in a string")
    @MethodSource("StringsWords")
    public void method09Test(String input, int expected) {
        Assertions.assertEquals(expected, StringManipulator.countWords(input));
    }
}
