package in.vyashivam.striversa2zdsa.step3_arrays.lec3;

import java.util.HashMap;
import java.util.Map;

/*
    Given an array containing both positive and negative integers,
    Find the length of the longest subarray with the sum of all elements equal to zero.
*/
public class Arrays5 {
    //Brute-force solution
    public static int maxLen(int[] nums) {
        int len = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if(sum == 0) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }

    //better approach
    public static int maxLength(int[] nums) {
        int len = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if(sum == 0) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }

    //Optimal approach - Hashing
    public static int maxLengthSubarray(int[] nums) {
        int maxLen = 0, k = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if(sum == k) {
                maxLen = Math.max(maxLen, i+1);
            }

            int rem = sum - k;

            if(map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
//link: Refer to the same link given in Step 1 Lec 1 Problem 13 and 14
