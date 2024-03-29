import java.util.*;

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
            if (plantedFlowersCount >= newFlowersCount) {
                return true;
            }
        }

        return false;
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

    public static int[] productExceptSelf(int[] numbers) {
        int size = numbers.length;
        int[] preProduct = new int[size];
        int[] postProduct = new int[size];
        int[] productExceptSelf = new int[size];
        int product = 1;

        preProduct[0] = 1;
        postProduct[size - 1] = 1;
        productExceptSelf[0] = 1;

        for (int index = 1; index < size; index++) {
            product = product * numbers[index - 1];
            preProduct[index] = product;
        }

        product = 1;
        for (int index = size - 2; index >= 0; index--) {
            product = product * numbers[index + 1];
            postProduct[index] = product;
        }

        for (int index = 0; index < size; index++) {
            productExceptSelf[index] = preProduct[index] * postProduct[index];
        }

        return productExceptSelf;
    }

    public void moveZeroes(int[] numbers) {
        int zeroIndex = 0;
        int nonZeroIndex = 0;
        int size = numbers.length;

        while (zeroIndex < size && nonZeroIndex < size) {
            if (numbers[zeroIndex] != 0) {
                zeroIndex++;
            } else if (numbers[nonZeroIndex] == 0) {
                nonZeroIndex++;
            } else {
                swap(zeroIndex, nonZeroIndex, numbers);
                zeroIndex++;
            }
        }
    }

    private void swap(int firstIndex, int secondIndex, int input[]) {
        int temp = input[firstIndex];
        input[firstIndex] = input[secondIndex];
        input[secondIndex] = temp;
    }

    public int maxSumPairs(int[] numbers, int target) {
        if (numbers.length == 1) {
            return 0;
        } else {
            int pairs = 0;
            Map<Integer, Integer> counts = new HashMap<Integer,Integer>();
            for (int number : numbers) {
                int difference = target - number;
                if (counts.containsKey(difference)) {
                    if (counts.get(difference) > 1) {
                        counts.put(difference, counts.get(difference) - 1);
                    } else {
                        counts.remove(difference);
                    }
                    pairs++;
                } else {
                    counts.put(number, counts.getOrDefault(number, 0) + 1);
                }
            }
            return pairs;
        }
    }
}
