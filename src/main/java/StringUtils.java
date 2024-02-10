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

    public static int compress(char[] chars) {
        char previousChar = chars[0];
        int previousCharSize = 1;
        int length = chars.length;
        int compressedIndex = 0;

        for (int index = 1; index < length; index++) {
            if (chars[index] == previousChar) {
                previousCharSize++;
            } else {
                chars[compressedIndex++] = previousChar;
                compressedIndex = updateChars(chars, compressedIndex, previousCharSize);
                previousChar = chars[index];
                previousCharSize = 1;
            }
        }

        chars[compressedIndex++] = previousChar;
        compressedIndex = updateChars(chars, compressedIndex, previousCharSize);

        return compressedIndex;
    }

    private static int updateChars(char chars[], int index, int previousCharSize) {
        if (previousCharSize != 1) {
            char numbers[] = String.valueOf(previousCharSize).toCharArray();
            for (char number : numbers) {
                chars[index++] = number;
            }
        }
        return index;
    }
}
