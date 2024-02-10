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

    public static boolean canPlaceFlowers(int[] flowerbed, int newFlowers) {
        int totalFlowersThatCanBePut = 0;

        for (int index = 0; index < flowerbed.length; index++) {
            if (flowerbed[index] == 0) {
                int previousIndexValue = getPreviousIndexValue(index, flowerbed);
                int nextIndexValue = getNextIndexValue(index, flowerbed);
                if (previousIndexValue == 0 && nextIndexValue == 0) {
                    flowerbed[index] = 1;
                    totalFlowersThatCanBePut++;
                }
            }
        }

        return newFlowers <= totalFlowersThatCanBePut;
    }

    private static int getPreviousIndexValue(int currentIndex, int[] flowerbed) {
        int value = 0;
        if (currentIndex - 1 >= 0) {
            value = flowerbed[currentIndex - 1];
        }
        return value;
    }

    private static int getNextIndexValue(int currentIndex, int[] flowerbed) {
        int value = 0;
        if (currentIndex + 1 < flowerbed.length) {
            value = flowerbed[currentIndex + 1];
        }
        return value;
    }
}
