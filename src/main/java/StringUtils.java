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
}
