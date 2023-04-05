public class StringManipulator {
    /**
     * Method 07: Reverse a string
     * @param input string to reverse
     * @return the reversed string
     */
    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }

    /**
     * Method 08: Count the number of vowels in a string
     * @param input string to count vowels
     * @return the number of vowels in the string
     */
    public static int countVowels(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                count++;
            }
        }
        return count;
    }

    /**
     * Method 09: Count the number of words in a string
     * @param input string to count words
     * @return the number of words in the string
     */
    public static int countWords(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        while (input.charAt(0) == ' ') {
            input = input.substring(1);
            if (input.isEmpty()) {
                return 0;
            }
        }
        String[] words = input.split("\\s+");
        return words.length;
    }
}
