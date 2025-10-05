package in.vyashivam.striversa2zdsa.step3_arrays.lec3;

import java.util.ArrayList;

// Given an array that contains both negative and positive integers, find the maximum product subarray.
public class Arrays12 {
    //brute-force solution
    public static int maximumProduct(ArrayList<Integer> nums, int n) {
        int maxProduct = Integer.MIN_VALUE;

        //creating subarrays and finding the product of each subarray
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int product = 1;
                for (int k = i; k <= j; k++) {
                    product *= nums.get(k);
                }
                maxProduct = Math.max(maxProduct, product); // Update the maximum product found so far
            }
        }
        return maxProduct;
    }

    //better solution
    public static int maximumProduct(int[] nums, int n) {
        int maxProduct = Integer.MIN_VALUE;

        // Instead of recalculating product from scratch for each subarray,
        // keep multiplying as we expand the subarray from i to j.

        // For every starting index, calculate cumulative product till the end
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    //optimal solution - Observations
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 1, suffix = 1, maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // Reset prefix/suffix when zero encountered
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            // Multiply from front and back simultaneously
            prefix *= nums[i];
            suffix *= nums[n-1-i];

            // Maximum product so far can be from prefix or suffix
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }

        return maxProduct;
    }
}
//link: https://www.naukri.com/code360/problems/maximum-product-subarray_1115474
//link2: https://leetcode.com/problems/maximum-product-subarray/description/

