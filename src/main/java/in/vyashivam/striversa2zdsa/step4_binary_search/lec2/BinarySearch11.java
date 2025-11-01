package in.vyashivam.striversa2zdsa.step4_binary_search.lec2;

import java.util.ArrayList;

/*
    Given an array/list of length ‘n’, where the array/list represents the boards and each element of the given
    array/list represents the length of each board.
    Some ‘k’ numbers of painters are available to paint these boards.
    Each painter can paint only contiguous boards.

    You are supposed to return the area of the minimum time to get this job done of painting all the
    ‘n’ boards under a constraint that any painter will only paint the continuous sections of boards.

    In other words, You must allocate boards among painters such that the time taken to finish
    painting all boards is minimized.

    Ex: boards[] = [2, 1, 5, 6, 2, 3]; k = 2;
        Possibility 1: [2], [1, 5, 6, 2, 3] => maxTime = 17
        Possibility 2: [2, 1], [5, 6, 2, 3] => maxTime = 16
        Possibility 3: [2, 1, 5], [6, 2, 3] => maxTime = 11
        Possibility 4: [2, 1, 5, 6], [2, 3] => maxTime = 14
        Possibility 5: [2, 1, 5, 6, 2], [3] => maxTime = 16

        min(maxTime) -> 11 Ans
*/
public class BinarySearch11 {
    //brute-force solution
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int n = boards.size();

        if(k > n) { // If painters are more than boards, invalid case
            return -1;
        }

        int minimum = max(boards); // Suppose one board has a very large length, Even if there are 100 painters,
        // that one board must be painted completely by one painter, because boards can’t be split.
        // So, the minimum time any painter will take must be at least the time to paint the largest single board.

        int maximum = sum(boards); // Suppose there is only one painter, then that painter must paint all the boards.
        // In that case, total time = sum of all boards.

        int minMaxTime = 0;

        // Try every possible max time between minimum and maximum
        for(int i = minimum; i <= maximum; i++) {
            int noOfPainters = countPainters(boards, i);

            // When exactly 'k' painters are needed, that 'i' is our answer
            if(noOfPainters == k) {
                minMaxTime = i;
                break;
            }
        }
        return minMaxTime;
    }

    // counting how many painters are needed if total time from each painter should exceeds maximumTime
    private static int countPainters(ArrayList<Integer> boards, int maximumTime) {
        int painters = 1; // Start with one painter
        int maxTime = 0; // Current painter's total time

        for(int i = 0; i < boards.size(); i++) {
            // If current board can be added without exceeding maximumTime
            if(maxTime + boards.get(i) <= maximumTime) {
                maxTime += boards.get(i);
            } else {
                // Need a new painter for next set of boards
                painters++;
                maxTime = boards.get(i);
            }
        }
        return painters;
    }

    // Helper method — returns the maximum value from the array
    private static int max(ArrayList<Integer> arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i) > max) {
                max = arr.get(i);
            }
        }
        return max;
    }

    // Helper method — returns the sum of elements of the array
    private static int sum(ArrayList<Integer> arr) {
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        return sum;
    }

    // optimal solution - binary search
    public static int findTheLargestMinDistance(ArrayList<Integer> boards, int k) {
        // Define the search space:
        // 'low' → minimum possible time (longest single board)
        // 'high' → maximum possible time (if one painter paints all boards)
        int low = max(boards), high = sum(boards);

        while(low <= high) {
            int mid = (low + high) / 2; // Assume this is the maximum time a painter can take
            int noOfPainters = countPainters(boards, mid); // Count how many painters are needed under this assumption
            if(noOfPainters > k) {
                low = mid + 1; // Too many painters required → mid is too small → increase lower bound
            } else {
                high = mid - 1; // Possible with given or fewer painters → try smaller max time
            }
        }
        return low; // 'low' now represents the minimum possible maximum time (our answer)
    }
}
//link: https://www.naukri.com/code360/problems/painter-s-partition-problem_1089557
