package in.vyashivam.striversa2zdsa.step3_arrays.lec2;

//Print subarray with maximum sum - Continuation of the Kadane's algorithm problem.
public class Arrays5 {
    public static int printSubArrayMaxSum(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE; // Stores maximum subarray sum found so far
        int sum = 0;  // Running sum of the current subarray
        int start = 0; // Potential start index of subarray
        int ansStart = -1, ansEnd = -1; //Final start and end indices of max subarray

        for (int i = 0; i < n; i++) {
            // If running sum is 0, mark this index as a new potential start
            if (sum == 0) {
                start = i; // starting index
            }

            // Add current element to running sum
            sum += nums[i];

            // Update max and store indices if we find a better sum
            if (sum > max) {
                max = sum;
                ansStart = start;
                ansEnd = i;
            }

            // If running sum becomes negative, reset it (discard subarray)
            if (sum < 0) {
                sum = 0;
            }
        }

        //Printing the elements of max subarray
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("]");
        System.out.println();

        // If all numbers are negative and problem allows empty subarray,
        // return 0 instead of a negative max sum
        if (max < 0) {
            max = 0;
        }

        return max;
    }
}
