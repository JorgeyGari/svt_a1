import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

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
                Arguments.arguments("a", "a"));
    }

    @ParameterizedTest(name = "Reversing \"{0}\"")
    @MethodSource("StringsToReverse")
    public void method07Test(String input, String expected) {
        assertEquals(expected, StringManipulator.reverseString(input));
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
        assertEquals(StringManipulator.countVowels(input), expected);
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
        assertEquals(expected, StringManipulator.countWords(input));
    }

    /* Method 10 */
    public static Stream<Arguments> StringsSpaces() {
        return Stream.of(
                Arguments.arguments("hello world", "helloworld"),
                Arguments.arguments("this is a test", "thisisatest"),
                Arguments.arguments("  another   test   ", "anothertest"),
                Arguments.arguments("    ", ""),
                Arguments.arguments("", "")
        );
    }

    @ParameterizedTest(name = "Checking there are no whitespaces")
    @MethodSource("StringsSpaces")
    public void method10Test(String input, String expected) {
        assertEquals(expected, StringManipulator.removeSpaces(input));
    }

    /* Method 11 */
    @Test
    public void method11Test() {
        assertTrue(StringManipulator.isPalindrome("racecar"));
        assertTrue(StringManipulator.isPalindrome("radar"));
        assertFalse(StringManipulator.isPalindrome("hello"));
        //assertTrue(StringManipulator.isPalindrome("A man a plan a canal Panama"));
        assertTrue(StringManipulator.isPalindrome(""));
    }

    /* Method 12 */
    @Test
    public void  method12Test(){
        String input = "this is a test";
        String expectedOutput = "test a is this";
        String actualOutput = StringManipulator.reverseWords(input);
        assertEquals(expectedOutput, actualOutput);

        input = "hello world";
        expectedOutput = "world hello";
        actualOutput = StringManipulator.reverseWords(input);
        assertEquals(expectedOutput, actualOutput);

        input = " a b  c   d e  ";
        expectedOutput = "e d c b a";
        actualOutput = StringManipulator.reverseWords(input);
        assertEquals(expectedOutput, actualOutput);

        input = "";
        expectedOutput = "";
        actualOutput = StringManipulator.reverseWords(input);
        assertEquals(expectedOutput, actualOutput);

        input = "  ";
        expectedOutput = "";
        actualOutput = StringManipulator.reverseWords(input);
        assertEquals(expectedOutput, actualOutput);
    }

    /* Method 13 */
    public static Stream<Arguments> DuplicatesStrings() {
        return Stream.of(
                Arguments.arguments("hello world", "helo wrd"),
                Arguments.arguments("abcde", "abcde"),
                Arguments.arguments("abbcde", "abcde"),
                Arguments.arguments("    ", " "),
                Arguments.arguments("", ""),
                Arguments.arguments("aaaabbbccddee", "abcde")
        );
    }
        @ParameterizedTest(name= "Checking that duplicated characters are eliminated")
        @MethodSource("DuplicatesStrings")
        public void method13Tests(String input, String expectedOutput) {
            String actualOutput = StringManipulator.removeDuplicates(input);
            assertEquals(expectedOutput, actualOutput);
        }
    /* Method 14 */
    public static Stream<Arguments> DuplicatedWords() {
        return Stream.of(
                Arguments.arguments("hello world hello", "hello world"),
                Arguments.arguments("hello world", "hello world"),
                Arguments.arguments("", ""),
                Arguments.arguments("  one two     three two one", "one two three")
        );
    }
    @ParameterizedTest(name= "Checking that duplicated words are eliminated")
    @MethodSource("DuplicatedWords")
    public void method14Tests(String input, String expectedOutput) {
        String actualOutput = StringManipulator.removeDuplicateWords(input);
        assertEquals(expectedOutput, actualOutput);
    }
}
