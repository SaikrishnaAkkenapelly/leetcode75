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

    public static boolean canPlaceFlowers(int[] flowerbed, int newFlowersCount) {
        int plantedFlowersCount = 0;

        for (int index = 0; index < flowerbed.length; index++) {
            if (flowerbed[index] == 0) {
                int previousValue = getPreviousValue(index, flowerbed);
                int nextValue = getNextValue(index, flowerbed);
                if (previousValue == 0 && nextValue == 0) {
                    flowerbed[index] = 1;
                    plantedFlowersCount++;
                }
            }
        }

        return newFlowersCount <= plantedFlowersCount;
    }

    private static int getPreviousValue(int index, int[] flowerbed) {
        int value = 0;
        if (index - 1 >= 0) {
            value = flowerbed[index - 1];
        }
        return value;
    }

    private static int getNextValue(int index, int[] flowerbed) {
        int value = 0;
        if (index + 1 < flowerbed.length) {
            value = flowerbed[index + 1];
        }
        return value;
    }
}
