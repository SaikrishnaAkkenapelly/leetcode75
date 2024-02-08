import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {
    public static List<Boolean> findKidsWithGreatestCandles(int candies[], int extraCandies) {
        int totalKids = candies.length;
        List<Boolean> kidsWithGreatestCandies = new ArrayList<>(totalKids);
        int maxCandies = 0;

        for (int count : candies) {
            maxCandies = Math.max(maxCandies, count);
        }

        for (int count : candies) {
            kidsWithGreatestCandies.add(extraCandies + count >= maxCandies);
        }

        return kidsWithGreatestCandies;
    }
}
