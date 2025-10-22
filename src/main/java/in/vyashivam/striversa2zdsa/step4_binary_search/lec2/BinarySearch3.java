package in.vyashivam.striversa2zdsa.step4_binary_search.lec2;

/*
    A monkey Koko is given ‘n’ piles of bananas, whereas the 'ith' pile has ‘piles[i]’ bananas.
    An integer ‘h’ is also given, which denotes the time (in hours) for all the bananas to be eaten.
    Each hour, the monkey chooses a non-empty pile of bananas and eats ‘k’ bananas.
    If the pile contains less than ‘k’ bananas, then the monkey consumes all the bananas and won’t eat any more bananas in that hour.

    Find the minimum number of bananas ‘k’ to eat per hour so that the monkey can eat all the bananas within ‘h’ hours.
*/

public class BinarySearch3 {
    // brute-force solution
    public static int minimumRateToEatBananas(int[] piles, int h) {
        int ans = 0;
        int maxValue = maximumValue(piles); // get the max pile value as the upper limit for speed

        for (int i = 1; i <= maxValue; i++) {
            int totalHours = timeOfEachPile(piles, i); // total hours needed at speed i
            if (totalHours <= h) {
                ans = i; // if within allowed time, we found the answer
                break;
            }
        }

        return ans;
    }

    // helper to find maximum element (used as high boundary)
    private static int maximumValue(int[] arr) {
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // helper to calculate total time required for each pile of bananas at a given speed
    private static int timeOfEachPile(int[] piles, int speed) {
        int totalHours = 0;
        for (int i = 0; i < piles.length; i++) {
            double ans = (double) piles[i] / speed;
            totalHours += (int) Math.ceil(ans);
        }
        return totalHours;
    }

    // optimal solution - binary search
    public static int minEatingSpeed(int[] piles, int h) {
        int ans = 0;
        int low = 1, high = maxValue(piles); // search space between 1 and max pile

        while (low <= high) {
            long mid = (low + high) / 2; // current eating speed
            long totalHours = timeOfPile(piles, mid); // hours needed at this speed
            if (totalHours <= h) { // can finish within h hours -> try smaller speed
                ans = (int) mid;
                high = (int) (mid - 1);
            } else { // takes more time -> need to eat faster
                low = (int) (mid + 1);
            }
        }

        return ans;
    }

    // helper to find max value in array
    private static int maxValue(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // calculates total hours at given eating speed (use long to prevent overflow)
    private static long timeOfPile(int[] piles, long speed) {
        long totalHours = 0;
        for (int i = 0; i < piles.length; i++) {
            totalHours += (long) Math.ceil((double) piles[i] / speed);
        }
        return totalHours;
    }
}
//link: https://leetcode.com/problems/koko-eating-bananas/
//link2: https://www.naukri.com/code360/problems/koko-eating-bananas_10870969
