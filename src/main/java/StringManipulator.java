import java.util.stream.Stream;

public class StringManipulator {
    /**
     * Method 07: Reverse a string
     *
     * @param input string to reverse
     * @return the reversed string
     */
    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }

    /**
     * Method 08: Count the number of vowels in a string
     *
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
     *
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

    /**
     * Method 10: Remove whitespaces from string
     *
     * @param input string to remove whitespaces
     * @return the string without the whitespaces
     */
    public static String removeSpaces(String input) {
        if (input.isEmpty()) {
            return input;
        }
        return input.replaceAll("\\s", "");
    }

    /**
     * Method 11
     */
    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reversed);
    }

    /**
     * method 12
     */
    public static String reverseWords(String input) {
        String[] words = input.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) { //last word
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }

    /**
     * Method 13
     */
    public static String removeDuplicates(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            String currentChar = Character.toString(input.charAt(i));
            if (result.indexOf(currentChar) < 0) { //this would mean that has not been recorded yet as a character of the string
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    /**
     * method 14
     */
    public static String removeDuplicateWords(String str) {
        str = str.trim(); //to avoid if a blank space is leading the stringcan
        String[] words = str.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (words[j].equals(word)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                sb.append(word).append(" ");
            }
        }
        return sb.toString().trim();
    }

}