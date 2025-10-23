package in.vyashivam.striversa2zdsa.step4_binary_search.lec2;
/*
    You are given 'N’ roses and you are also given an array 'arr' where 'arr[i]' denotes that the 'ith' rose will bloom
    on the 'arr[i]th' day.

    You can only pick already bloomed roses that are adjacent to make a bouquet.
    You are also told that you require exactly 'k' adjacent bloomed roses to make a single bouquet.

    Find the minimum number of days required to make at least ‘m' bouquets each containing 'k' roses.
    Return -1 if it is not possible.
*/
public class BinarySearch4 {
    // brute-force solution
    public static int minNumberOfDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m * k > n) { // check if total flowers required exceed available flowers
            return -1;
        }

        // Determining the search range
        int minDay = minValue(bloomDay);
        int maxDay = maxValue(bloomDay);
        int ans = 0;

        // Trying every day between minimum day and maximum day
        for (int i = minDay; i <= maxDay; i++) {
            if(isDayPossible(bloomDay, i, m, k)) {  // Check if 'ith day can make at least 'm' bouquets
                ans = i; // First valid day found -> the smallest possible
                break;
            }
        }
        return ans;
    }

    // Helper: Find minimum bloom day
    private static int minValue(int[] arr) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < ans) {
                ans = arr[i];
            }
        }
        return ans;
    }

    // Helper: Find maximum bloom day
    private static int maxValue(int[] arr) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > ans) {
                ans = arr[i];
            }
        }
        return ans;
    }

    // Check if the given 'day' is enough to make 'm' bouquets with each having size 'k' flowers
    private static boolean isDayPossible(int[] bloomDay, int day, int m, int k) {
        int count = 0, noOfBouquets = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) { // Flower has bloomed -> count towards current bouquet
                count++;
            } else {
                noOfBouquets += (count / k); // Flower hasn't bloomed -> reset, form bouquet(s) from previous streak
                count = 0;
            }
        }
        noOfBouquets += (count / k); // After loop, check if the last sequence also contributes bouquets
        return noOfBouquets >= m; // If enough bouquets formed, return true
    }

    //optimal solution - binarySearch

    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        // Overflow-safe multiplication using long (because m and k can be large as per constraints)
        long totalFlowers = (long) m * k;
        if(totalFlowers > n) {
            return -1;
        }

        // Binary search range between minimum and maximum bloom day
        long low = minValue(bloomDay);
        long high = maxValue(bloomDay);
        long ans = -1L;

        // Binary search to find the minimum possible 'day'
        while (low <= high) {
            long mid = (low + high) / 2;

            // Check if current 'mid' day is feasible
            if(isDayPossible(bloomDay, mid, m, k)) {
                ans = mid; // our answer
                high = mid - 1; // try smaller day (left half)
            } else {
                low = mid + 1; // need more days (right half)
            }
        }
        return (int) ans; // returning the smallest days on which bouquets can be made.
    }

    // Helper: Find minimum bloom day
    private static int minimumValue(int[] arr) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < ans) {
                ans = arr[i];
            }
        }
        return ans;
    }

    // Helper: Find maximum bloom day
    private static int maximumValue(int[] arr) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > ans) {
                ans = arr[i];
            }
        }
        return ans;
    }

    // Check if the given 'day' is enough to make 'm' bouquets with each having size 'k' flowers
    private static boolean isDayPossible(int[] bloomDay, long day, int m, int k) {
        long count = 0, noOfBouquets = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) { // Flower has bloomed -> count towards current bouquet
                count++;
            } else {
                noOfBouquets += (long) (count / k);
                count = 0;
            }
        }
        noOfBouquets += (long) (count / k);
        return noOfBouquets >= m;
    }
}
//link: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
//link2: https://www.naukri.com/code360/problems/rose-garden_2248080
