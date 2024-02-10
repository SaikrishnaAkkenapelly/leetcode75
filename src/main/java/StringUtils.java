import java.util.Arrays;

public class StringUtils {
    public static String mergeStringsAlternatively(String firstString, String secondString) {
        StringBuilder mergedString = new StringBuilder();
        int firstStringLength = firstString.length();
        int secondStringLength = secondString.length();
        int minLength = Math.min(firstStringLength, secondStringLength);

        for (int index = 0; index < minLength; index++) {
            mergedString.append(firstString.charAt(index));
            mergedString.append(secondString.charAt(index));
        }

        mergedString.append(firstString, minLength, firstStringLength);
        mergedString.append(secondString, minLength, secondStringLength);

        return mergedString.toString();
    }

    public static String reverseWordsInASentence(String sentence) {
        String words[] = sentence.trim().split("\\s+");
        int start = 0;
        int end = words.length - 1;

        while (start < end) {
            swap(start, end, words);
            start++;
            end--;
        }

        return String.join(" ", words);
    }

    private static void swap(int firstIndex, int secondIndex, String input[]) {
        String temp = input[firstIndex];
        input[firstIndex] = input[secondIndex];
        input[secondIndex] = temp;
    }

    public static String reverseVowels(String word) {
        int start = 0;
        int end = word.length() - 1;
        char wordArray[] = word.toCharArray();

        while (start < end) {
            if (!isCharVowel(wordArray[start])) {
                start++;
            } else if (!isCharVowel(wordArray[end])) {
                end--;
            } else {
                swap(start, end, wordArray);
                start++;
                end--;
            }
        }

        return String.valueOf(wordArray);
    }

    private static boolean isCharVowel(char input) {
        return (input == 'a' || input == 'e' || input == 'i' || input == 'o' || input == 'u'
                || input == 'A' || input == 'E' || input == 'I' || input == 'O' || input == 'U');
    }

    private static void swap(int firstIndex, int secondIndex, char input[]) {
        char temp = input[firstIndex];
        input[firstIndex] = input[secondIndex];
        input[secondIndex] = temp;
    }

}
