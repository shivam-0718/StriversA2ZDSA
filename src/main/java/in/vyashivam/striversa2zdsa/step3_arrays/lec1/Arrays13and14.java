package in.vyashivam.striversa2zdsa.step3_arrays.lec1;

import java.util.HashMap;
import java.util.Map;

//Find the longest subarray out of the array with given sum of K (array containing positives and negatives)
public class Arrays13and14 {
    //brute-force approach
    public static int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int len = 0;

        for (int i = 0; i < n; i++) { //starting index
            for (int j = i; j < n; j++) { //ending index
                int sum = 0; //sum for the sub array
                for (int K = i; K <= j; K++) {
                    sum += nums[K];
                }
                if(sum == k) {
                    len = Math.max(len, j - i + 1); //finding the length of subarray
                }
            }
        }
        return len;
    }

    //simplified brute-force approach
    public static int longestSubarrayWithGivenSum(int[] nums, int k) {
        int n = nums.length;
        int len = 0;

        for (int i = 0; i < n; i++) { //starting index
            int sum = 0; //sum for the sub array
            for (int j = i; j < n; j++) { //ending index
                sum += nums[j];

                if(sum == k) {
                    len = Math.max(len, j - i + 1); //finding the length of subarray
                }
            }
        }
        return len;
    }

    //better solution - hashing
    public static int longestSubarrayWithSumK(int []a, long k) {
        int n = a.length;
        int maxLength = 0;
        long sum = 0;

        Map<Long, Integer> preSumMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += a[i]; // update running prefix sum

            // Case 1: subarray from index 0 to i has sum = k
            if (sum == k) {
                maxLength = Math.max(maxLength, i+1);
            }

            long rem = sum - k; //As per reverse mathematics, if we have a subarray with sum as k within an array of prefix sum x, then there will be another sub array with the sum of x - k

            // Case 2: check if there exists a prefix with sum = (sum - k)
            // If yes, then subarray between that index+1 and i has sum = k
            if(preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLength = Math.max(maxLength, len);
            }

            // Store prefix sum only if it's not already present
            // (ensures earliest index is stored → helps maximize subarray length)
            if(!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLength;
    }


    //optimal solution - 2 pointer (Sliding window) (Only valid with non-negative numbers)
    public static int largestSubarray(int []a, long k) {
        int left = 0, right = 0, maxLength = 0;
        long sum = a[0]; //keeps track of sum of current subarray
        int n = a.length;

        //Moving the right-pointer until it reaches the end of array
        while(right < n) {
            //If sum > k, keep removing elements from the left till sum <= k
            while (left <= right && sum > k) {
                sum -= a[left];
                left++; //shift pointer forward
            }

            //If sum == k, update maxLength, and move right pointer forward
            if(sum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;

            //increment sum by moving the right pointer till the end of array
            if(right < n) {
                sum += a[right];
            }
        }
        return maxLength;
    }
}

//link: https://www.naukri.com/code360/problems/longest-subarray-with-sum-k_6682399
//link: https://leetcode.com/problems/subarray-sum-equals-k/description/ (Refer Step 3 Lec 2 Problem 14)
// (This is for finding the number of subarrays with sum equals k)
