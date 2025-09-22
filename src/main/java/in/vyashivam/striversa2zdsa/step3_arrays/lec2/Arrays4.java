package in.vyashivam.striversa2zdsa.step3_arrays.lec2;

//From the given array, find the subarray with the largest sum, and return the sum
public class Arrays4 {
    //brute-force approach
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE; //maxSum must be Integer.MIN_VALUE as array also contain negative numbers

        // Generate all possible subarrays
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;

                // Calculate sum of subarray nums[i..j]
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                // Update maxSum if current subarray sum is greater OR use maxSum = Math.max(sum, maxSum)
                if (sum >= maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    //better approach
    public static int maxSumSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE; //maxSum must be Integer.MIN_VALUE as array also contain negative numbers
        for (int i = 0; i < n; i++) {
            int sum = 0;
            // Expand subarray towards right
            for (int j = i; j < n; j++) {
                sum += nums[j]; // Keep cumulative sum
                maxSum = Math.max(sum, maxSum); //Update maxSum if needed
            }
        }
        return maxSum;
    }

    //optimal approach - Kadane's algorithm
    public static int maxSubArraySum(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0; // Stores maximum subarray sum found so far

        for (int i = 0; i < n; i++) {
            sum += nums[i]; // Add current element to running sum
            max = Math.max(sum, max); //update maxSum is sum is greater than max

            // If running sum becomes negative, reset it to 0
            // (negative sum will never contribute to maximum subarray)
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
//link: https://www.naukri.com/code360/problems/maximum-subarray-sum_630526
//link2: https://leetcode.com/problems/maximum-subarray/
