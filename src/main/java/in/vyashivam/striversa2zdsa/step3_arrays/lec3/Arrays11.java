package in.vyashivam.striversa2zdsa.step3_arrays.lec3;

import java.util.ArrayList;
import java.util.List;

/*
    Given an integer array nums. Return the number of reverse pairs in the array.

    An index pair (i, j) is called a reverse pair if:
    0 <= i < j < nums.length
    nums[i] > 2 * nums[j]
*/

public class Arrays11 {
    //brute-force solution
    public static int reversePairs(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                // Check every pair (i, j) where i < j and nums[i] > 2L * nums[j] (To avoid integer overflow)
                if(i < j && nums[i] > 2L* nums[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    //Optimal Solution
    // We split the array, count pairs, and merge — similar to counting inversions
    public static int numberOfReversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    // Recursive Merge Sort — divides and counts reverse pairs in each half
    private static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low >= high) {
            return count; // base case: one element -> no pairs
        }
        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid); // count reverse pairs in left half
        count += mergeSort(arr, mid+1, high); // count reverse pairs in right half
        count += countPairs(arr, low, mid, high); // count reverse pairs (one from left half, one from right half)
        merge(arr, low, mid, high); // Merge two sorted arrays

        return count; // return total reverse pair count for this range
    }

    // Count cross reverse pairs where arr[i] > 2 * arr[j]
    private static int countPairs(int[] arr, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;

        // For every element in left half
        for (int i = low; i <= mid; i++) {
            // Move 'right' until condition breaks
            // Use long to handle overflow cases (e.g., Integer.MAX_VALUE)
            while (right <= high && (long)arr[i] > 2L * (long)arr[right]) {
                right++;
            }

            // All elements before 'right' in right half form valid reverse pairs
            count += right - (mid + 1);
        }
        return count;
    }

    // Standard merge function to combine sorted halves
    private static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        // Merge the two halves into a sorted list
        while (left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                right++;
            }
        }

        // Add any remaining elements
        while (left <= mid) {
            list.add(arr[left]);
            left++;
        }

        while (right <= high) {
            list.add(arr[right]);
            right++;
        }

        // Put the sorted list back into original array.
        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }

    }
}
//link: https://leetcode.com/problems/reverse-pairs/
//link2: https://www.naukri.com/code360/problems/reverse-pairs_1112652
