package in.vyashivam.striversa2zdsa.step4_binary_search.lec1;

import java.util.ArrayList;

/*
    You have been given a sorted array/list 'arr' consisting of ‘n’ elements. You are also given an integer ‘k’.
    Now, your task is to find the first and last occurrence of ‘k’ in 'arr'.

        1. If ‘k’ is not present in the array, then the first and the last occurrence will be -1.
        2. 'arr' may contain duplicate elements.
*/
public class BinarySearch6 {
    //brute-force approach
    public static int[] firstAndLastOccurrence(int[] arr, int n, int k) {
        int first = -1, last = -1;
        for (int i = 0; i < n; i++) {
            if(arr[i] == k && first == -1) { // first occurrence found
                first = i;
                last = i;
            } else if (arr[i] == k && first != -1) { // update last occurrence
                last = i;
            }
        }
        return new int[]{first, last};
    }

    //binary search using functionalities like lower-bound and upper-bound
    // lower bound -> the smallest index such that arr[index] >= x
    // upper bound -> the smallest index such that arr[index] > x
    public static int[] firstAndLastOccurrence(ArrayList<Integer> arr, int n, int k) {
        int first = firstOccurrence(arr, n, k);
        if (first == n || arr.get(first) != k) { // element not foun
            return new int[]{-1, -1};
        } else {
            int last = lastOccurrence(arr, n, k);
            return new int[] {first, last - 1}; // last occurrence = upper_bound - 1
        }
    }

    // first occurrence of a number can be calculated using lower bound concept
    private static int firstOccurrence(ArrayList<Integer> arr, int n, int k) {
        int first = n;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if(arr.get(mid) >= k) {
                first = mid;
                high = mid - 1; // move left
            } else {
                low = mid + 1;
            }
        }
        return first;
    }

    // first occurrence of a number can be calculated using upper bound concept
    private static int lastOccurrence(ArrayList<Integer> arr, int n, int k) {
        int last = n;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if(arr.get(mid) > k) {
                last = mid;
                high = mid - 1; // move left
            } else {
                low = mid + 1;
            }
        }
        return last;
    }


    //binary search using standard binary search algorithm
    public static int[] searchRange(int[] nums, int target) {
        return new int[]{firstPosition(nums, target), lastPosition(nums, target)};
    }

    // finding the first position / occurrence of a given number using binary search
    private static int firstPosition(int[] nums, int target) {
        int first = -1, low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) { // potential first
                first = mid;
                high = mid - 1; // moving left to find the smaller index for first occurrence
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return first;
    }

    // finding the last position / occurrence of a given number using binary search
    private static int lastPosition(int[] nums, int target) {
        int last = -1, low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) { // potential last
                last = mid;
                low = mid + 1; // moving right to find the larger index for last occurrence
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return last;
    }

}
//link: https://www.naukri.com/code360/problems/first-and-last-position-of-an-element-in-sorted-array_1082549
//link2: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
