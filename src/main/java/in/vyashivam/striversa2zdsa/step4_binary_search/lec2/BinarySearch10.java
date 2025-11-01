package in.vyashivam.striversa2zdsa.step4_binary_search.lec2;

import java.util.ArrayList;

/*
    Given an integer array of size n and an integer k.
    Split the array into k non-empty subarrays such that the largest sum of any subarray is minimized.

    Return the minimized largest sum of the split.

    Ex: nums[] = [7, 2, 5, 10, 8]; k = 2;
        Possibility 1: [7], [2, 5, 10, 8] => maxSum = 25
        Possibility 2: [7, 2], [5, 10, 8] => maxSum = 23
        Possibility 3: [7, 2, 5], [10, 8] => maxSum = 18
        Possibility 4: [7, 2, 5, 10], [8] => maxSum = 24

        min(maxSum) -> 18 Ans
*/
public class BinarySearch10 {
    //brute-force solution
    public static int splitArray(ArrayList<Integer> array, int k) {
        int n = array.size();

        if(k > n) { // if request for number of subarrays is more than the number of elements in the array, return -1
            return -1;
        }

        int minimum = max(array); // Each subarray must contain at least one element.
        //So, the largest subarray sum can never be smaller than the largest individual element.
        // Because even if you isolate that large element into its own subarray, the sum = that element itself

        int maximum = sum(array); // If only one subarray (hypothetical), total sum = sum of all elements
        int minMaxSubarraySum = 0;

        // Brute-force solution — tries all possible maximum limits linearly
        for (int i = minimum; i <= maximum; i++) {

            // Count how many subarrays are needed if max sum of each subarray ≤ i
            int noOfSubarrays = countNumberOfSubArrays(array, i);

            // If exactly k subarrays can be formed with this constraint, record the value
            if(noOfSubarrays == k) {
                minMaxSubarraySum = i;
                break;
            }
        }
        return minMaxSubarraySum;
    }

    // counting how many subarrays are needed if no subarray's sum should exceeds maxSubArraySum
    private static int countNumberOfSubArrays(ArrayList<Integer> array, int maxSubArraySum) {
        int noOfSubArray = 1; // Start with one subarray
        int maxSum = 0; // Tracks sum of current subarray

        for(int i = 0; i < array.size(); i++) {
            if(maxSum + array.get(i) <= maxSubArraySum) {
                maxSum += array.get(i); // Add element to current subarray if within limit
            } else {
                noOfSubArray++;
                maxSum = array.get(i); // Otherwise, start a new subarray and reset sum
            }
        }

        return noOfSubArray;
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


    //optimal solution - Binary Search
    public static int splitArray(int[] nums, int k) {
        if(k > nums.length) { // if request for number of subarrays is more than the number of elements in the array, return -1
            return -1;
        }

        int low = maxElement(nums); // Each subarray must have at least one element, so min limit = largest element
        int high = sumOfElements(nums); // If only one subarray (hypothetical), total sum = sum of all elements

        // Binary search between [low, high] to find the minimum valid largest subarray sum
        while(low <= high) {
            int mid = (low + high) / 2; // Assume mid as the largest allowed subarray sum
            int noOfSubArrays = numberOfSubArrays(nums, mid); // Counting number of subarrays with this limit
            if(noOfSubArrays > k) {
                low = mid + 1; // Too many subarrays -> Increase limit (move to right side)
            } else {
                high = mid - 1; // Possible allocation -> Check for minimum (move to left side)
            }
        }

        return low; // 'low' holds the minimized largest subarray sum
    }

    // Helper method to find the max element in the array
    private static int maxElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Helper method to find the sum of elements in the array
    private static int sumOfElements(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // Counts how many subarrays are needed if each subarray’s sum ≤ maxSubArraySum
    private static int numberOfSubArrays(int[] nums, int maxSubArraySum) {
        int noOfSubArrays = 1;  // Start with one subarray
        int maxSum = 0; // Tracks the sum of current subarray
        for(int i = 0; i < nums.length; i++) {
            if(maxSum + nums[i] <= maxSubArraySum) {
                maxSum += nums[i]; // if sum is within limit, assign element to that subarray
            } else {
                noOfSubArrays++;
                maxSum = nums[i]; // otherwise, start a new subarray and reset the sum to the current element
            }
        }
        return noOfSubArrays;
    }

}
//link: https://leetcode.com/problems/split-array-largest-sum/description/
//link2: https://www.naukri.com/code360/problems/split-the-given-array-into-k-sub-arrays_1215015
