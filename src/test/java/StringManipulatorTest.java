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
    @ParameterizedTest(name = "Reversing '{0}'")
    @MethodSource("StringsToReverse")
    public void method07Test(String input, String expected) {
        Assertions.assertEquals(expected, StringManipulator.reverseString(input));
    }
}
