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
     * Method 11: Check if a string is a palindrome
     * @param str string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return str.equalsIgnoreCase(reversed);
    }

    /**
     * Method 12: Reverse the words in a string
     * @param input string to reverse
     * @return the string with the words reversed
     */
    public static String reverseWords(String input) {
        String[] words = input.trim().split("\\s+");
        String reversed = "";
        for (int i = words.length - 1; i >= 0; i--) {
            reversed += words[i];
            if (i != 0) {
                reversed += " ";
            }
        }
        return reversed;
    }


    /**
     * Method 13: Remove duplicate characters from a string
     * @param input string to remove duplicates
     * @return the string without the duplicate characters
     */
    public static String removeDuplicates(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            String currentChar = Character.toString(input.charAt(i));
            if (result.indexOf(currentChar) < 0) { //this would mean that has not been recorded yet as a character of the string
                result += currentChar;
            }
        }
        return result;
    }

    /**
     * Method 14: Remove duplicate words from a string
     * @param str string to remove duplicates
     * @return the string without the duplicate words
     */
    public static String removeDuplicateWords(String str) {
        str = str.trim();
        String[] words = str.split("\\s+");
        String result = "";
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
                result += word + " ";
            }
        }
        return result.trim();
    }


}